package Homework.Homework1_Generics.Assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<E extends Fruit> {
    ArrayList <E> content;


    public Box(E... content){
        this.content = new ArrayList<>(Arrays.asList(content));
    }

    public float getWeight(){
    float sum = 0.0f;
        for (E fruit:content)
        { sum+= fruit.getWeight();
        }
        return sum;
    }
    public void addFruit(List <? extends E> someFruit) {
    content.addAll(someFruit);
    }

    public boolean compare (Box<? extends Fruit> another) {
        return this.getWeight() == another.getWeight();
    }
    public void moveTo (Box <? super E> another) {
        another.addFruit(content);
        content.clear();
    }
}
