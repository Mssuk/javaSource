import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex0211_05 {

    public static void main(String[] args) throws Exception {
        
        
        
        int[][] score= new int[3][3]; // 0,1 random;
		String[][] score_in = new String[3][3]; //내가 입력해서 저장하는 배열
        
		
		Scanner scan = new Scanner(System.in);
        
        int in_x = 0;
        int in_y =0;


		for(int i=0; i<score.length; ++i) {
			for(int j=0; j<score[i].length; ++j) {
				score[i][j] = (int)(Math.random()* 2);
			}
        }
        
        
        // x좌표 1
        // y좌표 2  [1,2] -> 1이 들어가 있으면 score_in[1][2] 당첨
        // 0이 들어가있으면 꽝.
        
        

        while(true){
            System.out.println("-------------------------");
            System.out.println("    [좌표 맞추기 게임]  ");
            System.out.println("-------------------------");
            System.out.println("\t0\t1\t2\n");
            
            
            for(int i=0; i<score_in.length; i++){
                System.out.print(i+"\t");
                for(int j=0; j<score_in[i].length; j++){
                    System.out.print(score_in[i][j]+"\t");
                }
                System.out.println();
            }

            System.out.println("x좌표를 입력하세요. >>");
            in_x = scan.nextInt();
            System.out.println("y좌표를 입력하세요. >>");
            in_y = scan.nextInt();

            if(score[in_x][in_y] == 1) {
                score_in[in_x][in_y] = "당첨";
            } else{
                score_in[in_x][in_y] = "꽝";
            }

            System.out.println("-------------------------");
            System.out.println("    [좌표 맞추기 게임]  ");
            System.out.println("-------------------------");
            System.out.println("\t0\t1\t2\n");
            
            
            for(int i=0; i<score_in.length; i++){
                System.out.print(i+"\t");
                for(int j=0; j<score_in[i].length; j++){
                    System.out.print(score_in[i][j]+"\t");
                }
                System.out.println();
            }
    }





//		Scanner scan = new Scanner(System.in);
//		int[][] bina = new int[5][8];
//		System.out.println("2의 배수로 2차원 배열을 채워넣기");
//		
//		for(int i=0; i<bina.length; ++i) {
//			for(int j=0; j<bina[i].length; ++j) {
//				System.out.println("2의 배수를 입력하세요.");
//				int num = scan.nextInt();
//				if(num%2 !=0) {
//					j--;
//					System.out.println("2의 배수가 아닙니다. 다시 입력하세요.");
//				} else {
//					bina[i][j] = num;
//				}
//			}
//		}
//		
//		
//		for (int[] is : bina) {
//			for (int is2 : is) {
//				System.out.print(is2+ "\t");
//			}
//			System.out.println();
//		}
//		
//		
//		
//		
		
		
//		
//		
//		
//		System.out.println("/////////////////////////////////////");
//		//[5][8] 2차원 배열에 2의 배수를 넣어보기
//		int[][] score = new int[5][8];
//		//2의 배수로 채워보세요.
//		int num = 1;
//		for(int i=0; i<score.length; ++i) {
//			for(int j=0; j<score[i].length; ++j) {
//				//score[i][j] = 2*num;
//				num++;
//				score[i][j] = ((i*score[0].length)+j+1)*2;
//			}
//		}
//		
//		for(int i=0; i<score.length; ++i) {
//			for(int j=0; j<score[i].length; ++j) {
//				System.out.print(score[i][j]+ "\t");
//			}
//			System.out.println();
//		}
//		
//		
		
		
//		Scanner scan= new Scanner(System.in);	
		
//		//시간표 짜기 [4][5]
//		
//		String[] days = {"월","화", "수", "목","금"};
//		String[][] schedule = new String[4][5];
//		
//
//		for(int i=0; i<schedule.length; ++i) {
//			for(int j=0; j<schedule[i].length; ++j) {
//				System.out.println(days[j]+"요일의 "+  (i+1) + "번째 과목을 입력해 주세요.");
//				schedule[i][j] = scan.next();
//			}
//		}
//		
//		
//		System.out.println("[시간표]");
//		for(int i=0; i<5; ++i) {
//			System.out.print(days[i]+"\t");
//		}
//		System.out.println();
//		int numbering = 1;
//		for (String[] strings : schedule) {
//			System.out.print(numbering+ " ");
//			for (String str : strings) {
//				System.out.print(str+"\t");
//			}
//			System.out.println();
//			numbering++;
//		}
//		
//				
		
		//[3][3] 
		//국어점수 영어점수 수학점수
		//100  78  99
		// 87  85  100
		// 75 100  89
		
		
		//int[][] scores = {{100,78,99}, {87,85,100}, {75,100,89}};
		
		//입력 1 Scanner
		
//		int[][] scores= new int[3][3];
//		for(int i=0; i<scores.length; ++i) {
//			for(int j=0; j<scores[i].length; ++j) {
//			System.out.println(scores[0].length*i + (j+1) +"번째 점수를 입력하세요.");
//				scores[i][j]=scan.nextInt();
//			}
//		}
		
		//입력 2 BufferedReader
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		StringTokenizer st =null;
//		for(int i=0; i<scores.length; ++i) {
//			st = new StringTokenizer(br.readLine());
//			for(int j=0; j<scores[i].length; ++j) {
//				scores[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//		
		
		
		//출력 
//		
//		for (int[] is : scores) {
//			for (int is2 : is) {
//				System.out.print(is2+"\t");
//			}
//			System.out.println();
//		}
		
//		
//		
		
		
		
		
		
		
		
		
//		// [7][9]
//		int[][] dimension2 = new int[7][9];
//		
//		
//		for(int i=0; i<dimension2.length; ++i) {
//			for(int j=0; j<dimension2[i].length; ++j) {
//				dimension2[i][j] = dimension2[0].length* i + (j+1);
//			}
//		}
//		
//		
//		for (int[] is : dimension2) {
//			for(int is2: is) {
//				System.out.print(is2+"\t");
//			}
//			System.out.println();
//		}
//
//		
//		
//		
		
		
//		
//		
//		
//		//[5][5] -> 1~25까지
//		int[][] num1 = new int[3][3];
//		num1[0][0] = 1;
//		num1[0][1] = 2;
//		num1[0][2] = 3;
//		num1[1][0] = 4;
//		num1[1][1] = 5;
//		num1[1][2] = 6;
//		num1[2][0] = 7;
//		num1[2][1] = 8;
//		num1[2][2] = 9;
//		
//		for (int[] is : num1) {
//			for (int is2 : is) {
//				System.out.printf(is2+"\t");
//			}
//			System.out.println();
//		}
//		
//		System.out.println("//////////////////");
//		
//		
//		int[][] num2 = { {1,2,3}, {4,5,6}, {7,8,9}};
//		
//		for (int[] is : num2) {
//			for (int is2 : is) {
//				System.out.printf(is2+"\t");
//			}
//			System.out.println();
//		}
//		
//		System.out.println("//////////////////");
//		
//		
//		
//		
//		int[][] num3 = new int[3][3];
////		int num = 1;
//		
//		for(int i=0; i<num3.length; ++i) {
//			for(int j=0; j<num3[i].length; ++j) {
//				//num3[i][j] = num;
////				num++;
//				num3[i][j] = num3[0].length * i + (j+1);
//			}
//		}
//		
//		
//		for (int[] is : num3) {
//			for (int is2 : is) {
//				System.out.printf(is2+"\t");
//			}
//			System.out.println();
//		}
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		

		// int[][] score = new int[5][3];
//		int[][] score={{100,100,100},{90,90,90},{80,80,80},{70,70,70},{60,60,60}};
//		
//		
//		System.out.println("[2차원 배열]");
//		for(int i=0; i<score.length; ++i) {
//			for(int j=0; j<score[i].length; ++j) {
//				System.out.print("2차원 배열:" + score[i][j]+ "\t");
//			}
//			System.out.println();
//		}

	}

}
