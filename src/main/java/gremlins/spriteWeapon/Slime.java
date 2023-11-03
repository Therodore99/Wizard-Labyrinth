package gremlins.spriteWeapon;

import gremlins.Resource;
import gremlins.roles.Wizard;
import processing.core.PApplet;
import processing.core.PImage;
/**
 * @author Guohao Tong
 * @Assignment01
 */

/**
 * Slime class, extends the Weapon class.
 */
public class Slime extends Weapon implements WeaponInterface{

    private PImage slimeImage;

    private int gremlinXVel;

    private int gremlinYVel;

    /**
     * Create the slime object.
     * @param x The same as the current gremlin's x location.
     * @param y The same as the current gremlin's y location.
     * @param slimeImage The image of the slime.
     * @param gremlinXVel The velocity of gremlin in the x direction.
     * @param gremlinYVel The velocity of gremlin in the y direction.
     */
    public Slime(int x, int y, PImage slimeImage, int gremlinXVel, int gremlinYVel){

        super(x, y);
        this.slimeImage = slimeImage;
        this.gremlinXVel = gremlinXVel;
        this.gremlinYVel = gremlinYVel;
        this.speed = 4;
    }

    boolean flag;

    /**
     * Move the slime.
     * Determine the direction in which the slime should move based on the positive or negative value of gremlin's moving speed.
     */
    public void moveSlime(){
        flag = true;

        if (gremlinYVel < 0) {
            this.xVel = 0;
            this.yVel = - speed;
            //Down
        } else if (gremlinYVel > 0) {
            this.xVel = 0;
            this.yVel = speed;
            //Right
        } else if (gremlinXVel > 0) {
            if(flag){
                this.yVel = 0;
                this.xVel = speed;
            }
            //Left
        } else if (gremlinXVel < 0){
            this.yVel = 0;
            this.xVel = -speed;
        }
    }

    /**
     * Determine if slime is about to collide with stonewall. If so, remove the current slime.
     */
    public void collisionStoneWall(){
        if(xVel > 0) {
            for (int i = 0; i < Resource.stonewallCoordinate.size(); i++) {
                if(Resource.stonewallCoordinate.get(i).getX() > this.getX() && Resource.stonewallCoordinate.get(i).getY() == this.getY()) {
                    if (Resource.stonewallCoordinate.get(i).getX() <= this.getX() + 20 & Resource.stonewallCoordinate.get(i).getX() + 20 > this.getX() + 20) {
                        flag = false;
                        Resource.gremlinSlime.remove(this);


                    }
                }
            }
        }else if(xVel < 0){
            for (int i = 0; i < Resource.stonewallCoordinate.size(); i++) {
                if (Resource.stonewallCoordinate.get(i).getX() < this.getX() && Resource.stonewallCoordinate.get(i).getY() == this.getY()) {
                    if (Resource.stonewallCoordinate.get(i).getX() <= this.getX() & Resource.stonewallCoordinate.get(i).getX() + 20 > this.getX()) {
                        flag = false;
                        Resource.gremlinSlime.remove(this);
                    }
                }
            }
        }else if(yVel > 0){
            for (int i = 0; i < Resource.stonewallCoordinate.size(); i++) {
                if (Resource.stonewallCoordinate.get(i).getX() == this.getX() && Resource.stonewallCoordinate.get(i).getY() > this.getY()) {
                    if (Resource.stonewallCoordinate.get(i).getY() <= this.getY() + 20 & Resource.stonewallCoordinate.get(i).getY() + 20 > this.getY() + 20) {
                        flag = false;
                        Resource.gremlinSlime.remove(this);
                    }
                }
            }
        }else if(yVel < 0){
            for (int i = 0; i < Resource.stonewallCoordinate.size(); i++) {
                if (Resource.stonewallCoordinate.get(i).getX() == this.getX() && Resource.stonewallCoordinate.get(i).getY() < this.getY()) {
                    if (Resource.stonewallCoordinate.get(i).getY() <= this.getY() & Resource.stonewallCoordinate.get(i).getY() + 20 > this.getY()) {
                        flag = false;
                        Resource.gremlinSlime.remove(this);
                    }
                }
            }
        }
    }

    /**
     * Determine if slime is about to collide with brick wall.
     */
    public void collisionBrickWall(){
        if(xVel > 0) {
            for (int i = 0; i < Resource.brickwallCoordinate.size(); i++) {
                if(Resource.brickwallCoordinate.get(i).getX() > this.getX() && Resource.brickwallCoordinate.get(i).getY() == this.getY()) {
                    if (Resource.brickwallCoordinate.get(i).getX() <= this.getX() + 20 & Resource.brickwallCoordinate.get(i).getX() + 20 > this.getX() + 20) {
                        flag = false;
                        Resource.gremlinSlime.remove(this);


                    }
                }
            }
        }else if(xVel < 0){
            for (int i = 0; i < Resource.brickwallCoordinate.size(); i++) {
                if (Resource.brickwallCoordinate.get(i).getX() < this.getX() && Resource.brickwallCoordinate.get(i).getY() == this.getY()) {
                    if (Resource.brickwallCoordinate.get(i).getX() <= this.getX() & Resource.brickwallCoordinate.get(i).getX() + 20 > this.getX()) {
                        flag = false;
                        Resource.gremlinSlime.remove(this);
                    }
                }
            }
        }else if(yVel > 0){
            for (int i = 0; i < Resource.brickwallCoordinate.size(); i++) {
                if (Resource.brickwallCoordinate.get(i).getX() == this.getX() && Resource.brickwallCoordinate.get(i).getY() > this.getY()) {
                    if (Resource.brickwallCoordinate.get(i).getY() <= this.getY() + 20 & Resource.brickwallCoordinate.get(i).getY() + 20 > this.getY() + 20) {
                        flag = false;
                        Resource.gremlinSlime.remove(this);
                    }
                }
            }
        }else if(yVel < 0){
            for (int i = 0; i < Resource.brickwallCoordinate.size(); i++) {
                if (Resource.brickwallCoordinate.get(i).getX() == this.getX() && Resource.brickwallCoordinate.get(i).getY() < this.getY()) {
                    if (Resource.brickwallCoordinate.get(i).getY() <= this.getY() & Resource.brickwallCoordinate.get(i).getY() + 20 > this.getY()) {
                        flag = false;
                        Resource.gremlinSlime.remove(this);
                    }
                }
            }
        }
    }

    /**
     * Draw the slime object.
     * @param App PApplet Object
     */

    public void draw(PApplet App){
        App.image(this.slimeImage, this.x, this.y);
        moveSlime();
        collisionStoneWall();
        collisionBrickWall();
        if(flag){
            x += xVel;
            y += yVel;
        }

    }
}
