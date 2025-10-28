import animals.Snake;
import zadania.Zoo;
import animals.Dog;
import animals.Animal;

public static void main(String[] args) {
    Zoo zoo = new Zoo();

    zoo.fill();
    System.out.println(zoo.sumLegs());

    Animal animal = new Snake();
    System.out.println(animal.getDescription());

    int legs = animal.getLegs();

}

