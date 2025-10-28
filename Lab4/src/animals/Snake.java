package animals;

public class Snake extends Animal{
    public Snake() {
        super("Snake",0);
    }
    @Override
    public String getDescription() {
        return "Name: "+name+"\nLegs: "+legs;
    }
    void makeSound() {
        System.out.println("test");
    }
}
