import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Excute cmd = new Excute();

        Scanner scan = new Scanner(System.in);
        while (true) {
            int menu = 0;
            try {
                cmd.showMenu();
                menu = scan.nextInt();
            } catch (Exception e) {
                System.out.println("잘못된 입력");
                scan.nextLine();
                continue;
            }
            switch (menu) {
                case 1:
                    cmd.addStu();
                    break;

                case 2:
                    cmd.showStu(null);
                    break;

                case 3:
                    cmd.searchStu();
                    break;

                case 4:
                    cmd.checkRank();
                    break;

                case 5:
                    cmd.administerLogin();
                    break;

                case 0:
                    System.exit(0);

                default:
                    System.out.println("잘못된 입력");
                    break;
            }
        }
    }
}
