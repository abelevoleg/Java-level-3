package hw1;

import java.util.ArrayList;
import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        Task1 arr = new Task1("a", "b", "c");
        Object[] array = arr.getObj();

        ArrayList<Object> list = toArrayList(array);

        for (int i = 0; i < arr.getLength(); i++) {
            System.out.println(list.get(i));
        }
    }

    static <T> ArrayList toArrayList(Object[] arr){
        return new ArrayList<>(Arrays.asList(arr));
    }
}
