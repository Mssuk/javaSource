package unit.ground;
import unit.Unit;
/**
 * GroundUnit
 */
public abstract class GroundUnit extends Unit{
    public int transit;
    public String name;

    GroundUnit(int transit, String name){
        this.transit = transit;
        this.name= name;
    }
}