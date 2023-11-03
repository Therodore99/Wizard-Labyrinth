package gremlins.readJson;

import java.util.Objects;

/**
 * Store and control map information.
 */
public class MapInfo {
    private String layout;
    private double wizard_cooldown;
    private double enemy_cooldown;

    /**
     * Object contains the information of the layout, wizard cooldown and enemy cooldown.
     * @param layout Contain the map file.
     * @param wizard_cooldown Contain the cool down time of fireball.
     * @param enemy_cooldown Contain the cool down time of slime.
     */
    public MapInfo(String layout, double wizard_cooldown, double enemy_cooldown){
        this.layout = layout;
        this.wizard_cooldown = wizard_cooldown;
        this.enemy_cooldown = enemy_cooldown;
    }
    public String getLayout() {
        return layout;
    }

    public double getWizard_cooldown() {
        return wizard_cooldown;
    }

    public double getEnemy_cooldown() {
        return enemy_cooldown;
    }

}
