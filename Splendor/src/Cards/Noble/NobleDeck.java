package Cards.Noble;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The NobleDeck class
 */

public class NobleDeck {

    private ArrayList<Noble> nobles = new ArrayList<>();

    public NobleDeck() {
        createNobles();
        shuffleDeck();
    }

    // Create all nobles, there are 10 nobles in total
    private void createNobles() {
    // call noble constructor: new Noble(points, blackCost, whiteCost, redCost, blueCost, greenCost)
    // Note: The Cost here is not the cost of token, it is the number of particular color development card 
    //       a player must have. This is the actually the bonus a player owned.

        nobles.add(new Noble(3, 0, 0, 4, 0, 4, "noble1")); // 4R + 4G
        nobles.add(new Noble(3, 3, 3, 3, 0, 0, "noble2")); // 3B + 3W + 3R
        nobles.add(new Noble(3, 0, 4, 0, 4, 0, "noble3")); // 4W + 4Blu
        nobles.add(new Noble(3, 4, 4, 0, 0, 0, "noble4")); // 4Blk + 4W
        nobles.add(new Noble(3, 0, 0, 0, 4, 4, "noble5")); // 4Blu + 4G
        nobles.add(new Noble(3, 0, 0, 3, 3, 3, "noble6")); // 3R + 3Bl + 3G
        nobles.add(new Noble(3, 0, 3, 0, 3, 3, "noble7")); // 3W + 3Bl + 3G
        nobles.add(new Noble(3, 4, 0, 4, 0, 0, "noble8")); // 4B + 4R
        nobles.add(new Noble(3, 3, 3, 0, 3, 0, "noble9")); // 3B + 3W + 3Blu
        nobles.add(new Noble(3, 3, 0, 3, 0, 3, "noble10")); // 3B + 3R + 3G
    }

    // Method in the collection to automatically shuffle the order of the cards for every level.
    private void shuffleDeck() {
        Collections.shuffle(nobles);
    }

    // Method to draw cards to place on the table for each level
    public Noble draw(){
        if (isEmpty()) {
            throw new IllegalArgumentException("Noble cards are not enough");
        }
        return nobles.remove(0);
    }

    // Getter, get the number of Noble in the desk
    public int size(){
        return nobles.size();
    }

    // Getter, get the list of Nobles in the desk
    public ArrayList<Noble> getNobles() {
        return new ArrayList<>(nobles);
    }

    // remove a noble card from desk
    public void removeNoble(Noble noble){
        nobles.remove(noble);
    }

    // check if the noble desk is empty
    public boolean isEmpty() {
        return nobles.isEmpty();
    }

}
