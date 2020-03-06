package Mall;

import Mall.Product.Product;
import Mall.Product.Ref.*;
import Mall.Product.TV.*;
import Mall.Product.Washer.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ExcuteMall {
    //명령어

    Login loginSession = new Login();
    ArrayList<Member> members = new ArrayList<>();
    HashMap<Integer, Product> products = new HashMap<>();
    ArrayList<Purchase> purchaseLog = new ArrayList<>();

    Scanner scan = new Scanner(System.in);

    ExcuteMall(){
        int proNumber = 1;
        //시작할 때 상품 목록에 상품 넣어줌
        products.put(proNumber++,new LCD(1000,"42LCDTV", "black",42));
        products.put(proNumber++, new LED(1200,"TNMTV 무결점", "black",65));
        products.put(proNumber++, new OLED(1900,"65OLED873 필립스", "black",65));
        products.put(proNumber++, new BasicRef(320, "레트로 원도어", "red", 92));
        products.put(proNumber++, new DobuleDoorRef(1140, "디오스 S831S30", "silver", 821));
        products.put(proNumber++, new TopLoader(374, "TR13BK LG통돌이", "white", 13));
        products.put(proNumber++, new FrontLoader(519, "트롬F9WK", "silver", 9));
        products.put(proNumber++, new DryFrontLoader(1470, "H드럼 플렉스워시건조", "black", 20));
    }


    public void printMenu() {

        System.out.println("------**--.++--..-..*-*-*-");
        System.out.println("[쇼핑몰 프로그램]");
        System.out.print(loginSession.sessionEmpty() ? "1.회원가입\n" : "");
        System.out.println(loginSession.sessionEmpty() ? "2.로그인" : "3.로그아웃");
        System.out.println("4.상품구매");
        System.out.print(loginSession.sessionEmpty() ? "" : "5.구매내역보기\n");
        System.out.println("8.회원정보검색");
        System.out.println("9.회원정보보기");
        System.out.println("0.종료");
        System.out.println("------**--.++--..-..*-*-*-");
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

        Calendar time = Calendar.getInstance();
        newMember.setSignDate(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(time.getTime()));

        members.add(newMember);

    }


    //로그인
    public void login() {

        //로그아웃 안했을 때는 로그인 못함
        if(!loginSession.sessionEmpty()){
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
                //로그인
                loginSession.login(inputID, inputPW);
                return;
            }
        }

        System.out.println("비밀번호 입력횟수 초과");

    }

    //로그아웃
    public  void logout(){
        //로그인 안했을 때는 로그아웃 못함
        if(loginSession.sessionEmpty()){
            return;
        }

        //ID를 한번더 입력 후 일치한 ID 삭제
        System.out.println("아이디를 입력하세요");
        String inputID = scan.next();
        loginSession.logout(inputID);

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


    //상품 구매
    public void buy(){
        System.out.println("상품 구매입니다.");

        System.out.println("아이디를 입력해주세요.");
        String id = scan.next();
        if(loginSession.checkLogin(id)){
            System.out.println("반갑습니다 " + id+ "님");
        } else if(loginSession.sessionEmpty()){
            System.out.println("로그인을 먼저 해주세요.");
            return;
        } else{
            System.out.println("아이디를 올바르게 다시 입력해주세요.");
            return;
        }

        while(true){

            System.out.println("상품 보기");
            System.out.println("1) TV 2)냉장고 3)세탁기 0)이전으로");
            System.out.print("원하는 번호를 입력하세요.>>");
            int menu = scan.nextInt();

            int lower = 0;
            int upper  = 0;
            switch (menu){
                case 1:
                    System.out.println("<TV 상품 목록>");
                    Map<Integer, Product> filter_Tv = products.entrySet()
                            .stream()
                            .filter(map-> map.getValue() instanceof  TV)
                            .collect(Collectors.toMap(map-> map.getKey(), map-> map.getValue()));

                    lower = Integer.MAX_VALUE;
                    upper = Integer.MIN_VALUE;

                    System.out.println("---------------------------------------------------------------------------------------------------");
                    for (Map.Entry<Integer, Product> et : filter_Tv.entrySet()) {
                        if(et.getKey()<lower){
                            lower = et.getKey();
                        }
                        if(et.getKey() > upper){
                            upper = et.getKey();
                        }
                        System.out.println("[상품no:" + et.getKey() + "] " + et.getValue());
                        System.out.println("-----------------------------------------------------------------------------------------------");
                    }
                    purchase(lower, upper, id);
                    break;

                case 2:
                    System.out.println("<냉장고 상품 목록>");
                    Map<Integer, Product> filter_Ref = products.entrySet()
                            .stream()
                            .filter(map-> map.getValue() instanceof  Ref)
                            .collect(Collectors.toMap(map-> map.getKey(), map-> map.getValue()));

                    lower = Integer.MAX_VALUE;
                    upper = Integer.MIN_VALUE;

                    System.out.println("------------------------------------------------------------------------------------------------------");
                    for (Map.Entry<Integer, Product> et : filter_Ref.entrySet()) {
                        if(et.getKey()<lower){
                            lower = et.getKey();
                        }
                        if(et.getKey() > upper){
                            upper = et.getKey();
                        }
                        System.out.println("[상품no:" + et.getKey() + "] " + et.getValue());
                        System.out.println("--------------------------------------------------------------------------------------------------");
                    }
                    purchase(lower, upper, id);
                    break;

                case 3:
                    System.out.println("세탁기 상품 목록");
                    Map<Integer, Product> filter_Was = products.entrySet()
                            .stream()
                            .filter(map-> map.getValue() instanceof  Washer)
                            .collect(Collectors.toMap(map-> map.getKey(), map-> map.getValue()));

                    lower = Integer.MAX_VALUE;
                    upper = Integer.MIN_VALUE;

                    System.out.println("------------------------------------------------------------------------------------------------------");
                    for (Map.Entry<Integer, Product> et : filter_Was.entrySet()) {
                        if(et.getKey()<lower){
                            lower = et.getKey();
                        }
                        if(et.getKey() > upper){
                            upper = et.getKey();
                        }
                        System.out.println("[상품no:" + et.getKey() + "] " + et.getValue());
                        System.out.println("--------------------------------------------------------------------------------------------------");
                    }
                    purchase(lower, upper, id);
                    break;

                case 0:
                    return;

                default:
                    System.out.println("잘못된 입력");
            }

        }

    }

    private void purchase(int lower, int upper, String id){

        while(true) {

            System.out.println("상품을 구매하시겠습니까?");
            System.out.println("1) 구매하겠습니다 2)아니오(이전으로)");
            int select = scan.nextInt();
            if (select == 1) {
                System.out.println("구매를 원하는 상품의 번호를 입력하세요.");
                int select2 = scan.nextInt();
                if (select2 < lower || select2 > upper){
                    System.out.println("잘못된 범위값. 범위는 "+lower +"~"+upper + " 사이입니다.");
                    continue;
                }
                    Product p = products.get(select2);
                System.out.println("구매하실 상품이 " + p.getName() + " 이(가) 맞습니까? (y/n)");
                String confirm = scan.next();
                if (confirm.equals("y")) {
                    //구매 확정
                    purchaseLog.add(new Purchase(id, p.getName(), p.getBonuspoint()));
                } else if (confirm.equals("n")) {
                    System.out.println("이전으로 돌아갑니다.");
                } else {
                    System.out.println("잘못된 입력. 이전으로 돌아갑니다.");
                }
            } else if (select == 2){
                return;
            } else{
                System.out.println("잘못된 입력");
            }
        }
    }


    //구매내역 보기
    public void printPurchase(){
        System.out.println("sdfdsf");
        for(int i=0; i<purchaseLog.size(); ++i){
            System.out.println(purchaseLog.get(i));
        }
    }


    //회원정보보기
    public void printMembers() {

        int query = 0;
        System.out.println("정렬 기준 1) 이름 순 2) 아이디 순");
        query = scan.nextInt();

        if(query == 1) {
            //이름 오름차순 정렬
            members.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        } else if(query == 2){
            //아이디 오름차순 정렬
            members.sort((o1,o2) ->{
                return o1.getId().compareTo(o2.getId());
            });
        } else{
            System.out.print("잘못된 입력");
        }

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
