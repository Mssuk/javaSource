package Mall;

import java.util.HashMap;
import java.util.Map;


public class Login {

    private HashMap<String,String> session = new HashMap<>();
    private Member loginMember;
    boolean sessionEmpty(){
        return session.isEmpty();
    }

    void login(String id, String pw, Member loginMember) {
        session.put(id, pw);
        this.loginMember = loginMember;
        System.out.println("로그인 성공");
    }

    void logout(){
        session.clear();
        System.out.println("로그아웃 완료");
    }

    void logout(String id){
        if(session.remove(id)!=null) {
            System.out.println("로그아웃 완료");
        } else{
            System.out.println("아이디가 틀렸습니다.");
        }
    }

    Map.Entry getLoginInfo(){
        try{
            return session.entrySet().iterator().next();
        }catch (Exception e){
            return null;
        }
    }

    public Member getLoginMember() {
        return loginMember;
    }
}
