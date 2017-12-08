import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Simulation {

    public ArrayList<Item> loadItems(String textfile) {
        File file = new File(textfile);
        try {
            Scanner scanner = new Scanner(file);
            ArrayList<Item> items = new ArrayList<Item>();
            while (scanner.hasNextLine()) {
                String[] itemStr = (scanner.nextLine().trim()).split("=");
                Item item = new Item(itemStr[0], Double.parseDouble(itemStr[1]));
                items.add(item);
            }
            return items;
        }
        catch (FileNotFoundException fnfe) {
            System.out.println("There was a problem opening '" + textfile + "'. No items were loaded!");
            System.out.println("Please double-check your filename and try again.");
            System.exit(1);
            return null;
        }
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> items) {
        System.out.println("Attempting to load up U1 rockets! ...");
        ArrayList<Rocket> u1RocketList = new ArrayList();
        int itemIndex = 0;
        while (itemIndex < (items.size())) {
            U1 u1 = new U1();
            //System.out.println("New U1 object created.");
            //System.out.println("Fresh cargo quota: " + u1.getMaxWeight() + " tonnes.");
            //System.out.println();
            while (u1.getCurrentCargoWeight() <= u1.getMaxWeight()) {
                Item currentItem = items.get(itemIndex);
                if (currentItem.getWeight() > u1.getMaxWeight()) {
                    System.out.println("This item, '" + currentItem.getName() + "', couldn't possibly fit in a U1 rocket.");
                    System.out.println("Simulation aborted.");
                    System.exit(1);
                }
                if (u1.canCarry(currentItem)) {
                    u1.carry(currentItem);
                    //System.out.println(u1.getCurrentCargoWeight() + "/" + u1.getMaxWeight() + " tonnes used.");
                    itemIndex++;
                    //we've reached the end of our items, but haven't fully filled the rocket.
                    if (itemIndex == items.size()) {
                        u1RocketList.add(u1);
                        //System.out.println("The rocket was added to the fleet. New fleet: " + u1RocketList.size());
                        break;
                    }
                } else {
                    u1RocketList.add(u1);
                    //System.out.println("The rocket was added to the fleet. New fleet: " + u1RocketList.size());
                    break;
                }
            }
        }
        System.out.println("Success!");
        return u1RocketList;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> items) {
        System.out.println("Attempting to load up U2 rockets! ...");
        ArrayList<Rocket> u2RocketList = new ArrayList();
        int itemIndex = 0;
        while (itemIndex < (items.size())) {
            U2 u2 = new U2();
            //System.out.println("New U2 object created.");
            //System.out.println("Fresh cargo quota: " + u2.getMaxWeight() + " tonnes.");
            //System.out.println();
            while (u2.getCurrentCargoWeight() <= u2.getMaxWeight()) {
                Item currentItem = items.get(itemIndex);
                if (currentItem.getWeight() > u2.getMaxWeight()) {
                    System.out.println("This item, '" + currentItem.getName() + "', couldn't possibly fit in a U2 rocket.");
                    System.out.println("Simulation aborted.");
                    System.exit(1);
                }
                if (u2.canCarry(currentItem)) {
                    u2.carry(currentItem);
                    //System.out.println(u2.getCurrentCargoWeight() + "/" + u2.getMaxWeight() + " tonnes used. [" + currentItem.getName() + " ADDED]");
                    itemIndex++;
                    //we've reached the end of our items, but haven't fully filled the rocket.
                    if (itemIndex == items.size()) {
                        u2RocketList.add(u2);
                        //System.out.println("The rocket was added to the fleet. New fleet: " + u2RocketList.size());
                        break;
                    }
                } else {
                    u2RocketList.add(u2);
                    //System.out.println("The rocket was added to the fleet. New fleet: " + u2RocketList.size());
                    break;
                }
            }
        }
        System.out.println("Success!");
        return u2RocketList;
    }

    public double runSimulation(ArrayList<Rocket> rockets) {
        double totalBudget = 0;
        int rocketCounter = 0;
        int rocketsLost = 0;
        System.out.println("There are " + rockets.size() + " rockets to be launched! Godspeed!");
        System.out.println();
        while (rocketCounter <= (rockets.size() - 1)) {
            Rocket currentRocket = rockets.get(rocketCounter);
            //add rocket cost to our running budget, regardless of success.
            totalBudget += currentRocket.cost;
            boolean launchExplosion = currentRocket.launch();
            boolean landExplosion = currentRocket.land();
            //if the rocket doesn't explode, send the next one!
            if (launchExplosion == false && landExplosion == false) {
                rocketCounter++;
                System.out.println("Rocket " + rocketCounter + " has landed successfully!");
            }
            else if (launchExplosion) {
                rocketsLost++;
                System.out.println("A rocket exploded tragically while launching!");
            }
            else if (landExplosion) {
                rocketsLost++;
                System.out.println("A rocket exploded tragically while landing!");
            }
            //System.out.println("Running budget so far: $" + (totalBudget / 1000000) + "M.");
        }
        System.out.println((rockets.size() + rocketsLost) + " rocket(s) total to complete the mission, with " +
                rocketsLost + " rocket(s) lost in the pursuit of science.");
        return totalBudget;
    }

}
