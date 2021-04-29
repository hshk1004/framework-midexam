package kr.ac.jejunu.userdao;

import java.sql.*;

public class UserDao {
    private final kr.ac.jejunu.userdao.jdbcContext jdbcContext;

    //생성자를 통해서 UserDao를 사용하는 쪽으로 디펜던시 던짐 - 클라이언트 - 유저 디에이오 테스트
    public UserDao(jdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public User get(Integer id) throws SQLException {
        Object[] params = new  Object[] {id};
        String sql = "select * from userinfo where id = ?";
        return jdbcContext.getUser(params, sql);
    }

    //유저 추가 기능
    public void insert(User user) throws SQLException {
        Object[] params = new  Object[] {user.getName(), user.getPassword()};
        String sql = "insert into userinfo (name, password) values (?,?)";
        jdbcContext.insert(user, params, sql, this);
    }

    public void update(User user) {
        Object[] params = new  Object[] {user.getName(), user.getPassword(), user.getId()};
        String sql = "update userinfo set name = ?, password = ? where id = ?";
        jdbcContext.update(sql, params);
    }

    public void delete(Integer id) {
        Object[] params = new  Object[] {id};
        String sql = "delete from userinfo where id = ?";
        jdbcContext.update(sql, params);
    }

    private User jdbcContextForGet(StatementStrategy statementStrategy) throws SQLException {
        return jdbcContext.jdbcContextForGet(statementStrategy);
    }

    private void jdbcContextForinsert(User user, StatementStrategy statementStrategy) throws SQLException {
        jdbcContext.jdbcContextForinsert(user, statementStrategy);
    }

    private void jdbcContextForUpdate(StatementStrategy statementStrategy) {

        jdbcContext.jdbcContextForUpdate(statementStrategy);
    }

}

