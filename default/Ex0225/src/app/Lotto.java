package app;

/**
 * Lotto
 */
public class Lotto {


    int[] ball = new int[45];

    //초기화 블럭 사용
    // {
    //     count++;
    //     num = count;
    // }
    
    //생성자 사용
    Lotto(){
     
        for(int i=0; i<ball.length; ++i){
            ball[i]= i + 1;
        }
    }

}