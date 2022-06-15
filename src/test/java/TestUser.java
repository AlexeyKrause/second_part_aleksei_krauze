
import com.akrauze.buscompany.controllers.UserController;
import com.akrauze.buscompany.daoimpl.UserDaoImpl;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)
public class TestUser {
    @Autowired
    SqlSession sqlSession;
    @Autowired
    UserDaoImpl userDao;

//    @BeforeAll()
//    public static void setUp() {
//        if (!setUpIsDone) {
//            boolean initSqlSessionFactory = MyBatisUtils.initSqlSessionFactory();
//            if (!initSqlSessionFactory) {
//                throw new RuntimeException("Can't create connection, stop");
//            }
//            setUpIsDone = true;
//        }
//    }

    @Test
    public void testInsertSelectUser() {
//        User user = userDao.insert(new User("Alex", "Smith", "", "Alex1", "root"));
//
//        User userFromDb = userDao.getUser(user.getId());
//        assertEquals(user, userFromDb);
    }

}
