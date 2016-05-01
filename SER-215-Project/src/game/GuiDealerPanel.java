package game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Displays Dealer Cards
 */

public class GuiDealerPanel extends JPanel
{
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public GuiDealerPanel(){
		
		
		JLabel dealerName = new JLabel("Dealer");
		
		ImageIcon image;
		int x = 20, y = 600;
		
		JLabel cards;
		this.add(dealerName);
		for(int i = 0 ; i < BlackJackGame.game.players[0].getCurrentCards(0).getHand().length ; i++){
			image = BlackJackGame.game.players[0].getCurrentCards(0).getHand()[i].getCardImageFront();
			if(i==1)
				image = BlackJackGame.game.players[0].getCurrentCards(0).getHand()[i].getCardImageBack();
			cards = new JLabel(image);
			this.add(cards);
			cards.setLocation(x, y);
			x = x + 10;
		}
	}
		
	public GuiDealerPanel(boolean visible){
			
		JLabel dealerName = new JLabel("Dealer");
		JLabel handValue = new JLabel("Hand Value: " + BlackJackGame.game.players[0].getCurrentCards(0).getHandValue());
			
		ImageIcon image;
		int x = 20, y = 600;
			
		JLabel cards;
		this.add(dealerName);
		
		for(int i = 0 ; i < BlackJackGame.game.players[0].getCurrentCards(0).getHand().length ; i++){
			image = BlackJackGame.game.players[0].getCurrentCards(0).getHand()[i].getCardImageFront();
			cards = new JLabel(image);
			this.add(cards);
			cards.setLocation(x, y);
			x = x + 10;
		}
		this.add(handValue);
	}

	
	

	

}

