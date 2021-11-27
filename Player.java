
package blackjack;

public class Player {
     
   private String name;
   private int score;
   private Card [] arrOfCards = new Card[12];
   private int index=0;
   private boolean busted = false;
   public Player(String name,Card c1,Card c2 ,int i)
   {
       this.name=name;
       addCard(c1, i);
       addCard(c2, i);
       this.score=arrOfCards[0].getValue()+arrOfCards[1].getValue();
   }
   
   protected void addCard(Card c1,int i)
   {
       arrOfCards[index]=new Card(c1);
       score+=c1.getValue();
       if(score>21)busted=true;
       GUI gui = new GUI();
       gui.updatePlayerHand(c1,i);
       index++;
   }

    public boolean isBusted() {
        return busted;
    }
   
    
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getIndex() {
        return index;
    }

    public Card[] getArrOfCards() {
        return arrOfCards;
    }
    
   
   
   
    
}
