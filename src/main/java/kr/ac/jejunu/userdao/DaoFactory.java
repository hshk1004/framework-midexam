package kr.ac.jejunu.userdao;

//의존성 관리 및 의존성 오브젝트에 주입 - 디펜던시 인젝션
public class DaoFactory {
    public UserDao getUserDao() {
        return new UserDao(getConnentionMaker());
    }

    private JejuConnentionMaker getConnentionMaker() {
        return new JejuConnentionMaker();
    }
}
