package p01_Database;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    @Test
    public void testDatabaseConstructorIsWorkCorrectly() throws OperationNotSupportedException {
        Integer[] numbers = {34, 52, 25, 13, 10};
        Database database = new Database(numbers);
        Assert.assertEquals(5, database.getElements().length, 0);
        for (int i = 0; i < database.getElements().length; i++) {
            Assert.assertEquals(numbers[i], database.getElements()[i], 0);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testToCreateDatabaseWithLessThan1IntegersLong() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        Database database = new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testToCreateDatabaseWithMoreThan16IntegersLong() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        Database database = new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddCommandWithNull() throws OperationNotSupportedException {
      Integer[] numbers = {34, 2, 53};
      Database database = new Database(numbers);
      database.add(null);
    }

    @Test
    public void testAddCommandForAddingElementOnNextFreeIndex() throws OperationNotSupportedException {
        Integer[] numbers = {34, 2, 53};
        Database database = new Database(numbers);
        database.add(55);
        int searchingIndex = numbers.length;
        Assert.assertEquals(searchingIndex, database.getElements().length - 1, 0);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemovingElementFromEmptyDatabase() throws OperationNotSupportedException {
        Database database = new Database(1);
        database.remove();
        database.remove();
    }

    @Test
    public void testRemoveCommandForRemoveElementFromLastIndex() throws OperationNotSupportedException {
        Database database = new Database(1, 5, 10);
        int searchingIndex = database.getElements().length - 1;
        database.remove();
        Assert.assertEquals(--searchingIndex, database.getElements().length - 1);
        database.remove();
        Assert.assertEquals(--searchingIndex, database.getElements().length - 1);
    }

}
