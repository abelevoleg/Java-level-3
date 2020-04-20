package hw6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CheckMassTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[]{1, 1, 1, 4, 4, 1, 4, 4}},
                {new int[]{1, 1, 1, 1, 1, 1 }},
                {new int[]{4, 4, 4, 4}},
                {new int[]{1, 4, 4, 1, 1, 4, 3}},
                {new int[]{1, 4}},
        });
    }

    private int[] b;

    public CheckMassTest(int[] b) {
        this.b = b;
    }

    CheckArray checkArray;

    @Before
    public void init() {
        checkArray = new CheckArray();
    }

    @Test
    public void massTestCheck() {
        Assert.assertTrue(checkArray.check(b));
    }
}
