package gremlins.roles;

import processing.core.PImage;

/**
 * Role class, the parent class of Gremlins and Wizard
 */
public class Role {
    protected int x;
    protected int y;
    protected int xVel;
    protected int yVel;
    protected PImage roleImage;

    /**
     * Create Role object
     * @param x The x position on the map.
     * @param y The y position on the map.
     * @param roleImage The initial image of role.
     */
    public Role(int x, int y, PImage roleImage){
        this.x = x;
        this.y = y;
        this.roleImage = roleImage;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getxVel() {
        return xVel;
    }

    public int getyVel() {
        return yVel;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public PImage getRoleImage() {
        return roleImage;
    }

    public void setxVel(int xVel) {
        this.xVel = xVel;
    }

    public void setyVel(int yVel) {
        this.yVel = yVel;
    }

    public void setRoleImage(PImage roleImage) {
        this.roleImage = roleImage;
    }
}
