package app;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;
public class App {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String originalStr = "°­³¶Äá"; // 
        System.out.println("°­³¶Äá.");
        String [] charSet = {"utf-8","euc-kr","ksc5601","iso-8859-1","x-windows-949","latin1"};
        System.out.println(scan.next());
        for (int i=0; i< charSet.length; i++) {
            for (int j=0; j<charSet.length; j++) {
                try {
                    System.out.println("[" + charSet[i] +"," + charSet[j] +"] = " + new String(originalStr.getBytes(charSet[i]), charSet[j]));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}