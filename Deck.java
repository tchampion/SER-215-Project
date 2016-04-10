public static class Deck{
			
			
			private Card[] deck = new Card[52];
			private String name = "";
			private int cardsLeft;
			
			
			public Deck(){		
				deck = this.loadDeck();
				this.shuffle();				
			}
			
			public Card[] loadDeck(){
				
				for(int index = 0 ; index < deck.length ; index++){			
					Card load;
					if(index < 26)
						if(index > 12)
							load = new Card(1,index-13);
						else
							load = new Card(0,index);		
					else
						if(index < 39)
							load = new Card(2,index-26);
						else
							load = new Card(3,index-39);
				
					deck[index] = load;
				}
					cardsLeft = 52;	
						
					return deck;	
			}//end of load
			
			public void shuffle(){				
				for(int i = 0 ; i < 500 ; i++){													
					for(int card = 0 ; card < 51 ; card++){
						int swap = (int) (Math.random() * 52);
						Card temp = deck[card];
						deck[card] = deck[swap];
						deck[swap] = temp;
					}					
				}
				cardsLeft = 52;								
			}//end of shuffle
			
			public Card getCard(int i){
				return deck[i];
			}
			
			public Card deal(){
				Card delt = deck[cardsLeft-1];
				cardsLeft--;
				return delt;
			}
			
			public int cardsLeft(){
				return cardsLeft;
			}
			
			public String toString(){
				
				for(int card = 0 ; card < 52 ; card++){
					name += deck[card].toString();
				}
				return name;
			}
			
		}
