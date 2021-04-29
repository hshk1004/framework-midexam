package kr.ac.jejunu.userdao;


import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;

public class UserDaoTests {
    @Test
    public void testGet() throws SQLException, ClassNotFoundException {
        Integer id = 1;
        String name = "hulk";
        String password = "1234";
        ConnentionMaker connentionMaker = new JejuConnentionMaker();
        UserDao userDao = new UserDao(connentionMaker);
        User user = userDao.get(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    @Test
    public void InsertUser() throws SQLException, ClassNotFoundException {
        //추가할 사용자 이름과 비번
        String name = "whffu";
        String password = "12345";

        //유저의 이름과 비번 설정
        User user = new User();
        user.setName(name);
        user.setPassword(password);

        ConnentionMaker connentionMaker = new JejuConnentionMaker();
        UserDao userDao = new UserDao(connentionMaker);
        userDao.insert(user);
        assertThat(user.getId(), greaterThan(0));

        User insertedUser = userDao.get(user.getId());
        assertThat(insertedUser.getName(), is(name));
        assertThat(insertedUser.getPassword(), is(password));
    }

    @Test
    public void testGetHalla() throws SQLException, ClassNotFoundException {
        Integer id = 1;
        String name = "hulk";
        String password = "1234";
        ConnentionMaker connentionMaker = new HallaConnentionMaker();
        UserDao userDao = new UserDao(connentionMaker);
        User user = userDao.get(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    @Test
    public void InsertUserHalla() throws SQLException, ClassNotFoundException {
        //추가할 사용자 이름과 비번
        String name = "whffu";
        String password = "12345";

        //유저의 이름과 비번 설정
        User user = new User();
        user.setName(name);
        user.setPassword(password);

        ConnentionMaker connentionMaker = new HallaConnentionMaker();
        UserDao userDao = new UserDao(connentionMaker);
        userDao.insert(user);
        assertThat(user.getId(), greaterThan(0));

        User insertedUser = userDao.get(user.getId());
        assertThat(insertedUser.getName(), is(name));
        assertThat(insertedUser.getPassword(), is(password));

    }
}
