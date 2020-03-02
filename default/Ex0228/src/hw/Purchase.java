package hw;

import java.util.Scanner;

/**
 * Purchase
 * 
 * TV , 컴퓨터, 냉장고, 세탁기, 에어컨
 * 
 */
public class Purchase {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in, "euc-kr");

        // 구매자
        Buyer buyer = new Buyer();

        while (true) {

            System.out.println("------------------------------------------------");
            System.out.println("1)컴퓨터  | 2) TV | 3)냉장고  | 4)세탁기 | 5)에어컨");
            System.out.println("6)구매물품/구매금액 출력 | 7)보유금액/보너스포인트 출력");
            System.out.println("8)보유금액 충전 | 9) 검색 | 11) 구매 취소 | 0) 종료");
            System.out.println("------------------------------------------------");

            switch (scan.nextInt()) {
                case 1:
                    buyer.buy(new Computer());
                    break;
                case 2:
                    buyer.buy(new Television());
                    break;

                case 3:
                    buyer.buy(new Refrigerator());
                    break;

                case 4:
                    buyer.buy(new Washer());
                    break;

                case 5:
                    buyer.buy(new Aircon());
                    break;
                case 6:
                    buyer.bought();
                    break;

                case 7:
                    buyer.myAccount();
                    break;

                case 8:
                    System.out.print("충전할 금액? >>");
                    buyer.putMoney(scan.nextInt());
                    break;

                case 9:
                    buyer.search();
                    break;

                case 11:
                    String candidate;
                    do {
                        System.out.println("삭제하고 싶은 물품의 이름을 입력하세요 99) 이전으로");
                        candidate = scan.next();
                        // 사용자가 입력한 값이 99가 아니면서 주문 cancel이 실패했을 때에는 루프를 계속 돈다.
                    } while (!candidate.equals("99") && !buyer.cancel(candidate));
                    break;

                case 0:
                    System.out.println("시스템 종료");
                    System.exit(0);
                    break;

                default:
                    System.out.println("잘못된 입력 값");
                    break;
            }

        }
    } // main

} // class

class Buyer {

    // 보유 돈, 포인트
    int money = 10000;
    int bonus = 0;
    // 지금까지 사용한 금액
    int usedMoney = 0;

    // 구매한 물품
    Product[] cart = new Product[10];
    // 카트가 비었는지 체크하기 위한 배열
    int[] checkCart = new int[cart.length];

    ////////////////////////////////////////////////////////////////

    // 0. cart에 들어갈 수 있는 자리 찾기
    int findRoom() {
        int index = -1;
        for (int i = 0; i < checkCart.length; i++) {
            // 0: 비어있음 1:차있음.. 비어있는 자리를 찾으면 반복문에서 빠져나옴
            if (checkCart[i] == 0) {
                index = i;
                break;
            }
        }
        return index;
    }

    // 1-5. 구매 메소드
    void buy(Product p) {
        if (money < p.price) {
            System.out.println("잔액이 부족합니다. 구매 실패");
            return;
        }
        // findRoom 메소드를 통해 비어있는 카트 자리 확인
        int index = findRoom();
        if (index == -1) {
            // index가 -1이면 넣을 자리가 없다는 것임
            System.out.println("더 이상 구매할 수 없습니다. 더 사려면 구매 취소를 먼저 하세요.");
            return;
        }

        // 이제 이 자리는 차있어서 못 씀
        cart[index] = p;
        checkCart[index] = 1;

        System.out.println(p.name + "을(를) 구매하셨습니다.");
        money -= p.price;
        bonus += p.bonusPoint;
        usedMoney += p.price;

    }

