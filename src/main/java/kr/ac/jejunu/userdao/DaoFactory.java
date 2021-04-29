package kr.ac.jejunu.userdao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//의존성 관리 및 의존성 오브젝트에 주입 - 디펜던시 인젝션
@Configuration
public class DaoFactory {
    @Bean
    public UserDao getUserDao() {
        return new UserDao(connentionMaker());
    }

    @Bean
    public ConnentionMaker connentionMaker() {
        return new JejuConnentionMaker();
    }
}
