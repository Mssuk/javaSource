package app;

/**
 * Ex0302_04
 */
public class Ex0302_04 {

    public static void main(String[] args) {
        // Marine m1 = new Marine();
        // m1.move(10, 10);
        Unit[] group = new Unit[10];
        group[0] = new Marine();
        group[1] = new Tank();
        group[2] = new Dropship();

        // for (int i = 0; i < group.length; i++) {
        // if(group[i]!=null)
        // group[i].move(100, 200);
        // }

        group[0].move(1000, 1000);
        group[1].move(1000, 1000);
        group[2].move(1000, 1000);
    }
}

abstract class Unit {
    int x, y;

    abstract void move(int x, int y);

    void stop() {
        System.out.println("현재 위치에서 멈춤");
    }

}

class Marine extends Unit {

    @Override
    void move(int x, int y) {
        // TODO Auto-generated method stub
        int distance = (Math.abs(x) + Math.abs(y));
        int sec = distance * 4;

        int hour = 0;
        int minute = 0;

        if (sec >= 3600) {
            hour = sec / 3600;
            sec = sec % 3600;
        }
        if (sec >= 60) {
            minute = sec / 60;
            sec = sec % 60;
        }

        System.out.println(x + "," + y + "으로 이동. 걸리는 시간: " + hour + "시" + minute + "분" + sec + "초");
        System.out.println("몇미터 움직였나?" + distance);
    }

    void stimPack() {

    }

}

class Tank extends Unit {

    void move(int x, int y) {
        int distance = (Math.abs(x) + Math.abs(y));
        int sec = distance * 6;

        int hour = 0;
        int minute = 0;

        if (sec >= 3600) {
            hour = sec / 3600;
            sec -= 3600 * hour;
        }
        if (sec >= 60) {
            minute = sec / 60;
            sec -= 60 * minute;
        }

        System.out.println(x + "," + y + "으로 이동. 걸리는 시간: " + hour + "시" + minute + "분" + sec + "초");
        System.out.println("몇미터 움직였나?" + distance);
    }

    void changeMode() {

    }

}

class Dropship extends Unit {

    void move(int x, int y) {

        int distance = (int) (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
        int sec = distance * 2;
        int hour = 0;
        int minute = 0;

        // 1분 60초
        // 60분 3600초

        if (sec >= 3600) {
            hour = sec / 3600;
            sec = hour % 3600;
        }
        if (sec >= 60) {
            minute = sec / 60;
            sec = minute % 60;
        }

        System.out.println(x + "," + y + ":" + "하늘로 움직임. 움직이는 속도 10, 걸리는 시간: " + hour + "시" + minute + "분" + sec + "초");
        System.out.println("몇미터 움직였나?" + distance);
    }

    void load() {

    }

    void unload() {

    }
}
