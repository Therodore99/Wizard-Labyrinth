package gremlins.tiles;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Exit door.
 */
public class Exit extends gremlins.tiles.Tiles {

    private PImage exitImage;
    /**
     *
     * @param x x position of the exit door.
     * @param y y position of the exit door.
     * @param exitImage Image of exit door.
     */
    public Exit(int x, int y, PImage exitImage) {
        super(x, y);
        this.exitImage = exitImage;
    }

    /**
     * Draw the exit door in the map.
     * @param App PApplet Object
     */
    @Override
    public void draw(PApplet App) {
        this.exitImage.resize(20,20);
        App.image(this.exitImage, this.x, this.y);
    }

}

