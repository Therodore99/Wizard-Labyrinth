package gremlins;

import javafx.scene.input.KeyCode;
import org.junit.jupiter.api.*;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.event.KeyEvent;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import gremlins.Resource;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static processing.core.PConstants.*;


/**
 * @author Guohao Tong
 * @Assignment01
 */
//@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class AppTest {
    public static App app;

    /**
     * Start the test of the game, sometimes the static resource loading of the game is too slow,
     * which will cause the testcase to fail, and it will run normally after a few more attempts
     */

    @BeforeEach
    public void initialGame() {

        // Create an instance of your application
        app = new App();

        app.noLoop();

        PApplet.runSketch(new String[]{"App"}, app);

        app.setup();

        app.delay(3000);

    }
    @Test
    public void basicTest(){
        assertEquals(720, App.WIDTH);
        assertEquals(720, App.HEIGHT);
        assertEquals(60, App.FPS);
    }

    @Test
    public void keyPressRightTest() {
        Resource.wizard.setX(40);
        Resource.wizard.setY(20);
        Resource.wizard.setRoleImage(Resource.wizardImageTwo);
        app.keyCode = RIGHT;
        app.keyPressed();
        assertTrue(App.pressedRight);
        app.keyReleased(new KeyEvent(app,0,0,0,(char)0,39));

    }

    @Test
    public void keyPressLeftTest() {
        Resource.wizard.setX(40);
        Resource.wizard.setY(20);
        Resource.wizard.setRoleImage(Resource.wizardImageTwo);
        app.keyCode = LEFT;
        app.keyPressed();
        assertTrue(App.pressedLeft);
        app.keyReleased(new KeyEvent(app,0,0,0,(char)0,37));
    }

    @Test
    public void keyPressUpTest() {
        Resource.wizard.setX(40);
        Resource.wizard.setY(20);
        Resource.wizard.setRoleImage(Resource.wizardImageTwo);
        app.keyCode = UP;
        app.keyPressed();
        assertTrue(App.pressedUp);
        assertEquals(0, Resource.wizard.getyVel());
        app.keyReleased(new KeyEvent(app,0,0,0,(char)0,38));
    }

    @Test
    public void keyPressDownTest() {
        Resource.wizard.setX(40);
        Resource.wizard.setY(20);
        Resource.wizard.setRoleImage(Resource.wizardImageTwo);
        app.keyCode = DOWN;
        app.keyPressed();
        assertTrue(App.pressedDown);
        assertEquals(0, Resource.wizard.getyVel());
        app.keyReleased(new KeyEvent(app,0,0,0,(char)0,40));
    }


    @Test
    public void keySpaceFireBallTest() {
        Resource.wizard.setX(40);
        Resource.wizard.setY(20);
        Resource.wizard.setRoleImage(Resource.wizardImageTwo);
        Resource.numFrameBetPressedSpace = 20;
        app.keyCode = 32;
        app.keyPressed();
        assertTrue(App.pressedSpace);
        for(int i = 0; i < Resource.fireBalls.size(); i++){
            if(Resource.fireBalls.get(i).getX() == 100 & Resource.fireBalls.get(i).getY() == 20){
                assertEquals(4, Resource.fireBalls.get(i).getxVel());
                assertEquals(0, Resource.fireBalls.get(i).getyVel());
            }
        }
        app.keyReleased(new KeyEvent(app,0,0,0,(char)32,0));
    }

    @Test
    public void keyTabFreezeBallTest() {

        Resource.wizard.setX(40);
        Resource.wizard.setY(20);
        Resource.wizard.setRoleImage(Resource.wizardImageTwo);
        Resource.numFrameBetPressedSpace = 20;
        app.keyCode = 9;
        app.keyPressed();
        assertTrue(App.pressedKeyTab);
        for(int i = 0; i < Resource.freezeballs.size(); i++){
            if(Resource.freezeballs.get(i).getX() == 100 & Resource.freezeballs.get(i).getY() == 20){
                assertEquals(4, Resource.freezeballs.get(i).getxVel());
                assertEquals(0, Resource.freezeballs.get(i).getyVel());
            }
        }
        app.keyReleased(new KeyEvent(app,0,0,0,(char)9,0));
    }

}

