package kr.ac.jejunu.userdao;


import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;

public class UserDaoTests {

    private static UserDao userDao;

    @BeforeAll
    public static void setup(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoFactory.class);
        userDao = applicationContext.getBean("getUserDao", UserDao.class);
    }

    @Test
    public void testGet() throws SQLException, ClassNotFoundException {
        Integer id = 1;
        String name = "hulk";
        String password = "1234";

//        ConnentionMaker connentionMaker = new JejuConnentionMaker();
//        UserDao userDao = new UserDao(connentionMaker);

        //의존성 DaoFactory로 던짐
        DaoFactory daoFactory = new DaoFactory();
        UserDao userDao = daoFactory.getUserDao();

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

//        ConnentionMaker connentionMaker = new JejuConnentionMaker();
//        UserDao userDao = new UserDao(connentionMaker);


        userDao.insert(user);
        assertThat(user.getId(), greaterThan(0));

        User insertedUser = userDao.get(user.getId());
        assertThat(insertedUser.getName(), is(name));
        assertThat(insertedUser.getPassword(), is(password));
    }

    @Test
    public void update() throws SQLException {
        String name = "whffu";
        String password = "12345";
        //유저의 이름과 비번 설정
        User user = new User();
        user.setName(name);
        user.setPassword(password);

        userDao.insert(user);

        //추가할 사용자 이름과 비번
        String updatedName = "dhkdlvn";
        String updatedPassword = "123415";
        user.setName(updatedName);
        user.setPassword(updatedPassword);

        userDao.update(user);

        User updatedUser = userDao.get(user.getId());
        assertThat(updatedUser.getName(), is(updatedName));
        assertThat(updatedUser.getPassword(), is(updatedPassword));
    }

    @Test
    public void delete() throws SQLException {
        String name = "whffu";
        String password = "12345";
        //유저의 이름과 비번 설정
        User user = new User();
        user.setName(name);
        user.setPassword(password);

        userDao.insert(user);

        userDao.delete(user.getId());

        User deletedUser = userDao.get(user.getId());

        assertThat(deletedUser, IsNull.nullValue());
    }

//    @Test
//    public void testGetHalla() throws SQLException, ClassNotFoundException {
//        Integer id = 1;
//        String name = "hulk";
//        String password = "1234";
//        ConnentionMaker connentionMaker = new HallaConnentionMaker();
//        UserDao userDao = new UserDao(connentionMaker);
//        User user = userDao.get(id);
//        assertThat(user.getId(), is(id));
//        assertThat(user.getName(), is(name));
//        assertThat(user.getPassword(), is(password));
//    }
//
//    @Test
//    public void InsertUserHalla() throws SQLException, ClassNotFoundException {
//        //추가할 사용자 이름과 비번
//        String name = "whffu";
//        String password = "12345";
//
//        //유저의 이름과 비번 설정
//        User user = new User();
//        user.setName(name);
//        user.setPassword(password);
//
//        ConnentionMaker connentionMaker = new HallaConnentionMaker();
//        UserDao userDao = new UserDao(connentionMaker);
//        userDao.insert(user);
//        assertThat(user.getId(), greaterThan(0));
//
//        User insertedUser = userDao.get(user.getId());
//        assertThat(insertedUser.getName(), is(name));
//        assertThat(insertedUser.getPassword(), is(password));
//
//    }
}
