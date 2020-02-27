package app;

/**
 * Stu01
 */
final public class Stu01 {

    private static Stu01 s = new Stu01();

    private int hak_num;
    private String name;
    private int kor;

    private Stu01() {

    }

    public static Stu01 getInstance(){
        if(s == null){
            s = new Stu01();
        }
        return s;
    }


    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("학번 : %d / 이름 : %s / 국어점수 : %d", hak_num, name, kor);
    }

    public int getHak_num() {
        return hak_num;
    }

    public void setHak_num(int hak_num) {
        this.hak_num = hak_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKor(int kor){
        this.kor = kor;
    }
}