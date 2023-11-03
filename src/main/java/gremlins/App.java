package gremlins;
/**
 * @author Guohao Tong
 * @Assignment01
 */
import gremlins.readJson.MapInfo;
import gremlins.roles.Gremlins;
import gremlins.roles.Wizard;
import gremlins.spriteWeapon.Fireball;
import gremlins.spriteWeapon.Freezeball;
import gremlins.spriteWeapon.Slime;
import gremlins.tiles.BrickWalls;
import gremlins.tiles.Exit;
import gremlins.tiles.StoneWalls;
import org.checkerframework.checker.units.qual.C;
import processing.core.PApplet;
import processing.data.JSONObject;
import processing.data.JSONArray;
import processing.event.KeyEvent;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.io.*;


    /**
     * APP class extends the PApplet.
     */
public class App extends PApplet {
        public static final int WIDTH = 720;
        public static final int HEIGHT = 720;
        //public static final int SPRITESIZE = 20;
        //public static final int BOTTOMBAR = 60;
        public static final int FPS = 60;

        //public static final Random randomGenerator = new Random();
        public static String configPath = "config.json";

        static boolean flag;

        /**
         * Constructor of App.
         */
        public App() {

            //this.configPath = "config.json";

            Resource.stonewall = new HashMap<>();

            Resource.brickwall = new HashMap<>();

            Resource.stonewallCoordinate = new ArrayList<Coordinate>();

            Resource.brickwallCoordinate = new ArrayList<Coordinate>();

            Resource.fireBalls = new ArrayList<Fireball>();

            Resource.freezeballs = new ArrayList<Freezeball>();

            Resource.gremlins = new HashMap<>();

            Resource.gremlinsCoordinate = new ArrayList<>();

            Resource.noneWallCoordinate = new ArrayList<>();

            //Resource.slimeCoordinate = new ArrayList<>();

            Resource.gremlinSlime = new ArrayList<>();

            Resource.powerup = new ArrayList<>();
        }

        /**
         * Initialise the setting of the window size.
         */
        public void settings() {
            size(WIDTH, HEIGHT);
        }

        /**
         * Load all resources such as images. Initialise the elements such as the player, enemies and map elements.
         */
        public void setup() { //define the variable and set up the background, fonts and other attributes.
            frameRate(FPS);
            Resource.setup(this, this.configPath);
            //get the info in the JSON file;
        }

        //private boolean actionComplete = true; // In order to perform the action only once
        //private boolean releasedFlag = false;
        public static boolean releasedUp = true;
        public static boolean releasedDown = true;
        public static boolean releasedRight = true;
        public static boolean releasedLeft = true;

        public boolean releasedSpace = true;
        public static boolean pressedUp = false;
        public static boolean pressedDown = false;
        public static boolean pressedLeft = false;
        public static boolean pressedRight = false;
        public static boolean pressedSpace = false;
        public static boolean pressedKeyTab = false;

        private boolean progressBarFlag = false;

        private boolean restartGame = false;

