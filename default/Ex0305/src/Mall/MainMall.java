package Mall;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMall {
    //화면 단

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //명령어 모음
        ExcuteMall cmd = new ExcuteMall();
        while(true){
                cmd.printMenu();
                int menu = scan.nextInt();

                switch (menu){
                     case 1:
                         cmd.join();
                         break;
                    case 2:
                        cmd.login();
                        break;
                    case 3:
                        cmd.logout();
                        break;
                    case 4:
                        cmd.buy();
                        break;

                    case 5:
                        cmd.printPurchase();
                        break;

                    case 8:
                        cmd.searchMember();
                        break;


                    case 9:
                        cmd.printMembers();
                        break;

                    case 0:
                        cmd.exit();
                        break;
                    default:

                }


        }
    }
}
