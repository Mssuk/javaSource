package unit.air;
import unit.Trans;
import unit.ground.*;
public class Dropship extends AirUnit {


    int transit_space = 0;
    GroundUnit[] ground = new GroundUnit[7];
    int i =0;

    public void transport(Trans t){
        if(t instanceof GroundUnit){
            GroundUnit g = (GroundUnit)t;
            if((transit_space += g.transit) <=7){
              //  System.out.println(g.name+ " 태웠습니다.");
                ground[i] = g;
                i++;
            } else{
                System.out.println("공간이 없어 태울 수 없습니다.");
                transit_space -=g.transit;
                return;
            }
        }
        
        for (GroundUnit groundUnit : ground) {
            if(groundUnit != null)
            System.out.print(groundUnit.name+ " ");
        }
        System.out.println();
    }

   public void move(int x, int y) {
    };

    void load() {
    };

    void unload() {
    };
}