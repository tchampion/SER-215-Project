package game;

import java.util.Scanner;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class BlackJackGame
{
	public Player[] players;
	public static Deck deck = new Deck();
	public Hand dealerHand;
	public static Gui gui = new Gui();
	public Hand hand;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	

	
	
	public static void dealTable(Player[] player){
		
		
		for(int i = 0 ; i < player.length ; i++){
			Hand hand = new Hand(5);			
			hand.addCard(deck.deal());
			hand.addCard(deck.deal());
			player[i].setCurrentCards(hand, 0);
		}
		gui.bet(player);
	}

	
	
	public boolean winner(Player parameter) {
		// TODO implement me
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void calcFunds(Player parameter, double parameter2, boolean parameter3) {
		// TODO implement me
	}
	
	

	

}

