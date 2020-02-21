package app;

import java.util.Scanner;

/**
 * Ex0221_01
 */
public class Ex0221_01 {

    public static void main(String[] args) {

        // 랜덤으로 10개의 1차원 배열을 만들어서
        // 1~45의 값을 넣어보세요.

        int[] arr = new int[45];
        int[] nums = new int[10];
    
        while (true) {

            switch (main_print()) {
                case 1:
                    inNum(arr);
                    System.out.println("45개 값 넣기 완료.");
                    break;
                case 2:
                    shuffleNum(arr);
                    System.out.println("랜덤 섞기 완료");
                    break;

                case 3:
                    copyNum(arr, nums);
                    System.out.println("10개 값 넣기 완료");
                    break;

                case 4:
                    print(nums);
                    System.out.println("10개 출력 완료");
                    break;

                case 5:
                    System.out.println(sum(nums));
                    System.out.println("10개 합구하기  완료");
                    break;

                case 6:
                    int[] sorted = new int[nums.length];
                    sorted = arrSort(nums);
                    System.out.println("10개 정렬하기 완료");

                    System.out.println("----------------------");
                    System.out.println("정렬된 배열");
                    print(sorted);
                    System.out.println("원래 배열");
                    print(nums);

                    break;

                default:
                    break;
            }
        }

    } // main

    static int main_print(){
        System.out.println();
        System.out.println("----------------------------------");
        System.out.println("1.45개의 값넣기");
        System.out.println("2.랜덤섞기");
        System.out.println("3.10개의 값넣기");
        System.out.println("4.10개 출력");
        System.out.println("5.10개 합구하기");
        System.out.println("6.10개 정렬하기");
        System.out.println("원하는 번호를 입력하세요.>>");
        System.out.println("----------------------------------");
        Scanner scan =new Scanner(System.in);
        return scan.nextInt();
    }


    static void init(int[] arr1, int[] arr2) {
        inNum(arr1);
        shuffleNum(arr1);
        copyNum(arr1, arr2);
    }

    static void inNum(int[] arr1) {
        for (int i = 0; i < arr1.length; ++i) {
            arr1[i] = i + 1;
        }
    }

    static void shuffleNum(int[] arr1) {
        for (int i = 0; i < 10000; ++i) {
            int idx = (int) (Math.random() * 45);
            int temp = arr1[0];
            arr1[0] = arr1[idx];
            arr1[idx] = temp;
        }
    }

    static void copyNum(int[] arr1, int[] arr2) {
        System.arraycopy(arr1, 0, arr2, 0, arr2.length);
    }

    static void print(int[] arr){
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
    static int sum(int[] arr){
        int result = 0;
        for(int i=0; i<arr.length; i++){
            result +=arr[i];
        }
        return result;
    }

    static int[] arrSort(int[] arr){

        int[] sorted = new int[arr.length];
        System.arraycopy(arr, 0, sorted, 0, arr.length);
        int minIdx = 0;
        int temp = 0;
        for(int i=0; i<sorted.length-1; i++){
            minIdx = i;
            for(int j=i+1; j<sorted.length; j++){
                if(sorted[j]< sorted[minIdx]){
                    minIdx = j;
                }
            }
            temp = sorted[i];
            sorted[i] = sorted[minIdx];
            sorted[minIdx] = temp;
        }
        return sorted;
    }

} // class





/*

          65 64 63 62 61 60 59 58 57
          66 37 36 35 34 33 32 31 56
          67 38 17 16 15 14 13 30 55
          68 39 18 5  4  3 12  29 54
          69 40 19 6  1  2 11  28 53
          70 41 20 7  8  9 10  27 52
          71 42 21 22 23 24 25 26 51
          72 43 44 45 46 47 48 49 50
          73 74

          1        
                    > 4 2     
          5 3         6 8    
          <7> 9     [8]
                    > 12 10
          17 13       14 16
          <21> 25   [8]
                    > 20 18
          37 31       22 24
          <43> 49 

        (x,y)                                                    |
        1                                                       |   (3,3)
                        + [2 4 6 8]                            |    
        (x-1, y+1) (x-1, y-1) (x+1, y-1) (x+1, y+1)           |     (2,4) (1,3) (3,3) (4,4)
        3 5 7 9                                              |  
                       + [10 12 14 16]                      |       
        (x-2, y+2) (x-2, y-2) (x+2, y-2) (x+2, y+2)        |        (1,5) (1,1) (5,1) (5,5)
        13 17 21 25                                       |
                                                         | 
        (x-3,y+3) (x-3, y-3) (x+3, y-3) (x+3, y+3)      |           (0,6) (0,0) (6,0) (6,6)
        31 37 43 49   + [18 20 22 24]                  |

                    + [26 28 30 32]
        57 65 73 81
    

        (-3 ,-3) (2, 0)  ->  시작 위치 (3,3)
                         -> 왼쪽구석 (0,0) 오른쪽 구석(5, 3)

        (-3, -3) (3, 3) -> 시작 위치(3,3)
                        -> 왼쪽구석 (0,0) 오른쪽 구석(6, 6)


        (40, -2) (45, 1)  ->시작위치(40, 2)
                          -> 왼쪽구석(0,0) 오른쪽 구석(5, 3)

        0 0 0 0                           -2 -1  0  1   2
        0 0 0 0                       40 \ 8  8  8  8 \ 0
        0 0 0 0                       41 \ 8  8  8  8 \ 0
        0 0 0 1                       42 \ 8  8  8  8 \ 0                                   
        0 0 0 0                       43 \ 8  8  8  8 \ 0  
                                      44 \ 8  8  8  8 \ 0
                                      45 \ 8  8  8  8 \ 0
                                      .
                                      .
                                      .
                                      0  \ 0  0  1  0 \ 0


    (40,2) -> 1
    (39,3) (39,1) (41,1) (41,3) 
    (38,4) (38,0) (42,0) (42,4)
    (37,5) (37,-1)
    ..
    //40번
    (0, 42) (0,-38) (80, -38)(80, 42)
    


*/                                    