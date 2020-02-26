package app;

/**
 * Ex0226_02
 */
public class Ex0226_02 {

    public static void main(String[] args) {
        Point p = new Point(100, 100);

        Point3D p3= new Point3D(50, 60, 70);
        System.out.println(p3.getLocation());

       System.out.println(p.getLocation());
    }
}

class Point{
    int x;
    int y;

    // Point(){
    //     this(0,0);
    // }

    Point(int x, int y){
        this.x= x;
        this.y= y;
    }

    String getLocation(){
        return String.format("X좌표: %d , Y좌표: %d", x, y);
    }

}

class Point3D extends Point{
    int z;

    Point3D(int x, int y, int z){
        super(x, y);
        this.x =x;
        this.y= y;
        this.z= z;
    }

    @Override
    String getLocation(){
        return super.getLocation() + ", Z좌표 : " + z;
    }

}