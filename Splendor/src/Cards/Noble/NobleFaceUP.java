

package Cards.Noble;

import java.util.ArrayList;

/**
 * The NobleFaceUP class stores the (player + 1) nobles which will be used / are face up on the table.
*/
public class NobleFaceUP {

    private ArrayList<Noble> faceUp = new ArrayList<>();
    private int cardAmt;


    /**
     * Initialize (player + 1) noble cards in an arrayList to be face up
     * @param deck deck of all noble cards
     * @param playerAmt Number of players
     */
    public NobleFaceUP(NobleDeck deck, int playerAmt) {
        cardAmt = playerAmt + 1;
        if (cardAmt == 2) {
            cardAmt += 1;
        }
        
        for (int i = 0; i < cardAmt; i++) {
            Noble n = deck.draw();
            if(n != null){
                faceUp.add(n);
            }
        }
    }

    /**
     * Returns an arrayList of all face up noble cards
     * @return arrayList of all face up noble cards
     */
    public ArrayList<Noble> getFaceUp() {
        return faceUp;
    }

    /**
     * Returns face up noble card at specific index
     * @param index index of noble card in face up cards
     * @return Noble object at specific index in face up cards
     */
    public Noble getCard(int index) {
        return faceUp.get(index);
    }

    /**
     * Remove noble card from face up noble cards when it visits a player
     * @param index index of noble card to be removed 
     */
    public void remove(int index) {
        faceUp.remove(index);
    }

    /**
     * Remove noble card from face up noble cards when it visits a player
     * @param noble Noble object to be removed
     */
    public void remove(Noble noble) {
        faceUp.remove(noble);
    }

    /**
     * Formats and prints all noble cards in the noble face up deck
     */
    public void printMarket() {
        System.out.println("=== Noble ===");
        String[] colors = {"BLACK", "WHITE", "RED", "BLUE", "GREEN"};
        String[][] matrix = new String[9][faceUp.size()];

        for (int i = 0; i < faceUp.size(); i++) {
            matrix[0][i] = "Index " + i;
            matrix[1][i] = "--------------";
            matrix[2][i] = String.format("| %dpt        |", faceUp.get(i).getPoints());
            matrix[8][i] = "--------------";
            int point = 7;
            for (String color : colors) {
                if (faceUp.get(i).getCost(color) != 0) {
                    matrix[point][i] = String.format("| %-6s= %-3d|", color, faceUp.get(i).getCost(color));
                    point -= 1;
                }
            }
            while (point != 2) {
                matrix[point][i] = "|            |";
                point -= 1;
            }
        }

        for (String[] row : matrix) {
            for (String val : row) {
                System.out.printf("%-17s", val);
            }
            System.out.println();
        }
        
    }
}