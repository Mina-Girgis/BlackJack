
package blackjack;

public class BlackJack {
    static Game game = new Game(); // i googled it actually :)   ; 
    public static void main(String[] args) {
        
        GUI gui = new GUI();
        game.generateCards();
        game.setInformation();
        gui.runGUI(game.getCard(), game.player[0].getArrOfCards(), game.player[1].getArrOfCards(), game.player[2].getArrOfCards(),game.player[3].getArrOfCards());
        game.play(); // Start The Game  
        
    }
    
}
