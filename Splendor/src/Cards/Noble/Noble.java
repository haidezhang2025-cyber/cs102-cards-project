
package Cards.Noble;

import Cards.AbstractCard.AbstractCard;

/**
 * The Noble class stores the noble object, each noble object has points and cost for each card color.
 * Note that the cost of Noble is not tokens, but the number of bonuses collected by a player
*/
public class Noble extends AbstractCard {

    // Constructor to initialise all the information for individual card
    public Noble(int points, int blackCost, int whiteCost, int redCost, int blueCost, int greenCost, String id){

        super(points, blackCost, whiteCost, redCost, blueCost, greenCost, id);

    }

    @Override
    public String toString() {
        return super.toString();
    }

}