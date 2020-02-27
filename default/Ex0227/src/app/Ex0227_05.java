package app;

import java.util.Scanner;

/**
 * Ex0227_05
 */
public class Ex0227_05 {

    public static void main(String[] args) {

        SamsungTv[] sam = new SamsungTv[10];
        User user = new User();
        Scanner scan = new Scanner(System.in);

        //

        while (true) {
            System.out.println("1) 삼성TV 구매");
            System.out.println("2) 현재 가지고 있는 금액 확인");
            System.out.println("원하는 번호를 입력하세요.");
            int num = scan.nextInt();
            int tv_count = 0;

            switch (num) {
                case 1:
                    System.out.println("현재 유저가 가지고 있는 금액 :" + user.money);
                    if (tv_count <= 10) {

                        sam[0] = new SamsungTv();
                        System.out.println("삼성Tv를 1대 구매했습니다.");
                        user.money = user.money - sam[0].price;
                        System.out.println("현재 유저가 가지고 있는 금액 :" + user.money);

                    }
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

}