package app;

import java.util.Scanner;

/**
 * Ex0214_04
 */
public class Ex0214_04 {

    public static void main(String[] args) {
        // [ 성적처리 프로그램 ]
        // -------------------------

        Scanner scan = new Scanner(System.in, "euc-kr");
        int menu = 0; // 메뉴 선택 변수
        int exit = 0; // 종료 변수

        String[] subject = { "이름", "국어", "영어", "수학", "합계", "평균", "등수" };
        String[] names = new String[10]; // 이름 저장배열
        int[][] score = new int[names.length][4]; // 국어, 영어, 수학, 합계
        double[] avg = new double[names.length]; // 평균 저장 배열
        int[] rank = new int[names.length]; // 등수 저장
        int rank_count = 1;// 랭크 카운트
        int save = 0; // 입력 세이브값
        String yORn = ""; // 선택

        while (exit == 0) {
            System.out.println();
            System.out.println("-------------------------");
            System.out.println(" 성적처리 프로그램 ");
            System.out.println(" 1.성적 입력 ");
            System.out.println(" 2.성적 출력 ");
            System.out.println(" 3.등수 처리 ");
            System.out.println(" 4.학생 성적검색 ");
            System.out.println(" 0.시스템 종료 ");
            System.out.println("-------------------------");
            System.out.println("원하는 번호를 입력하세요.>>");
            menu = scan.nextInt();

            switch (menu) {
            case 1:
                System.out.println("성적 입력 화면입니다.(최대 10명)");

                for (int i = 0; i < names.length; ++i) {

                    if (save != 0) {
                        i = save;
                        save = 0;
                    }
                    System.out.println(i + 1 + "번째 학생의 이름을 입력하세요. (0) 이전 화면");
                    String candiName = scan.next();
                    if (candiName.equals("0")) {
                        System.out.println("상위메뉴로 이동합니다.");
                        save = i; // 입력한 것 다음부터 시작하기 위해 인덱스 저장
                        break;
                    }
                    names[i] = candiName;

                    // 10명 넘어가서 다시 입력할 때 기존 값 수정 (11번째부터는 덮어씀)
                    if (save == 0 && names[i] != null) {
                        score[i][score[i].length - 1] = 0; // 합계 초기화
                        // 랭크 갱신
                    }
                    for (int j = 0; j < score[i].length - 1; ++j) {
                        System.out.println(names[i] + "의 " + subject[j + 1] + "점수를 입력하세요.");
                        score[i][j] = scan.nextInt();
                        if (score[i][j] < 1 || score[i][j] > 100) {
                            System.out.println("점수는 1~100까지의 범위입니다.");
                            j--;
                            continue;
                        }

                        // 합계 구하는 식
                        score[i][score[i].length - 1] += score[i][j];
                    }
                    // 평균 구하는 식
                    avg[i] = score[i][score[i].length - 1] / 3.0; // 3 과목
                }

                break;

            case 2:
                scan.nextLine();
                System.out.println("성적 출력 화면입니다.");

                while (true) {

                    for (int i = 0; i < subject.length; ++i) {
                        System.out.print(subject[i] + "\t");
                    }
                    System.out.println();

                    for (int i = 0; i < score.length; ++i) {
                        if (names[i] == null) {
                            break;
                        }
                        System.out.print(names[i] + "\t");
                        for (int j = 0; j < score[i].length; ++j) {
                            System.out.print(score[i][j] + "\t");
                        }
                        System.out.printf("%.1f\t", avg[i]);
                        System.out.print(rank[i] !=0 ? rank[i]+ "\t\n" : "계산안됨"+"\t\n");

                    }
                    System.out.println("다시 출력하시겠습니까?(y/n)");
                    yORn = scan.nextLine();
                    if (yORn.equals("N") || yORn.equals("n")) {
                        System.out.println("이전 화면으로 이동합니다.");
                        break;
                    }
                }
                break;

            case 3:

                System.out.println("등수 처리를 입력하셨습니다.");

                // rank 처리
                for (int i = 0; i < score.length; ++i) {
                    rank_count = 1;
                    for (int j = 0; j < score.length; ++j) {
                        if (score[i][score[i].length - 1] < score[j][score[j].length - 1]) {
                            rank_count++;
                        }
                    }
                    rank[i] = rank_count;
                }
                System.out.println("등수 계산 완료. 출력하여 확인하시길 바랍니다.");
                break;


            case 4:
                System.out.println("학생 성적 검색을 입력하셨습니다.");
                
                while(true){
                    
                    System.out.println("--------------------------------");
                    System.out.println("원하는 학생의 이름을 입력하세요.  (0) 이전 화면>>");
    
                    //학생의 이름을 입력받아서
                    //이름을 비교한다.
                    String searchingName = scan.next();
                    if(searchingName.equals("0")){
                        System.out.println("이전 화면으로 이동합니다.");
                        break;
                    }
                    int searchIdx = -1;
                    for(int i=0; i<names.length; ++i){
                        if(searchingName.equals(names[i])){
                            searchIdx = i;
                            break;
                        }
                    }
                    if (searchIdx != -1) {
                        System.out.println(names[searchIdx] + " 학생의 점수를 출력합니다.");
                        for (int i = 0; i < subject.length; ++i) {
                            System.out.print(subject[i] + "\t");
                        }
                        System.out.println();
    
                        System.out.print(names[searchIdx] + "\t");
                        for (int j = 0; j < score[searchIdx].length; ++j) {
                            System.out.print(score[searchIdx][j] + "\t");
                        }
    
                        System.out.printf("%.1f\t", avg[searchIdx]);
                        System.out.print(rank[searchIdx] != 0 ? rank[searchIdx] + "\t\n" : "계산안됨" + "\t\n");
                    } else {
                        System.out.println("찾는 학생이 없습니다.");
                    }
                }


                break;

            case 0:
                System.out.println("프로그램 종료..");
                exit = 1;
                break;
            default:
                System.out.println("잘못된 값.");
                break;
            }

        }

    }
}