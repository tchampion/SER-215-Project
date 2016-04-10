public static class Card{
		//creates an object that represents a standard playing card
		private int suitValue;		
		private int faceValue;
		private String suit,face;
						
		public Card(int suitInput,int faceInput){
			if(suitInput >= 0 || suitInput < 3)
				suitValue = suitInput;
			if(faceInput >=0 || faceInput < 12)
				faceValue = faceInput;
			switch(suitValue){
			case 0:
				suit = "Spades";
				break;
			case 1:
				suit = "Clubs";
				break;
			case 2:
				suit = "Diamonds";
				break;
			case 3:
				suit = "Hearts";
				break;
			}//end of suit switch
			switch(faceValue){
			case 0:
				face = "Ace";
				break;
			case 10:
			    face = "Jack";
			    break;
			case 11:
				face = "Queen";
				break;
			case 12:
				face = "King";
				break;
			default:
				face = "" + (faceValue+1);
				break;
			}//end of face switch			
		}//end of constructor		

		public String toString(){
			return (face + " of " + suit + "\n");
		}						
	}
