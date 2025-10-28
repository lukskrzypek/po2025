package animals;

public class Dog extends Animal{
    public Dog() {
        super("Dog",4);
    }
    @Override
    public String getDescription() {
        return "Name: "+name+"\nLegs: "+legs;
    }
}
