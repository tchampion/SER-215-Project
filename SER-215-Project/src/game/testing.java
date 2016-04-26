package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;
import javax.swing.SwingUtilities;

public class testing extends JFrame{
	
		public static Player player1 = new Player("Terin");
		public static Player player2 = new Player("Britta");
		public static Player player3 = new Player("Test");
		public static Gui gui = new Gui();
	public static void main(String[] args){
		
		
		
		//player1.hit(0);
		//player2.hit(0);
		//player3.hit(0);
		//player1.hit(0);
		//player2.hit(0);
		//player3.hit(0);
		Hand hand1 = new Hand(5);
		Hand hand2 = new Hand(5);
		Hand hand3 = new Hand(5);
		
		hand1.addCard(BlackJackGame.deck.deal());
		hand1.addCard(BlackJackGame.deck.deal());
		hand2.addCard(BlackJackGame.deck.deal());
		hand2.addCard(BlackJackGame.deck.deal());
		hand3.addCard(BlackJackGame.deck.deal());
		hand3.addCard(BlackJackGame.deck.deal());
		

		player1.setCurrentCards(hand1,0);
		player2.setCurrentCards(hand2, 0);
		player3.setCurrentCards(hand3, 0);
		
		player1.hit(0);

		
		gui.guiStart();
	}
}
