package gremlins.roles;

import gremlins.Resource;
import processing.core.PApplet;
import processing.core.PImage;

import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static processing.core.PApplet.dist;
import static processing.core.PApplet.pow;
/**
 * @author Guohao Tong
 * @Assignment01
 */

/**
 * The gremlin class.
 * Controls the gremlin's behavior
 */
public class Gremlins extends Role {
//
//    private int x;
//    private int y;
//    private int xVel;
//    private int yVel;
    private PImage gremlinsImage;
    private boolean initialFlag = true;
    private int SPEED = 1;

    /**
     *
     * @param x The x position on the map.
     * @param y The y position on the map.
     * @param gremlinsImage The initial image of gremlin.
     */
    public Gremlins(int x, int y , PImage gremlinsImage){
        super(x, y, gremlinsImage);
//        this.x = x;
//        this.y = y;
//        this.gremlinsImage = gremlinsImage;
    }

    /**
     * When the level starts, the gremlins pick a random starting direction
     *
     * When a gremlin hits a wall, they should:
     *      turn left if they can't turn right
     *      turn right if they can't turn left
     *      turn around if they can't turn left or right
     *      randomly choose left or right if they can turn in either direction
     *
     * @return true or false
     * If it returns true, gremlin has moved in a legal direction at random.
     * The initialMove() method is no longer called by judgment in Gremlin.draw().
     */
    public boolean initialMove(){
        Random random = new Random();
        int number = random.nextInt(4);
        if (number == 0) {
            if(collisionUp()) {
                this.xVel = 0;
                this.yVel = - SPEED;
                return true;
            }else
                return false;

        } else if (number == 1) {//Down
            if(collisionDown()){
                this.xVel = 0;
                this.yVel = SPEED;
                return true;
            }else
                return false;

        } else if (number == 2) {//Right
            if(collisionRight()){
                this.yVel = 0;
                this.xVel = SPEED;
                return true;
            }else
                return false;

        } else if (number == 3){//Left
            if(collisionLeft()){
                this.yVel = 0;
                this.xVel = -SPEED;
                return true;
            }else
                return false;
        }else
            return false;
    }

    /**
     * Determine if gremlin's move to the right will touch the wall.
     * @return Return false if there is a collision;
     */
    public boolean collisionRight(){
        boolean tempFlag = true;
        for (int i = 0; i < Resource.stonewallCoordinate.size(); i++) {
            if (Resource.stonewallCoordinate.get(i).getX() == this.getX() + 20 & Resource.stonewallCoordinate.get(i).getY() == this.getY()) {
                //return false;
                tempFlag = false;
            }
        }
        for (int i = 0; i < Resource.brickwallCoordinate.size(); i++) {
            if (Resource.brickwallCoordinate.get(i).getX() == this.getX() + 20 & Resource.brickwallCoordinate.get(i).getY() == this.getY()) {
                //return false;
                tempFlag = false;
            }
        }

        if(tempFlag == false){
            return false;
        }else
            return true;
    }

    /**
     * Determine if gremlin's move to the left will touch the wall.
     * @return Return false if there is a collision;
     */
    public boolean collisionLeft(){
        boolean tempFlag = true;
        for(int i = 0 ; i < Resource.stonewallCoordinate.size(); i++){
            if(Resource.stonewallCoordinate.get(i).getX() == this.getX() - 20 & Resource.stonewallCoordinate.get(i).getY() == this.getY()){
                tempFlag = false;
            }
        }

        for(int i = 0 ; i < Resource.brickwallCoordinate.size(); i++){
            if(Resource.brickwallCoordinate.get(i).getX() == this.getX() - 20 & Resource.brickwallCoordinate.get(i).getY() == this.getY()){
                tempFlag = false;
            }
        }
        if(tempFlag == false){
            return false;
        }else
            return true;
    }

    /**
     * Determine if gremlin's move to the up will touch the wall.
     * @return Return false if there is a collision;
     */
    public boolean collisionUp(){
        boolean tempFlag = true;
        for (int i = 0; i < Resource.stonewallCoordinate.size(); i++) {
            if (Resource.stonewallCoordinate.get(i).getX() == this.getX() & Resource.stonewallCoordinate.get(i).getY() == this.getY() - 20) {
                tempFlag = false;
            }
        }
        for (int i = 0; i < Resource.brickwallCoordinate.size(); i++) {
            if (Resource.brickwallCoordinate.get(i).getX() == this.getX() & Resource.brickwallCoordinate.get(i).getY() == this.getY() - 20) {
                tempFlag = false;
            }
        }
        if(tempFlag == false){
            return false;
        }else
            return true;
    }

    /**
     * Determine if gremlin's move to the down will touch the wall.
     * @return Return false if there is a collision;
     */
    public boolean collisionDown(){
        boolean tempFlag = true;
        for (int i = 0; i < Resource.stonewallCoordinate.size(); i++) {
            if (Resource.stonewallCoordinate.get(i).getX() == this.getX() & Resource.stonewallCoordinate.get(i).getY() == this.getY() + 20) {
                tempFlag = false;
            }
        }

        for (int i = 0; i < Resource.brickwallCoordinate.size(); i++) {
            if (Resource.brickwallCoordinate.get(i).getX() == this.getX() & Resource.brickwallCoordinate.get(i).getY() == this.getY() + 20) {
                tempFlag = false;
            }
        }
        if(tempFlag == false){
            return false;
        }else
            return true;
    }


