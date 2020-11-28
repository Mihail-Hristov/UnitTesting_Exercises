package p05_CustomLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomLinkedListTest {
    private CustomLinkedList list;

    @Before
    public void initializationCustomLinkedList() {
        list = new CustomLinkedList();
    }

    @Test
    public void testAddElementAtTheEndOfTheList() {
        list.add(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetOutOfBoundIndex() {
        list.add(5);
        Assert.assertEquals(10, list.get(5));
    }

    @Test
    public void testGetElementAtTheSpecificIndex() {
        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);
        Assert.assertEquals(15, list.get(2));
    }



}
