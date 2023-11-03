
package gremlins;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import processing.core.PApplet;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Guohao Tong
 * @Assignment01
 */
public class ResourceTest {

    public static App app;

    @BeforeEach
    public void basicTest() {
        // Create an instance of your application
        app = new App();
        //app.noLoop();
        PApplet.runSketch(new String[]{"App"}, app);
        app.setup();
        app.delay(3000);
    }

    @Test
    public void LevelOneResourceTest() {

        assertEquals(2, Resource.numOfLevel);
        assertEquals(3, Resource.lives);
        assertEquals(0.3333, Resource.wizard_cooldown);
        assertEquals(3.0, Resource.enemy_cooldown);

        assertNotNull(Resource.stonewall);
        assertNotNull(Resource.stonewallCoordinate);
        assertNotNull(Resource.brickwall);
        assertNotNull(Resource.brickwallCoordinate);
        assertNotNull(Resource.gremlinSlime);
        assertNotNull(Resource.fireBalls);
        assertNotNull(Resource.freezeballs);
        assertNotNull(Resource.gremlins);
        assertNotNull(Resource.gremlinsCoordinate);
        assertNotNull(Resource.mapLevelInfo);
        assertNotNull(Resource.wizard);
        assertNotNull(Resource.powerup);
    }
}
