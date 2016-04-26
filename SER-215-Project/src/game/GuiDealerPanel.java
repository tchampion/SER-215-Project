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
		JLabel dealer = new JLabel("Dealer");
		Hand hand1 = testing.player1.getCurrentCards(0);
		
		ImageIcon image;
		int x = 20, y = 600;
		
		JLabel cards;
		this.add(dealer);
		for(int i = 0 ; i < hand1.getHand().length ; i++){
			image = hand1.getHand()[i].getCardImageFront();
			cards = new JLabel(image);
			this.add(cards);
			cards.setLocation(x, y);
			x = x + 20;
		}
		
		
		
	}

}

