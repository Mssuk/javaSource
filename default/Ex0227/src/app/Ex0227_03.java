package app;

/**
 * Ex0227_03
 */
public class Ex0227_03 {

    public static void main(String[] args) {

            Car c = new Car();
            Car c2= null;

            FireEngine f = null;
            FireEngine f2 = new FireEngine();

            c.drive();
            c =f2;
            if(c instanceof Car){
                System.out.println("카이다");
            }
            if(c instanceof FireEngine){
                System.out.println("소방차이다");
            }
            c2 = f2;

            // f= (FireEngine) c;
            //FireEngine f = new Car(); 
            //자손의 참조변수에 조상의 객체를 선언하는 것은 안된다.


            //f.water(); //Car에 water가 없으므로 안된다.
            f2.water(); //이거는 된다.


            // Car c = new Car();
            // FireEngine f = new FireEngine();
            // Car c2 = new FireEngine(); //다형성
            
            // //FireEngine f2 = new Car(); //이건 안됨
            // FireEngine f2 = new FireEngine();
            // FireEngine f3 = null;
            // c = f2; // 자손->조상 up은 형변환 생략가능

            // f3 = (FireEngine) c; //조상 ->자손 명시적 형변환 해야 한다.
            // f3.water();


            // System.out.println("<깡통차>");
            // c.drive();
            // c.stop();
            // // c.water();  error

            // System.out.println("<소방차>");
            // f.drive();
            // f.stop();
            // f.water();

    }
}

class Car{
    String color;
    int door;

    void trans(){
        System.out.println("기본 카로 변신되었습니다.");
    }
    void drive(){
        System.out.println("엑셀을 밟으면 출발~~");
    }

    void stop(){
        System.out.println("브레이크를 밟으면 멈춤");
    }
    

}

class FireEngine extends Car{


    FireEngine(){
        water();
    }

    void water(){
        System.out.println("물이 발사~");

    }
    @Override
    void drive(){
        System.out.println("소방차의 엑셀");
    }
}

class Ambulance extends Car{

    Ambulance(){
        siren();
    }

    void siren(){
        System.out.println("왜애애애애애애애애앵");
    }
    void move(){
        System.out.println("●▅▇█▇▆▅▄▇");
    }
    @Override
    void drive(){
        System.out.println("앰뷸런스의 엑셀");
    }
}

class Truck extends Car{

    Truck(){
        move();
    }
    void move(){
        System.out.println("물건을 옮깁니다.");
    }
    @Override
    void drive(){
        System.out.println("트럭의 엑셀");
    }
}
