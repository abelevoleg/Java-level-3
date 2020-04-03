package hw1.task3;

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>(new Apple(), new Apple(), new Apple());
        Box<Orange> orangeBox = new Box<>(new Orange(), new Orange());
        Box<Orange> orangeBox1 = new Box<>(new Orange(), new Orange(), new Orange());

        System.out.println(appleBox.getWeight());

        System.out.println(orangeBox.compare(appleBox));
        System.out.println(orangeBox.compare(orangeBox1));

        orangeBox.summBox(orangeBox1);
        System.out.println(orangeBox1.getWeight());

        appleBox.addFruit(new Apple());
        System.out.println(appleBox.getWeight());
    }
}
