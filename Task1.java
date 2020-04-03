package hw1;

public class Task1<T extends Object> {
    private T[] arr;

    public Task1(T... arr) {
        this.arr = arr;
    }

    public T[] getObj(){
        return arr;
    }

    public void setObj(T... arr){
        this.arr = arr;
    }

    public int getLength(){
        return arr.length;
    }

    public static void main(String[] args) {
        Task1 arr = new Task1("a", "b", "c");
        for (int i = 0; i < arr.getLength(); i++)
            System.out.println(arr.getObj()[i]);

        change(arr, 0, 2);

        for (int i = 0; i < arr.getLength(); i++)
            System.out.println(arr.getObj()[i]);
    }

    static void change(Task1 arr, int num1, int num2){
        if (num1 < 0 || num1 >= arr.getLength() || num2 < 0 || num2 >= arr.getLength() || num1 == num2){
            System.out.println("Неправильно указаны номера элементов");
        } else {
            Object[] arr1 = arr.getObj();
            Object next = arr1[num1];
            arr1[num1] = arr1[num2];
            arr1[num2] = next;
            arr.setObj(arr1);
        }
    }
}
