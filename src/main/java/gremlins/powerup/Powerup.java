package gremlins.powerup;

import gremlins.Resource;
import processing.core.PApplet;
import processing.core.PImage;

import java.util.Random;

import static processing.core.PApplet.dist;

/**
 * @author Guohao Tong
 * @Assignment01
 */

/**
 * Powerup class
 */
public class Powerup {
    private int x;
    //the Y coordinate of tiles
    private int y;

    private PImage powerImage;

    /**
     * Create the object.
     * @param x The x position on the map.
     * @param y The y position on the map.
     * @param powerImage The image of powerup.
     */
    public Powerup(int x, int y,PImage powerImage) {
        this.x = x;
        this.y = y;
        this.powerImage = powerImage;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * When the user makes contact with powerup,
     * it reappears in any legal location on the map within a certain amount of time.
     */
    public void RespawnPowerUp(){
        Random random = new Random();
        int tempNum = random.nextInt(Resource.noneWallCoordinate.size());
        this.x = Resource.noneWallCoordinate.get(tempNum).getX();
        this.y = Resource.noneWallCoordinate.get(tempNum).getY();
    }

    /**
     * Draw the powerup.
     * @param App PApplet Object.
     */
    public void draw(PApplet App){
        App.image(powerImage, this.x, this.y);
    }
}
