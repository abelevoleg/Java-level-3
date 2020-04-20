package hw6;

import java.util.ArrayList;

public class ArrayTransfer {
    public Integer[] transfer(int[] array) throws RuntimeException {
        ArrayList<Integer> trans = new ArrayList<>();

        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 4) {
                for (int j = i + 1; j < array.length; j++){
                    trans.add(array[j]);
                }
                break;
            }
        }

        if (trans.isEmpty()){
            throw new RuntimeException("Входной массив не содержит четверок!");
        }
        return trans.toArray(new Integer[0]);
    }
}
