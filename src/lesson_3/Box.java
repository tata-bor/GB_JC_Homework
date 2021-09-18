package lesson_3;

import java.util.ArrayList;
import java.util.Arrays;

public class Box <T extends Fruit> {
    ArrayList<T> fruits;

    public float getWeight() {
        if (fruits.size() == 0) {
            return 0;
        }
        return fruits.get(0).getWeight() * fruits.size();
    }

    public Box(T[] fr) {
        fruits = new ArrayList<T>(Arrays.asList(fr));
    }

    public boolean compare(Box<T> box) {
        return this.getWeight() == box.getWeight();
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public void move (Box <T> fruitBox) {
        while (fruits.size() > 0) {
            T y = fruits.remove(0);
            fruitBox.addFruit(y);
        }
    }
}
