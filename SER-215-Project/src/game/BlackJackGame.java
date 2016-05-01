package game;

import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
	public static BlackJackGame game;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	
	public static void main(String[] args){	
		game = new BlackJackGame();
		gui.displayCredits();
	}
	
	
	public void dealTable(Player[] player){
		
		players = player;
		
		for(int i = 0 ; i < player.length ; i++){
			Hand hand = new Hand(5);			
			hand.addCard(deck.deal());
			hand.addCard(deck.deal());
			player[i].setCurrentCards(hand, 0);
		}
		
		gui.bet(player);
		
	}

	
	
	public void dealerTurn()
	{	
		System.out.println("Dealer Turn" + players[0].getCurrentCards(0).getHandValue());
		GuiDealerPanel temp = new GuiDealerPanel(true);
		
		gui.setDealer(temp);
		gui.refresh();
		while(players[0].getCurrentCards(0).getHandValue() < 17){
			players[0].hit(0);
			temp = new GuiDealerPanel(true);
			gui.setDealer(temp);
			gui.refresh();
			
			
		}
		endHand();
	}
	
	public void endHand(){
		for(int i = 0 ; i< gui.getEachPlayer().length ; i++)
			winner(gui.getEachPlayer()[i].getPlayer());
		gui.getP().remove(gui.getPlayerPanel());
		dealTable(players);
	}


	/**
	 * Compares each hand of passed Player to dealer's hand.  Calls to calcFunds.
	 * @param player
	 */
	public void winner(Player player) {
		System.out.println(player.getCurrentCards(0).getHandValue());
		System.out.println(players[0].getCurrentCards(0).getHandValue());
		if(player.getCurrentCards(0).getHandValue() < 22){
			if(player.getCurrentCards(0).getHandValue() > players[0].getCurrentCards(0).getHandValue()){
				calcFunds(player, player.getCurrentCards(0).getBet(), true);
				JOptionPane.showMessageDialog(gui,new JLabel(player.getName() + " Wins!!!"));
			}
			else{
				if(players[0].getCurrentCards(0).getHandValue() > 21){
					calcFunds(player, player.getCurrentCards(0).getBet(), true);
					JOptionPane.showMessageDialog(gui,new JLabel(player.getName() + " Wins!!!"));
				}
				else{
					calcFunds(player, player.getCurrentCards(0).getBet(), false);
					JOptionPane.showMessageDialog(gui,new JLabel(player.getName() + " Lost.  Better luck next time."));
				}
			}
		}
		else{
			calcFunds(player, player.getCurrentCards(0).getBet(), false);
			JOptionPane.showMessageDialog(gui,new JLabel(player.getName() + " Lost.  Better luck next time."));
		}
		
		player.setCurrentCards(new Hand[1]);
		player.setHandCount(1);
		player.setTurnover(false);
	}

	/**
	 * Recalculates the player's funds after each hand
	 * @param Player player, double betAmount, boolean win
	 */
	
	public void calcFunds(Player player, int betAmount, boolean win) {
		if(win){
			player.setFunds(betAmount + player.getFunds());
		}
		else
			player.setFunds(player.getFunds() - betAmount);
	}



	public Player[] getPlayers() {
		return players;
	}


	public void setPlayers(Player[] players) {
		this.players = players;
	}
	
	

	

}

