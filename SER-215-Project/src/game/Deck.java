package game;



/**
 * Creates a deck of cards
 * 
 * 
 * @author Terin Champion
 * @version 1.0
 */

public class Deck{

	private static Card[] deck = new Card[52];
	private int cardsLeft;
	
	
	public Deck(){		
		deck = this.loadDeck();
		this.shuffle();				
	}

	/**
	 * Loads all cards into the deck
	 * 
	 * @returns card[]
	 */
	private Card[] loadDeck(){
		
		for(int index = 0 ; index < deck.length ; index++){			
			Card load;
			if(index < 26)
				if(index > 12)
					load = new Card(1,index-13);
				else
					load = new Card(0,index);		
			else
				if(index < 39)
					load = new Card(2,index-26);
				else
					load = new Card(3,index-39);
		
			deck[index] = load;
		}
			cardsLeft = 52;	
				
			return deck;	
	}//end of load

	/**
	 * Shuffles the deck of cards.
	 */
	public void shuffle(){				
		for(int i = 0 ; i < 500 ; i++){													
			for(int card = 0 ; card < 51 ; card++){
				int swap = (int) (Math.random() * 52);
				Card temp = deck[card];
				deck[card] = deck[swap];
				deck[swap] = temp;
			}					
		}
		cardsLeft = 52;								
	}//end of shuffle

	/**
	 * Get card info from index i
	 * @param Array index i
	 * @return Card at index i
	 */
	public Card getCard(int i){
		return deck[i];
	}
	
	/**
	 * Deals the next card in the deck
	 * 
	 * @return Card
	 */
	public Card deal(){
		Card delt = deck[cardsLeft-1];
		cardsLeft--;
		if(cardsLeft == 0)
			shuffle();
		return delt;
	}
	
	/**
	 * Returns the number of cards left in the deck
	 * 
	 * @return int cardsLeft
	 */
	public int cardsLeft(){
		return cardsLeft;
	}
	
	/**
	 * String representation of the deck of cards
	 * 
	 * @return String
	 */
	public String toString(){
		String name = "";
		
		for(int card = 0 ; card < 52 ; card++){
			name += deck[card].toString();
		}
		return name;
	}
}

