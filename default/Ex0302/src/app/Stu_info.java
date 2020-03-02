package app;

/**
 * Stu_info
 */
public class Stu_info {

    //학생정보
    //1. 학번 , 이름, 학과, 학년 , 전화
    static int numbering;
    int hak_num;
    String name;
    String major;
    int grade;
    int tel;

    Stu_info(String name, String major, int grade ,int tel){
        this.name =name;
        this.major =major;
        this.grade =grade;
        this.tel = tel;
        hak_num = ++numbering;
    }

}