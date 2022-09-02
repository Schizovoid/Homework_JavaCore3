package Homework.Homework1_Generics.Assignment1;

//1. Написать метод, который меняет два элемента массива местами (массив может быть любого
//ссылочного типа);

import java.util.Arrays;

public class ArraySwap {
    public static <T> void swap(T[] arr, int firstIndex, int secondIndex) {
        if (firstIndex > arr.length || secondIndex > arr.length) {
            throw new IllegalArgumentException();
        }
        T temporary = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temporary;
    }

    public static void main(String[] args) {
    Integer[] intArr = new Integer[] {1,2,3,4,5};
        System.out.println(Arrays.toString(intArr));
    swap(intArr, 2,4);
        System.out.println(Arrays.toString(intArr));
    }
}
