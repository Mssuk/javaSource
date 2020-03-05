/**
 * Ex0304_01
 */
public class Ex0304_01 {

    public static void main(String[] args) {
        Person p1 = new Person(88801011105519L);
        Person p2 = new Person(88801011105519L);
        System.out.println("p1의 " + p1);
        System.out.println("p2의 " + p2);
        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));

    }
}

class Person {
    long id;

    // 생성자
    Person() {
    }

    Person(long id) {
        this.id = id;
    }

    public String toString() {
        return "변수 값 :" + id;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        if(obj != null && obj instanceof Person){
            return this.id == ((Person)obj).id;
        } else{
            return false;
        }
    }
}