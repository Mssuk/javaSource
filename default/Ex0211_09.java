
import java.util.Random;

/**
 * Ex0211_09
 */
public class Ex0211_09 {

    public static void main(String[] args) {
        //Exercise 2
        //배열에 값 넣기
        //1차원 배열의 크기 10
                
        Random ran = new Random();
        //2-1
        //배열 값에 0, 500, 1000, 3000 중에 1개 값을 넣는다.
        //값을 배열에 넣어서 랜덤으로 돌려보세요.
        int[] arr = new int[10];
        int[] num = {0,500, 1000, 3000};
        int ranIndex = 0;


        for(int i=0; i<arr.length; ++i) {
        
            ranIndex = ran.nextInt(num.length);
            arr[i] = num[ranIndex];
        }

        System.out.println();
        
        System.out.println("----- 배열에 값 넣기 ------");
        System.out.println("<배열의 값>");
        System.out.print("{");
        for(int i=0; i<arr.length; ++i){
            if(i!= arr.length-1){
                System.out.print(arr[i] + ",");
            } else {
                System.out.print(arr[i]);
            }
        }
        System.out.print("}");
        
        System.out.println();

        //2-2
        //배열에 랜덤수를 0,10, 100, 1000 중에 1개를 넣는다.
        //0~3 
        //*1  | *10 | *100 | *1000을 곱해서 만들어보세요.
        int[] arr2 = new int[10];

        int[] num2 = {0,1, 2, 3};
        int ranIndex2 = 0;

        for(int i=0; i<arr2.length; ++i){
            ranIndex2 = ran.nextInt(num2.length);
            arr2[i] = (int)Math.pow(10,ranIndex2);
        }

        System.out.println();
        
        System.out.println("----- 배열에 값 넣기 ------");
        System.out.println("<배열의 값>");
        System.out.print("{");
        for(int i=0; i<arr2.length; ++i){
            if(i!= arr2.length-1){
                System.out.print(arr2[i] + ",");
            } else {
                System.out.print(arr2[i]);
            }
        }
        System.out.print("}");
        
        System.out.println();

        
    }
}