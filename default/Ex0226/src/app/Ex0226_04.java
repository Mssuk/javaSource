package app;

import java.util.Scanner;

import app.Card.Kind;

/**
 * Ex0226_04
 */
public class Ex0226_04 {

    static int cardCount = 0; // 전체 카드 카운트

    public static void main(String[] args) {
        // 카드게임 프로그램

        User[] users = null;
        Deck fDeck = new Deck(); // 게임에 사용할 카드 덱
        int menu = 0;

        Scanner scan = new Scanner(System.in);
        while (true) {

            // 총 나온 카드가 14장일 때 게임 끝
            if (cardCount == 14) {
                users = showResult();
            }

            printMenu();
            menu = scan.nextInt();

            switch (menu) {
                case 1:
                    users = gameInit(fDeck, users);
                    for (User u : users) {
                        System.out.println(u);
                    }

                    break;

                case 2:
                    if (users == null) {
                        System.out.println("게임 시작을 먼저하세요.");
                        break;
                    }
                    System.out.println("한 장을 추가합니다.");
                    for (int i = 0; i < users.length; i++) {
                        giveCard(users[i], fDeck.pick(cardCount));
                        cardCount++;
                        System.out.println(users[i]);
                    }
                    break;

                case 3:
                    case3Clover(users);
                    break;

                case 4:
                    System.out.println("게임 종료합니다.");
                    System.exit(0);
                default:
                    break;
            }
        }

    }

    // 메뉴를 출력
    static void printMenu() {

        System.out.println("---------------------------");
        System.out.println("1. 게임 시작");
        System.out.println("2. 1장 추가");
        System.out.println("3. 몇개씩 있나");
        System.out.println("4. 게임 종료");
        System.out.println("원하는 번호를 입력하세요.");
        System.out.println("---------------------------");
    }

    // 게임을 (재)시작
    static User[] gameInit(Deck fDeck, User[] users) {
        users = new User[2]; // 2명의 플레이어

        users[0] = new User("user"); // 유저.
        users[1] = new User("computer"); // 컴퓨터.

        System.out.println("게임을 시작합니다.");
        cardCount = 0;
        System.out.println("카드를 섞습니다.");
        fDeck.shuffle();

        System.out.println("카드 세장을 전달합니다.");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < users.length; j++) {
                giveCard(users[j], fDeck.pick(cardCount));
                cardCount++;
            }
        }
        return users;
    }

    static void giveCard(User user, Card card) {
        // 카드 돌림
        user.inputCard(card);
    }

    // 게임 끝났을 때
    static User[] showResult() {
        System.out.println("게임 끝");
        System.out.println("결과는? ");

        System.out.println("게임 리셋합니다.");
        // 게임 리셋
        cardCount = 0;
        return null;
    }

    static void case3Clover(User[] users) {

        if (users == null) {
            System.out.println("게임 시작을 먼저 하세요.");
            return;
        }
        // 모양 카운트
        int[] shapeArr = new int[5];

        for (int i = 0; i < users.length; ++i) {
            shapeArr[1] += users[i].showMyCard(Kind.HEART);
            shapeArr[2] += users[i].showMyCard(Kind.DIAMOND);
            shapeArr[3] += users[i].showMyCard(Kind.SPADE);
            shapeArr[4] += users[i].showMyCard(Kind.CLOVER);
        }

        for (int i = 1; i < shapeArr.length; ++i) {
            System.out.println(Kind.values()[i] + "의 갯수는 : " + shapeArr[i] + "개");
        }

    }
}// class
