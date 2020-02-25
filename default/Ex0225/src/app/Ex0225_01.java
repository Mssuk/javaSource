package app;

import java.util.Scanner;

/**
 * Ex0225_01
 */

// 도형그리기 클래스
class Shape {
    String color = "black";

    Shape() {
        System.out.println("shape 만들어짐");
    }

    void draw() {
        System.out.println("면을 만듭니다.");
        System.out.println("면의 색상 :" + color);
    }
}

// 좌표점 클래스
class Point {
    int x;
    int y;

    Point() {
        this(0, 0);
    }

    Point(int x, int y) {
        System.out.println("Point 생성");
        this.x = x;
        this.y = y;
    }

    String getXY() {
        return "(" + "x의 좌표 " + x + ", y의 좌표 " + y + ")";
    }
}

// 원형 그리기 클래스
class Circle extends Shape {
    Point center;
    int r;

    Circle() {
        this(new Point(0, 0), 100);
        System.out.println("써클 만들어짐1");
        super.color = "red";

    }

    Circle(Point center, int r) {
        this.center = center;
        System.out.println("써클 만들어짐2");
        this.r = r;

    }

    void draw() {
        System.out.println("원형을 그립니다.");
        System.out.println("(원점 :" + center.x + "," + center.y + "/ 반지름 :" + r + " 색상 :" + super.color + ")");
    }
}

class Triangle extends Shape {
    Point[] p;

    Triangle() {
        this(new Point(0, 0), new Point(100, 0), new Point(0, 100));
    }

    Triangle(Point[] p) {
        this.p = p;
    }

    Triangle(Point p1, Point p2, Point p3) {
        p = new Point[] { p1, p2, p3 };
    }

    void draw() {
        System.out.println("삼각형을 그립니다.");
        System.out.println("(좌표1: " + p[0].getXY() + " / 좌표2: " + p[1].getXY() + "/ 좌표3 : " + p[2].getXY() + "/ 색상 :"
                + color + ")");
    }
}

public class Ex0225_01 {

    public static void main(String[] args) {
        // Circle c1 = new Circle();
        // Circle c2 = new Circle(new Point(150,150), 50);
        // Circle c3 = new Circle(new Point(150,30), 200);
        // Point[] p ={
        // new Point(100,100),
        // new Point(140,50),
        // new Point(200,100)
        // };
        // Triangle t1 = new Triangle(p);
        // System.out.println(c1.color);
        // c1.draw();
        // c2.draw();
        // c3.draw();
        // t1.draw();

        // input -> 좌표 60,50, 반지름 100

        Scanner scan = new Scanner(System.in);
        // int[] num = new int[3];

        // Circle[] c = new Circle[3];
        // Point[] pp = new Point[3];
        // String[] print = { "X좌표", "Y좌표", "반지름" };

        // for (int j = 0; j < num.length; j++) {
        //     for (int i = 0; i < num.length; i++) {
        //         System.out.println(print[i] + "값을 넣으세요.>>");
        //         num[i] = scan.nextInt();
        //     }
        //     pp[j] = new Point(num[0], num[1]);
        //     c[j] = new Circle(pp[j], num[2]);
        // }

        // for (Point ps : p) {
        // System.out.println(ps.getXY());
        // }

        // for (int i : r) {
        // System.out.print(i+ " ");
        // }

        // for (int i = 0; i < c.length; i++) {
        //     c[i].draw();
        // }


        //Triangle 
        // 20,20, /40, 100 / 30, 10

        Triangle tri= new Triangle(new Point(20,20), new Point(40, 100), new Point(30, 10));
        tri.draw();

    }
}


//책의 