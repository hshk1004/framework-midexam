package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//추상화 한 메서드 하나만 있으고 추상화 한 클래스이니 인터페이스 사용으로 추상화
public interface ConnentionMaker {
    public Connection getConnection() throws ClassNotFoundException, SQLException;
}