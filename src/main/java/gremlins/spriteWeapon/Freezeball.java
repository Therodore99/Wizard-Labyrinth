package gremlins.spriteWeapon;

import gremlins.Coordinate;
import gremlins.Resource;
import gremlins.roles.Wizard;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * @author Guohao Tong
 * @Assignment01
 */

/**
 * Freeze ball class, extends the Weapon class.
 */
public class Freezeball extends Weapon implements WeaponInterface{

    private int speed = 4 ;
    private PImage freezeImage;

    int temp = -1;

    /**
     * Create a freeze ball when the user presses the Tab key.
     * @param x The same as the current wizard's x location.
     * @param y The same as the current wizard's y location.
     * @param freezeImage The image of freeze ball.
     */
    public Freezeball(int x, int y, PImage freezeImage){
        super(x,y);
        this.freezeImage = freezeImage;
        this.speed = 4;
    }

    boolean flag;

    /**
     * When the user presses the Tab keyboard, freeze ball moves in the direction the current wizard.
     * @param wizardImage The current image of wizard.
     */
    public void moveFreezeball(PImage wizardImage){
        flag = true;
        if (wizardImage == Wizard.getWizardUp()) {
            this.xVel = 0;
            this.yVel = - speed;
            //Down
        } else if (wizardImage == Wizard.getWizardDown()) {
            this.xVel = 0;
            this.yVel = speed;
            //Right
        } else if (wizardImage == Wizard.getWizardRight()) {
            if(flag){
                this.yVel = 0;
                this.xVel = speed;
            }
            //Left
        } else if (wizardImage == Wizard.getWizardLeft()){
            this.yVel = 0;
            this.xVel = -speed;
        }
    }

    /**
     * Determine if the freeze ball is colliding with the stone wall. If so, remove the current freeze ball.
     */

    public void collisionStoneWall(){

        if(xVel > 0) {
            for (int i = 0; i < Resource.stonewallCoordinate.size(); i++) {
                if(Resource.stonewallCoordinate.get(i).getX() > this.getX() && Resource.stonewallCoordinate.get(i).getY() == this.getY()) {
                    if (Resource.stonewallCoordinate.get(i).getX() <= this.getX() + 20 & Resource.stonewallCoordinate.get(i).getX() + 20 > this.getX() + 20) {
                        flag = false;
                        Resource.freezeballs.remove(this);
                    }
                }
            }
        }else if(xVel < 0){
            for (int i = 0; i < Resource.stonewallCoordinate.size(); i++) {
                if (Resource.stonewallCoordinate.get(i).getX() < this.getX() && Resource.stonewallCoordinate.get(i).getY() == this.getY()) {
                    if (Resource.stonewallCoordinate.get(i).getX() <= this.getX() & Resource.stonewallCoordinate.get(i).getX() + 20 > this.getX()) {
                        flag = false;
                        Resource.freezeballs.remove(this);
                    }
                }
            }
        }else if(yVel > 0){
            for (int i = 0; i < Resource.stonewallCoordinate.size(); i++) {
                if (Resource.stonewallCoordinate.get(i).getX() == this.getX() && Resource.stonewallCoordinate.get(i).getY() > this.getY()) {
                    if (Resource.stonewallCoordinate.get(i).getY() <= this.getY() + 20 & Resource.stonewallCoordinate.get(i).getY() + 20 > this.getY() + 20) {
                        flag = false;
                        Resource.freezeballs.remove(this);
                    }
                }
            }
        }else if(yVel < 0){
            for (int i = 0; i < Resource.stonewallCoordinate.size(); i++) {
                if (Resource.stonewallCoordinate.get(i).getX() == this.getX() && Resource.stonewallCoordinate.get(i).getY() < this.getY()) {
                    if (Resource.stonewallCoordinate.get(i).getY() <= this.getY() & Resource.stonewallCoordinate.get(i).getY() + 20 > this.getY()) {
                        flag = false;
                        Resource.freezeballs.remove(this);
                    }
                }
            }
        }
    }

    int brickWallState = 0;

