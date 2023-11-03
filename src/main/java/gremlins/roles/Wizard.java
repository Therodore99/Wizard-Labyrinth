package gremlins.roles;

import gremlins.Coordinate;
import gremlins.Resource;
import processing.core.PApplet;
import processing.core.PImage;

import java.util.Random;
/**
 * @author Guohao Tong
 * @Assignment01
 */

/**
 * The wizard class.
 * Controls the wizard's behavior
 */
public class Wizard extends Role {
//    private int x;
//    private int y;
//    private int xVel;
//    private int yVel;
    private int speed = 2;
    // The initial image of wizard.
    //public static PImage wizardImage;
    private static PImage wizardLeft;
    private static PImage wizardRight;
    private static PImage wizardUp;
    private static PImage wizardDown;
    private boolean withPowerUp = false;
    public boolean lostPowerUp = false;


    /**
     * Create a wizard object, there is only one wizard object on the map.
     *
     * @param x The x position on the map.
     * @param y The x position on the map.
     * @param wizardImage The initial image of wizard.
     * @param wizardLeft Image as the wizard moves left.
     * @param wizardRight Image as the wizard moves right.
     * @param wizardUp Image as the wizard moves up.
     * @param wizardDown Image as the wizard moves down.
     */
    public Wizard(int x, int y, PImage wizardImage, PImage wizardLeft, PImage wizardRight,PImage wizardUp, PImage wizardDown){
        super(x, y, wizardRight);
        //this.x = x;
        //this.y = y;
        //this.wizardImage = wizardRight;
        this.wizardLeft = wizardLeft;
        this.wizardRight = wizardRight;
        this.wizardUp = wizardUp;
        this.wizardDown = wizardDown;
    }

//    public int getX() {
//        return this.x;
//    }
//
//    public int getY() {
//        return this.y;
//    }
//    public static PImage getWizardImage() {
//        return wizardImage;
//    }
    public static PImage getWizardLeft() {
        return wizardLeft;
    }
    public static PImage getWizardRight() {
        return wizardRight;
    }
    public static PImage getWizardUp() {
        return wizardUp;
    }
    public static PImage getWizardDown() {
        return wizardDown;
    }

//    public void setxVel(int xVel) {
//        this.xVel = xVel;
//    }
//
//    public void setyVel(int yVel) {
//        this.yVel = yVel;
//    }

    /**
     * Change the Wizard image according to the user clicking up, down, or left of the keyboard;
     * @param KeyCode The value of pressed key.
     */
    public void changeWizardDirection(int KeyCode) {
        //Up
        if (KeyCode == 38) {
            this.roleImage = wizardUp;
            //Down
        } else if (KeyCode == 40) {
            this.roleImage = wizardDown;
            //Right
        } else if (KeyCode == 39) {
            this.roleImage = wizardRight;
            //Left
        } else if (KeyCode == 37){
            this.roleImage = wizardLeft;
        }
    }
    /**
     * Control Wizard movement.Assign the speed to wizard in the x or y direction.
     * @param KeyCode The value of pressed key.
     */
    public void moveWizard(int KeyCode){
        if (KeyCode == 38) {
            //this.y -= this.yVel;
            this.xVel = 0;
            this.yVel = - speed;
            //Down
        } else if (KeyCode == 40) {
            //this.y += this.yVel;
            this.xVel = 0;
            this.yVel = speed;
            //Right
        } else if (KeyCode == 39) {
            //this.x += this.xVel;
            this.yVel = 0;
            this.xVel = speed;
            //Left
        } else if (KeyCode == 37){
            //this.x -= this.xVel;
            this.yVel = 0;
            this.xVel = -speed;
        }
    }
    private boolean ifMove = false;

    /**
     * When the user releases the Direction keys, call stopMove() to make the wizard start moving like the center of the tile.
     */
    public void stopMove(){
        ifMove = true;
    }

