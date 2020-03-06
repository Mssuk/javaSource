public class Student {
    int hak_num;
    String name;
    int total;

    Student(int hak_num, String name, int total){
        this.hak_num = hak_num;
        this.name = name;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Student{" +
                "hak_num=" + hak_num +
                ", name='" + name + '\'' +
                ", total=" + total +
                '}';
    }
}
