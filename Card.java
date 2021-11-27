
package blackjack;

public class Card {
       
    private int suit;
    private int rank;
    private int value;
    
    public Card(int suit,int rank, int value) // Parameterized constructor
    {
        this.suit=suit;
        this.rank=rank;
        this.value=value;
    }
    
    public Card(Card obj) //Copy constructor
    {
        this.suit=obj.suit;
        this.rank=obj.rank;
        this.value=obj.value;
    }

    //Getters 
    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }
    
}
