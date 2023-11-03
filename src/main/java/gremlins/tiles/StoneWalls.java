package gremlins.tiles;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Stone Walls
 */
public class StoneWalls extends Tiles{

    private PImage stoneWallImage;

    /**
     * Create a stone wall.
     * @param x x position of a stone wall.
     * @param y y position of a stone wall.
     * @param stoneWallImage Image of stone wall.
     */
    public StoneWalls(int x, int y, PImage stoneWallImage) {
        super(x, y);
        this.stoneWallImage = stoneWallImage;
    }

    /**
     * Draw the stone walls in the map.
     * @param App PApplet Object
     */
    @Override
    public void draw(PApplet App) {
        App.image(this.stoneWallImage, this.x, this.y);
    }
}
