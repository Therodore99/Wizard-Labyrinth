package gremlins;

import gremlins.powerup.Powerup;
import gremlins.readJson.MapInfo;
import gremlins.roles.Gremlins;
import gremlins.roles.Wizard;
import gremlins.spriteWeapon.Fireball;
import gremlins.spriteWeapon.Freezeball;
import gremlins.spriteWeapon.Slime;
import gremlins.tiles.BrickWalls;
import gremlins.tiles.Exit;
import gremlins.tiles.StoneWalls;
import processing.core.PApplet;
import processing.core.PImage;
import processing.data.JSONArray;
import processing.data.JSONObject;
import processing.core.PApplet;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

import static processing.core.PApplet.loadJSONObject;

    /**
     * Program resource class, just similar to the database of the program.
     */

public class Resource {

    /**
     * player current lives.
     */
    public static int lives;

    /**
     * player current wizard_cooldown.
     */
    public static double wizard_cooldown;

    /**
     * player current enemy_cooldown.
     */
    public static double enemy_cooldown;



    /**
     * the number of frame between per pressed space bar. Initialize to 20, meaning the user starts the game with full mana.
     */
    protected static int numFrameBetPressedSpace = (int) Math.round(wizard_cooldown * 60);

    /**
     * The counter counts frames for the interval between each launch of Slime.
     */
    public static int numFrameBetPerSlime = 0;

    /**
     * HashMap data structure used to store Stonewall locations and objects.
     * The type of key is Coordinate. The type of value os StoneWalls.
     */
    public static HashMap<Coordinate, StoneWalls> stonewall;

    /**
     * list of coordinates for each stonewall location.
     */
    public static List<Coordinate> stonewallCoordinate;

    /**
     * HashMap data structure used to store brickwall locations and objects
     * The type of key is Coordinate. The type of value os StoneWalls
     */
    public static HashMap<Coordinate, BrickWalls> brickwall;

    /**
     * list of coordinates for each brickwall location.
     */
    public static List<Coordinate> brickwallCoordinate;

    /**
     * list of every gremlin's slime.
     */
    public static List<Slime> gremlinSlime;

    /**
     * list of every wizard's fireballs.
     */
    public static List<Fireball> fireBalls;

    /**
     * list of every wizard's freeze balls.
     */
    public static List<Freezeball> freezeballs;

    /**
     * counter
     */
    public static int counter = 0;

    /**
     * counter Flag
     */
    public static boolean counterFlag = false;


    public static int currentCollisionBrickWall = -1;

    /**
     * HashMap data structure used to store gremlins locations and objects.
     * The type of key is Coordinate. The type of value os Gremlin.
     */
    public static HashMap<Coordinate, Gremlins> gremlins;

    /**
     * list of coordinates for each gremlin location.
     */
    public static List<Coordinate> gremlinsCoordinate;

    /**
     * Exit object.
     */
    public static Exit exit;

    /**
     * An array of Mapinfo objects.
     */
    public static MapInfo[] mapLevelInfo;

    /**
     * Wizard object.
     */
    public static Wizard wizard;

    /**
     * List of power up.
     */
    public static List<Powerup> powerup;

        /**
         * Image of brick wall.
         */
    public static PImage brickWallImage;
        /**
         * The first animation image of brick wall after being hit by a fireball.
         */
    public static PImage brickWallDestroyedImageOne;

        /**
         * The second animation image of brick wall after being hit by a fireball.
         */
    public static PImage brickWallDestroyedImageTwo;

        /**
         * The third animation image of brick wall after being hit by a fireball.
         */
    public static PImage brickWallDestroyedImageThree;

        /**
         * The fourth animation image of brick wall after being hit by a fireball
         */
    public static PImage brickWallDestroyedImageFour;

        /**
         * Image of exit door.
         */
    public static PImage exitDoorImage;

        /**
         * Image of fireball.
         */
    public static PImage fireBallImage;

        /**
         * Image of gremlin.
         */
    public static PImage gremlinImage;

        /**
         * Image of slime.
         */
    public static PImage slimeImage;

        /**
         * Image of stone wall.
         */
    public static PImage stoneWallImage;

        /**
         * Image of wizard facing left.
         */
    public static PImage wizardImageOne;

        /**
         * Image of wizard facing right.
         */
    public static PImage wizardImageTwo;

        /**
         * Image of wizard facing up.
         */
    public static PImage wizardImageThree;

        /**
         * Image of wizard facing down.
         */
    public static PImage wizardImageFour;

