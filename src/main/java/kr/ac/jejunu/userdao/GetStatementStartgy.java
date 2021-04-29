package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GetStatementStartgy implements StatementStrategy {
    @Override
    public PreparedStatement makePreparedStatement(Object object, Connection connection) throws SQLException {
        Integer id = (Integer) object;
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from userinfo where id = ?");
        preparedStatement.setLong(1, id);
        return preparedStatement;
    }
}
