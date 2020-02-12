import java.util.Scanner;

public class Ex0211_06 {

    public static void main(String[] args) {
        //5,5 ->  1이 나오면 당첨, 0이나오면 꽝.
        //10까지만 하겠습니다. 당첨: 5 꽝 :5

    	
    	Scanner scan = new Scanner(System.in);
    	int success = 0 , fail = 0;
    	int in_x, in_y;
    	
    	
        int[][] score = new int[5][5];
        String[][] score2 = new String[5][5];
        
        for(int i=0; i<score.length; ++i){
            for(int j=0; j<score[i].length; ++j){
                score[i][j] = (int)(Math.random()*2);
                score2[i][j] = "?";
            }
        }

        
        System.out.println("----------------------------------------------");
        System.out.println("\t\t\t당첨판");
        System.out.println("----------------------------------------------");
        System.out.println("\t0\t1\t2\t3\t4\t");
        
        int numbering = 0;
        for (String[] is : score2) {
        	System.out.print(numbering+"\t");
            for (String is2 : is) {
                System.out.print(is2+ "\t");
            }
            System.out.println();
            numbering++;
        }
        
        System.out.println("----------- 1번째 판-----------------------------");
        for(int i=0; i<10; ++i) {
        	System.out.println("x좌표를 입력하세요.>>");
        	in_x = scan.nextInt();
        	System.out.println("y좌표를 입력하세요.>>");
        	in_y = scan.nextInt();
        	
        	if(score2[in_x][in_y] != "?") {
        		System.out.println("이미 입력한 값입니다. 다시 입력하세요.");
        		i--;
        		continue;
        	}
        	
        	
        	
        	if(score[in_x][in_y] == 1) {
        		score2[in_x][in_y]= "당첨";
        		success++;
        	} else {
        		score2[in_x][in_y] = "꽝";
        		fail++;
        	}
        	
            System.out.println("-----------"+ (i+1) +" 번째 판-----------------------------");
            System.out.println("\t\t\t당첨판");
            System.out.println("----------------------------------------------");
            System.out.println("\t0\t1\t2\t3\t4\t");
            
            numbering = 0;
            for (String[] is : score2) {
            	System.out.print(numbering+"\t");
                for (String is2 : is) {
                    System.out.print(is2+ "\t");
                }
                System.out.println();
                numbering++;
            }
        		
        }
        
        System.out.println();
        System.out.println("{게임 결과}");
        System.out.printf("당첨 : %d , 꽝 : %d", success, fail);
    }
}