package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {


    private static final Integer FIRST_NUMBER = 34;
    private static final Integer SECOND_NUMBER = 52;
    private static final Integer THIRD_NUMBER = 25;

    private Database database;
    private Integer[] numbers;

    @Before
    public void createDatabase() throws OperationNotSupportedException {
        this.numbers = new Integer[]{FIRST_NUMBER, SECOND_NUMBER, THIRD_NUMBER};
        this.database = new Database(numbers);
    }

    @Test
    public void testDatabaseConstructorIsWorkCorrectly() throws OperationNotSupportedException {
        Assert.assertEquals(3, database.getElements().length, 0);
        for (int i = 0; i < database.getElements().length; i++) {
            Assert.assertEquals(numbers[i], database.getElements()[i], 0);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testToCreateDatabaseWithLessThan1IntegersLong() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        database = new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testToCreateDatabaseWithMoreThan16IntegersLong() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        database = new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddCommandWithNull() throws OperationNotSupportedException {
      database.add(null);
    }

    @Test
    public void testAddCommandForAddingElementOnNextFreeIndex() throws OperationNotSupportedException {
        database.add(55);
        int searchingIndex = numbers.length;
        Assert.assertEquals(searchingIndex, database.getElements().length - 1, 0);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemovingElementFromEmptyDatabase() throws OperationNotSupportedException {
        database.remove();
        database.remove();
        database.remove();
        database.remove();
    }

    @Test
    public void testRemoveCommandForRemoveElementFromLastIndex() throws OperationNotSupportedException {
        int searchingIndex = database.getElements().length - 1;
        database.remove();
        Assert.assertEquals(--searchingIndex, database.getElements().length - 1);
        database.remove();
        Assert.assertEquals(--searchingIndex, database.getElements().length - 1);
    }

    @Test
    public void testFetchMethodToReturnArray() throws OperationNotSupportedException {
        Integer[] numbers = {3, 16, 84, 10, 35};
        Database database = new Database(numbers);
        Integer[] result = database.getElements();
        Assert.assertEquals(numbers, result);
    }

}
