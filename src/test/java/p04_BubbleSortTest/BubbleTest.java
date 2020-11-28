package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {


    @Test
    public void testSortedAlgorithm() {
        boolean result = false;
        int[] arr = sor();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                result = true;
            }else {
                result = false;
                break;
            }
        }

        Assert.assertTrue(result);
    }

    public static int[] sor() {
        int[] arr = new int[]{1, 11 ,100, 200, 43, 25, 2, 0, -10, -1, 1000, 536, 645};
        Bubble.sort(arr);
        return arr;
    }
}
