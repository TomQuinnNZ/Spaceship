public interface Spaceship {
    public boolean launch();
    public boolean land();
    public boolean canCarry(Item item);
    public boolean carry(Item item);
}
