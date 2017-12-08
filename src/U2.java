import java.util.*;

public class U2 extends Rocket {
    Random random = new Random();

    public U2() {
        this.weight = 18.00;
        this.maxWeight = 29.00;
        this.cost = 120000000;
    }

    public boolean launch() {
        double chance = 0.04 * (this.getCurrentCargoWeight() / this.getMaxWeight());
        double randomNum = random.nextDouble();
        if (randomNum < chance) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean land() {
        double chance = 0.08 * (this.getCurrentCargoWeight() / this.getMaxWeight());
        double randomNum = random.nextDouble();
        if (randomNum < chance) {
            return true;
        }
        else {
            return false;
        }
    }
}