    /**
     *When gremlin is hit by a fireball, it will respawn from a legal area 10 tiles radius away from the player.
     */
    public void gremlinRespawn(){
        List<Integer> respawnIndex = new ArrayList<>();
        for(int i = 0; i < Resource.noneWallCoordinate.size(); i++){
            if(dist(Resource.noneWallCoordinate.get(i).getX(), Resource.noneWallCoordinate.get(i).getY(), Resource.wizard.getX(), Resource.wizard.getY()) > 10 * 20){
                respawnIndex.add(i);
            }
        }
        Random random = new Random();
        int temp = random.nextInt(respawnIndex.size());
        initialMove();
        this.setX(Resource.noneWallCoordinate.get(temp).getX());
        this.setY(Resource.noneWallCoordinate.get(temp).getY());


    }

    /**
     * Draw the gremlin object.
     * @param App PApplet Object.
     */
    public void draw(PApplet App){
        App.image(this.roleImage, this.x, this.y);
        if(initialFlag){
            while(initialMove() && initialFlag){
                initialFlag = false;
            }
        }
        if(xVel > 0){
            if(collisionRight() == false){
                if(collisionUp() & collisionDown()){
                    Random random = new Random();
                    int number = random.nextInt(2);
                    if(number == 0){//Up
                        this.xVel = 0;
                        this.yVel = - SPEED;
                    }else {//down
                        this.xVel = 0;
                        this.yVel = SPEED;
                    }
                }else if(collisionUp() & collisionDown() == false){
                    this.xVel = 0;
                    this.yVel = - SPEED;
                }else if(collisionUp() == false & collisionDown()){
                    this.xVel = 0;
                    this.yVel = SPEED;
                }else if(collisionUp() == false & collisionDown() == false){
                    this.xVel = - SPEED;
                    this.yVel = 0;
                }
            }else{
                yVel = 0;
                x += xVel;
            }
        }else if(xVel < 0){
            if(collisionLeft() == false){
                if(collisionUp() & collisionDown()){
                    Random random = new Random();
                    int number = random.nextInt(2);
                    if(number == 0){//Up
                        this.xVel = 0;
                        this.yVel = - SPEED;
                    }else {//down
                        this.xVel = 0;
                        this.yVel = SPEED;
                    }
                }else if(collisionUp() & collisionDown() == false){
                    this.xVel = 0;
                    this.yVel = - SPEED;
                }else if(collisionUp() == false & collisionDown()){
                    this.xVel = 0;
                    this.yVel = SPEED;
                }else if(collisionUp() == false & collisionDown() == false){
                    this.xVel = SPEED;
                    this.yVel = 0;
                }
            }else{
                yVel = 0;
                x += xVel;
            }
        }else if(yVel > 0){
            if(collisionDown() == false){
                if(collisionRight() & collisionLeft()){
                    Random random = new Random();
                    int number = random.nextInt(2);
                    if(number == 0){//left
                        this.yVel = 0;
                        this.xVel = - SPEED;
                    }else {//right
                        this.yVel = 0;
                        this.xVel = SPEED;
                    }
                }else if(collisionRight() & collisionLeft() == false){
                    this.xVel = SPEED;
                    this.yVel = 0;
                }else if(collisionRight() == false & collisionLeft()){
                    this.xVel = - SPEED;
                    this.yVel = 0;
                }else if(collisionRight() == false & collisionLeft() == false){
                    this.xVel = 0;
                    this.yVel = - SPEED;
                }
            }else{
                xVel = 0;
                y += yVel;
            }
        }else if(yVel < 0){
            if(collisionUp() == false){
                if(collisionRight() & collisionLeft()){
                    Random random = new Random();
                    int number = random.nextInt(2);
                    if(number == 0){//left
                        this.yVel = 0;
                        this.xVel = - SPEED;
                    }else {//right
                        this.xVel = 0;
                        this.yVel = SPEED;
                    }
                }else if(collisionRight() & collisionLeft() == false){
                    this.xVel = SPEED;
                    this.yVel = 0;
                }else if(collisionRight() == false & collisionLeft()){
                    this.xVel = - SPEED;
                    this.yVel = 0;
                }else if(collisionRight() == false & collisionLeft() == false){
                    this.yVel = SPEED;
                    this.xVel = 0;
                }
            }else{
                xVel = 0;
                y += yVel;
            }
        }

    }

//    public int getX() {
//        return x;
//    }
//
//    public int getY() {
//        return y;
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
//    public int getxVel() {
//        return xVel;
//    }
//
//    public int getyVel() {
//        return yVel;
//    }
//
//    public int getSPEED() {
//        return SPEED;
//    }
//
//    public void setSPEED(int SPEED) {
//        this.SPEED = SPEED;
//    }
//
//    public void setxVel(int xVel) {
//        this.xVel = xVel;
//    }
//
//    public void setyVel(int yVel) {
//        this.yVel = yVel;
//    }
}
