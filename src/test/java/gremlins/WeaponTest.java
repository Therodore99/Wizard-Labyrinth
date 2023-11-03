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
import gremlins.spriteWeapon.Fireball;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WeaponTest {

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
    public void fireBallRightTest() {
        Resource.wizard.setRoleImage(Resource.wizardImageTwo);

        app.keyCode = 32;
        app.keyPressed();
        app.keyReleased(new KeyEvent(app,0,0,0,(char)32,0));

    }
    @Test
    public void fireBallLeftTest() {
        Resource.wizard.setRoleImage(Resource.wizardImageOne);
        app.keyCode = 32;
        app.keyPressed();
        app.keyReleased(new KeyEvent(app,0,0,0,(char)32,0));
    }

    @Test
    public void fireBallUpTest() {
        Resource.wizard.setRoleImage(Resource.wizardImageThree);
        app.keyCode = 32;
        app.keyPressed();
        app.keyReleased(new KeyEvent(app,0,0,0,(char)32,0));
    }
    @Test
    public void fireBallDownTest() {
        Resource.wizard.setRoleImage(Resource.wizardImageFour);
        app.keyCode = 32;
        app.keyPressed();
        app.keyReleased(new KeyEvent(app,0,0,0,(char)32,0));
    }

    @Test
    public void freezeBallRightTest() {
        Resource.wizard.setRoleImage(Resource.wizardImageOne);
        app.keyCode = 9;
        app.keyPressed();
        app.keyReleased(new KeyEvent(app,0,0,0,(char)9,0));

    }

    @Test
    public void freezeBallLeftTest() {
        Resource.wizard.setRoleImage(Resource.wizardImageTwo);
        app.keyCode = 9;
        app.keyPressed();
        app.keyReleased(new KeyEvent(app,0,0,0,(char)9,0));
    }

    @Test
    public void freezeBallUpTest() {
        Resource.wizard.setRoleImage(Resource.wizardImageThree);
        app.keyCode = 9;
        app.keyPressed();
        app.keyReleased(new KeyEvent(app,0,0,0,(char)9,0));
    }
    @Test
    public void freezeBallDownTest() {
        Resource.wizard.setRoleImage(Resource.wizardImageFour);
        app.keyCode = 9;
        app.keyPressed();
        app.keyReleased(new KeyEvent(app,0,0,0,(char)9,0));
    }
}