    /**
     * Determine if the freeze ball is colliding with the brick wall. If so, remove the current freeze ball.
     *
     */
    public void collisionBrickWall(){
        if(xVel > 0){
            for (int i = 0; i < Resource.brickwallCoordinate.size(); i++) {
                if(Resource.brickwallCoordinate.get(i).getX() > this.getX() && Resource.brickwallCoordinate.get(i).getY() == this.getY()) {
                    if (Resource.brickwallCoordinate.get(i).getX() <= this.getX() + 20 & Resource.brickwallCoordinate.get(i).getX() + 20 > this.getX() + 20){
                        flag = false;
                        Resource.freezeballs.remove(this);
                    }
                }
            }
        }else if(xVel < 0){
            for (int i = 0; i < Resource.brickwallCoordinate.size(); i++) {
                if (Resource.brickwallCoordinate.get(i).getX() < this.getX() && Resource.brickwallCoordinate.get(i).getY() == this.getY()) {
                    if (Resource.brickwallCoordinate.get(i).getX() <= this.getX() & Resource.brickwallCoordinate.get(i).getX() + 20 > this.getX()) {
                        flag = false;
                        Resource.freezeballs.remove(this);
                    }
                }
            }
        }else if(yVel > 0){
            for (int i = 0; i < Resource.brickwallCoordinate.size(); i++) {
                if (Resource.brickwallCoordinate.get(i).getX() == this.getX() && Resource.brickwallCoordinate.get(i).getY() > this.getY()) {
                    if (Resource.brickwallCoordinate.get(i).getY() <= this.getY() + 20 & Resource.brickwallCoordinate.get(i).getY() + 20 > this.getY() + 20) {
                        flag = false;
                        Resource.freezeballs.remove(this);
                    }
                }
            }
        }else if(yVel < 0){
            for (int i = 0; i < Resource.brickwallCoordinate.size(); i++) {
                if(Resource.brickwallCoordinate.get(i).getX() == this.getX() && Resource.brickwallCoordinate.get(i).getY() < this.getY()) {
                    if (Resource.brickwallCoordinate.get(i).getY() <= this.getY() & Resource.brickwallCoordinate.get(i).getY() + 20 > this.getY()) {
                        flag = false;
                        Resource.freezeballs.remove(this);
                    }
                }
            }
        }
    }

