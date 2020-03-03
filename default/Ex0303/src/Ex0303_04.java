/**
 * Ex0303_04
 */
public class Ex0303_04 {

    public static void main(String[] args) {
        Exception e = new Exception("고의로 발생시킨 예외");
        System.out.println(1);
        System.out.println(2);
        try{
            throw e;
            //System.out.println(3);
        } catch(Exception e2){
            System.out.println("에러 메시지:"+ e.getMessage());
            e.printStackTrace();
            System.out.println();
        }
        System.out.println(3);
        System.out.println("완료");
    }
}