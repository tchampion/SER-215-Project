package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
public class Gui extends JFrame 
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void deal(){
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void guiStart(){
		GuiDealerPanel dealer = new GuiDealerPanel();
		GuiPlayerPanel player1 = new GuiPlayerPanel(testing.player1);
		GuiPlayerPanel player2 = new GuiPlayerPanel(testing.player2);
		GuiPlayerPanel player3 = new GuiPlayerPanel(testing.player3);
		int numPlayers = 3;
		JPanel players = new JPanel();

		
		this.add(dealer, BorderLayout.NORTH);
		players.add(player1);
		players.add(player2);
		players.add(player3);
		
		this.add(players, BorderLayout.SOUTH);

		this.setTitle("Blackjack");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(800, 600);
	    this.setVisible(true);
	}
	
	public void refresh(){
		this.pack();
	}
	


}

