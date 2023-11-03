package gremlins;

/**
 * @author Guohao Tong
 * @Assignment01
 */

/**
 * The coordinate class.
 * Used to record the coordinates of all objects in the map.
 */
public class Coordinate{
    private int x;
    private int y;

    /**
     * The constructor of class
     * @param x The x coordinate of the current object
     * @param y The y coordinate of the current object
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