        /**
         * Image of power up(An orange lightning bolt).
         */
    public static PImage powerupImage;

        /**
         * Image of freeze ball.
         */
    public static PImage freezeBallImage;

        /**
         * The current game level.
         * The first level is assumed to be 0, and then it increases.
         */
    public static int currentMapLevel = 0;

        /**
         * Coordinates - There are no walls in the map.
         */
    public static List<Coordinate> noneWallCoordinate;

    public static int wizardCooldownFrameForBar = 0;

        /**
         * Counter - Reload time each time powerup is used by wizard.
         */
    public static int timeSpawnPowerUp = 0;

        /**
         * Counter - Validity time each time powerup is used by wizard.
         */
    public static int timeValidPowerUp = 0;

        /**
         * The total number of levels in the game.
         * It will be set up in setup(PApplet App, String configPath).
         */
    public static int numOfLevel = 0;

        /**
         * Restart time after the end of the game.
         */
    public static int restartGameTime;


        /**
         * Call by App.setup().
         * Load all resources such as images. Initialise the elements such as the player, enemies and map elements.
         * @param App        PApplet Object
         * @param configPath config file path
         */
    public static void setup(PApplet App, String configPath) {

        brickWallImage = App.loadImage("src/main/resources/gremlins/brickwall.png");
        brickWallDestroyedImageOne = App.loadImage("src/main/resources/gremlins/brickwall_destroyed1.png");
        brickWallDestroyedImageTwo = App.loadImage("src/main/resources/gremlins/brickwall_destroyed1.png");
        brickWallDestroyedImageThree = App.loadImage("src/main/resources/gremlins/brickwall_destroyed2.png");
        brickWallDestroyedImageFour = App.loadImage("src/main/resources/gremlins/brickwall_destroyed3.png");
        exitDoorImage = App.loadImage("src/main/resources/gremlins/exitdoor.png");
        gremlinImage = App.loadImage("src/main/resources/gremlins/gremlin.png");
        slimeImage = App.loadImage("src/main/resources/gremlins/slime.png");
        stoneWallImage = App.loadImage("src/main/resources/gremlins/stonewall.png");
        wizardImageOne = App.loadImage("src/main/resources/gremlins/wizard0.png");
        wizardImageTwo = App.loadImage("src/main/resources/gremlins/wizard1.png");
        wizardImageThree = App.loadImage("src/main/resources/gremlins/wizard2.png");
        wizardImageFour = App.loadImage("src/main/resources/gremlins/wizard3.png");
        powerupImage = App.loadImage("src/main/resources/gremlins/powerup.png");
        freezeBallImage = App.loadImage("src/main/resources/gremlins/freezeball.png");
        fireBallImage = App.loadImage("src/main/resources/gremlins/fireball.png");


        JSONObject conf = loadJSONObject(new File(configPath));
        JSONArray leverData = conf.getJSONArray("levels");
        Resource.numOfLevel = leverData.size();
        Resource.lives = conf.getInt("lives");
        mapLevelInfo = new MapInfo[leverData.size()];
        // get the information of levels;
        for(int i = 0; i < leverData.size(); i++){
            // Get each object in the array
            JSONObject level = leverData.getJSONObject(i);
            // JSONObject layout = level.getJSONObject("layout");
            String layout = level.getString("layout");
            double wizard_cooldown = level.getDouble("wizard_cooldown");
            double enemy_cooldown = level.getDouble("enemy_cooldown");
            mapLevelInfo[i] = new MapInfo(layout, wizard_cooldown, enemy_cooldown);
        }

        try{
            Resource.wizard_cooldown = mapLevelInfo[Resource.currentMapLevel].getWizard_cooldown();
            Resource.enemy_cooldown = mapLevelInfo[Resource.currentMapLevel].getEnemy_cooldown();
            File jsonFile = new File(mapLevelInfo[Resource.currentMapLevel].getLayout());
            InputStreamReader reader = new InputStreamReader(new FileInputStream(jsonFile));
            BufferedReader br = new BufferedReader(reader);
            int X_B_E;
            //the variable for loaction
            int x = 0;
            int y = 0;

            for(int i = 0; i < 33; i++){

                for(int j = 0; j < 38; j++){
                    X_B_E = br.read();
                    //System.out.print(X_B_E);
                    if(X_B_E == 88){
                        Coordinate stoneCoordinate = new Coordinate(x,y);
                        Resource.stonewallCoordinate.add(stoneCoordinate);
                        Resource.stonewall.put(stoneCoordinate,new StoneWalls(x, y, App.loadImage("src/main/resources/gremlins/stonewall.png")));
                        //this.stonewall.add(new StoneWalls(x, y, this.loadImage("src/main/resources/gremlins/stonewall.png")));
                        x += 20;
                    }else if(X_B_E == 66){
                        Coordinate brickCoodinate = new Coordinate(x,y);
                        Resource.brickwallCoordinate.add(brickCoodinate);
                        Resource.brickwall.put(brickCoodinate,new BrickWalls(x, y, brickWallImage,
                                App.loadImage("src/main/resources/gremlins/brickwall_destroyed0.png"),
                                App.loadImage("src/main/resources/gremlins/brickwall_destroyed1.png"),
                                App.loadImage("src/main/resources/gremlins/brickwall_destroyed2.png"),
                                App.loadImage("src/main/resources/gremlins/brickwall_destroyed3.png")));
                        x += 20;
                    }else if(X_B_E == 69){
                        Resource.exit = new Exit(x, y, App.loadImage("src/main/resources/gremlins/exitdoor.png"));//PImage.resize(w, h)
                        x += 20;
                    }else if(X_B_E == 71){
                        Coordinate gremlinCoordinate = new Coordinate(x, y);
                        Resource.gremlinsCoordinate.add(gremlinCoordinate);
                        Resource.noneWallCoordinate.add(new Coordinate(x,y));
                        Resource.gremlins.put(gremlinCoordinate, new Gremlins(x, y, App.loadImage("src/main/resources/gremlins/gremlin.png")));
                        x += 20;
                    }else if(X_B_E == 87){
                        Resource.noneWallCoordinate.add(new Coordinate(x,y));
                        Resource.wizard = new Wizard(x, y, App.loadImage("src/main/resources/gremlins/wizard1.png"),
                                App.loadImage("src/main/resources/gremlins/wizard0.png"),
                                App.loadImage("src/main/resources/gremlins/wizard1.png"),
                                App.loadImage("src/main/resources/gremlins/wizard2.png"),
                                App.loadImage("src/main/resources/gremlins/wizard3.png"));
                        x += 20;
                    }else if(X_B_E == 32){
                        Resource.noneWallCoordinate.add(new Coordinate(x,y));
                        x += 20;
                    }else if(X_B_E == 68){//D
                        Resource.powerup.add(new Powerup(x,y,Resource.powerupImage));
                        x += 20;
                    }
                }
                x = 0;
                y += 20;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

        /**
         * Update the elements such as the player, enemies and map elements,
         * when wizard dies or enters another level.
         */
    public static void mapLayoutUpdate(){

        Resource.stonewall.clear();
        Resource.brickwall.clear();
        Resource.stonewallCoordinate.clear();
        Resource.brickwallCoordinate.clear();
        Resource.gremlins.clear();
        Resource.noneWallCoordinate.clear();
        Resource.gremlinSlime.clear();
        //Resource.slimeCoordinate.clear();

        Resource.wizard_cooldown = mapLevelInfo[Resource.currentMapLevel].getWizard_cooldown();
        Resource.enemy_cooldown = mapLevelInfo[Resource.currentMapLevel].getEnemy_cooldown();

        try{
            File jsonFile = new File(mapLevelInfo[Resource.currentMapLevel].getLayout());
            InputStreamReader reader = new InputStreamReader(new FileInputStream(jsonFile));
            BufferedReader br = new BufferedReader(reader);
            int X_B_E;
            //the variable for loaction
            int x = 0;
            int y = 0;

            for(int i = 0; i < 33; i++){

                for(int j = 0; j < 38; j++){
                    X_B_E = br.read();
                    //System.out.print(X_B_E);
                    if(X_B_E == 88){
                        Coordinate stoneCoordinate = new Coordinate(x,y);
                        Resource.stonewallCoordinate.add(stoneCoordinate);
                        Resource.stonewall.put(stoneCoordinate,new StoneWalls(x, y, stoneWallImage));
                        //this.stonewall.add(new StoneWalls(x, y, this.loadImage("src/main/resources/gremlins/stonewall.png")));
                        x += 20;
                    }else if(X_B_E == 66){
                        Coordinate brickCoodinate = new Coordinate(x,y);
                        Resource.brickwallCoordinate.add(brickCoodinate);
                        Resource.brickwall.put(brickCoodinate,new BrickWalls(x, y, brickWallImage, brickWallDestroyedImageOne,
                                brickWallDestroyedImageTwo, brickWallDestroyedImageThree, brickWallDestroyedImageFour));
                        x += 20;
                    }else if(X_B_E == 69){
                        Resource.exit = new Exit(x, y, exitDoorImage);//PImage.resize(w, h)
                        x += 20;
                    }else if(X_B_E == 71){
                        Coordinate gremlinCoordinate = new Coordinate(x, y);
                        Resource.gremlinsCoordinate.add(gremlinCoordinate);
                        Resource.gremlins.put(gremlinCoordinate, new Gremlins(x, y, gremlinImage));
                        x += 20;
                    }else if(X_B_E == 87){
                        Resource.wizard = new Wizard(x, y, wizardImageTwo, wizardImageOne, wizardImageTwo, wizardImageThree, wizardImageFour);
                        x += 20;
                    }else if(X_B_E == 32){
                        Resource.noneWallCoordinate.add(new Coordinate(x,y));
                        x += 20;
                    }
                }
                x = 0;
                y += 20;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void restartGame(String configPath){
        Resource.stonewall.clear();
        Resource.brickwall.clear();
        Resource.stonewallCoordinate.clear();
        Resource.brickwallCoordinate.clear();
        Resource.gremlins.clear();
        Resource.noneWallCoordinate.clear();
        Resource.gremlinSlime.clear();
        Resource.freezeballs.clear();
        Resource.fireBalls.clear();

        try{
            Resource.currentMapLevel = 0;
            Resource.wizard_cooldown = mapLevelInfo[Resource.currentMapLevel].getWizard_cooldown();
            Resource.enemy_cooldown = mapLevelInfo[Resource.currentMapLevel].getEnemy_cooldown();
            File jsonFile = new File(mapLevelInfo[Resource.currentMapLevel].getLayout());
            InputStreamReader reader = new InputStreamReader(new FileInputStream(jsonFile));
            BufferedReader br = new BufferedReader(reader);
            int X_B_E;
            //the variable for loaction
            int x = 0;
            int y = 0;

            for(int i = 0; i < 33; i++){

                for(int j = 0; j < 38; j++){
                    X_B_E = br.read();
                    //System.out.print(X_B_E);
                    if(X_B_E == 88){
                        Coordinate stoneCoordinate = new Coordinate(x,y);
                        Resource.stonewallCoordinate.add(stoneCoordinate);
                        Resource.stonewall.put(stoneCoordinate,new StoneWalls(x, y, stoneWallImage));
                        //this.stonewall.add(new StoneWalls(x, y, this.loadImage("src/main/resources/gremlins/stonewall.png")));
                        x += 20;
                    }else if(X_B_E == 66){
                        Coordinate brickCoodinate = new Coordinate(x,y);
                        Resource.brickwallCoordinate.add(brickCoodinate);
                        Resource.brickwall.put(brickCoodinate,new BrickWalls(x, y, brickWallImage, brickWallDestroyedImageOne,
                                brickWallDestroyedImageTwo, brickWallDestroyedImageThree, brickWallDestroyedImageFour));
                        x += 20;
                    }else if(X_B_E == 69){
                        Resource.exit = new Exit(x, y, exitDoorImage);//PImage.resize(w, h)
                        x += 20;
                    }else if(X_B_E == 71){
                        Coordinate gremlinCoordinate = new Coordinate(x, y);
                        Resource.gremlinsCoordinate.add(gremlinCoordinate);
                        Resource.gremlins.put(gremlinCoordinate, new Gremlins(x, y, gremlinImage));
                        x += 20;
                    }else if(X_B_E == 87){
                        Resource.wizard = new Wizard(x, y, wizardImageTwo, wizardImageOne, wizardImageTwo, wizardImageThree, wizardImageFour);
                        x += 20;
                    }else if(X_B_E == 32){
                        Resource.noneWallCoordinate.add(new Coordinate(x,y));
                        x += 20;
                    }
                }
                x = 0;
                y += 20;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }


        /**
         * Shows the current lives of the wizard.
         * @param App PApplet Object
         */
    public static void draw(PApplet App){
        int wizardLivesBarX = 60;
        int wizardLivesBarY = 670;
        if(Resource.lives > 0){
            for(int i = 0; i < Resource.lives; i++){

                App.image(Resource.wizardImageTwo, wizardLivesBarX, wizardLivesBarY);
                wizardLivesBarX = wizardLivesBarX + 20;
            }
        }
    }
}
