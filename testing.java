package Blackjack.src.main.java.model;

public class testing {

	public static void main(String[] args){
		Player player1 = new Player("Terin");
		Player player2 = new Player("Britta");
		Hand hand = new Hand(5);

		Hand[] currentCards = new Hand[1];
		currentCards[0] = hand;

		player1.setCurrentCards(currentCards);
		hand.addCard(BlackJackGame.deck.deal());
		
		player1.hit(0);
		player1.hit(0);
		
		currentCards = player1.getCurrentCards();
		hand = currentCards[0];
		System.out.println(hand);
		System.out.println(hand.getHandValue());

		player1.hit(0);
		
		currentCards = player1.getCurrentCards();
		hand = currentCards[0];
		System.out.println(hand);
		System.out.println(hand.getHandValue());

		

		
	}
}
