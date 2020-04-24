package hw7;
// Задача 2
// Сделал с заранее известными именами методов, т.к. вариант с неизвестными именами методов
// был реализован в задаче 1 (чтобы не повторяться)

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.io.*;

public class CheckDZ {
    public static void check() throws Exception {
        File file = new File("C:/Java/Level3/out/production/Level3/DZ");

        String[] str = file.list();

        for (String  o : str) {
            String[] mass = o.split("\\.");
            if (!mass[1].equalsIgnoreCase("class")) {
                throw new RuntimeException(o, new Exception());
            }

            System.out.println(mass[0] + ":");

            Class ch = URLClassLoader.newInstance(new URL[] {file.toURL()}).loadClass(mass[0]);
            Constructor constructor = ch.getConstructor();
            Object check = constructor.newInstance();

            Method m1 = ch.getDeclaredMethod("calculate", int.class, int.class, int.class, int.class);
            m1.setAccessible(true);
            int result1 = (int) m1.invoke(check, 1, 1, 1, 1);
            System.out.print(result1);
            if (result1 == 2) System.out.println(" (правильный ответ)");
            else System.out.println(" (неправильный ответ)");

            Method m2 = ch.getDeclaredMethod("checkTwoNumbers", int.class, int.class);
            m2.setAccessible(true);
            boolean result2 = (boolean) m2.invoke(check, 7, 7);
            System.out.print(result2);
            if (result2 == true) System.out.println(" (правильный ответ)");
            else System.out.println(" (неправильный ответ)");

            Method m3 = ch.getDeclaredMethod("isNegative", int.class);
            m3.setAccessible(true);
            boolean result3 = (boolean) m3.invoke(check, -7);
            System.out.print(result3);
            if (result3 == true) System.out.println(" (правильный ответ)");
            else System.out.println(" (неправильный ответ)");

            Method m4 = ch.getDeclaredMethod("isLeapYear", int.class);
            m4.setAccessible(true);
            boolean result4 = (boolean) m4.invoke(check, 2020);
            System.out.print(result4);
            if (result4 == true) System.out.println(" (правильный ответ)");
            else System.out.println(" (неправильный ответ)");
        }
    }

    public static void main(String[] args) {
        try {
            check();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
