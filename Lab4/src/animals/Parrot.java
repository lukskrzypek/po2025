package animals;

public class Parrot extends Animal{
    public Parrot() {
        super("Parrot",2);
    }
    @Override
    public String getDescription() {
        return "Name: "+name+"\nLegs: "+legs;
    }
}
