import java.util.*;

public class U1 extends Rocket {
    Random random = new Random();

    public U1() {
        this.weight = 10.00;
        this.maxWeight = 18.00;
        this.cost = 100000000;
    }
    public boolean launch() {
        double chance = 0.05 * (this.getCurrentCargoWeight() / this.getMaxWeight());
        double randomNum = random.nextDouble();
        if (randomNum < chance) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean land() {
        double chance = 0.01 * (this.getCurrentCargoWeight() / this.getMaxWeight());
        double randomNum = random.nextDouble();
        if (randomNum < chance) {
            return true;
        }
        else {
            return false;
        }
    }
}
