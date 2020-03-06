package Mall;

import java.util.ArrayList;

public class Login {

    private ArrayList<Member> session = new ArrayList<>();


    Member getMember(int index){
        try {
            return session.get(index);
        }catch (Exception e){
            return null;
        }
    }

    boolean sessionEmpty(){
        return session.isEmpty();
    }

    void login(Member member) {
        session.add(member);
        System.out.println("로그인 성공");
    }

    void logout(Member member){
        if(session.remove(member)){
            System.out.println("로그아웃 완료");
        } else{
            System.out.println("오류");
        }
    }
}
