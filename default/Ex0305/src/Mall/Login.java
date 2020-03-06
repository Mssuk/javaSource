package Mall;

import java.util.ArrayList;
import java.util.HashMap;

public class Login {

    private HashMap<String,String> session = new HashMap<>();

    boolean sessionEmpty(){
        return session.isEmpty();
    }

    void login(String id, String pw) {
        session.put(id, pw);
        System.out.println("로그인 성공");
    }

    void logout(String id){
        if(session.remove(id)!=null) {
            System.out.println("로그아웃 완료");
        } else{
            System.out.println("아이디가 틀렸습니다.");
        }
    }

    //구매 전 로그인 상태 확인
    boolean checkLogin(String id){
        return session.containsKey(id);
    }
}
