package game;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Creates a card object
 * 
 * 
 * @author Terin Champion
 * @version 1.0
 */
public class Card
{
	private int suitValue;		
	private int faceValue;
	private String suit,face;	
	private ImageIcon cardImageFront;	
	private ImageIcon cardImageBack;


	public Card(int suitInput,int faceInput){
		if(suitInput >= 0 || suitInput < 3)
			suitValue = suitInput;
		if(faceInput >=0 || faceInput < 12)
			faceValue = faceInput;
		switch(suitValue){
		case 0:
			suit = "spades";
			break;
		case 1:
			suit = "clubs";
			break;
		case 2:
			suit = "diamonds";
			break;
		case 3:
			suit = "hearts";
			break;
		}//end of suit switch
		switch(faceValue){
		case 0:
			face = "ace";
			break;
		case 10:
		    face = "jack";
		    break;
		case 11:
			face = "queen";
			break;
		case 12:
			face = "king";
			break;
		default:
			face = "" + (faceValue+1);
			break;
		}//end of face switch	
		
		cardImageFront = new ImageIcon(getClass().getResource("/images/" + face + "_of_" + suit + ".png"));
		cardImageBack = new ImageIcon(getClass().getResource("/images/back.png"));
		
	}//end of constructor	
	

	public ImageIcon getCardImageFront() {
		return cardImageFront;
	}

	public void setCardImageFront(ImageIcon cardImageFront) {
		this.cardImageFront = cardImageFront;
	}

	public ImageIcon getCardImageBack() {
		return cardImageBack;
	}

	public void setCardImageBack(ImageIcon cardImageBack) {
		this.cardImageBack = cardImageBack;
	}

	public int getSuitValue() {
		return suitValue;
	}

	public int getFaceValue() {
		return faceValue;
	}

	public String getSuit() {
		return suit;
	}

	public String getFace() {
		return face;
	}
	
	public String toString() {
		return (face + " of " + suit + "\n");
	}

}

