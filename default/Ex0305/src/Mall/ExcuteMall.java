package Mall;

import java.util.ArrayList;
import java.util.Scanner;

public class ExcuteMall {
    //명령어

    Login loginSession = new Login();
    ArrayList<Member> members = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    public void printMenu() {

        System.out.println("------**--.++--..-..*-*-*-");
        System.out.println("[쇼핑몰 프로그램]");
        System.out.print(loginSession.sessionEmpty() ? "1.회원가입\n" : "");
        System.out.println(loginSession.sessionEmpty() ? "2.로그인" : "2.로그아웃");
        System.out.print(loginSession.sessionEmpty()  ? "" : "3.마이페이지\n");
        System.out.println("8.회원정보검색");
        System.out.println("9.회원정보보기");
        System.out.println("0.종료");
        System.out.println("------**--.++--..-..*-*-*-");
        System.out.print(loginSession.sessionEmpty()  ? "" : "☆★☆★☆★ " + loginSession.getMember(0).getName()+ "님 환영합니다.! ☆★☆★☆★\n");
        System.out.print("원하는 번호를 선택하세요.>> ");
    }


    //id로 회원정보 검색하는 메소드 (내부사용)
    private Member findMem(String word) {
        for (Member mem : members) {
            if (mem.getId().equals(word)) {
                return mem;
            }
        }
        return null;
    }

    private boolean validateID(String id) {

        boolean result = true;
        if (id.length() < 3) {
            System.out.println("아이디는 3자리 이상이어야 합니다.");
            result = false;
        }
        if (result) {
            //멤버쓰에서 같은 아이디가 있는지 찾음.
            Member exist = findMem(id);
            if (exist != null) {
                System.out.println("중복된 아이디입니다.");
                result = false;
            }
        }

        if (result) {
            System.out.println("아이디 생성 완료.");
        } else {
            System.out.println("생성 실패. 다시 입력하세요.");
        }
        return result;

    }


    //회원가입
    public void join() {

        //로그인되어있을때 누르면 안되기때문
        if(!loginSession.sessionEmpty()){
            return;
        }

        System.out.println("회원 가입 화면입니다.");

        //아이디
        String id;
        //유효성 검사
        do {
            System.out.println("사용하실 아이디를 입력하세요. 아이디는 3자리 이상의 문자입니다. ");
            id = scan.next();

        } while (!validateID(id));

        //비밀번호
        String pw;
        System.out.println("사용하실 비밀번호를 입력하세요.");
        pw = scan.next();

        //이름
        String name;
        System.out.println("이름을 입력하세요.");
        name = scan.next();

        //전화번호
        String tel;
        System.out.println("전화번호를 입력하세요.");
        tel = scan.next();

        Member newMember = new Member(name, id, pw, tel);
        System.out.println("회원 가입을 축하합니다. 가입 포인트 100point 지급!");
        newMember.setPoint(100);

        members.add(newMember);

    }


    //로그인
    public void login() {

        //로그아웃
        if(!loginSession.sessionEmpty()){
            loginSession.logout(loginSession.getMember(0));
            return;
        }

        System.out.println("아이디를 입력하세요.");
        String inputID = scan.next();
        Member mem = findMem(inputID);
        if (mem == null) {
            System.out.println("없는 아이디입니다.");
            return;
        }
        String inputPW;
        //비밀번호 5회 입력
        for (int i = 0; i < 5; ++i) {
            System.out.println("비밀번호를 입력하세요. 5회 실패시 처음으로 돌아갑니다.");
            System.out.print(i > 0 ? "시도횟수: " + (i + 1) + "번\n" : "");
            inputPW = scan.next();
            if (inputPW.equals(mem.getPw())) {
                loginSession.login(mem);
                return;
            }
        }

        System.out.println("비밀번호 입력횟수 초과");

    }


    //회원정보검색
    public void searchMember() {
        //일치하는 인덱스 저장.
        class NameSet {
            int startIdx;
            int objIdx;

            NameSet(int objIdx, int startIdx) {
                this.objIdx = objIdx;
                this.startIdx = startIdx;
            }
        }
        ArrayList<NameSet> indices = new ArrayList<>();


        System.out.println("찾고 싶은 이름 1글자 이상 입력하세요.");
        String query = scan.next();

        for (int i = 0; i < members.size(); ++i) {
            String memName = members.get(i).getName();
            int idxOf = memName.indexOf(query);
            if (idxOf > -1) {

                indices.add(new NameSet(i, idxOf));
            }
        }
        if (indices.isEmpty()) {
            System.out.println("검색 결과 없음.");
            return;
        }

        //첫글자부터 일치하는 순서로 정렬하여 출력
        indices.sort((o1, o2) -> Integer.compare(o1.startIdx, o2.startIdx));

        for (NameSet index : indices) {
            System.out.println(members.get(index.objIdx));
        }

    }


    //회원정보보기
    public void printMembers() {
        //오름차순 정렬
        members.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));

        for (var m :
                members) {
            System.out.println(m);
        }
        System.out.println();
    }


    public void exit() {
        System.out.println("프로그램 종료..");
        System.exit(0);
    }

}
