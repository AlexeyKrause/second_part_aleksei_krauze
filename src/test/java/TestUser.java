import com.akrauze.buscompany.MyBatisUtils;
import com.akrauze.buscompany.daoImpl.UserDao;
import com.akrauze.buscompany.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestUser {

    UserDao userDa = new UserDao();
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
        User user = userDa.insert(new User("Alex", "Smith", "", "Alex1", "root"));

        User userFromDb = userDa.getUser(user.getId());
        assertEquals(user, userFromDb);
    }

}
