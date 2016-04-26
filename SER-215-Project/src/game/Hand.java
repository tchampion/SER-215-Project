package game;


/**
 * Represents a hand of blackJack
 */

public class Hand
{

	private Card[] hand;
	private int handValue = 0;
	private int bet = 0;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Hand(int bet){
		this.bet = bet;
		hand = new Card[0];
	}

	public void addCard(Card card){
		this.expand();
		hand[hand.length-1] = card;
		
		if(card.getFaceValue() == 0)
			handValue = handValue + 11;
		else if(card.getFaceValue() == 10 || card.getFaceValue() == 11 || card.getFaceValue() == 12)
			handValue = handValue + 10;
		else
			handValue = handValue + card.getFaceValue()+1;
		
		
		if(handValue > 21){
			for(int i = 0 ; i < hand.length ; i++){
				if(hand[i].getFaceValue() == 0)
					handValue = handValue - 10;
				if(handValue < 21)
					break;		
			}
		}
	}
	
	
	
	public int getBet() {
		return bet;
	}

	public void setBet(int bet) {
		this.bet = bet;
	}

	public Card[] getHand() {
		return hand;
	}
	
	public Card getCard(int cardPosition){
		return hand[cardPosition];
	}
	
	public void setCard(int cardPosition, Card card){
		hand[cardPosition] = card;
	}

	public int getHandValue() {
		return handValue;
	}

	private void expand(){
		Card[] temp = new Card[hand.length+1];
		for(int i = 0 ; i < hand.length ; i++)
			temp[i] = hand[i];
		hand = temp;
	}
	
	public String toString(){
		String result = "";
		
		for(int i = 0 ; i < hand.length ; i++)
			result = result + hand[i];
		
		return result;
	}
}

