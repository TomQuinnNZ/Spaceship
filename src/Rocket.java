import java.util.*;

public class Rocket implements Spaceship {
    public double weight;
    public double maxWeight;
    public int cost;
    private double currentCargoWeight = 0;
    private ArrayList<Item> cargo = new ArrayList<Item>();

    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    public boolean canCarry(Item item) {
        if ((item.getWeight() + this.getCurrentCargoWeight()) > this.getMaxWeight()) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean carry(Item item) {
        //System.out.println("'" + item.getName() + "' added to cargo.");
        cargo.add(item);
        updateCurrentCargoWeight(item);
        return true;
    }

    //getters and setters
    public double getWeight() {
        return this.weight;
    }

    public double getMaxWeight() {
        return this.maxWeight;
    }

    public double getCurrentWeight() {
        return this.currentCargoWeight + this.weight;
    }

    public double getCurrentCargoWeight() {
        return this.currentCargoWeight;
    }

    private void updateCurrentCargoWeight(Item item) {
        this.currentCargoWeight += item.getWeight();
    }
}
