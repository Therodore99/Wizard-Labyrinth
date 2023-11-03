package gremlins.tiles;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Brick wall.
 */
public class BrickWalls extends gremlins.tiles.Tiles {
    private PImage brickwallCurrentState;
    public static PImage brickwallStateOne;
    public static PImage brickwallStateTwo;
    public static PImage brickwallStateThree;
    public static PImage brickwallStateFour;

    /**
     * Create a brick wall.
     * @param x The x position in the map.
     * @param y The y position in the map.
     * @param brickwallCurrentState Image of brick wall.
     * @param brickwallStateOne The first animation image of brick wall after being hit by a fireball.
     * @param brickwallStateTwo The second animation image of brick wall after being hit by a fireball.
     * @param brickwallStateThree The third animation image of brick wall after being hit by a fireball.
     * @param brickwallStateFour The fourth animation image of brick wall after being hit by a fireball.
     */
    public BrickWalls(int x, int y, PImage brickwallCurrentState, PImage brickwallStateOne, PImage brickwallStateTwo, PImage brickwallStateThree, PImage brickwallStateFour) {
        super(x, y);
        this.brickwallCurrentState = brickwallCurrentState;
        this.brickwallStateOne = brickwallStateOne;
        this.brickwallStateTwo = brickwallStateTwo;
        this.brickwallStateThree = brickwallStateThree;
        this.brickwallStateFour = brickwallStateFour;
    }

    /**
     * Set the brick wall image.
     * @param Image Current brick wall image
     */
    public void setBrickwallCurrentState(PImage Image) {
        this.brickwallCurrentState = Image;
    }

    /**
     * Draw the brick walls in the map.
     * @param App PApplet Object.
     */
    @Override
    public void draw(PApplet App) {
        App.image(this.brickwallCurrentState, this.x, this.y);
    }

}
