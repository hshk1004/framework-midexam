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
        StatementStrategy statementStrategy = new GetStatementStartgy(id);
        return jdbcContext.jdbcContextForGet(statementStrategy);
    }

    //유저 추가 기능
    public void insert(User user) throws SQLException {
        StatementStrategy statementStrategy = new InsertStatementStrategy(user);
        jdbcContext.jdbcContextForinsert(user, statementStrategy);
    }

    public void update(User user) {
        StatementStrategy statementStrategy = new UpdateStatementStartgy(user);
        jdbcContext.jdbcContextForUpdate(statementStrategy);
    }

    public void delete(Integer id) {
        StatementStrategy statementStrategy = new DeleteStatementStrategy(id);
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

