package gremlins.spriteWeapon;

import gremlins.App;
import gremlins.Coordinate;
import gremlins.Resource;
import gremlins.roles.Wizard;
import gremlins.tiles.BrickWalls;
import processing.core.PApplet;
import processing.core.PImage;
/**
 * @author Guohao Tong
 * @Assignment01
 */

/**
 * Fireball class, extends the Weapon class.
 */
public class Fireball extends Weapon implements WeaponInterface{

    private int speed = 4 ;
    private PImage fireballImage;

    int temp = -1;

    /**
     * Create a fireball when the user presses the space key.
     * @param x The same as the current wizard's x location.
     * @param y The same as the current wizard's y location.
     * @param fireballImage The image of the fireball.
     */
    public Fireball(int x, int y, PImage fireballImage){
        super(x,y);
        this.fireballImage = fireballImage;
        this.speed = 4;
    }
    boolean flag;

    /**
     * When the user presses the Space keyboard, fireball moves in the direction the current wizard.
     * @param wizardImage The current image of wizard.
     */
    public void moveFireball(PImage wizardImage){
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
            this.yVel = 0;
            this.xVel = speed;
            //Left
        } else if (wizardImage == Wizard.getWizardLeft()){
            this.yVel = 0;
            this.xVel = -speed;
        }
    }

    /**
     * Determine if the fireball is colliding with the stone wall. If so, remove the current freeze ball.
     */
    public void collisionStoneWall(){

        if(xVel > 0) {
            for (int i = 0; i < Resource.stonewallCoordinate.size(); i++) {
                if(Resource.stonewallCoordinate.get(i).getX() > this.getX() && Resource.stonewallCoordinate.get(i).getY() == this.getY()) {
                    if (Resource.stonewallCoordinate.get(i).getX() <= this.getX() + 20 & Resource.stonewallCoordinate.get(i).getX() + 20 > this.getX() + 20) {
                        flag = false;
                        Resource.fireBalls.remove(this);
                    }
                }
            }
        }else if(xVel < 0){
            for (int i = 0; i < Resource.stonewallCoordinate.size(); i++) {
                if (Resource.stonewallCoordinate.get(i).getX() < this.getX() && Resource.stonewallCoordinate.get(i).getY() == this.getY()) {
                    if (Resource.stonewallCoordinate.get(i).getX() <= this.getX() & Resource.stonewallCoordinate.get(i).getX() + 20 > this.getX()) {
                        flag = false;
                        Resource.fireBalls.remove(this);
                    }
                }
            }
        }else if(yVel > 0){
            for (int i = 0; i < Resource.stonewallCoordinate.size(); i++) {
                if (Resource.stonewallCoordinate.get(i).getX() == this.getX() && Resource.stonewallCoordinate.get(i).getY() > this.getY()) {
                    if (Resource.stonewallCoordinate.get(i).getY() <= this.getY() + 20 & Resource.stonewallCoordinate.get(i).getY() + 20 > this.getY() + 20) {
                        flag = false;
                        Resource.fireBalls.remove(this);
                    }
                }
            }
        }else if(yVel < 0){
            for (int i = 0; i < Resource.stonewallCoordinate.size(); i++) {
                if (Resource.stonewallCoordinate.get(i).getX() == this.getX() && Resource.stonewallCoordinate.get(i).getY() < this.getY()) {
                    if (Resource.stonewallCoordinate.get(i).getY() <= this.getY() & Resource.stonewallCoordinate.get(i).getY() + 20 > this.getY()) {
                        flag = false;
                        Resource.fireBalls.remove(this);
                    }
                }
            }
        }
    }
    int brickWallState = 0;

    /**
     * Determine if the fireball is colliding with the stone wall.
     * If so, brick wall is destroyed and show the destruction animation. Remove the fireball.
     */
    public void collisionBrickWall(){
        if(xVel > 0){
            for (int i = 0; i < Resource.brickwallCoordinate.size(); i++) {
                if(Resource.brickwallCoordinate.get(i).getX() > this.getX() && Resource.brickwallCoordinate.get(i).getY() == this.getY()) {
                    if (Resource.brickwallCoordinate.get(i).getX() <= this.getX() + 20 & Resource.brickwallCoordinate.get(i).getX() + 20 > this.getX() + 20){
                        Resource.counterFlag = true;
                        Resource.currentCollisionBrickWall = i;
                        temp = Resource.currentCollisionBrickWall;
                        Resource.currentCollisionBrickWall = -1;
                    }
                }
            }
        }else if(xVel < 0){
            for (int i = 0; i < Resource.brickwallCoordinate.size(); i++) {
                if (Resource.brickwallCoordinate.get(i).getX() < this.getX() && Resource.brickwallCoordinate.get(i).getY() == this.getY()) {
                    if (Resource.brickwallCoordinate.get(i).getX() <= this.getX() & Resource.brickwallCoordinate.get(i).getX() + 20 > this.getX()) {
                        Resource.counterFlag = true;
                        Resource.currentCollisionBrickWall = i;
                        temp = Resource.currentCollisionBrickWall;
                        Resource.currentCollisionBrickWall = -1;
                    }
                }
            }
        }else if(yVel > 0){
            for (int i = 0; i < Resource.brickwallCoordinate.size(); i++) {
                if (Resource.brickwallCoordinate.get(i).getX() == this.getX() && Resource.brickwallCoordinate.get(i).getY() > this.getY()) {
                    if (Resource.brickwallCoordinate.get(i).getY() <= this.getY() + 20 & Resource.brickwallCoordinate.get(i).getY() + 20 > this.getY() + 20) {
                        Resource.counterFlag = true;
                        Resource.currentCollisionBrickWall = i;
                        temp = Resource.currentCollisionBrickWall;
                        Resource.currentCollisionBrickWall = -1;
                    }
                }
            }
        }else if(yVel < 0){
            for (int i = 0; i < Resource.brickwallCoordinate.size(); i++) {
                if(Resource.brickwallCoordinate.get(i).getX() == this.getX() && Resource.brickwallCoordinate.get(i).getY() < this.getY()) {
                    if (Resource.brickwallCoordinate.get(i).getY() <= this.getY() & Resource.brickwallCoordinate.get(i).getY() + 20 > this.getY()) {

                        Resource.counterFlag = true;
                        Resource.currentCollisionBrickWall = i;
                        temp = Resource.currentCollisionBrickWall;
                        Resource.currentCollisionBrickWall = -1;
                    }
                }
            }
        }
    }

    /**
     * Show the destruction animation.
     * @param brickWallImageState The current animation that needs to be displayed.
     * @param i Brick wall coordinates index.
     */
    public void destroyBrickWall(int brickWallImageState, int i){
        if(brickWallImageState == 1){
            Resource.brickwall.get(Resource.brickwallCoordinate.get(i)).setBrickwallCurrentState(BrickWalls.brickwallStateOne);
        }else if(brickWallImageState == 2){
            Resource.brickwall.get(Resource.brickwallCoordinate.get(i)).setBrickwallCurrentState(BrickWalls.brickwallStateTwo);;
        }else if(brickWallImageState == 3){
            Resource.brickwall.get(Resource.brickwallCoordinate.get(i)).setBrickwallCurrentState(BrickWalls.brickwallStateThree);
        } else if(brickWallImageState == 4){
            Resource.brickwall.get(Resource.brickwallCoordinate.get(i)).setBrickwallCurrentState(BrickWalls.brickwallStateFour);
            Resource.brickwall.remove(Resource.brickwallCoordinate.get(i));
            Resource.brickwallCoordinate.remove(i);
        }
    }

    /**
     * The moving direction of the fireball is determined according to the x and y direction velocities of the fireball.
     * When the fireball touches gremlin anywhere, gremlin is destroyed.
     */
    public void destroyGremlins(){
        if(this.xVel > 0){
            for(Coordinate gremlinCoordinate : Resource.gremlins.keySet()){
                for(int i = 0; i < Resource.fireBalls.size(); i++) {
                    if((Resource.fireBalls.get(i).getX() + 20 >= Resource.gremlins.get(gremlinCoordinate).getX() &
                            Resource.fireBalls.get(i).getX() + 20 <= Resource.gremlins.get(gremlinCoordinate).getX() + 20 &
                            Resource.fireBalls.get(i).getY() == Resource.gremlins.get(gremlinCoordinate).getY())
                            |
                            (Resource.fireBalls.get(i).getX() + 20 >= Resource.gremlins.get(gremlinCoordinate).getX() &
                                    Resource.fireBalls.get(i).getX() + 20 <= Resource.gremlins.get(gremlinCoordinate).getX() + 20 &
                                    Resource.fireBalls.get(i).getY() < Resource.gremlins.get(gremlinCoordinate).getY() + 20 &
                                    Resource.fireBalls.get(i).getY() > Resource.gremlins.get(gremlinCoordinate).getY())
                            |
                            (Resource.fireBalls.get(i).getX() + 20 >= Resource.gremlins.get(gremlinCoordinate).getX() &
                                    Resource.fireBalls.get(i).getX() + 20 <= Resource.gremlins.get(gremlinCoordinate).getX() + 20 &
                                    Resource.fireBalls.get(i).getY() + 20 > Resource.gremlins.get(gremlinCoordinate).getY() &
                                    Resource.fireBalls.get(i).getY() + 20 < Resource.gremlins.get(gremlinCoordinate).getY() + 20)
                    ){
                        Resource.gremlins.get(gremlinCoordinate).gremlinRespawn();
                        Resource.fireBalls.remove(i);
                        break;
                    }
                }
            }
        }else if(this.xVel < 0){
            for(Coordinate gremlinCoordinate : Resource.gremlins.keySet()) {
                for (int i = 0; i < Resource.fireBalls.size(); i++) {
                    if ((Resource.fireBalls.get(i).getX() <= Resource.gremlins.get(gremlinCoordinate).getX() + 20
                            & Resource.fireBalls.get(i).getX() > Resource.gremlins.get(gremlinCoordinate).getX()
                            & Resource.fireBalls.get(i).getY() == Resource.gremlins.get(gremlinCoordinate).getY())
                            |
                            (Resource.fireBalls.get(i).getX() <= Resource.gremlins.get(gremlinCoordinate).getX() + 20
                                    & Resource.fireBalls.get(i).getX() > Resource.gremlins.get(gremlinCoordinate).getX() &
                                    Resource.fireBalls.get(i).getY() < Resource.gremlins.get(gremlinCoordinate).getY() + 20 &
                                    Resource.fireBalls.get(i).getY() > Resource.gremlins.get(gremlinCoordinate).getY())
                            |
                            (Resource.fireBalls.get(i).getX() <= Resource.gremlins.get(gremlinCoordinate).getX() + 20
                                    & Resource.fireBalls.get(i).getX() > Resource.gremlins.get(gremlinCoordinate).getX() &
                                    Resource.fireBalls.get(i).getY() + 20 > Resource.gremlins.get(gremlinCoordinate).getY() &
                                    Resource.fireBalls.get(i).getY() + 20 < Resource.gremlins.get(gremlinCoordinate).getY() + 20)

                    ) {
                        Resource.gremlins.get(gremlinCoordinate).gremlinRespawn();
                        Resource.fireBalls.remove(i);
                        break;
                    }
                }
            }
        }else if(this.yVel > 0){
            for(Coordinate gremlinCoordinate : Resource.gremlins.keySet()) {
                for (int i = 0; i < Resource.fireBalls.size(); i++) {
                    if ((Resource.fireBalls.get(i).getX() == Resource.gremlins.get(gremlinCoordinate).getX()
                            & Resource.fireBalls.get(i).getY() + 20 >= Resource.gremlins.get(gremlinCoordinate).getY()
                            & Resource.fireBalls.get(i).getY() + 20 <= Resource.gremlins.get(gremlinCoordinate).getY() + 20)
                            |
                            (Resource.fireBalls.get(i).getY() + 20 >= Resource.gremlins.get(gremlinCoordinate).getY()
                                    & Resource.fireBalls.get(i).getY() + 20 <= Resource.gremlins.get(gremlinCoordinate).getY() + 20
                                    & Resource.fireBalls.get(i).getX() >= Resource.gremlins.get(gremlinCoordinate).getX()
                                    & Resource.fireBalls.get(i).getX() < Resource.gremlins.get(gremlinCoordinate).getX() + 20)
                            |
                            (Resource.fireBalls.get(i).getY() + 20 >= Resource.gremlins.get(gremlinCoordinate).getY()
                                    & Resource.fireBalls.get(i).getY() + 20 <= Resource.gremlins.get(gremlinCoordinate).getY() + 20
                                    & Resource.fireBalls.get(i).getX() + 20 >= Resource.gremlins.get(gremlinCoordinate).getX()
                                    & Resource.fireBalls.get(i).getX() + 20 < Resource.gremlins.get(gremlinCoordinate).getX() + 20)

                    ) {
                        Resource.gremlins.get(gremlinCoordinate).gremlinRespawn();
                        Resource.fireBalls.remove(i);
                        break;
                    }
                }
            }
        }else if(this.yVel < 0){
            for(Coordinate gremlinCoordinate : Resource.gremlins.keySet()) {
                for (int i = 0; i < Resource.fireBalls.size(); i++) {
                    if ((Resource.fireBalls.get(i).getX() == Resource.gremlins.get(gremlinCoordinate).getX()
                            & Resource.fireBalls.get(i).getY() <= Resource.gremlins.get(gremlinCoordinate).getY() + 20
                            & Resource.fireBalls.get(i).getY() >= Resource.gremlins.get(gremlinCoordinate).getY())
                            |
                            (Resource.fireBalls.get(i).getY() <= Resource.gremlins.get(gremlinCoordinate).getY() + 20
                                    & Resource.fireBalls.get(i).getY() >= Resource.gremlins.get(gremlinCoordinate).getY()
                                    & Resource.fireBalls.get(i).getX() >= Resource.gremlins.get(gremlinCoordinate).getX()
                                    & Resource.fireBalls.get(i).getX() < Resource.gremlins.get(gremlinCoordinate).getX() + 20)
                            |
                            (Resource.fireBalls.get(i).getY() <= Resource.gremlins.get(gremlinCoordinate).getY() + 20
                                    & Resource.fireBalls.get(i).getY() >= Resource.gremlins.get(gremlinCoordinate).getY()
                                    & Resource.fireBalls.get(i).getX() + 20 >= Resource.gremlins.get(gremlinCoordinate).getX()
                                    & Resource.fireBalls.get(i).getX() + 20 < Resource.gremlins.get(gremlinCoordinate).getX() + 20)
                    ){
                        Resource.gremlins.get(gremlinCoordinate).gremlinRespawn();
                        Resource.fireBalls.remove(i);
                        break;
                    }
                }
            }
        }
    }

    /**
     * The moving direction of the fireball is determined according to the x and y direction velocities of the fireball.
     * When the fireball touches slime anywhere, slime is destroyed.
     */
    public void collisionSlime(){
        if(this.xVel > 0){
            for(int i = 0; i < Resource.fireBalls.size(); i++) {
                for (int j = 0; j < Resource.gremlinSlime.size(); j++) {
                    if ((Resource.fireBalls.get(i).getX() + 20 >= Resource.gremlinSlime.get(j).getX() &
                            Resource.fireBalls.get(i).getX() + 20 <= Resource.gremlinSlime.get(j).getX() + 20 &
                            Resource.fireBalls.get(i).getY() == Resource.gremlinSlime.get(j).getY())
                            |
                            (Resource.fireBalls.get(i).getX() + 20 >= Resource.gremlinSlime.get(j).getX() &
                                    Resource.fireBalls.get(i).getX() + 20 <= Resource.gremlinSlime.get(j).getX() + 20 &
                                    Resource.fireBalls.get(i).getY() < Resource.gremlinSlime.get(j).getY() + 20 &
                                    Resource.fireBalls.get(i).getY() > Resource.gremlinSlime.get(j).getY())
                            |
                            (Resource.fireBalls.get(i).getX() + 20 >= Resource.gremlinSlime.get(j).getX() &
                                    Resource.fireBalls.get(i).getX() + 20 <= Resource.gremlinSlime.get(j).getX() + 20 &
                                    Resource.fireBalls.get(i).getY() + 20 > Resource.gremlinSlime.get(j).getY() &
                                    Resource.fireBalls.get(i).getY() + 20 < Resource.gremlinSlime.get(j).getY() + 20)
                    ) {
                        Resource.gremlinSlime.remove(j);
                        Resource.fireBalls.remove(i);
                        break;
                    }
                }
            }
        }else if(this.xVel < 0){

            for (int i = 0; i < Resource.fireBalls.size(); i++) {
                for (int j = 0; j < Resource.gremlinSlime.size(); j++) {
                    if ((Resource.fireBalls.get(i).getX() <= Resource.gremlinSlime.get(j).getX() + 20
                            & Resource.fireBalls.get(i).getX() > Resource.gremlinSlime.get(j).getX()
                            & Resource.fireBalls.get(i).getY() == Resource.gremlinSlime.get(j).getY())
                            |
                            (Resource.fireBalls.get(i).getX() <= Resource.gremlinSlime.get(j).getX() + 20
                                    & Resource.fireBalls.get(i).getX() > Resource.gremlinSlime.get(j).getX() &
                                    Resource.fireBalls.get(i).getY() < Resource.gremlinSlime.get(j).getY() + 20 &
                                    Resource.fireBalls.get(i).getY() > Resource.gremlinSlime.get(j).getY())
                            |
                            (Resource.fireBalls.get(i).getX() <= Resource.gremlinSlime.get(j).getX() + 20
                                    & Resource.fireBalls.get(i).getX() > Resource.gremlinSlime.get(j).getX() &
                                    Resource.fireBalls.get(i).getY() + 20 > Resource.gremlinSlime.get(j).getY() &
                                    Resource.fireBalls.get(i).getY() + 20 < Resource.gremlinSlime.get(j).getY() + 20)

                    ) {
                        Resource.gremlinSlime.remove(j);
                        Resource.fireBalls.remove(i);
                        break;
                    }
                }
            }
        }else if(this.yVel > 0){

            for (int i = 0; i < Resource.fireBalls.size(); i++) {
                for (int j = 0; j < Resource.gremlinSlime.size(); j++) {
                    if ((Resource.fireBalls.get(i).getX() == Resource.gremlinSlime.get(j).getX()
                            & Resource.fireBalls.get(i).getY() + 20 >= Resource.gremlinSlime.get(j).getY()
                            & Resource.fireBalls.get(i).getY() + 20 <= Resource.gremlinSlime.get(j).getY() + 20)
                            |
                            (Resource.fireBalls.get(i).getY() + 20 >= Resource.gremlinSlime.get(j).getY()
                                    & Resource.fireBalls.get(i).getY() + 20 <= Resource.gremlinSlime.get(j).getY() + 20
                                    & Resource.fireBalls.get(i).getX() >= Resource.gremlinSlime.get(j).getX()
                                    & Resource.fireBalls.get(i).getX() < Resource.gremlinSlime.get(j).getX() + 20)
                            |
                            (Resource.fireBalls.get(i).getY() + 20 >= Resource.gremlinSlime.get(j).getY()
                                    & Resource.fireBalls.get(i).getY() + 20 <= Resource.gremlinSlime.get(j).getY() + 20
                                    & Resource.fireBalls.get(i).getX() + 20 >= Resource.gremlinSlime.get(j).getX()
                                    & Resource.fireBalls.get(i).getX() + 20 < Resource.gremlinSlime.get(j).getX() + 20)

                    ) {
                        Resource.gremlinSlime.remove(j);
                        Resource.fireBalls.remove(i);
                        break;
                    }
                }
            }
        }else if(this.yVel < 0){
            for (int i = 0; i < Resource.fireBalls.size(); i++) {
                for (int j = 0; j < Resource.gremlinSlime.size(); j++) {
                    if ((Resource.fireBalls.get(i).getX() == Resource.gremlinSlime.get(j).getX()
                            & Resource.fireBalls.get(i).getY() <= Resource.gremlinSlime.get(j).getY() + 20
                            & Resource.fireBalls.get(i).getY() >= Resource.gremlinSlime.get(j).getY())
                            |
                            (Resource.fireBalls.get(i).getY() <= Resource.gremlinSlime.get(j).getY() + 20
                                    & Resource.fireBalls.get(i).getY() >= Resource.gremlinSlime.get(j).getY()
                                    & Resource.fireBalls.get(i).getX() >= Resource.gremlinSlime.get(j).getX()
                                    & Resource.fireBalls.get(i).getX() < Resource.gremlinSlime.get(j).getX() + 20)
                            |
                            (Resource.fireBalls.get(i).getY() <= Resource.gremlinSlime.get(j).getY() + 20
                                    & Resource.fireBalls.get(i).getY() >= Resource.gremlinSlime.get(j).getY()
                                    & Resource.fireBalls.get(i).getX() + 20 >= Resource.gremlinSlime.get(j).getX()
                                    & Resource.fireBalls.get(i).getX() + 20 < Resource.gremlinSlime.get(j).getX() + 20)
                    ){
                        Resource.gremlinSlime.remove(j);
                        Resource.fireBalls.remove(i);
                        break;
                    }
                }
            }
        }
    }


    /**
     * Draw the fire ball object.
     * @param app PApplet Object
     */
    public void draw(PApplet app){
        app.image(this.fireballImage, this.x, this.y);
        this.collisionBrickWall();
        this.collisionStoneWall();
        this.destroyGremlins();
        this.collisionSlime();
        if(flag){
            x += xVel;
            y += yVel;
        }
        while(Resource.counterFlag == true) {
            if (Resource.counter < 4) {
                Resource.brickwall.get(Resource.brickwallCoordinate.get(temp)).setBrickwallCurrentState(BrickWalls.brickwallStateOne);
                Resource.counter++;
            } else if (Resource.counter == 4) {
                destroyBrickWall(2, temp);
                Resource.counter++;
                //Resource.fireBalls.remove(this);
            } else if (Resource.counter == 8) {
                destroyBrickWall(3, temp);
                Resource.counter++;
                //Resource.fireBalls.remove(this);
            } else if (Resource.counter == 12) {
                destroyBrickWall(4, temp);
                Resource.fireBalls.remove(this);
                Resource.counterFlag = false;
                Resource.counter = 0;
            } else {
                Resource.counter++;
            }
        }
    }

}

