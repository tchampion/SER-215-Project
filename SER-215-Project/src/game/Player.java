package game;



/**
 * Represents a Black Jack player
 */

public class Player
{
	
	private String name;
	private int funds;
	private Hand[] currentCards = new Hand[1];
	private boolean turnover = false;
	

	public boolean isTurnover() {
		return turnover;
	}

	public void setTurnover(boolean turnover) {
		this.turnover = turnover;
	}

	private int handCount = 1;

	/**
	 * Creates a player
	 * @param String name, int funds
	 */
	public Player(String name, int funds){
		this.name = name;
		this.funds = funds;
		Hand hand = new Hand(5);
		currentCards[0] = hand;
	}
	
	/**
	 * Creates a player
	 * @param String name
	 */
	public Player(String name){
		this.name = name;
		this.funds = 1000;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFunds() {
		return funds;
	}

	public void setFunds(int d) {
		this.funds = d;
	}

	public int getHandCount() {
		return handCount;
	}

	public void setHandCount(int handCount) {
		this.handCount = handCount;
	}

	public Hand getCurrentCards(int handNumber) {
		return currentCards[handNumber];
	}
	
	public void setCurrentCards(Hand currentCards, int handNumber) {
		this.currentCards[handNumber] = currentCards;
		
	}
	
	public void setCurrentCards(Hand[] currentCards) {
		this.currentCards = currentCards;
		
	}
	/**
	 * Player Chooses to Double Down.  1 card added to hand and bet is doubled.
	 * @param int handNumber
	 */
	
	public void doubleDown(int handNumber){
		int bet = currentCards[handNumber].getBet();
		currentCards[handNumber].setBet(bet*2);
		currentCards[handNumber].addCard(BlackJackGame.deck.deal());
		turnover = true;
	}

	/**
	 * Player chooses to split
	 */
	
	public void split(int handNumber) {
		int bet = currentCards[handNumber].getBet();
		Hand[] temp = new Hand[handCount+1];
		handCount++;
		for(int i = 0 ; i < handCount-1 ; i++)
			temp[i] = currentCards[i];
		Hand temp2 = new Hand(bet);
		temp[handNumber+1] = temp2;
		temp[handNumber+1].addCard(temp[handNumber].getCard(1));
		temp[handNumber].setCard(1,BlackJackGame.deck.deal());
		temp[handNumber+1].addCard(BlackJackGame.deck.deal());

		currentCards = temp;
		
	}

	/**
	 * Player chooses to hit.
	 */
	public void hit(int handNumber) {
		Card card = BlackJackGame.deck.deal();
		currentCards[handNumber].addCard(card);
		if(currentCards[handNumber].getHandValue() > 21)
			turnover = true;
	}

	/**
	 * Player chooses to Stand
	 */
	
	public void stand(int handNumber) {
		turnover = true;
	}


}

