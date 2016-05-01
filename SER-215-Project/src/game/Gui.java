package game;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
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
	private int numPlayers;
	private GuiDealerPanel dealer;
	private GuiPlayerPanel[] eachPlayer;
	

	private JPanel playerPanel;
	private JPanel p = new JPanel(new GridBagLayout());
	private	GridBagConstraints c = new GridBagConstraints();
	/**
	 * Displays credits to the screen
	 */
	public void displayCredits(){
		ImageIcon credits = new ImageIcon(getClass().getResource("/images/splash.png"));
		JLabel l = new JLabel(credits);
		p.add(l);
		this.add(p);
		
		this.setTitle("Blackjack");	
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(1200,900);
	    this.setVisible(true);
	    
		l.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				numPlayers();
				p.remove(l);
				p.updateUI();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	/**
	 * Prompts screen for the number of players
	 */
	public void numPlayers(){
		
		
		
		JLabel l = new JLabel("Select Number of Players:");
		Integer[] choices = {1,2,3,4};
		JComboBox<Integer> cb1 = new JComboBox<Integer>(choices);
		JButton numSubmit = new JButton("Submit");
		
		c.gridx = 0;
		c.gridy = 0;
		getP().add(l,c);
		
		c.gridy = 1;
		getP().add(cb1,c);
		
		c.gridy = 2;
		getP().add(numSubmit,c);
		
		numSubmit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				numPlayers = (int)cb1.getSelectedItem();
				getP().removeAll();
				getPlayerNames(numPlayers);				
				getP().updateUI();
			}
			
		});
		
		this.add(getP());
		
		
		
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
		
		
			JLabel l = new JLabel("Enter each player name");
			JTextField tf = new JTextField(20);
			JButton submit = new JButton("Submit");
			
			c.gridx = 0;
			c.gridy = 0;
			getP().add(l,c);
			
			c.gridy = 1;
			getP().add(tf,c);
			
			c.gridy = 2;
			getP().add(submit,c);
		
		
			
			
		
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
						getP().removeAll();
						remove(p);
						add(p);
						BlackJackGame.game.dealTable(players);
						getP().updateUI();
						
					}
						
				}			
		});	
	}
			
		

	public void bet(Player[] player){
		
		allBetsReceived = player.length-1;
		setBetReceived(0);
		
		dealer = new GuiDealerPanel();
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
		
		getP().removeAll();
			c.anchor = GridBagConstraints.SOUTH;
		getP().add(playerPanel, c);
		this.add(getP());
		this.setTitle("Blackjack");	
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(1200,900);
	    this.setVisible(true);
		
		
		
		
		
		
	}
	
	public void play(){
		
		for(int i = 0 ; i < eachPlayer.length ; i++){
			eachPlayer[i].play(eachPlayer[i].getPlayer());
		}
		getP().removeAll();
		
		
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTH;
		getP().add(getDealer(), c);
		
		c.weighty = .8;
		c.gridy = 1;
		c.gridheight = 10;
		c.weighty = .5;
		c.anchor = GridBagConstraints.SOUTH;
		
		getP().add(getPlayerPanel(),c);
		p.updateUI();
		
	}
	
	public void handOver(){
		boolean handOver = true;
		for(int i = 0 ; i < eachPlayer.length;  i++){
			if(!eachPlayer[i].getPlayer().isTurnover())
				handOver = false;
		}
		if(handOver)
			BlackJackGame.game.dealerTurn();
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

	public JPanel getPlayerPanel() {
		return playerPanel;
	}

	public void setPlayerPanel(JPanel playerPanel) {
		this.playerPanel = playerPanel;
	}

	public GuiDealerPanel getDealer() {
		return dealer;
		
	}

	public void setDealer(GuiDealerPanel dealer) {
		this.dealer = dealer;
	}

	public JPanel getP() {
		return p;
	}

	public void setP(JPanel p) {
		this.p = p;
	}
	
	public GuiPlayerPanel[] getEachPlayer() {
		return eachPlayer;
	}

	public void setEachPlayer(GuiPlayerPanel[] eachPlayer) {
		this.eachPlayer = eachPlayer;
	}

	public void refresh(){
		getP().removeAll();
		
		
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTH;
		getP().add(dealer, c);
		
		c.weighty = .8;
		c.gridy = 1;
		c.gridheight = 10;
		c.weighty = .5;
		c.anchor = GridBagConstraints.SOUTH;
		
		getP().add(getPlayerPanel(),c);
		p.updateUI();
		this.setVisible(true);

	}
	


}

