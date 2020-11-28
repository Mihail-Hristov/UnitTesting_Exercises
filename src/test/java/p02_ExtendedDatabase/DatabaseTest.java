package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private final static int FIRST_ID = 523;
    private final static int SECOND_ID = 312;
    private final static int THIRD_ID = 443;
    private final static int NEGATIVE_ID = -5;
    private final static String FIRST_NAME = "Misho";
    private final static String SECOND_NAME = "Pesho";
    private final static String THIRD_NAME = "Ivan";

    private Person person1;
    private Person person2;
    private Person person3;
    private Database database;

    @Before
    public void createDatabase() throws OperationNotSupportedException {
        this.person1 = new Person(FIRST_ID, FIRST_NAME);
        this.person2 = new Person(SECOND_ID, SECOND_NAME);
        this.person3 = new Person(THIRD_ID, THIRD_NAME);

        this.database = new Database(person1, person2, person3);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testToAddNegativeId() throws OperationNotSupportedException {
        Person person = new Person(NEGATIVE_ID, FIRST_NAME);
        this.database.add(person);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testToAddNullId() {
        Person person = new Person(0, FIRST_NAME);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindUserWithNoExistName() throws OperationNotSupportedException {
        database.findByUsername("Petar");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindUserWithNullForName() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindUserWithNoExistId() throws OperationNotSupportedException {
        database.findById(555);
    }
}
