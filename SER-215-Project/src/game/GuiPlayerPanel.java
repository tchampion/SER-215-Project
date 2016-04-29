package game;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class GuiPlayerPanel extends JPanel
{

	public JButton hitButton;
	public JButton standButton;
	public JButton splitButton;
	public JButton doubleButton;
	public JSpinner bet;
	public JButton submitBet;
	public JLabel currentBet;
	public JLabel playerName;
	public JLabel cards;
	public JLabel handValue;
	private Player player;
	

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public GuiPlayerPanel(Player player){
		
		this.setPlayer(player);
		SpinnerNumberModel bets = new SpinnerNumberModel(5,5,player.getFunds(),5);
		JSpinner bet = new JSpinner(bets);
		JButton submitBet = new JButton("Submit Bet");
		playerName = new JLabel(player.getName());
		
		this.add(playerName);
		this.add(bet);
		this.add(submitBet);
		
		submitBet.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				final int betValue = (int) bet.getValue();
				player.getCurrentCards(0).setBet(betValue);
				BlackJackGame.gui.setBetReceived(BlackJackGame.gui.getBetReceived() + 1);
				remove(submitBet);
				updateUI();
				//BlackJackGame.gui.setVisible(true);
				
				System.out.println(BlackJackGame.gui.getBetReceived() + " and " + BlackJackGame.gui.getAllBetsReceived());
				
				if(BlackJackGame.gui.getAllBetsReceived() == BlackJackGame.gui.getBetReceived()){
					
					BlackJackGame.gui.play();
				}
				
				
			}
			
		});

	}
	
	public void play(Player player){
		
		System.out.println("Gets Here");
		Hand hand1 = player.getCurrentCards(0);
		Card[] card = hand1.getHand();
		ImageIcon image;
		
		this.removeAll();
		setLayout(new GridLayout(2,1));
		this.add(playerName);
		
		for(int j = 0 ; j < player.getHandCount() ; j++){
			for(int i = 0 ; i < card.length ; i++){
				image = card[i].getCardImageFront();
				cards = new JLabel(image);
				this.add(cards);
			}
			handValue = new JLabel("" + player.getCurrentCards(j).getHandValue());
			this.add(handValue);
		}
		
		hitButton = new JButton("Hit");
		standButton = new JButton("Stand");
		doubleButton = new JButton("Double Down");
		splitButton = new JButton("Split");
		
		this.add(hitButton);
		this.add(standButton);
		this.add(doubleButton);
		this.add(splitButton);
		
		
		hitButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				player.hit(0);
				play(player);
				updateUI();
			}
			
		});
		
		standButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				player.stand(0);
				play(player);
				updateUI();
			}
			
		});
		
		doubleButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				player.doubleDown(0);
				play(player);
				updateUI();
			}
			
		});
		
		splitButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				player.split(0);
				play(player);
				updateUI();
			}
			
		});

	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}

