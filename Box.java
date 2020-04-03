package hw1.task3;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    ArrayList<T> box = new ArrayList();

    public Box(T... fruits){
        box = new ArrayList<>(Arrays.asList(fruits));
    }

    public float getWeight(){
        float weight = box.get(0).getWeight() * box.size();

        return weight;
    }

    public boolean compare(Box compareBox){
        float weight1 = getWeight();
        float weight2 = compareBox.getWeight();

        if (weight1 == weight2) return true;
        else return false;
    }

    public void summBox(Box<T> addBox){
        addBox.box.addAll(box);
        box.clear();
    }

    public void addFruit(T fruit){
        box.add(fruit);
    }
}
