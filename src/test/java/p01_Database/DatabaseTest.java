package p01_Database;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    @Test(expected = OperationNotSupportedException.class)
    public void testToCreateDatabaseWithMoreThan16IntegersLong() throws OperationNotSupportedException {
        Database database = new Database(13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,1,31,3,13);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testToCreateDatabaseWithLessThan16IntegersLong() throws OperationNotSupportedException {
        Database database = new Database(13,13);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddCommandWithNullPassedElement() throws OperationNotSupportedException {
        Database database = new Database(13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13);
        database.add(15);
        database.add(15);
        database.add(15);
        database.add(15);
        database.add(15);

        for (int i = 16; i < 21; i++) {
            Assert.assertEquals(database.getElements()[i], database.getIndex(), 0);
        }
    }
}
