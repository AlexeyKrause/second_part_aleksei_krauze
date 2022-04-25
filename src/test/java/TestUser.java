import com.akrauze.buscompany.MyBatisUtils;
import com.akrauze.buscompany.daoImpl.TestTest;
import com.akrauze.buscompany.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestUser {

    TestTest testTest = new TestTest();
    private static boolean setUpIsDone = false;

    @BeforeAll()
    public static void setUp() {
        if (!setUpIsDone) {
            boolean initSqlSessionFactory = MyBatisUtils.initSqlSessionFactory();
            if (!initSqlSessionFactory) {
                throw new RuntimeException("Can't create connection, stop");
            }
            setUpIsDone = true;
        }
    }

    @Test
    public void testInsertSelectUser() {
        User user = testTest.insert(new User("Alex"));

        User userFromDb = testTest.getUser(user.getId());
        assertEquals(user, userFromDb);
    }

}