        /**
         * Receive key pressed signal from the keyboard.
         */
        public void keyPressed() {
            flag = true;
            //Player movement Handling
            //if (key == CODED) {
            switch (keyCode) {
                //38 UP
                case UP:
                    flag = true;
                    pressedUp = true;
                    releasedUp = false;
                    //Change the Wizard image direction
                    if (Resource.wizard.getY() % 20 == 0 && Resource.wizard.getX() % 20 == 0 && releasedDown && releasedLeft && releasedRight) {
                        Resource.wizard.changeWizardDirection(keyCode);

                        //Check whether stonewall is one block above the Wizard, and if so, do not call the moveWizard() function.
                        for (int i = 0; i < Resource.stonewallCoordinate.size(); i++) {
                            if (Resource.stonewallCoordinate.get(i).getX() == Resource.wizard.getX() & Resource.stonewallCoordinate.get(i).getY() == Resource.wizard.getY() - 20) {
                                flag = false;
                            }
                        }
                        //Check if any brickwall is one block above the Wizard. If so, the moveWizard() function is not called.
                        for (int i = 0; i < Resource.brickwallCoordinate.size(); i++) {
                            if (Resource.brickwallCoordinate.get(i).getX() == Resource.wizard.getX() & Resource.brickwallCoordinate.get(i).getY() == Resource.wizard.getY() - 20) {
                                flag = false;
                            }
                        }

                        if (flag) {
                            Resource.wizard.moveWizard(keyCode);
                        }
                    }
                    break;

                //40 down
                case DOWN:
                    flag = true;
                    pressedDown = true;
                    releasedDown = false;
                    if (Resource.wizard.getY() % 20 == 0 && Resource.wizard.getX() % 20 == 0 && releasedUp && releasedLeft && releasedRight) {
                        Resource.wizard.changeWizardDirection(keyCode);

                        //Check to see if any stonewall is next to the Wizard. If so, the moveWizard() function is not called.
                        for (int i = 0; i < Resource.stonewallCoordinate.size(); i++) {
                            if (Resource.stonewallCoordinate.get(i).getX() == Resource.wizard.getX() & Resource.stonewallCoordinate.get(i).getY() == Resource.wizard.getY() + 20) {
                                flag = false;
                            }
                        }

                        //Check if any brickwall is next to the Wizard. If so, the moveWizard() function is not called.
                        for (int i = 0; i < Resource.brickwallCoordinate.size(); i++) {
                            if (Resource.brickwallCoordinate.get(i).getX() == Resource.wizard.getX() & Resource.brickwallCoordinate.get(i).getY() == Resource.wizard.getY() + 20) {
                                flag = false;
                            }
                        }

                        if (flag) {
                            Resource.wizard.moveWizard(keyCode);
                        }
                    }
                    break;

                //37 left
                case LEFT:
                    flag = true;
                    pressedLeft = true;
                    releasedLeft = false;
                    if (Resource.wizard.getX() % 20 == 0 && Resource.wizard.getY() % 20 == 0 && releasedUp && releasedRight && releasedDown) {
                        Resource.wizard.changeWizardDirection(keyCode);

                        //Check to see if stonewall is one box to the left of the Wizard. If so, do not call the moveWizard() function.
                        for (int i = 0; i < Resource.stonewallCoordinate.size(); i++) {
                            if (Resource.stonewallCoordinate.get(i).getX() == Resource.wizard.getX() - 20 & Resource.stonewallCoordinate.get(i).getY() == Resource.wizard.getY()) {
                                flag = false;
                            }
                        }

                        //Check whether the brickwall is one column to the left of the Wizard. If it is, the moveWizard() function is not called.
                        for (int i = 0; i < Resource.brickwallCoordinate.size(); i++) {
                            if (Resource.brickwallCoordinate.get(i).getX() == Resource.wizard.getX() - 20 & Resource.brickwallCoordinate.get(i).getY() == Resource.wizard.getY()) {
                                flag = false;
                            }
                        }

                        if (flag) {
                            Resource.wizard.moveWizard(keyCode);
                        }
                    }
                    break;

                //39
                case RIGHT:
                    flag = true;
                    pressedRight = true;
                    releasedRight = false;
                    if (Resource.wizard.getX() % 20 == 0 && Resource.wizard.getY() % 20 == 0 && releasedUp && releasedDown && releasedLeft) {
                        Resource.wizard.changeWizardDirection(keyCode);
                        //Check whether stonewall is one space to the right of the Wizard. If so, the moveWizard() function is not called.
                        for (int i = 0; i < Resource.stonewallCoordinate.size(); i++) {
                            if (Resource.stonewallCoordinate.get(i).getX() == Resource.wizard.getX() + 20 & Resource.stonewallCoordinate.get(i).getY() == Resource.wizard.getY()) {
                                flag = false;
                            }
                        }
                        //Check whether stonewall is one space to the right of the Wizard. If so, the moveWizard() function is not called.
                        for (int i = 0; i < Resource.brickwallCoordinate.size(); i++) {
                            if (Resource.brickwallCoordinate.get(i).getX() == Resource.wizard.getX() + 20 & Resource.brickwallCoordinate.get(i).getY() == Resource.wizard.getY()) {
                                flag = false;
                            }
                        }
                        if (flag) {
                            Resource.wizard.moveWizard(keyCode);
                        }
                    }
                    break;
                //type space to shoot fireballs
           // }
            // }else{
            //     switch (key){
            // type key "tab" to shoot Freeze ball
            case 9:
            pressedKeyTab = true;
            if (pressedKeyTab && Resource.currentMapLevel == 0 && Resource.numFrameBetPressedSpace == (int) Math.round(Resource.wizard_cooldown * 60)) {
                Resource.numFrameBetPressedSpace = 0;
                Freezeball currentFreezeball = new Freezeball(Resource.wizard.getX(), Resource.wizard.getY(), Resource.freezeBallImage);
                Resource.freezeballs.add(currentFreezeball);
                currentFreezeball.moveFreezeball(Resource.wizard.getRoleImage());
            }
            break;

            // type key "Space" to shoot Freeze ball
            case 32:
            pressedSpace = true;
            while (pressedSpace && Resource.numFrameBetPressedSpace == (int) Math.round(Resource.wizard_cooldown * 60)) {
                Resource.numFrameBetPressedSpace = 0;
                Fireball currentFireball = new Fireball(Resource.wizard.getX(), Resource.wizard.getY(), Resource.fireBallImage);
                Resource.fireBalls.add(currentFireball);
                currentFireball.moveFireball(Resource.wizard.getRoleImage());
            }
            break;
        }

    }



    boolean stopFlag = true;
    /**
     * Receive key released signal from the keyboard.
     */
    public void keyReleased(KeyEvent e){

        int key = e.getKeyCode();
        if (key == 38) {

            pressedUp = false;
            releasedUp = true;
            Resource.wizard.stopMove();
        }else if(key == 39){//right

            pressedRight = false;
            releasedRight = true;
            Resource.wizard.stopMove();
        }else if(key == 37){

            pressedLeft = false;
            releasedLeft = true;
            Resource.wizard.stopMove();
        }else if(key == 40){

            pressedDown = false;
            releasedDown = true;
            Resource.wizard.stopMove();
        }else if(key == 32){
            pressedSpace = false;

        }else if(key == 9){
            pressedKeyTab = false;
        }

    }


