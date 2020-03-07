package Mall;

import java.util.ArrayList;

public class Member {

    //아이디, 패스워드, 이름, 전화, 주소

    private String name;
    private String id;
    private String pw;
    private String tel;
    private int money = 3000;
    private int point;
    //가입 날짜
    private String signDate;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public Member(String name, String id, String pw, String tel){
        this.name = name;
        this.id= id;
        this.pw = pw;
        this.tel = tel;
    }

    public String getPw() {
        return pw;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("아이디:%11s | 비밀번호:%11s | 이름:%11s | 전화번호:%11s | 보유머니:%11d | 보유포인트:%11d | 가입일:%11s"
                ,id,pw,name,tel,money,point, signDate);
    }

}
