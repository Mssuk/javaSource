package app;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int[] lotto = {8, 19, 20, 21, 33, 39};
        int[] backup = new int[6];     
        int[] ranNum = new int[45];

        for(int i=0; i<ranNum.length ;++i){
            ranNum[i] = i+1;
        }
        
        long tryCnt = 0;
        long start = System.currentTimeMillis();
        do{
            tryCnt++;
            for(int i=0; i<ranNum.length; ++i){
                int index = (int)(Math.random()*45);
                int temp = ranNum[i];
                ranNum[i] = ranNum[index];
                ranNum[index] = temp;
            }
            
            System.arraycopy(ranNum, 0, backup, 0, backup.length);
            Arrays.sort(backup);

            for (int i : backup) {
                System.out.print(i + " ");
            }
            System.out.println();
        } while(!(Arrays.equals(lotto, backup)));
        
        long end = System.currentTimeMillis();
        System.out.println("시도 횟수: "+tryCnt+ "회");
        System.out.println("실행 시간: "+(end-start)/1000.0 + "초");
     }
}