package gremlins;

import gremlins.roles.Gremlins;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import processing.core.PApplet;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Guohao Tong
 * @Assignment01
 */
public class RolesTest {

    public static App app;

    @BeforeEach
    public void basicTest() {

        // Create an instance of your application
        app = new App();

        app.noLoop();

        PApplet.runSketch(new String[]{"App"}, app);

        app.setup();

        app.delay(3000);

    }
    @Test
    public void gremlinTest() {
        for(Coordinate gremlinCoordinate : Resource.gremlins.keySet()){
            if(Resource.gremlins.get(gremlinCoordinate).getY() == 360 &
                    Resource.gremlins.get(gremlinCoordinate).getX() == 40){
                assertTrue(Resource.gremlins.get(gremlinCoordinate).collisionUp());
                assertTrue(Resource.gremlins.get(gremlinCoordinate).collisionRight());
                Resource.gremlins.get(gremlinCoordinate).gremlinRespawn();
                assertNotEquals(360, Resource.gremlins.get(gremlinCoordinate).getX());
                assertNotEquals(40, Resource.gremlins.get(gremlinCoordinate).getY());
            }else if(Resource.gremlins.get(gremlinCoordinate).getY() == 440 &
                    Resource.gremlins.get(gremlinCoordinate).getX() == 200){
                assertFalse(Resource.gremlins.get(gremlinCoordinate).collisionDown());
                assertTrue(Resource.gremlins.get(gremlinCoordinate).collisionUp());
                assertTrue(Resource.gremlins.get(gremlinCoordinate).collisionRight());
                Resource.gremlins.get(gremlinCoordinate).gremlinRespawn();
                assertNotEquals(440, Resource.gremlins.get(gremlinCoordinate).getX());
                assertNotEquals(200, Resource.gremlins.get(gremlinCoordinate).getY());
            }
        }
    }
}