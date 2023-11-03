package gremlins.spriteWeapon;

/**
 * @author Guohao Tong
 * @Assignment01
 */

/**
 * Weapon class.
 * The parent class od fireball, freezeball and Slime.
 */
public class Weapon {
    protected int x;
    protected int y;
    protected int xVel;
    protected int yVel;
    protected int speed;

    /**
     * Create a weapon object.
     * @param x The x position on the map.
     * @param y The y position on the map.
     */
    public Weapon(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public int getxVel() {
        return xVel;
    }

    public int getyVel() {
        return yVel;
    }

    public void setxVel(int xVel) {
        this.xVel = xVel;
    }
    public void setyVel(int yVel) {
        this.yVel = yVel;
    }
}
