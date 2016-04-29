package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Controls the Gui of the blackjack game
 */
public class Gui extends JFrame 
{
	private int nameSubmitCount;
	private int betReceived;
	private int allBetsReceived;
	private GuiDealerPanel dealer;
	private GuiPlayerPanel[] eachPlayer;
	private JPanel playerPanel;
	/**
	 * Displays credits to the screen
	 */
	public void displayCredits(){
		//add credits screen
	}
	
	/**
	 * Prompts screen for the number of players
	 */
	public void numPlayers(){
		
		JPanel p = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel l = new JLabel("Select Number of Players:");
		Integer[] choices = {1,2,3,4};
		JComboBox<Integer> cb1 = new JComboBox<Integer>(choices);
		JButton numSubmit = new JButton("Submit");
		
		c.gridx = 0;
		c.gridy = 0;
		p.add(l,c);
		
		c.gridy = 1;
		p.add(cb1,c);
		
		c.gridy = 2;
		p.add(numSubmit,c);
		
		numSubmit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int numPlayers = (int)cb1.getSelectedItem();
				getPlayerNames(numPlayers);				
				remove(p);
			}
			
		});
		
		this.add(p);
		
		
		
		this.setTitle("Blackjack");	
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(1200,900);
	    this.setVisible(true);
	    
	}
	
	/**
	 * Asks each player for their name and creates the player profile
	 */
	public void getPlayerNames(int numPlayers){
		
		
		
		Player[] players = new Player[numPlayers+1];
		Player dealer = new Player("Dealer");
		players[0] = dealer;
		nameSubmitCount = 1;
		
		
			
		
			JPanel p = new JPanel(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
		
		
			JLabel l = new JLabel("Enter each player name");
			JTextField tf = new JTextField(20);
			JButton submit = new JButton("Submit");
			
			c.gridx = 0;
			c.gridy = 0;
			p.add(l,c);
			
			c.gridy = 1;
			p.add(tf,c);
			
			c.gridy = 2;
			p.add(submit,c);
		
		
			this.add(p);
			
		
			this.setTitle("Blackjack");	
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(1200,900);
			this.setVisible(true);
		
			submit.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					String playerName = tf.getText();

					
					players[nameSubmitCount] = new Player(playerName);
					nameSubmitCount++;

					if(nameSubmitCount == numPlayers+1){	
						BlackJackGame.dealTable(players);
						remove(p);	
						
					}
						
				}			
		});	
	}
			
		

	public void bet(Player[] player){
		
		allBetsReceived = player.length-1;
		setBetReceived(0);
		
		dealer = new GuiDealerPanel(player[0]);
		eachPlayer = new GuiPlayerPanel[player.length-1];
		
		for(int i = 1 ; i < player.length ; i++){
			GuiPlayerPanel add = new GuiPlayerPanel(player[i]);
			eachPlayer[i-1] = add;
			
		}
		
		
		
		playerPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		for(int i = 0 ; i < eachPlayer.length ; i++){
			c.gridx = i;
			c.gridy = 0;
			c.weightx = .5;
			playerPanel.add(eachPlayer[i], c);
			
		}
		

		this.add(playerPanel);
		
		this.setTitle("Blackjack");	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200,900);
		this.setVisible(true);
		
		
		
	}
	
	public void play(){
		
		for(int i = 0 ; i < eachPlayer.length ; i++){
			eachPlayer[i].play(eachPlayer[i].getPlayer());
		}
		
		this.add(dealer, BorderLayout.NORTH);
		
		this.add(playerPanel, BorderLayout.SOUTH);

		this.setTitle("Blackjack");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(1200, 900);
	    this.setVisible(true);
	}
	

	public int getBetReceived() {
		return betReceived;
	}

	public void setBetReceived(int betReceived) {
		this.betReceived = betReceived;
	}

	public int getAllBetsReceived() {
		return allBetsReceived;
	}

	public void setAllBetsReceived(int allBetsReceived) {
		this.allBetsReceived = allBetsReceived;
	}
	

	


}

