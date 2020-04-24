package hw7;
// Задача 1

public class Kit2 {
    @BeforeSuite
    public void begin(){
        String s = "Начало теста Kit2";
        System.out.println(s);
    }

    @Test(priority = 1)
    public int multi(){
        int a = 2;
        int b = 1;
        int c = a * b;
        return c;
    }

    @Test(priority = 0)
    public int div(){
        int a = 5;
        int b = 1;
        int c = a / b;
        return c;
    }

    @AfterSuite
    public void end(){
        String s = "Конец теста Kit2";
        System.out.println(s);
    }
}
