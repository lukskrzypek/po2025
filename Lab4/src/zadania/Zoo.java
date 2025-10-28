package zadania;

import animals.Animal;
import animals.Parrot;
import animals.Dog;
import animals.Snake;
import java.util.Random;

public class Zoo {
    Animal[] animals= new Animal[100];

    public void fill() {
        Random rand = new Random();
        for (int i = 0; i < animals.length; i++) {
            int x = rand.nextInt(3);
            if (x == 0) {
                animals[i] = new Dog();
            } else if (x == 1) {
                animals[i] = new Parrot();
            } else {
                animals[i] = new Snake();
            }
        }
    }

    public int sumLegs() {
        int sum = 0;
        for (int i = 0; i < animals.length; i++) {
            sum += animals[i].getLegs();
        }
        return sum;
    }
}