    /**
     * When freeze ball hits gremlin, gremlin is frozen and unable to move.
     */
    public void freezeGremlins(){
        if(this.xVel > 0){
            for(Coordinate gremlinCoordinate : Resource.gremlins.keySet()){
                for(int i = 0; i < Resource.freezeballs.size(); i++) {
                    if((Resource.freezeballs.get(i).getX() + 20 >= Resource.gremlins.get(gremlinCoordinate).getX() &
                            Resource.freezeballs.get(i).getX() + 20 <= Resource.gremlins.get(gremlinCoordinate).getX() + 20 &
                            Resource.freezeballs.get(i).getY() == Resource.gremlins.get(gremlinCoordinate).getY())
                            |
                            (Resource.freezeballs.get(i).getX() + 20 >= Resource.gremlins.get(gremlinCoordinate).getX() &
                                    Resource.freezeballs.get(i).getX() + 20 <= Resource.gremlins.get(gremlinCoordinate).getX() + 20 &
                                    Resource.freezeballs.get(i).getY() < Resource.gremlins.get(gremlinCoordinate).getY() + 20 &
                                    Resource.freezeballs.get(i).getY() > Resource.gremlins.get(gremlinCoordinate).getY())
                            |
                            (Resource.freezeballs.get(i).getX() + 20 >= Resource.gremlins.get(gremlinCoordinate).getX() &
                                    Resource.freezeballs.get(i).getX() + 20 <= Resource.gremlins.get(gremlinCoordinate).getX() + 20 &
                                    Resource.freezeballs.get(i).getY() + 20 > Resource.gremlins.get(gremlinCoordinate).getY() &
                                    Resource.freezeballs.get(i).getY() + 20 < Resource.gremlins.get(gremlinCoordinate).getY() + 20)
                    ){
                        Resource.gremlins.get(gremlinCoordinate).setxVel(0);
                        Resource.gremlins.get(gremlinCoordinate).setyVel(0);
                        Resource.freezeballs.remove(i);
                        break;
                    }
                }
            }
        }else if(this.xVel < 0){
            for(Coordinate gremlinCoordinate : Resource.gremlins.keySet()) {
                for (int i = 0; i < Resource.freezeballs.size(); i++) {
                    if ((Resource.freezeballs.get(i).getX() <= Resource.gremlins.get(gremlinCoordinate).getX() + 20
                            & Resource.freezeballs.get(i).getX() > Resource.gremlins.get(gremlinCoordinate).getX()
                            & Resource.freezeballs.get(i).getY() == Resource.gremlins.get(gremlinCoordinate).getY())
                            |
                            (Resource.freezeballs.get(i).getX() <= Resource.gremlins.get(gremlinCoordinate).getX() + 20
                                    & Resource.freezeballs.get(i).getX() > Resource.gremlins.get(gremlinCoordinate).getX() &
                                    Resource.freezeballs.get(i).getY() < Resource.gremlins.get(gremlinCoordinate).getY() + 20 &
                                    Resource.freezeballs.get(i).getY() > Resource.gremlins.get(gremlinCoordinate).getY())
                            |
                            (Resource.freezeballs.get(i).getX() <= Resource.gremlins.get(gremlinCoordinate).getX() + 20
                                    & Resource.freezeballs.get(i).getX() > Resource.gremlins.get(gremlinCoordinate).getX() &
                                    Resource.freezeballs.get(i).getY() + 20 > Resource.gremlins.get(gremlinCoordinate).getY() &
                                    Resource.freezeballs.get(i).getY() + 20 < Resource.gremlins.get(gremlinCoordinate).getY() + 20)

                    ) {
                        Resource.gremlins.get(gremlinCoordinate).setxVel(0);
                        Resource.gremlins.get(gremlinCoordinate).setyVel(0);
                        Resource.freezeballs.remove(i);
                        break;
                    }
                }
            }
        }else if(this.yVel > 0){
            for(Coordinate gremlinCoordinate : Resource.gremlins.keySet()) {
                for (int i = 0; i < Resource.freezeballs.size(); i++) {
                    if ((Resource.freezeballs.get(i).getX() == Resource.gremlins.get(gremlinCoordinate).getX()
                            & Resource.freezeballs.get(i).getY() + 20 >= Resource.gremlins.get(gremlinCoordinate).getY()
                            & Resource.freezeballs.get(i).getY() + 20 <= Resource.gremlins.get(gremlinCoordinate).getY() + 20)
                            |
                            (Resource.freezeballs.get(i).getY() + 20 >= Resource.gremlins.get(gremlinCoordinate).getY()
                                    & Resource.freezeballs.get(i).getY() + 20 <= Resource.gremlins.get(gremlinCoordinate).getY() + 20
                                    & Resource.freezeballs.get(i).getX() >= Resource.gremlins.get(gremlinCoordinate).getX()
                                    & Resource.freezeballs.get(i).getX() < Resource.gremlins.get(gremlinCoordinate).getX() + 20)
                            |
                            (Resource.freezeballs.get(i).getY() + 20 >= Resource.gremlins.get(gremlinCoordinate).getY()
                                    & Resource.freezeballs.get(i).getY() + 20 <= Resource.gremlins.get(gremlinCoordinate).getY() + 20
                                    & Resource.freezeballs.get(i).getX() + 20 >= Resource.gremlins.get(gremlinCoordinate).getX()
                                    & Resource.freezeballs.get(i).getX() + 20 < Resource.gremlins.get(gremlinCoordinate).getX() + 20)

                    ) {
                        Resource.gremlins.get(gremlinCoordinate).setxVel(0);
                        Resource.gremlins.get(gremlinCoordinate).setyVel(0);
                        Resource.freezeballs.remove(i);
                        break;
                    }
                }
            }
        }else if(this.yVel < 0){
            for(Coordinate gremlinCoordinate : Resource.gremlins.keySet()) {
                for (int i = 0; i < Resource.freezeballs.size(); i++) {
                    if ((Resource.freezeballs.get(i).getX() == Resource.gremlins.get(gremlinCoordinate).getX()
                            & Resource.freezeballs.get(i).getY() <= Resource.gremlins.get(gremlinCoordinate).getY() + 20
                            & Resource.freezeballs.get(i).getY() >= Resource.gremlins.get(gremlinCoordinate).getY())
                            |
                            (Resource.freezeballs.get(i).getY() <= Resource.gremlins.get(gremlinCoordinate).getY() + 20
                                    & Resource.freezeballs.get(i).getY() >= Resource.gremlins.get(gremlinCoordinate).getY()
                                    & Resource.freezeballs.get(i).getX() >= Resource.gremlins.get(gremlinCoordinate).getX()
                                    & Resource.freezeballs.get(i).getX() < Resource.gremlins.get(gremlinCoordinate).getX() + 20)
                            |
                            (Resource.freezeballs.get(i).getY() <= Resource.gremlins.get(gremlinCoordinate).getY() + 20
                                    & Resource.freezeballs.get(i).getY() >= Resource.gremlins.get(gremlinCoordinate).getY()
                                    & Resource.freezeballs.get(i).getX() + 20 >= Resource.gremlins.get(gremlinCoordinate).getX()
                                    & Resource.freezeballs.get(i).getX() + 20 < Resource.gremlins.get(gremlinCoordinate).getX() + 20)
                    ){
                        Resource.gremlins.get(gremlinCoordinate).setxVel(0);
                        Resource.gremlins.get(gremlinCoordinate).setyVel(0);
                        Resource.freezeballs.remove(i);
                        break;
                    }
                }
            }
        }
    }

    /**
     * Draw the freeze ball object.
     * @param app PApplet Object
     */
    public void draw(PApplet app) {
        app.image(this.freezeImage, this.x, this.y);
        this.collisionBrickWall();
        this.collisionStoneWall();
        this.freezeGremlins();
        if (flag) {
            x += xVel;
            y += yVel;
        }
    }
}