    // 6. 현재 구매한 물품
    void bought() {
        System.out.println("[나의 구매내역]");
        System.out.print("\tname\tprice\tbonus point\n");

        for (int i = 0; i < cart.length; i++) {
            // 해당 카트자리에 물건이 없으면 '-'' 표시
            if (cart[i] == null) {
                System.out.printf("[%d]\t%s\t%s\t%s\n", i, "-", "-", "-");
                continue;
            }
            System.out.printf("[%d]\t%s\t%d\t%d\n", i, cart[i].name, cart[i].price, cart[i].bonusPoint);
        }
        System.out.println();
        System.out.println("총 구매 금액 " + usedMoney + "원");
    }

    // 7. 내 보유금액/보너스포인트 출력
    void myAccount() {
        System.out.println("나의 보유금액은 " + money + "원 입니다.");
        System.out.println("나의 보너스 포인트는 " + bonus + "점 입니다.");
    }

    // 8. 돈 넣기
    void putMoney(int money) {
        this.money += money;
        System.out.println(money + "원이 충전되었습니다. 현재 금액 " + this.money + "원");
    }

    // 9. 검색

    void search() {

        System.out.println("[ 검색 ]");
        int[] kind = new int[5]; // 종류 5개
        String[] naming = { "콤퓨타", "테레비", "냉장고", "세탁기", "에어콘" };

        for (int i = 0; i < cart.length; ++i) {
            // 해당 카트가 비었으면 건너뜀
            if (cart[i] == null) {
                continue;
            }
            if (cart[i] instanceof Computer) {
                kind[0]++;
            } else if (cart[i] instanceof Television) {
                kind[1]++;
            } else if (cart[i] instanceof Refrigerator) {
                kind[2]++;
            } else if (cart[i] instanceof Washer) {
                kind[3]++;
            } else if (cart[i] instanceof Aircon) {
                kind[4]++;
            }

        }

        System.out.print("| ");
        for (int i = 0; i < kind.length; i++) {
            System.out.print(naming[i] + " 구매대수: " + kind[i] + "대  | ");
        }
        System.out.println();

    }

    // 11. 구매 취소 메소드
    boolean cancel(String name) {

        // 위치 찾기용 인덱스
        int findIdx = -1;

        // 최근 산 물품부터 삭제하기 위해 뒤에서부터 돈다
        for (int i = cart.length - 1; i >= 0; i--) {
            // 해당 자리가 null이 아니어야하고 품목이 같아야 함.
            if (cart[i] != null && cart[i].name.equals(name)) {
                findIdx = i;
                break;
            }
        }
        if (findIdx == -1) {
            System.out.println("해당하는 품목이 없습니다.");
            return false;
        }

        System.out.println("1건의 주문취소 완료.");
        System.out.println("돈 " + cart[findIdx].price + "원이 환불되었습니다.");
        System.out.println("보너스포인트 " + cart[findIdx].bonusPoint + "점은 무효입니다.");

        // 돈 다시 돌려주고 포인트 없앰
        money += cart[findIdx].price;
        bonus -= cart[findIdx].bonusPoint;

        // 카트에 해당 자리는 다시 사용할 수 있게 비워준다.
        cart[findIdx] = null;
        checkCart[findIdx] = 0;

        return true;
    }

}

class Product {

    String name;
    int price;
    int bonusPoint;

    Product(String name, int price, int bonusPoint) {
        this.name = name;
        this.price = price;
        this.bonusPoint = bonusPoint;
    }

    // 현재 구매 원하는거 출력해주는거
    void printMsg() {
        System.out.println(name + " 구매를 진행합니다.");
    }
}

class Television extends Product {

    Television() {
        super("테레비", 1000, 1000 / 100);
        printMsg();
    }
}

class Computer extends Product {

    Computer() {
        super("콤퓨타", 950, 950 / 100);
        printMsg();
    }
}

class Refrigerator extends Product {

    Refrigerator() {
        super("냉장고", 800, 800 / 100);
        printMsg();
    }
}

class Washer extends Product {
    Washer() {
        super("세탁기", 660, 660 / 100);
        printMsg();
    }
}

class Aircon extends Product {
    Aircon() {
        super("에어콘", 470, 470 / 100);
        printMsg();
    }
}