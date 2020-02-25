package app;

/**
 * Ex0225_03
 * 
 * 1. Shape 2. Point 3. Circle 4. Triangle 5. Circle -> 기본생성자, 50,100 r = 200
 * Triangle -> 기본생성자, 30,30 70,70 100, 20
 */

class Shape1 {
    protected String color = "black";

    void draw() {
        System.out.println("색상은 " + color + " 이다.");
        System.out.println();
    }
}

class Point1 {
    int x;
    int y;

    // 기본 값 원점 0,0
    Point1() {
        this(0, 0);
    }

    Point1(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // x,y좌표 반환
    String getXY() {
        return String.format("좌표는 (%d,%d) ", x, y);
    }
}

class Circle1 extends Shape1 {
    Point1 point; // 좌표
    int r; // 반지름

    Circle1() {
        this(new Point1(0, 0), 2);
        super.color = "blue";
    }

    Circle1(Point1 point, int r) {
        this.point = point;
        this.r = r;
    }

    @Override
    void draw() {
        System.out.println("원을 그리기.");
        System.out.println("원의 " + point.getXY() + "반지름은 " + r);
        super.draw();
    }
}

class Triangle1 extends Shape1 {
    Point1[] points;

    Triangle1() {
        this(new Point1[] { new Point1(10, 10), new Point1(20, 20), new Point1(30, 30) });
        super.color = "white";
    }

    Triangle1(Point1[] points) {
        this.points = points;
    }

    @Override
    void draw() {
        System.out.println("삼각형을 그리기.");
        System.out.println("삼각형의 " + points[0].getXY() + points[1].getXY() + points[2].getXY());
        super.draw();
    }

}

public class Ex0225_03 {

    public static void main(String[] args) {

        Circle1 newCircle = new Circle1();
        Circle1 newCircle2 = new Circle1(new Point1(50, 100), 200);

        Triangle1 newTri = new Triangle1();
        Triangle1 newTri2 = new Triangle1(new Point1[] { new Point1(30, 30), new Point1(70, 70), new Point1(100, 20) });

        newCircle.draw();
        newCircle2.draw();

        newTri.draw();
        newTri2.draw();

    }
}