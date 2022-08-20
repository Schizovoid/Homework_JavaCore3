package Homework.Homework1_Generics.Assignment2;
//2. Написать метод, который преобразует массив в ArrayList;
import java.util.ArrayList;
import java.util.List;

public class MigrateData {
    private static <T> ArrayList<T> migrateData (T[] from) {
        return new ArrayList<>(List.of(from));
    }

    public static void main(String[] args) {
    Integer[] intArr = new Integer[] {1,2,3,4,5};
        System.out.println(migrateData(intArr));
    String[] stringArr = new String[] {"One", "Two", "Three", "Four", "Five"};
        System.out.println(migrateData(stringArr));
    }
}