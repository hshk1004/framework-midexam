package kr.ac.jejunu.userdao;


import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class UserDaoTests {
    @Test
    public void testGet() throws SQLException, ClassNotFoundException {
        Integer id = 1;
        String name = "hulk";
        String password = "1234";
        UserDao userDao = new UserDao();
        User user = userDao.get(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    @Test
    public void InsertUser() {
        Integer id = 2;
        String name = "qkqh";
        String password = "3333";
        UserDao userDao = new UesrDao();
        User user = userDao.set(id);
        assertThat(user.setId(), is(id));
        assertThat(user.setName(), is(name));
        assertThat(user.setPassword(), is(password));
    }
}
