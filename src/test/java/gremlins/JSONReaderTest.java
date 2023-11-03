package gremlins;

import org.junit.jupiter.api.Test;
import processing.data.JSONArray;
import processing.data.JSONObject;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static processing.core.PApplet.loadJSONObject;

/**
 * @author Guohao Tong
 * @Assignment01
 */
public class JSONReaderTest {

    /**
     * Test the return value of lives
     */
    @Test
    public void wizardLivesTest() {
        JSONObject conf = loadJSONObject(new File(App.configPath));
        assertEquals(3, conf.getInt("lives"));
    }

    /**
     * Test the number of Level
     */
    @Test
    public void mapLevelTest() {
        JSONObject conf = loadJSONObject(new File(App.configPath));
        JSONArray leverData = conf.getJSONArray("levels");
        Resource.numOfLevel = leverData.size();
        assertEquals(2, Resource.numOfLevel);
    }

}