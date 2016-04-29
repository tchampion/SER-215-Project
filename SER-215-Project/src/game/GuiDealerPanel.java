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
	public GuiDealerPanel(Player player){
		JLabel dealer = new JLabel("Dealer");
		Hand hand = player.getCurrentCards(0);
		
		ImageIcon image;
		int x = 20, y = 600;
		
		JLabel cards;
		this.add(dealer);
		for(int i = 0 ; i < hand.getHand().length ; i++){
			image = hand.getHand()[i].getCardImageFront();
			if(i==1)
				image = hand.getHand()[i].getCardImageBack();
			cards = new JLabel(image);
			this.add(cards);
			cards.setLocation(x, y);
			x = x + 20;
		}
		
		
		
	}

}

