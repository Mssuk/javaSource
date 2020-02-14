package app;

/**
 * Ex0214_02 BUBBLE SORT
 */
public class Ex0214_02 {

    public static void main(String[] args) {
        //정렬~ 
        //1.10개의 배열을 만든다
        //2.각 랜덤으로 0~9까지의 숫자를 넣는다.
        //3.첫번째 두번째 비교.. 자리바꿈 두번째 세번째 비교 자리바꿈..
        //4. 연속으로 체크

  ///BUBBLESORT BUBBLESORT BUBBLESORT BUBBLESORT BUBBLESORT BUBBLESORT BUBBLESORT BUBBLESORT///      
        int temp = 0; //임시저장변수
        boolean check = false; //자리변경 체크변수
        //buble sort
        
        int[] arr1 = new int[10];        
        for(int i=0; i<arr1.length; ++i){
            arr1[i] = (int)(Math.random()*10);
        }

        System.out.println("정렬전 배열");
        for (int i : arr1) {
            System.out.print(i+" ");
        }
        System.out.println();
        
        for(int i=0; i<arr1.length; i++){
            check= false;
            for(int j=0; j<arr1.length - 1- i; j++){
                if(arr1[j]>arr1[j+1]) {
                    temp = arr1[j];
                    arr1[j] = arr1[j+1];
                    arr1[j+1] = temp;
                    check = true;
                }

                System.out.println(i+"번 인덱스의 " + j+" 번째 정렬");
                for (int k : arr1) {
                    System.out.print(k+" ");
                }
                System.out.println();
                System.out.println("-----------------------");
            }
            
            if(!check){
                System.out.println("정렬이 이미 완료되었습니다.");
                break;
            }
            System.out.println(i+1+"번 돌았을 때 배열");
            for (int k : arr1) {
                System.out.print(k+" ");
            }
            System.out.println();
        }
    
        System.out.println("최종 정렬 후 배열");
        for (int i : arr1) {
            System.out.print(i+" ");
        }
/////////////////////////////////////////////////////////////////////////////////////////////
        

    }
}