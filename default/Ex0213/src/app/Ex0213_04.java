package app;

import java.util.Random;
import java.util.Scanner;

/**
 * Ex0213_04
 */
public class Ex0213_04 {

    public static void main(String[] args) {
        //1에서 100까지의 숫자 한개를 랜덤으로 뽑습니다.
        //무한으로 돌려서 숫자를 맞추는 게임.
        //입력한 숫자가 랜덤 숫자 1개보다 높으면 숫자가 큽니다. 다시입력
        //작으면 작습니다. 다시 입력
        //맞으면 빙고 정답은 ooo
        //자신이 입력한 숫자를 모두 출력합니다. 최대 20번까지

        int history[] = new int[20];
        Scanner scan = new Scanner(System.in, "euc-kr");
        Random ran  = new Random();
        int num = 0;
        int answer  = ran.nextInt(100)+1;

        int count = 1; //game count
        int index = 0; //입력값 저장을 위한 index
        boolean ok = false; //정답체크

        while(count<=20){
            System.out.println(count+"번째 기회입니다.");
            System.out.println("--------------------------");
            System.out.println("생각한 숫자를 입력해주세요.");
            num = scan.nextInt();
            if(num<1 || num>100){
                System.out.println("1~100까지의 숫자만 입력하세요.");
                continue;
            }
            history[index] = num;    
            index++;
            if(num>answer) {
                System.out.println("입력한 숫자가 큽니다. 다시 입력하세요.");
            } else if(num<answer) {
                System.out.println("입력한 숫자가 작습니다. 다시 입력하세요.");
            } else{
                System.out.println("정답입니다. 정답은 "+ answer);
                ok =true;
                break;
            }
            count++;
        }
        
        if(count>20){
            count = 20;
        }
        System.out.println("게임이 끝났습니다. 정답은 "+ answer +" 이고, 입력했던 값들은");
        System.out.println("------------------------------------------------------------");
        System.out.print("횟수\t\t");
        for(int i=1; i<=count; ++i){
            System.out.print(i+"\t");
        }
        System.out.print("\n입력한숫자\t");
        for(int i=0; i<count; ++i){
            System.out.print(history[i]+"\t");
        }
        System.out.println();
        System.out.println(ok ? "정답입니다." : "못맞췄습니다.");



    }
}