    /**
     * Check to see if any stonewall or brickwall is next to the Wizard move. If so, the moveWizard() function is not called.
     * @return true or false
     */
    public boolean wizardStatus(){
        if(this.xVel > 0){
            for (int i = 0; i < Resource.stonewallCoordinate.size(); i++) {
                if (Resource.stonewallCoordinate.get(i).getX() == this.getX() + 20 & Resource.stonewallCoordinate.get(i).getY() == this.getY()) {
                    return false;
                }
            }
            for (int i = 0; i < Resource.brickwallCoordinate.size(); i++) {
                if (Resource.brickwallCoordinate.get(i).getX() == this.getX() + 20 & Resource.brickwallCoordinate.get(i).getY() == this.getY()) {
                    return false;
                }
            }
        }else if(xVel < 0){
            for(int i = 0 ; i < Resource.stonewallCoordinate.size(); i++){
                if(Resource.stonewallCoordinate.get(i).getX() == this.getX() - 20 & Resource.stonewallCoordinate.get(i).getY() == this.getY()){
                    return false;
                }
            }

            for(int i = 0 ; i < Resource.brickwallCoordinate.size(); i++){
                if(Resource.brickwallCoordinate.get(i).getX() == this.getX() - 20 & Resource.brickwallCoordinate.get(i).getY() == this.getY()){
                    return false;
                }
            }

        }else if(yVel > 0){
            for (int i = 0; i < Resource.stonewallCoordinate.size(); i++) {
                if (Resource.stonewallCoordinate.get(i).getX() == this.getX() & Resource.stonewallCoordinate.get(i).getY() == this.getY() + 20) {
                    return false;
                }
            }

            for (int i = 0; i < Resource.brickwallCoordinate.size(); i++) {
                if (Resource.brickwallCoordinate.get(i).getX() == this.getX() & Resource.brickwallCoordinate.get(i).getY() == this.getY() + 20) {
                    return false;
                }
            }
        }else if(yVel < 0){
            for (int i = 0; i < Resource.stonewallCoordinate.size(); i++) {
                if (Resource.stonewallCoordinate.get(i).getX() == this.getX() & Resource.stonewallCoordinate.get(i).getY() == this.getY() - 20) {
                    return false;
                }
            }
            for (int i = 0; i < Resource.brickwallCoordinate.size(); i++) {
                if (Resource.brickwallCoordinate.get(i).getX() == this.getX() & Resource.brickwallCoordinate.get(i).getY() == this.getY() - 20) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Check if the wizard touches gremlin. If it does, it decreases lives by one and restarts the current level.
     */
    public void collisionGremlin(){
        if(this.xVel >= 0){
            for(Coordinate gremlinCoordinate : Resource.gremlins.keySet()){
                if((Resource.wizard.getX() + 20 >= Resource.gremlins.get(gremlinCoordinate).getX() &
                        Resource.wizard.getX() + 20 <= Resource.gremlins.get(gremlinCoordinate).getX() + 20 &
                        Resource.wizard.getY() == Resource.gremlins.get(gremlinCoordinate).getY())
                        |
                        (Resource.wizard.getX() + 20 >= Resource.gremlins.get(gremlinCoordinate).getX() &
                                Resource.wizard.getX() + 20 <= Resource.gremlins.get(gremlinCoordinate).getX() + 20 &
                                Resource.wizard.getY() < Resource.gremlins.get(gremlinCoordinate).getY() + 20 &
                                Resource.wizard.getY() > Resource.gremlins.get(gremlinCoordinate).getY())
                        |
                        (Resource.wizard.getX() + 20 >= Resource.gremlins.get(gremlinCoordinate).getX() &
                                Resource.wizard.getX() + 20 <= Resource.gremlins.get(gremlinCoordinate).getX() + 20 &
                                Resource.wizard.getY() + 20 > Resource.gremlins.get(gremlinCoordinate).getY() &
                                Resource.wizard.getY() + 20 < Resource.gremlins.get(gremlinCoordinate).getY() + 20)
                ){
                    Resource.lives--;
                    Resource.mapLayoutUpdate();
                    break;
                }
            }

        }else if(this.xVel < 0){
            for(Coordinate gremlinCoordinate : Resource.gremlins.keySet()) {
                if ((Resource.wizard.getX() <= Resource.gremlins.get(gremlinCoordinate).getX() + 20
                        & Resource.wizard.getX() > Resource.gremlins.get(gremlinCoordinate).getX()
                        & Resource.wizard.getY() == Resource.gremlins.get(gremlinCoordinate).getY())
                        |
                        (Resource.wizard.getX() <= Resource.gremlins.get(gremlinCoordinate).getX() + 20
                                & Resource.wizard.getX() > Resource.gremlins.get(gremlinCoordinate).getX() &
                                Resource.wizard.getY() < Resource.gremlins.get(gremlinCoordinate).getY() + 20 &
                                Resource.wizard.getY() > Resource.gremlins.get(gremlinCoordinate).getY())
                        |
                        (Resource.wizard.getX() <= Resource.gremlins.get(gremlinCoordinate).getX() + 20
                                & Resource.wizard.getX() > Resource.gremlins.get(gremlinCoordinate).getX() &
                                Resource.wizard.getY() + 20 > Resource.gremlins.get(gremlinCoordinate).getY() &
                                Resource.wizard.getY() + 20 < Resource.gremlins.get(gremlinCoordinate).getY() + 20)

                ) {
                    Resource.lives--;
                    Resource.mapLayoutUpdate();
                    break;
                }
            }
        }else if(this.yVel > 0){
            for(Coordinate gremlinCoordinate : Resource.gremlins.keySet()) {
                if ((Resource.wizard.getX() == Resource.gremlins.get(gremlinCoordinate).getX()
                        & Resource.wizard.getY() + 20 >= Resource.gremlins.get(gremlinCoordinate).getY()
                        & Resource.wizard.getY() + 20 <= Resource.gremlins.get(gremlinCoordinate).getY() + 20)
                        |
                        (Resource.wizard.getY() + 20 >= Resource.gremlins.get(gremlinCoordinate).getY()
                                & Resource.wizard.getY() + 20 <= Resource.gremlins.get(gremlinCoordinate).getY() + 20
                                & Resource.wizard.getX() >= Resource.gremlins.get(gremlinCoordinate).getX()
                                & Resource.wizard.getX() < Resource.gremlins.get(gremlinCoordinate).getX() + 20)
                        |
                        (Resource.wizard.getY() + 20 >= Resource.gremlins.get(gremlinCoordinate).getY()
                                & Resource.wizard.getY() + 20 <= Resource.gremlins.get(gremlinCoordinate).getY() + 20
                                & Resource.wizard.getX() + 20 >= Resource.gremlins.get(gremlinCoordinate).getX()
                                & Resource.wizard.getX() + 20 < Resource.gremlins.get(gremlinCoordinate).getX() + 20)

                ) {
                    Resource.lives--;
                    Resource.mapLayoutUpdate();
                    break;
                }
            }
        }else if(this.yVel < 0){
            for(Coordinate gremlinCoordinate : Resource.gremlins.keySet()) {
                if ((Resource.wizard.getX() == Resource.gremlins.get(gremlinCoordinate).getX()
                        & Resource.wizard.getY() <= Resource.gremlins.get(gremlinCoordinate).getY() + 20
                        & Resource.wizard.getY() >= Resource.gremlins.get(gremlinCoordinate).getY())
                        |
                        (Resource.wizard.getY() <= Resource.gremlins.get(gremlinCoordinate).getY() + 20
                                & Resource.wizard.getY() >= Resource.gremlins.get(gremlinCoordinate).getY()
                                & Resource.wizard.getX() >= Resource.gremlins.get(gremlinCoordinate).getX()
                                & Resource.wizard.getX() < Resource.gremlins.get(gremlinCoordinate).getX() + 20)
                        |
                        (Resource.wizard.getY() <= Resource.gremlins.get(gremlinCoordinate).getY() + 20
                                & Resource.wizard.getY() >= Resource.gremlins.get(gremlinCoordinate).getY()
                                & Resource.wizard.getX() + 20 >= Resource.gremlins.get(gremlinCoordinate).getX()
                                & Resource.wizard.getX() + 20 < Resource.gremlins.get(gremlinCoordinate).getX() + 20)
                ){
                    Resource.lives--;
                    Resource.mapLayoutUpdate();
                    break;
                }
            }
        }
    }

    /**
     * Check to see if the wizard touches slime, if it does, it decreases health by one and restarts the current level.
     */
    public void collisionSlime(){
        if(this.xVel >= 0){
            for(int i = 0; i < Resource.gremlinSlime.size(); i++) {
                if((Resource.gremlinSlime.get(i).getX() + 20 >= Resource.wizard.getX() &
                        Resource.gremlinSlime.get(i).getX() + 20 <= Resource.wizard.getX() + 20 &
                        Resource.gremlinSlime.get(i).getY() == Resource.wizard.getY())
                        |
                        (Resource.gremlinSlime.get(i).getX() + 20 >= Resource.wizard.getX() &
                                Resource.gremlinSlime.get(i).getX() + 20 <= Resource.wizard.getX() + 20 &
                                Resource.gremlinSlime.get(i).getY() < Resource.wizard.getY() + 20 &
                                Resource.gremlinSlime.get(i).getY() > Resource.wizard.getY())
                        |
                        (Resource.gremlinSlime.get(i).getX() + 20 >= Resource.wizard.getX() &
                                Resource.gremlinSlime.get(i).getX() + 20 <= Resource.wizard.getX() + 20 &
                                Resource.gremlinSlime.get(i).getY() + 20 > Resource.wizard.getY() &
                                Resource.gremlinSlime.get(i).getY() + 20 < Resource.wizard.getY() + 20)
                ){
                    Resource.lives--;
                    Resource.mapLayoutUpdate();
                    break;
                }
            }
        }else if(this.xVel < 0){
            for (int i = 0; i < Resource.gremlinSlime.size(); i++) {
                if ((Resource.gremlinSlime.get(i).getX() <= Resource.wizard.getX() + 20
                        & Resource.gremlinSlime.get(i).getX() > Resource.wizard.getX()
                        & Resource.gremlinSlime.get(i).getY() == Resource.wizard.getY())
                        |
                        (Resource.gremlinSlime.get(i).getX() <= Resource.wizard.getX() + 20
                                & Resource.gremlinSlime.get(i).getX() > Resource.wizard.getX() &
                                Resource.gremlinSlime.get(i).getY() < Resource.wizard.getY() + 20 &
                                Resource.gremlinSlime.get(i).getY() > Resource.wizard.getY())
                        |
                        (Resource.gremlinSlime.get(i).getX() <= Resource.wizard.getX() + 20
                                & Resource.gremlinSlime.get(i).getX() > Resource.wizard.getX() &
                                Resource.gremlinSlime.get(i).getY() + 20 > Resource.wizard.getY() &
                                Resource.gremlinSlime.get(i).getY() + 20 < Resource.wizard.getY() + 20)

                ) {
                    Resource.lives--;
                    Resource.mapLayoutUpdate();
                    break;
                }

            }
        }else if(this.yVel > 0){
            for (int i = 0; i < Resource.gremlinSlime.size(); i++) {
                if ((Resource.gremlinSlime.get(i).getX() == Resource.wizard.getX()
                        & Resource.gremlinSlime.get(i).getY() + 20 >= Resource.wizard.getY()
                        & Resource.gremlinSlime.get(i).getY() + 20 <= Resource.wizard.getY() + 20)
                        |
                        (Resource.gremlinSlime.get(i).getY() + 20 >= Resource.wizard.getY()
                                & Resource.gremlinSlime.get(i).getY() + 20 <= Resource.wizard.getY() + 20
                                & Resource.gremlinSlime.get(i).getX() >= Resource.wizard.getX()
                                & Resource.gremlinSlime.get(i).getX() < Resource.wizard.getX() + 20)
                        |
                        (Resource.gremlinSlime.get(i).getY() + 20 >= Resource.wizard.getY()
                                & Resource.gremlinSlime.get(i).getY() + 20 <= Resource.wizard.getY() + 20
                                & Resource.gremlinSlime.get(i).getX() + 20 >= Resource.wizard.getX()
                                & Resource.gremlinSlime.get(i).getX() + 20 < Resource.wizard.getX() + 20)

                ) {
                    Resource.lives--;
                    Resource.mapLayoutUpdate();
                    break;
                }
            }
        }else if(this.yVel < 0){
            for (int i = 0; i < Resource.gremlinSlime.size(); i++) {
                if ((Resource.gremlinSlime.get(i).getX() == Resource.wizard.getX()
                        & Resource.gremlinSlime.get(i).getY() <= Resource.wizard.getY() + 20
                        & Resource.gremlinSlime.get(i).getY() >= Resource.wizard.getY())
                        |
                        (Resource.gremlinSlime.get(i).getY() <= Resource.wizard.getY() + 20
                                & Resource.gremlinSlime.get(i).getY() >= Resource.wizard.getY()
                                & Resource.gremlinSlime.get(i).getX() >= Resource.wizard.getX()
                                & Resource.gremlinSlime.get(i).getX() < Resource.wizard.getX() + 20)
                        |
                        (Resource.gremlinSlime.get(i).getY() <= Resource.wizard.getY() + 20
                                & Resource.gremlinSlime.get(i).getY() >= Resource.wizard.getY()
                                & Resource.gremlinSlime.get(i).getX() + 20 >= Resource.wizard.getX()
                                & Resource.gremlinSlime.get(i).getX() + 20 < Resource.wizard.getX() + 20)
                ){
                    Resource.lives--;
                    Resource.mapLayoutUpdate();
                    break;
                }
            }
        }
    }

    /**
     *When wizard touches powerup, wizard gets a speed bonus, and after a certain amount of time, the speedup effect is removed.
     *
     * @return The index of powerup touched by wizard.
     */
    public int getPowerup(){
        if(xVel > 0){
            for(int i = 0; i < Resource.powerup.size(); i++) {
                if (Resource.powerup.get(i).getX() == this.getX() + 20 & Resource.powerup.get(i).getY() == this.getY()) {
                    this.speed = 4;
                    withPowerUp = true;
                    lostPowerUp = true;
                    return i;
                }
            }
        }else if(xVel < 0){
            for(int i = 0; i < Resource.powerup.size(); i++) {
                if (Resource.powerup.get(i).getX() == this.getX() - 20 & Resource.powerup.get(i).getY() == this.getY()) {
                    this.speed = 4;
                    withPowerUp = true;
                    lostPowerUp = true;
                    return i;
                }
            }
        }else if(yVel > 0){
            for(int i = 0; i < Resource.powerup.size(); i++) {
                if (Resource.powerup.get(i).getX() == this.getX() & Resource.powerup.get(i).getY() == this.getY() + 20) {
                    this.speed = 4;
                    withPowerUp = true;
                    lostPowerUp = true;
                    return i;
                }
            }
        }else if(yVel < 0) {
            for (int i = 0; i < Resource.powerup.size(); i++) {
                if (Resource.powerup.get(i).getX() == this.getX() & Resource.powerup.get(i).getY() == this.getY() - 20) {
                    this.speed = 4;
                    withPowerUp = true;
                    lostPowerUp = true;
                    return i;
                }
            }
        }
        return 0;
    }

    /**
     * Remove speedup effect when user loses powerup bonus.
     */
    public void losePowerUp(){
        withPowerUp = false;
        this.speed = 2;
    }

//    public int getxVel() {
//        return xVel;
//    }
//
//    public int getyVel() {
//        return yVel;
//    }
//
//    public void setX(int x) {
//        this.x = x;
//    }
//
//    public void setY(int y) {
//        this.y = y;
//    }
//
//    public int getSpeed() {
//        return speed;
//    }

//    public static void setWizardImage(PImage wizardImage) {
//        Wizard.wizardImage = wizardImage;
//    }

    int temp = 0;

    /**
     * Draw the wizard object.
     * @param App PApplet Object.
     */
    public void draw(PApplet App){

        App.image(this.roleImage, this.x, this.y);
        collisionGremlin();
        collisionSlime();
        int whichPowerUp = getPowerup();

        if(withPowerUp & Resource.timeValidPowerUp < 600){
            Resource.timeValidPowerUp++;
            App.text("Speed Up : ", 310 , 689);
            App.rect(380, 680, 100,8);
            App.fill(0);
            App.rect(380, 680, (Resource.timeValidPowerUp * 100) / 600, 8);
            App.fill(255);
        }else if(Resource.timeValidPowerUp == 600){
            Resource.timeValidPowerUp = 0;
            losePowerUp();
        }

        if(lostPowerUp){
            Resource.powerup.get(whichPowerUp).RespawnPowerUp();
            lostPowerUp = false;
        }
        //move
        if(wizardStatus()){
            x += xVel;
            y += yVel;
        }
        if(ifMove){
            if(this.x % 20 == 0 && this.y % 20 == 0){
                this.xVel = 0;
                this.yVel = 0;
                ifMove = false;
            }
        }

    }
}
