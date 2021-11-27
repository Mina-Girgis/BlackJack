
package blackjack;
import java.util.Random;
import java.util.Scanner;
public class Game {
       
    protected Player [] player = new Player[4];
    private Card[] card = new Card[52];
    int mxScore;
    
    
    // A function that generates the card deck array
    public void generateCards()
    {
        int index = 0;
        for (int i = 0; i < 4; i++) {
            
            for (int j = 0; j < 13; j++) 
            {
                Card obj = new Card(i,j,Integer.min(j+1, 10)); //suit rank value
                card[index] = new Card(obj);
                index++;
            }
        }
    }

    public Card[] getCard() {
        return card;
    }
    
    public Card drawCard()
    {
        Random rand= new Random();
        int x;
        while(true)
        {
            x = rand.nextInt(52);
            if(card[x] == null)continue;
            else{
                Card cardPicked = new Card(card[x]);
               // System.out.println(cardPicked.getSuit()+"  "+cardPicked.getRank()+"  "+ cardPicked.getValue());
                card[x]=null;
                return cardPicked;
            }
            
        }  
    }
    
    public void setInformation()
    {
        Scanner in=new Scanner(System.in);
        String s;
        for (int i = 0; i < 4; i++) 
        {
            System.out.println("Enter the "+num(i)+" name");
            s = in.next();
            Card c1=drawCard();
            Card c2=drawCard();
            player[i]=new Player(s,c1,c2,i);
            
        } 
        updateMxScore();
    }
    
    public void updateMxScore()
    {
        for (int i = 0; i < 3; i++) 
        {
            if(!player[i].isBusted())
            {
                mxScore=Integer.max(mxScore, player[i].getScore());
            }
        }
    }
    
    private String num(int i)
    {
        if(i==0)return "First";
        else if(i==1)return "Second";
        else if(i==2)return "Third";
        else return "fourth";
        
    }
    
    private void isBusted(int i)
    {
        System.out.println(" is busted, player`s score is equal "+player[i].getScore());
        System.out.println("");
    }
   
    
    public void winner()
    {
        int count=0;
        for (int i = 0; i < 4; i++) {      // check if there are winners or not !! 
            if(!player[i].isBusted())count++;
        }
        
        System.out.println("unBusted players "+ count);
        
        for (int i = 0; i < 4; i++) { // print all scores for all players
            System.out.println("player "+(i+1)+" score is = "+player[i].getScore());
        }
        
        
        if(count==0)System.out.println("No One Wins "); 
        else{
            count=0;
            int index= -1;
            int mx=-1;
            for (int i = 0; i < 4; i++)  // check mx score !!
            {
                if(!player[i].isBusted())
                {
                    mx=Integer.max(mx, player[i].getScore());
                }
            }
            count=0;
            for (int i = 0; i < 4; i++) { 
                if(!player[i].isBusted() && player[i].getScore()== mx )
                {
                    count++;
                    index=i+1;
                }
            }
            
            if(count>=2)System.out.println("No One Wins");
            else System.out.println("The winner is player "+index+" !!");
        }
       
    }
    
    
    
    public void play()
    {
         Scanner in=new Scanner(System.in);
        for (int i = 0; i < 3; i++) 
        {
             System.out.println("--------------------------------");
            System.out.println("It is the turn of the "+num(i)+" player");
            System.out.println("player`s score is equal " + player[i].getScore());
            System.out.println("");
            while(true)
            {
                
                System.out.println("Please Enter your choice");
                System.out.println("1 -> HIT ");
                System.out.println("2 -> STAND ");
                int x=in.nextInt();
                if(x==1)
                {
                   Card c1 = drawCard();
                   player[i].addCard(c1,i);
                }
                else
                {
                    System.out.println("");
                    break;
                }
           
                if(player[i].getScore()>21){ isBusted(i);break; }
                else{ 
                    System.out.println(" player`s score is equal " + player[i].getScore());
                    updateMxScore();
                    if(player[i].getScore()==21)break;
                }
            }
        }
        
         System.out.println("--------------------------------");
         System.out.println("It is the turn of the "+num(3)+" player");
         GUI gui = new GUI();
        while(player[3].getScore()<= mxScore)
        {
           
            Card c1 = drawCard();
            player[3].addCard(c1,3);
            gui.updateDealerHand(c1,card);
        }
        if(player[3].getScore()>21)isBusted(3);
        else{System.out.println(" player`s score is equal " + player[3].getScore());}
         System.out.println("--------------------------------");
        winner();
    }
}