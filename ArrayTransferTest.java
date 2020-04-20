package hw6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayTransferTest {

    ArrayTransfer arrayTransfer;

    @Before
    public void init() {
        arrayTransfer = new ArrayTransfer();
    }

    @Test
    public void test1() {
        Assert.assertArrayEquals(new Integer[]{2, 2}, arrayTransfer.transfer(new int[]{4, 2, 2}));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new Integer[]{1, 7}, arrayTransfer.transfer(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}));
    }

    @Test(expected = RuntimeException.class)
    public void test3() {
        Assert.assertArrayEquals(null, arrayTransfer.transfer(new int[]{1, 2, 2, 3, 1, 7}));
    }
}
