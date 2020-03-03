import java.util.ArrayList;
import unit.*;
import unit.ground.*;
import unit.air.*;

/**
 * Ex0303_01
 */
public class Ex0303_01 {

    public static void main(String[] args) {

        /*
         * 마린 2명, 탱크 2대, 메딕 2명, 드랍쉽 1대, 벌쳐 4대, 터렛 2대를 생서앻서 드랍쉽 태울수있는것은 마린, 탱크,메딕만 태울 수
         * 있게 하자. 드랍쉽 태울수 있는 공간은 7만큼 태울 수 있음.
         * 
         * 마린탱크메딕은 int transit을 갖고 있다. 마린 3, 탱크 4, 메딕 2의 크기
         * 
         * 드랍쉽은 transport() 메소드가 있다. int transit_space = 7 (MAX)
         * 
         * 탱크 하나 마린 하나를 싣는다.
         */

        ArrayList<Unit> units = new ArrayList<>();

        units.add(new Marine());
        units.add(new Marine());
        units.add(new Tank());
        units.add(new Tank());
        units.add(new Medic());
        units.add(new Medic());
        Dropship d = new Dropship();
        units.add(d);
        units.add(new Vulture());
        units.add(new Vulture());
        units.add(new Vulture());
        units.add(new Vulture());
        units.add(new Turret());
        
        for(int i=0; i<units.size(); ++i){
            if(units.get(i) instanceof Marine){
                    d.transport((Trans)units.get(i));
                    break;
            }
        }
        for(int i=0; i<units.size(); ++i){
            if(units.get(i) instanceof  Tank){
                    d.transport((Trans)units.get(i));
                    break;
            }
        }
       









        ////////////////////////////////////////////////////////////////////////////////
        // 마린 2명, 탱크 2대, 메딕 2명 200,100 좌표로 이동
        // 벌쳐 4대, 탱크2대, 마린 4명 300,300 좌표료 이동을 하여라.

        // Unit[] group1 = new Unit[6];
        // Unit[] group2 = new Unit[10];

        // group1[0] = new Marine();
        // group1[1] = new Marine();
        // group1[2] = new Tank();
        // group1[3] = new Tank();
        // group1[4] = new Medic();
        // group1[5] = new Medic();

        // group2[0] = new Vulture();
        // group2[1] = new Vulture();
        // group2[2] = new Vulture();
        // group2[3] = new Vulture();
        // group2[4] = new Tank();
        // group2[5] = new Tank();
        // group2[6] = new Marine();
        // group2[7] = new Marine();
        // group2[8] = new Marine();
        // group2[9] = new Marine();

        // for(int i=0; i<group1.length; ++i){
        // group1[i].move(200, 100);
        // }
        // for(int i=0; i<group2.length; ++i){
        // group1[i].move(300, 300);
        // }

    } // main
} // class
