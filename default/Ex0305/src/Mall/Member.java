package Mall;

import java.util.ArrayList;

public class Member {

    //아이디, 패스워드, 이름, 전화, 주소

    private String name;
    private String id;
    private String pw;
    private String tel;
    private int money;
    private int point;
    //가입 날짜
    private String signDate;

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
        return String.format("아이디:%s\t비밀번호:%s\t이름:%s\t전화번호:%s\t보유머니:%d\t보유포인트:%d\t가입일:%s",id,pw,name,tel,money,point, signDate);
    }

}
