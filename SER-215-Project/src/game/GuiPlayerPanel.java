package game;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		this.setSize(1200, 700);
		if(player.getFunds() < 1){
			JOptionPane.showMessageDialog(BlackJackGame.gui,new JLabel(player.getName() + " is out of funds.  Pull $1000 from ATM to try to win it back?"));
			player.setFunds(player.getFunds() + 1000);
		}
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
				
				
				
				
				if(BlackJackGame.gui.getAllBetsReceived() == BlackJackGame.gui.getBetReceived()){
					
					BlackJackGame.gui.play();
				}
				
				
			}
			
		});

	}
	
	public void play(Player player){
		

		ImageIcon image;
		
		
		removeAll();
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		this.setSize(1200, 700);
		c.anchor = GridBagConstraints.SOUTH;
		c.gridx = 0;
		c.gridy = 0;
		add(playerName,c);
		
		
		
		
		
		for(int j = 0 ; j < player.getHandCount() ; j++){
			JLabel betAmount = new JLabel("Hand Bet Amount: $" + player.getCurrentCards(0).getBet());
			c.gridy = (j+1) * ((int) player.getHandCount() + 1);
			add(betAmount,c);
			Card[] hand = player.getCurrentCards(j).getHand();
			for(int i = 0 ; i < hand.length ; i++){			
				image = hand[i].getCardImageFront();
				cards = new JLabel(image);
				c.gridy = (j+1) * ((int) player.getHandCount() + 2);
				c.gridx = i;
				add(cards,c);
			}
			handValue = new JLabel("Hand Value: " + player.getCurrentCards(j).getHandValue());
			c.gridy = (j+1) * ((int) player.getHandCount() + 3);
			c.gridx = 0;
			add(handValue,c);
		}
		
		hitButton = new JButton("Hit");
		standButton = new JButton("Stand");
		doubleButton = new JButton("Double Down");
		splitButton = new JButton("Split");
		splitButton.setVisible(false);
		
		if(player.isTurnover()){
			hitButton.setVisible(false);
			standButton.setVisible(false);
			splitButton.setVisible(false);
			doubleButton.setVisible(false);
		}
		
		JLabel funds = new JLabel("Total Funds: $" + player.getFunds());
		c.gridy = ((4*player.getHandCount()) + 3);
		add(funds,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 5;
		c.gridx = 0;
		c.gridy = ((4*player.getHandCount()) + 4);
		c.anchor = GridBagConstraints.PAGE_END;
		add(hitButton,c);
		
		c.gridx = 10;
		add(standButton,c);
		
		c.gridx = 0;
		c.gridy = ((4*player.getHandCount()) + 5);
		add(doubleButton,c);
		
		c.gridx = 10;
		add(splitButton,c);
		
		BlackJackGame.gui.handOver();
		
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

