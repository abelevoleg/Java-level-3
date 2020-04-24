package hw7;
// Задача 1

import java.lang.annotation.Annotation;

public class Kit1 {
    @BeforeSuite
    public void begin(){
        String s = "Начало теста Kit1";
        System.out.println(s);
    }

    @Test(priority = 1)
    public int summ(){
        int a = 2;
        int b = 1;
        int c = a + b;
        return c;
    }

    @Test(priority = 0)
    public int sub(){
        int a = 2;
        int b = 1;
        int c = a - b;
        return c;
    }

    @AfterSuite
    public void end(){
        String s = "Конец теста Kit1";
        System.out.println(s);
    }
}
