import java.util.*;

public class Main {

    public static void main(String[] args) {
        phaseOne();
        phaseTwo();
    }

    public static void phaseOne() {
        Simulation ourSim = new Simulation();
        System.out.println("Loading items...");
        ArrayList<Item> items = ourSim.loadItems("phase-1.txt");
        System.out.println();

        ArrayList<Rocket> u1Fleet = ourSim.loadU1(items);
        ArrayList<Rocket> u2Fleet = ourSim.loadU2(items);
        System.out.println();

        System.out.println("[SIMULATION RESULTS: PHASE 1]");
        System.out.println("------[U1]------");
        double u1Cost = ourSim.runSimulation(u1Fleet);
        System.out.println("Phase One Cost for U1 Rockets: $" + (u1Cost / 1000000) + "M.");
        System.out.println("------[U2]------");
        double u2Cost = ourSim.runSimulation(u2Fleet);
        System.out.println("Phase One Cost for U2 Rockets: $" + (u2Cost/ 1000000) + "M.");
        System.out.println("-------------------------------------------------------------");
    }

    public static void phaseTwo() {
        Simulation ourSim = new Simulation();
        System.out.println("Loading items...");
        ArrayList<Item> items = ourSim.loadItems("phase-2.txt");
        System.out.println();

        ArrayList<Rocket> u1Fleet = ourSim.loadU1(items);
        ArrayList<Rocket> u2Fleet = ourSim.loadU2(items);
        System.out.println();

        System.out.println("[SIMULATION RESULTS: PHASE 2]");
        System.out.println("------[U1]------");
        double u1Cost = ourSim.runSimulation(u1Fleet);
        System.out.println("Phase Two Cost for U1 Rockets: $" + (u1Cost / 1000000) + "M.");
        System.out.println("------[U2]------");
        double u2Cost = ourSim.runSimulation(u2Fleet);
        System.out.println("Phase Two Cost for U2 Rockets: $" + (u2Cost/ 1000000) + "M.");
        System.out.println();
    }
}
