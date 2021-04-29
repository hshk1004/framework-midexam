package kr.ac.jejunu.userdao;

import javax.sql.DataSource;
import java.sql.*;

public class UserDao {
    private final kr.ac.jejunu.userdao.jdbcContext jdbcContext;

    //생성자를 통해서 UserDao를 사용하는 쪽으로 디펜던시 던짐 - 클라이언트 - 유저 디에이오 테스트
    public UserDao(jdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public User get(Integer id) throws SQLException {
        StatementStrategy statementStrategy = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from userinfo where id = ?");
            preparedStatement.setLong(1, id);
            return preparedStatement;
        };
        return jdbcContext.jdbcContextForGet(statementStrategy);
    }

    //유저 추가 기능
    public void insert(User user) throws SQLException {
        StatementStrategy statementStrategy = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into userinfo (name, password) values (?,?)"
        );
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            return preparedStatement;
        };
        jdbcContext.jdbcContextForinsert(user, statementStrategy);
    }

    public void update(User user) {
        StatementStrategy statementStrategy = connection -> {
            PreparedStatement preparedStatement= connection.prepareStatement(
                    "update userinfo set name = ?, password = ? where id = ?"
            );
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getId());
            return preparedStatement;
        };
        jdbcContext.jdbcContextForUpdate(statementStrategy);
    }

    public void delete(Integer id) {
        StatementStrategy statementStrategy = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "delete from userinfo where id = ?"
            );

            preparedStatement.setInt(1, id);
            return preparedStatement;
        };
        jdbcContext.jdbcContextForUpdate(statementStrategy);
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

