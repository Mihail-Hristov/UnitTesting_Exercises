package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {
    private final static String[] START_ELEMENTS = new String[]{"first", "second", "third", "fourth"};

    private ListIterator listIterator;

    @Before
    public void initializationListIterator() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(START_ELEMENTS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testInitializationListIteratorWithNull() throws OperationNotSupportedException {
        listIterator = new ListIterator(null);
    }

    @Test
    public void testMoveCommandForMovingSuccessfullyInternalIndex() {
        boolean result = listIterator.move();
        Assert.assertTrue(result);
    }

    @Test
    public void testMoveCommandForMovingInternalIndexOutOfBound() {
        listIterator.move();
        listIterator.move();
        listIterator.move();
        boolean result = listIterator.move();
        Assert.assertFalse(result);
    }

    @Test
    public void testHasNextForForMoreElement() {
        boolean hasNextElement = listIterator.hasNext();
        Assert.assertTrue(hasNextElement);
    }

    @Test
    public void testHasNextForNoMoreElements() {
        listIterator.move();
        listIterator.move();
        listIterator.move();
        boolean hasNextElement = listIterator.hasNext();
        Assert.assertFalse(hasNextElement);
    }

    @Test
    public void TestPrintTheElementOfCurrentInternalIndex() {
        listIterator.move();
        Assert.assertEquals("second", listIterator.print());
    }

    @Test(expected = IllegalStateException.class)
    public void TestPrintTheEmptyCollection() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        listIterator.print();
    }

}
