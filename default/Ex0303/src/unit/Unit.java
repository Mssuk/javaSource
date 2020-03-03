package unit;

public abstract class Unit{
    protected int x, y;
    protected abstract void move(int x, int y);
    protected void stop() {};
}