package Player;

import Cards.DevelopmentCard.*;

public class Computer extends Player {
    public Computer() {
        super("Computer");
    }

    public void turnAlgorithm() {
        // 1. looks for development cards it can buy
        // 2. if there's none, take three random tokens

        // step 1
        DevelopmentCard currCard = null;
        for (int level = 3; level >= 1; level--) {
            for (int index = 0; index <= 3; index++) {
                currCard = developmentFaceUp.getCard(level, index);
            }
        }
    }
}
