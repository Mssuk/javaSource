package app;

/**
 * Ex0225_02
 */
public class Ex0225_02 {

    public static void main(String[] args) {
        Student[] stu = new Student[3];
        String[] name = { "홍길동", "이순신", "김유신" };
        int[] grade = { 3, 4, 1 };

        for(int i = 0; i<stu.length; ++i){
            stu[i] = new Student(name[i], grade[i]);
        }

        //lotto 라는 크기 45의 배열을 만들어서 1~45 숫자 넣어라
        // int[] lotto = new int[45];
        // for(int i=0; i<lotto.length; ++i){
        //     lotto[i]= i + 1;
        // }


        //lotto객체를 만들어서 1~45가 들어가서 만들어질수있도록 해주세요.
        //선언만 하면 내용이 들어간다.

        // Lotto[] lottoto = new Lotto[45];
        // for(int i=0; i<lottoto.length; i++){
        //     lottoto[i] = new Lotto();
        // }


        // for (Lotto lotto2 : lottoto) {
        //     System.out.print(lotto2.num+ " ");
        // }

        Lotto newLotoo = new Lotto();
        for (int b : newLotoo.ball) {
            System.out.print(b + " /");
        }
    }
}