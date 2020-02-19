package app;

/**
 * Board
 */
public class Board {

    int no;
    String sub;
    String cont;
    String writer;
    int view;

    void printBoard(){
        System.out.printf("%d\t%s\t%s\t%s\t%d\n", no, sub, cont, writer, view);
    }
}