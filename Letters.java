package hw4;

public class Letters {
    private final Object monitor = new Object();
    private volatile char currentLetter = 'A';

    public void print(char letter, char nextLetter){
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != letter){
                        monitor.wait();
                    }
                    System.out.print(letter);
                    currentLetter = nextLetter;
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Letters letters = new Letters();

        Thread t1 = new Thread(() -> {
            letters.print('A', 'B');
        });
        Thread t2 = new Thread(() -> {
            letters.print('B', 'C');
        });
        Thread t3 = new Thread(() -> {
            letters.print('C', 'A');
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
