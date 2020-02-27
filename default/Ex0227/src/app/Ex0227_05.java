package app;

import java.util.Scanner;

/**
 * Ex0227_05
 */
public class Ex0227_05 {

    public static void main(String[] args) {

        User user = new User();
        Scanner scan = new Scanner(System.in);

        //

        while (true) {
            System.out.println("-----------------------------------");
            System.out.println("1) 삼성TV 구매");
            System.out.println("2) 냉장고 구매");
            System.out.println("3) 에어컨 구매");
            System.out.println("4) 현재 가지고 있는 금액 확인");
            System.out.println("원하는 번호를 입력하세요.");
            System.out.println("-----------------------------------");
            int num = scan.nextInt();

            switch (num) {
                case 1:
                    user.buy(new SamsungTv(), num);
                    break;

                case 2:
                    user.buy(new Refrigerator(), num);
                    break;

                case 3:
                    user.buy(new Aircon(), num);
                    break;

                case 4:
                    user.money_now();
                    break;

                default:
                    break;
            }

        }

    }
}

class User {
    int money = 10000;
    String name = "홍길동";
    // 몇대 몇대 몇대..
    int[] caseCnt = new int[4];

    void buy(Product p, int num) {

        System.out.println(p.name + "을(를) 1대 구매했습니다.");
        if (money < p.price) {
            System.out.println("돈이 부족하여 구매를 할 수 없습니다.");
            return;
        }
        money -= p.price;
        caseCnt[num]++;
        System.out.println(p.name + ": 총 " + caseCnt[num] + "대 구매했습니다.");

        // if(p instanceof Aircon){
        // caseCnt[0]++;
        // System.out.println(p.name+ ":" + caseCnt[0] + "대");
        // } else if(p instanceof Refrigerator){
        // caseCnt[1]++;
        // System.out.println(p.name + ":" + caseCnt[1]+ "대");
        // } else if(p instanceof SamsungTv){
        // caseCnt[2]++;
        // System.out.println(p.name + ":" + caseCnt[2] + "대");
        // }

    }

    void money_now() {
        System.out.println("현재 유저가 가지고 있는 금액 :" + money);

    }

}