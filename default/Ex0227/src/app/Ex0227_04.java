package app;

import java.util.Scanner;

/**
 * Ex0227_04
 */
public class Ex0227_04 {

    public static void main(String[] args) {

        /*
         * 
         * 변신 카 프로그램 1) 소방차 생성 2) 앰뷸런스 생성 3) 트럭 생성 ----------------- 4) 기본차로 변신 5) 원래
         * 생성된 차로 변신 6) 종료 원하는 번호를 입력하시오.
         * 
         */
        Car myCar = null;
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("-----------------------------------------------");
            System.out
                    .print("변신 카 프로그램\n1)소방차 생성\n2)앰뷸런스 생성\n3)트럭 생성\n4)기본차로 변신\n5)원래 생성된 차로 변신\n6)종료\n원하는 번호를 입력하시오.");
            switch (scan.nextInt()) {
                case 1:
                    FireEngine newFire = new FireEngine();
                    myCar = newFire;
                    break;
                case 2:
                    Ambulance newAmb = new Ambulance();

                    myCar = newAmb;
                    break;
                case 3:
                    Truck newTruck = new Truck();
           
                    myCar = newTruck;
                    break;
                case 4:
                    myCar = transBasic(myCar);
                    break;
                case 5:
                    transOrigin(myCar);
                    break;
                case 6:
                    System.out.println("시스템 종료");
                    System.exit(0);
                    break;
                default:
                    System.out.println("잘못된 입력");
                    break;
            }

        }

        /*
         * ///////////////////////////////////// 앰뷸런스 객체 1개 생성 카 객체에 넣고 드라이브 메소드 실행 형변환을
         * 하여 앰뷸런스 1개 객체를 추가하여 사이렌을 실행해 보세요.
         * 
         */
        // Ambulance amb = new Ambulance();
        // Car carone;
        // //////////////////////////////////////////
        // carone = amb;
        // check(carone);
        // carone.drive();

        // Ambulance amb2 = null;
        // amb2 = (Ambulance)carone;
        // check(carone);

        // amb2.siren();

        //////////////////////////////////////

        // FireEngine fe = new FireEngine();

        // if(fe instanceof FireEngine){
        // System.out.println("네 맞습니다.");
        // }
        // if(fe instanceof Car){
        // System.out.println("네 맞습니다!");
        // }
        // if(fe instanceof Object){
        // System.out.println("네 맞습니다!!");
        // }
    }

    static Car transBasic(Car someCar) {

        return (Car)someCar;
    }

    static Car transOrigin(Car someCar) {
        if (someCar instanceof FireEngine) {
            return new FireEngine();

        }
        if (someCar instanceof Ambulance) {
            return new Ambulance();
        }
        if (someCar instanceof Truck) {
            return new Truck();
        }
        return new Car();

    }

    // static void check(Object obj) {
    // if (obj instanceof Ambulance) {
    // System.out.println("앰뷸런스 입니다.");
    // } else {
    // System.out.println("앰뷸런스가 아닙니다.");
    // }
    // }
}
