package Mall;

import Mall.Product.Product;
import Mall.Product.Ref.*;
import Mall.Product.TV.*;
import Mall.Product.Washer.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class ExcuteMall {


    Login loginSession = new Login(); //로그인 객체
    Board zeroBoard = new Board(); //게시판 객체
    ArrayList<Member> members = new ArrayList<>(); //가입 멤버들
    ArrayList<Product> products = new ArrayList<>(); //등록된 상품들
    ArrayList<Purchase> purchaseLog = new ArrayList<>(); //구매 기록


    Scanner scan = new Scanner(System.in);

    //초기 기본 데이터
    ExcuteMall() {
        //시작할 때 상품 목록에 상품 넣어줌
        products.add(new LCD(1000, "42LCDTV", "black", 42));
        products.add(new LED(1200, "TNMTV 무결점", "black", 65));
        products.add(new OLED(1900, "65OLED873 필립스", "black", 65));
        products.add(new BasicRef(320, "레트로 원도어", "red", 92));
        products.add(new DobuleDoorRef(1140, "디오스 S831S30", "silver", 821));
        products.add(new TopLoader(374, "TR13BK LG통돌이", "white", 13));
        products.add(new FrontLoader(519, "트롬F9WK", "silver", 9));
        products.add(new DryFrontLoader(1470, "H드럼 플렉스워시건조", "black", 20));

        //관리자 계정 admin data
        members.add(new Member("관리자", "admin", "qwerty", "02-0000-0000"));
    }


    //메뉴 출력
    public void printMenu() {

        //로그인 안했을 때와 했을때 보여주는 메뉴 다름
        boolean showFlag = loginSession.sessionEmpty();

        System.out.println("------**--.++--..-..*-*-*-");
        System.out.println("[쇼핑몰 프로그램]");
        System.out.println(showFlag ? "1.회원가입" : "1.------");
        System.out.println(showFlag ? "2.로그인" : "2.------");
        System.out.println(showFlag ? "3.------" : "3.로그아웃");
        System.out.println("4.상품구매");
        System.out.println("5.구매내역보기");
        System.out.println("6.문의게시판");
        System.out.println("8.회원정보검색");
        //관리자 전용메뉴
        if (!showFlag && loginSession.getLoginInfo().getKey().equals("admin")) {
            System.out.println("9.회원정보보기(admin)");
            System.out.println("10.게시판 관리(admin)");
        } else{
            System.out.println("9.나의정보보기");
        }
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

    //아이디 유효성 검사
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
            System.out.println("사용할 수 있는 아이디입니다.");
        } else {
            System.out.println("사용할 수 없는 아이디입니다. 다시 입력하세요.");
        }
        return result;

    }

    //전화번호 형식 검사
    private boolean vailidateTel(String tel) {
        String telReg = "^01(?:0|1|[6-9])[-](\\d{3}|\\d{4})[-](\\d{4})$";
        if (tel.matches(telReg)) {
            return true;
        } else {
            System.out.println("허용하지 않는 형식입니다. ");
            return false;
        }
    }


    //회원가입
    public void join() {

        //로그인되어있을때 누르면 안되기때문
        if (!loginSession.sessionEmpty()) {
            return;
        }

        System.out.println("회원 가입 화면입니다.");

        //아이디
        String id;
        //유효성 검사
        do {
            System.out.println("사용하실 아이디를 입력하세요. 아이디는 3자리 이상의 문자입니다. 0) 뒤로가기 ");
            id = scan.next();
            if (id.equals("0")) {
                return;
            }
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
        do {
            System.out.println("전화번호를 입력하세요. 형식은 000-0000-0000입니다.");
            tel = scan.next();
        } while (!vailidateTel(tel));

        Member newMember = new Member(name, id, pw, tel);
        System.out.println("회원 가입을 축하합니다. 가입 포인트 100point 지급!");
        newMember.setPoint(100);

        //생성날짜 찍어줌
        Calendar time = Calendar.getInstance();
        newMember.setSignDate(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(time.getTime()));

        members.add(newMember);

    }


    //로그인
    public void login() {

        //로그아웃 안했을 때는 로그인 못함
        if (!loginSession.sessionEmpty()) {
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
                loginSession.login(inputID, inputPW, mem);
                return;
            }
        }

        System.out.println("비밀번호 입력횟수 초과");

    }

    //로그아웃
    public void logout() {
        //로그인 안했을 때는 로그아웃 못함
        if (loginSession.sessionEmpty()) {
            return;
        }

        System.out.println("로그아웃을 하시겠습니까? (y/n)");
        String select = scan.next();
        if (select.equals("y")) {
            loginSession.logout();
        } else {
            return;
        }

    }


    //회원정보검색
    public void searchMember() {

        if (loginSession.getLoginInfo() == null || !loginSession.getLoginInfo().getKey().equals("admin")) {
            System.out.println("검색은 관리자만 가능합니다.");
            return;
        }

        //일치하는 인덱스 저장. (첫글자부터 일치하는 순서로 정렬하고 싶어서 inner class 작성)
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
    public void buy() {

        if (loginSession.sessionEmpty()) {
            System.out.println("로그인을 먼저 해주세요.");
            return;
        }

        System.out.println("상품 구매입니다.");
        String id = (String) loginSession.getLoginInfo().getKey();
        System.out.println("반갑습니다 " + id + "님");


        while (true) {

            System.out.println("상품 보기");
            System.out.println("1) TV 2)냉장고 3)세탁기 4) 전체 상품 보기 0)이전으로");
            System.out.print("원하는 번호를 입력하세요.>>");
            int menu = 0;
            //숫자가 아닌 값 입력 막음
            try {
                menu = scan.nextInt();
            } catch (Exception e) {
                System.out.println("잘못된 입력");
                scan.nextLine();
                continue;
            }

            switch (menu) {
                case 1:
                    System.out.println("<TV 상품 목록>");
                    List<Product> filter_Tv = products
                            .stream()
                            .filter(o -> o instanceof TV)
                            .collect(Collectors.toList());
                    filteredProduct(filter_Tv, id);
                    break;

                case 2:
                    System.out.println("<냉장고 상품 목록>");
                    List<Product> filter_Ref = products
                            .stream()
                            .filter(o -> o instanceof Ref)
                            .collect(Collectors.toList());
                    filteredProduct(filter_Ref, id);
                    break;

                case 3:
                    System.out.println("<세탁기 상품 목록>");
                    List<Product> filter_Was = products
                            .stream()
                            .filter(o -> o instanceof Ref)
                            .collect(Collectors.toList());
                    filteredProduct(filter_Was, id);
                    break;
                case 4:
                    System.out.println("<전체 상품 목록>");
                    filteredProduct(products, id);
                    break;
                case 0:
                    return;

                default:
                    System.out.println("잘못된 입력");
            }

        }

    }

    //종류별로 품목 보기 filtering
    private void filteredProduct(List<Product> filtered, String id) {

        boolean isOrign = false;
        //걸러지지 않은 리스트라면 앞에 품목 이름을 붙여준다.
        if (filtered.equals(products)) {
            isOrign = true;
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < filtered.size(); ++i) {
            System.out.println("[" + (i + 1) + "] " + (isOrign ? "[품목:" + filtered.get(i).GetType() + "] " : "") + filtered.get(i));
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        purchase(filtered, 1, filtered.size(), id);
    }


    //구매 요청 처리하는 메소드
    private void purchase(List<Product> filtered, int lower, int upper, String id) {

        while (true) {

            System.out.println("상품을 구매하시겠습니까?");
            System.out.println("1) 구매하겠습니다 0)아니오(이전으로)");
            int select = 0;
            try {
                select = scan.nextInt();
            } catch (Exception e) {
                System.out.println("잘못된 입력");
                scan.nextLine();
                continue;
            }

            switch (select) {
                case 1:
                    System.out.println("구매를 원하는 상품의 번호를 입력하세요.(" + lower + "~" + upper + ")");
                    int select2 = 0;
                    try {
                        select2 = scan.nextInt();
                    } catch (Exception e) {
                        System.out.println("잘못된 입력. 이전으로 돌아갑니다.");
                        scan.nextLine();
                        continue;
                    }

                    if (select2 < lower || select2 > upper) {
                        System.out.println("잘못된 범위값. 범위는 " + lower + "~" + upper + " 사이입니다. 이전으로 돌아갑니다.");
                        continue;
                    }
                    Product p = filtered.get(select2 - 1);

                    System.out.println("구매하실 상품이 " + p.getName() + " 이(가) 맞습니까? (y/n)");
                    String confirm = scan.next();
                    if (confirm.equals("y")) {
                        //구매 확정
                        confirmBuy(id, p);
                        return;
                    } else if (confirm.equals("n")) {
                        System.out.println("상품보기로 돌아갑니다.");
                        return;
                    } else {
                        System.out.println("잘못된 입력. 이전으로 돌아갑니다.");
                    }
                    break;

                case 0:
                    return;

                default:
                    System.out.println("잘못된 입력");
            }
        }
    }

    //구매 확정
    private boolean confirmBuy(String id, Product p) {
        boolean result = true;
        Member m = loginSession.getLoginMember();
        int pPrice = p.getPrice();
        System.out.println("상품 가격은 " + pPrice + "000원 입니다. 적립 가능한 포인트는 " + p.getBonuspoint() + "점 입니다.");
        System.out.println("보유 포인트 중 ((" + Math.min(pPrice, m.getPoint()) + "점)) 까지 사용할 수 있습니다. 얼마나 사용하시겠습니까? (1점당 1000원 할인)");
        System.out.println("주의사항) 포인트 사용시 구매포인트 적립 안됨. ");
        int usePoint;
        do {
            usePoint = -1;
            try {
                usePoint = scan.nextInt();
                if (usePoint > -1 && usePoint <= m.getPoint() && usePoint <= pPrice) {
                    pPrice -= usePoint;
                } else {
                    System.out.println("범위를 벗어난 입력 값입니다.");
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("다시 입력하세요.");
                scan.nextLine();
                usePoint = -1;
                continue;
            }
        } while (usePoint == -1);

        if (m.getMoney() < pPrice) {
            System.out.println("잔액 부족");
            result = false;
        } else {
            //구매 성공
            m.setMoney(m.getMoney() - pPrice);
            //포인트 썼으면 적립 안함.
            if (usePoint > 0) {
                m.setPoint(m.getPoint() - usePoint);
            } else {
                m.setPoint(m.getPoint() + p.getBonuspoint());
            }

            purchaseLog.add(new Purchase(id, p.getName(), (usePoint == 0 ? p.getBonuspoint() : 0), pPrice));
        }

        System.out.println(result ? "☆★☆★☆★구매 성공☆★☆★☆★" : " !!!구매 실패!!!");
        return result;
    }


    //구매내역 보기
    public void printPurchase() {

        //로그인 안하면 못봄
        if (loginSession.sessionEmpty()) {
            System.out.println("로그인 먼저 하세요.");
            return;
        }
        //are you admin?
        final boolean admin;
        String id = (String) loginSession.getLoginInfo().getKey();
        if (id.equals("admin")) {
            admin = true;
        } else {
            admin = false;
        }

        Member myInfo = loginSession.getLoginMember();

        System.out.println(admin ? "<---statistics--->" : "<--- " + id + "님의 구매내역--->");

        System.out.println("----------------------------------------------------------------------------------------------------------------");
        ////////////// 통계 ///////////////////////////////////////////
        //아이디별 총 구매 금액, 총 구매개수
        Map<String, IntSummaryStatistics> mapping = purchaseLog.
                stream()
                .peek(o -> {
                    if (admin || o.getId().equals(id)) {
                        System.out.println(o);
                    }
                })
                .collect(
                        Collectors.groupingBy(
                                Purchase::getId,
                                Collectors.summarizingInt(o -> o.getpPrice())
                        ));
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        //admin이 아니면 본인 것만
        if (!admin) {
            IntSummaryStatistics stat = mapping.get(myInfo.getId());
            if (stat == null) {
                System.out.println("구매내역이 없습니다.");
                return;
            }
            System.out.println("[총 구매 금액:" + stat.getSum() + "000원, 총 구매수량:" + stat.getCount() +
                    ", 보유금액:" + myInfo.getMoney() + "000원, 보유포인트: " + myInfo.getPoint() + "]");

            return;
        }

        //전체 출력
        for (Map.Entry<String, IntSummaryStatistics> km : mapping.entrySet()) {
            System.out.println("[구매자:" + km.getKey() + ", 총 구매금액: " + km.getValue().getSum() + "000원, 총 구매수량:" + km.getValue().getCount() + "]");
        }
    }


    //회원정보보기
    public void printMembers() {

        if (loginSession.sessionEmpty()) {
            System.out.println("로그인 먼저 하세요.");
            return;
        }

        //admin이 아니면 자신의 정보만 보기
        if (!loginSession.getLoginInfo().getKey().equals("admin")) {
            System.out.println(findMem((String) loginSession.getLoginInfo().getKey()));
            return;
        }

        int query = 0;
        System.out.println("정렬 기준 1) 입력 순 2) 아이디 순 3)이름 순");
        try {
            query = scan.nextInt();
        } catch (Exception e) {
            scan.nextLine();
            System.out.println("잘못된 입력");
            return;
        }

        if (query == 1) {
            //original
            for (var m :
                    members) {
                System.out.println(m);
            }
        } else if (query == 2) {
            //아이디 오름차순 정렬
            members.stream().sorted((o1, o2) -> {
                return o1.getId().compareTo(o2.getId());
            }).forEach(System.out::println);
        } else if (query == 3) {
            //이름 오름차순 정렬
            members.stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).forEach(System.out::println);
        } else {
            System.out.print("잘못된 입력");
        }

        System.out.println();
    }

    //문의게시판
    public void boardCtrl() {
        while (true) {
            zeroBoard.showBoard();
            int select = 0;
            while (true) {
                System.out.println("글을 보려면 글번호를 입력하세요. ... 1)글쓰기... 0)이전으로...");
                System.out.print(">> ");
                try {
                    select = scan.nextInt();
                } catch (Exception e) {
                    scan.nextLine();
                    continue;
                }
                if (select == 0) {
                    return;
                } else if (select == 1) {
                    if (zeroBoard.addPosts(loginSession)) {
                        break;
                    }
                } else {
                    zeroBoard.showPost(select, loginSession);
                    break;
                }
            }
            ;
        }
    }

    //게시판 관리(삭제기능)
    public void boardOwner() {

        if (loginSession.getLoginInfo() == null || !loginSession.getLoginInfo().getKey().equals("admin")) {
            System.out.println("관리자만 가능합니다.");
            return;
        }

        while (true) {
            zeroBoard.showBoard();
            int select = 0;
            while (true) {
                System.out.println("삭제할 글번호를 입력하세요... 0)이전으로...");
                System.out.print(">> ");
                try {
                    select = scan.nextInt();
                } catch (Exception e) {
                    scan.nextLine();
                    continue;
                }
                if (select == 0) {
                    return;
                } else {
                    zeroBoard.delPost(select);
                    break;
                }
            }
            ;

        }
    }


    public void exit() {
        System.out.println("프로그램 종료..");
        System.exit(0);
    }


}
