package app;

import java.util.Scanner;

/**
 * Ex0226_02
 */
public class Ex0226_02 {

    Ex0226_02(){
        super();
    }

    Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Point p = new Point(100, 100);

        Point3D p3 = new Point3D(50, 60, 70);
        System.out.println(p3.getLocation());

        System.out.println(p.getLocation());
    }
}

// 기본으로 Object를 상속함 (안 적어도)
class Point extends Object {
    int x;
    int y;

    Point() {
        this(0, 0);
    }

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    String getLocation() {
        return String.format("X좌표: %d , Y좌표: %d", x, y);
    }
    

}

class Point3D extends Point {
    int z;

    Point3D(int x, int y, int z) {
        // Point 클래스에 기본 생성자를 안만들어주면 super(x,y) 로 직접 명시해야함.
        // super(x, y);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    String getLocation() {
        return super.getLocation() + ", Z좌표 : " + z;
    }

}