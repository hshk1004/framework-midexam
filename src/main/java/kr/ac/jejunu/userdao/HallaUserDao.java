package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//한라유저 넣기 클래스 겟 커넥션(오브젝트)에 대한 부분을 자식 메서드인 이곳에서 해결하는것이 팩토리 메서드 패턴
public class HallaUserDao extends UserDao {
    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost/halla?serverTimezone=UTC"
                , "halla", "hallaupw");
    }
}
