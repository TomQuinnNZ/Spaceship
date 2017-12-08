public class Item {
    private String name;
    private double weight; //weight in kg!
    public static final double kgConvert = 1000.0;

    //constructor
    public Item(String name, double weight) {
        this.name = name;
        this.weight = weight / kgConvert;
        //System.out.println("Item Name: '" + this.getName() +
        //        "', Item Weight: " + this.getWeight() + " tonnes. [CREATED]");
    }

    public double getWeight() {
        return this.weight;
    }

    public String getName() {
        return this.name;
    }
}
