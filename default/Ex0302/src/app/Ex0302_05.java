package app;

/**
 * Ex0302_05
 */
public class Ex0302_05 {

    public static void main(String[] args) {

        Marine1 m1 = new Marine1();
        Tank1 t1 = new Tank1();
        SCV s1 = new SCV();

        m1.hitPoint -= 10;
        t1.hitPoint -= 100;

        System.out.println("-------------");
        System.out.println(t1.hitPoint);
        System.out.println(m1.hitPoint);
        System.out.println("-------------");
        s1.repair(t1); // 탱크 수리
        // s1.repair(m1);

        System.out.println("-------------");
        System.out.println(t1.hitPoint);
        System.out.println(m1.hitPoint);
        System.out.println("-------------");

    } // main
} // class

class Tank1 extends GroundUnit implements Repairable {
    Tank1() {
        super(150);
        hitPoint = MAXHP;
    }
}

class Marine1 extends GroundUnit {
    Marine1() {
        super(40);
        hitPoint = MAXHP;
    }
}

class SCV extends GroundUnit implements Repairable {
    SCV() {
        super(60);
        hitPoint = MAXHP;
    }

    void repair(Repairable u) {
        if (u instanceof Unit1) {
            Unit1 uni = (Unit1) u;
            while (uni.hitPoint != uni.MAXHP) {
                uni.hitPoint++;
            }
        }
    }
}

class Dropship1 extends AirUnit {
    Dropship1() {
        super(150);
        hitPoint = MAXHP;
    }
}

class Unit1 {
    int hitPoint;
    final int MAXHP;

    Unit1(int hp) {
        MAXHP = hp;
    }
}

class GroundUnit extends Unit1 {
    GroundUnit(int hp) {
        super(hp);
    }
}

class AirUnit extends Unit1 {
    AirUnit(int hp) {
        super(hp);
    }
}

interface Repairable {
}