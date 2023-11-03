package gremlins.tiles;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Abstract class.
 * Represent the same properties and methods of all tile classes.
 */
public abstract class Tiles {
    //the X coordinate of tiles
    protected int x;
    //the Y coordinate of tiles
    protected int y;

    /**
     * Create a tile.
     * @param x The x position in the map.
     * @param y The y position in the map.
     */
    public Tiles(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract void draw(PApplet App);
}

