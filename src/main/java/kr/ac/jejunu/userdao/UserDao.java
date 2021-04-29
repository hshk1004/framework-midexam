package kr.ac.jejunu.userdao;

import javax.sql.DataSource;
import java.sql.*;

public class UserDao {
    private DataSource dataSource;

    //생성자를 통해서 UserDao를 사용하는 쪽으로 디펜던시 던짐 - 클라이언트 - 유저 디에이오 테스트
    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public User get(Integer id) throws ClassNotFoundException, SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("select * from userinfo where id = ?");
        preparedStatement.setLong(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));

        resultSet.close();
        preparedStatement.close();
        connection.close();
        //리턴
        return user;
    }

    //유저 추가 기능
    public void insert(User user) throws ClassNotFoundException, SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("insert into userinfo (name, password) values (?,?)", Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        resultSet.next();
        user.setId(resultSet.getInt(1));
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}

