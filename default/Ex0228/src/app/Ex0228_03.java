package app;

import java.util.Scanner;
import java.util.Vector;

/**
 * Ex0228_03
 * 
 * 1. 구매 프로그램 구현
 * 2. 학생관리 프로그램 구현
 */
public class Ex0228_03 {

    public static void main(String[] args) {
        // 1)컴퓨터 2) TV 3)냉장고 4)세탁기 5)에이컨
        // 6)구매 물품, 구매 금액 출력 7) 보유금액 출력
        // 8) 보유금액 충전 0)종료

        Scanner scan = new Scanner(System.in, "euc-kr");

        Customer person = new Customer();

        while (true) {
            System.out.println("-------------------------------------------");
            System.out.println("1)컴퓨터  | 2) TV | 3)냉장고  | 4)세탁기 | 5)에어컨");
            System.out.println("6)구매물품/구매금액 출력 | 7)보유금액/보너스포인트 출력");
            System.out.println("8)보유금액 충전 | 9) 검색 | 11) 구매 취소 | 0) 종료");
            System.out.println("-------------------------------------------");

            switch (scan.nextInt()) {

                case 1:
                    person.buy(new Com());
                    break;

                case 2:
                    person.buy(new Tel());
                    break;

                case 3:
                    person.buy(new Ref());
                    break;

                case 4:
                    person.buy(new Was());
                    break;

                case 5:
                    person.buy(new Air());
                    break;

                case 6:
                    person.bought();
                    break;

                case 7:
                    person.nowAccount();
                    break;

                case 8:
                    System.out.print("충전할 금액? >>");
                    person.deposit(scan.nextInt());
                    break;

                case 9:
                    person.search();
                    break;
                case 0:
                    System.out.println("시스템 종료");
                    System.exit(0);
                    break;

                case 11:
             
                    String result;
                    do {
                        System.out.println("구매 취소할 상품의 이름은요 99)이전으로");
                        result = scan.next();
                    } while ( (!result.equals("99")) && person.erase(result) == -1 );
                    break;

                default:
                    System.out.println("잘못된 입력");
                    break;

            }
        }

    } // main
}// class

class Customer {

    int money = 10000;
    int myBonus = 0;

    Vector<Pro> cart = new Vector<>();

    Pro[] items = new Pro[10];
    int[] idxs = new int[items.length]; // 들어갈수 있는지 확인하기 위한 배열

    int used = 0;

    void search() {
    
        System.out.println("[ 검색 ]");
        int tv_count = 0;

        for (int j = 0; j < items.length; j++) {
            if (items[j] == null) {
                continue;
            }
            if (items[j].name.equals("티브이")) {
                tv_count++;
            }
        }
        System.out.println("티브이 구매대수 : " + tv_count);
    }

    // 배열에서 들어갈 수 있는 위치 찾기
    int findRoom() {
        int index = -1;
        for (int i = 0; i < idxs.length; ++i) {
            if (idxs[i] == 0) {
                index = i;
                break;
            }
        }
        return index;
    }

    int erase(String name) {

        int findIdx = -1;

        // 최근에 산 물건부터 삭제
        for (int i = items.length - 1; i >= 0; --i) {
            if (items[i] != null && items[i].name.equals(name)) {
                findIdx = i;
                break;
            }
        }
        if (findIdx == -1) {
            System.out.println("해당하는 품목이 없습니다.");
            return -1;
        }

        money += items[findIdx].price;
        myBonus -= items[findIdx].bonusPoint;

        System.out.println("1건의 주문취소 완료.");
        System.out.println("돈 " + items[findIdx].price + "원이 환불되었습니다.");
        System.out.println("보너스 " + items[findIdx].bonusPoint + "점은 무효입니다.");

        // 다시 사용할 수 있게 초기화
        items[findIdx] = null;
        idxs[findIdx] = 0;  

        return 0;
    }

    void buy(Pro p) {
        if (money < p.price) {
            System.out.println("잔액이 부족합니다. 구매 실패.");
            return;
        }
        int index = findRoom();
        if (index != -1) {
            // 이제 이 자리는 못씀
            items[index] = p;
            idxs[index] = 1;
        } else {
            System.out.println("더 이상 구매할 수 없습니다. 더 사려면 먼저 주문을 취소하세요");
            return;
        }
        System.out.println(p.name + "을 구매하셨습니다.");
        money -= p.price;
        myBonus += p.bonusPoint;
        used += p.price;
    }

    // 종류 카운트
    int kindCnt(Pro p) {

        if (p instanceof Com) {
            return 0;
        }
        if (p instanceof Tel) {
            return 1;
        }
        if (p instanceof Ref) {
            return 2;
        }
        if (p instanceof Was) {
            return 3;
        }
        if (p instanceof Air) {
            return 4;
        }
        return -1;

    }

    void bought() {

        String[] names = { "컴퓨터", "TV", "냉장고", "세탁기", "에어컨" };
        int[] kinds = new int[5];

        System.out.println("[나의 구매내역]");

        System.out.print("\tname\tprice\tbonusPoint\n");

        for (int i = 0; i < items.length; ++i) {
            if (items[i] == null) {
                System.out.printf("[%d]\t%s\t%s\t%s\n", i, "-", "-", "-");
                continue;
            }
            System.out.printf("[%d]\t%s\t%d\t%d\n", i, items[i].name, items[i].price, items[i].bonusPoint);
            kinds[kindCnt(items[i])]++;

        }
        System.out.println();
        System.out.println("총 구매 금액 " + used + "원");
        for (int i = 0; i < kinds.length; ++i) {
            System.out.print(names[i] + ": " + kinds[i] + "대");
            if (i < kinds.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

    }

    void nowAccount() {
        System.out.println("나의 보유금액은 " + money + " 원 입니다.");
        System.out.println("나의 보너스포인트는 " + myBonus + "포인트 입니다.");

    }

    void deposit(int mon) {
        money += mon;
    }

}

class Pro {
    String name;
    int price;
    int bonusPoint;

    Pro(String name, int price, int bonusPoint) {
        this.name = name;
        this.price = price;
        this.bonusPoint = bonusPoint;
    }

    void printMsg() {
        System.out.println(name + "을(를) 구매합니다.");
    }
}

class Com extends Pro {

    Com() {
        super("콤퓨타", 1000, 1000 / 10);
        printMsg();
    }

}

class Tel extends Pro {
    Tel() {
        super("티브이", 700, 700 / 10);
        printMsg();
    }
}

class Ref extends Pro {

    Ref() {
        super("냉장고", 980, 980 / 10);
        printMsg();
    }
}

class Was extends Pro {
    Was() {
        super("세탁기", 888, 888 / 10);
        printMsg();
    }
}

class Air extends Pro {
    Air() {
        super("에어콘", 500, 500 / 10);
        printMsg();
    }
}