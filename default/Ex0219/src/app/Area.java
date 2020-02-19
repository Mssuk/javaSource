package app;

/**
 * Area
 */
public class Area {

    int horiz;
    int vert;
    int height;


    int square(){
        return horiz * horiz;
    }

    int rectangle(){
        return horiz* vert;
    }
}