    public boolean wizardStatus(){
        if(Resource.wizard.getX() % 20 == 0 & Resource.wizard.getY() % 20 == 0){
            stopFlag = false;
        }
        return stopFlag;
    }


    int barTime = 0;
    /**
     * Draw all elements in the game by current frame.
     */
    public void draw() {
        background(200, 150, 110);
        text("Lives:", 20F, 690F);
        text("Level : " + (Resource.currentMapLevel + 1) + "/" + Resource.numOfLevel, 180 , 690);
        Resource.draw(this);
        if(Resource.lives == 0){
            text("Game Over", WIDTH*0.5F, HEIGHT*0.5F, 300, 300);
            restartGame = true;
            return;
        }

        if(Resource.wizard.getX() == Resource.exit.getX() & Resource.wizard.getY() == Resource.exit.getY() && Resource.currentMapLevel == 0){//level1 == 0. level2 == 1;
            Resource.currentMapLevel++;
            Resource.mapLayoutUpdate();
        }else if(Resource.wizard.getX() == Resource.exit.getX() & Resource.wizard.getY() == Resource.exit.getY() && Resource.currentMapLevel == 1){
            if(Resource.lives > 0){
                text("You Win", WIDTH*0.5F, HEIGHT*0.5F,300, 300);
                restartGame = true;
                Resource.restartGameTime++;
                if(Resource.restartGameTime == 60) {
                    Resource.restartGame(configPath);
                }
                return;
            }
        }

        //Retrieve HashMap stonewall
        for(Coordinate stoneCoordinate : Resource.stonewall.keySet()){
            Resource.stonewall.get(stoneCoordinate).draw(this);
        }

        //Retrieve HashMap brickwall
        for(Coordinate brickCoordinate : Resource.brickwall.keySet()){
            Resource.brickwall.get(brickCoordinate).draw(this);
        }
        Resource.exit.draw(this);
        Resource.wizard.draw(this);

        //The powerup should not spawn immediately when the level loads,
        //When the game starts 10 seconds later, just 600 frames, powerup loads.

        if(Resource.timeSpawnPowerUp < 600) {
            Resource.timeSpawnPowerUp++;
        }else{
            for (int i = 0; i < Resource.powerup.size(); i++) {
                Resource.powerup.get(i).draw(this);
            }
        }
        //Only one ball is allowed to be fired every 20 frames
        if(Resource.numFrameBetPressedSpace < Math.round(Resource.wizard_cooldown * 60)){
            Resource.numFrameBetPressedSpace++;
        }

        for(int i = 0; i < Resource.fireBalls.size(); i++) {
            Resource.fireBalls.get(i).draw(this);
        }

        for(int i = 0; i < Resource.freezeballs.size(); i++) {
            Resource.freezeballs.get(i).draw(this);
        }

        //Retrieve HashMap gremlins
        for(Coordinate gremlinCoordinate : Resource.gremlins.keySet()){
            Resource.gremlins.get(gremlinCoordinate).draw(this);

            if(Resource.numFrameBetPerSlime < (int) Resource.enemy_cooldown * 60){
                Resource.numFrameBetPerSlime++;
            }else{
                Resource.numFrameBetPerSlime = 0;

                if( Resource.gremlins.get(gremlinCoordinate).getxVel() !=0 | Resource.gremlins.get(gremlinCoordinate).getyVel() !=0){
                    Slime slime = new Slime(Resource.gremlins.get(gremlinCoordinate).getX(), Resource.gremlins.get(gremlinCoordinate).getY(), Resource.slimeImage,
                            Resource.gremlins.get(gremlinCoordinate).getxVel(), Resource.gremlins.get(gremlinCoordinate).getyVel());
                    Resource.gremlinSlime.add(slime);
                }

            }

        }

        for(int i = 0; i < Resource.gremlinSlime.size(); i++){
            Resource.gremlinSlime.get(i).draw(this);
        }
        if(pressedSpace){
            progressBarFlag = true;
        }

        if(progressBarFlag & Resource.wizardCooldownFrameForBar < (int) Math.round(Resource.wizard_cooldown * 60)){
            Resource.wizardCooldownFrameForBar++;
            text("Fireball Cool: ", 478 , 689);
            rect(560, 680, 100,8);
            fill(0);
            rect(560, 680, (float) ((float) Resource.wizardCooldownFrameForBar * (100 / (Resource.wizard_cooldown * 60))), 8);
            fill(255);
        }else{
            Resource.wizardCooldownFrameForBar = 0;
            progressBarFlag = false;
        }
    }

    public static void main(String[] args) {
        PApplet.main("gremlins.App");
    }
}
