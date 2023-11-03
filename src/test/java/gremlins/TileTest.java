package gremlins;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Guohao Tong
 * @Assignment01
 */

public class TileTest {

    @Test
    public void locationBrickWalls(){
        App app = new App();
        for(Coordinate brickCoordinate : Resource.brickwall.keySet()){
            assertEquals(80, Resource.brickwall.get(brickCoordinate).getX());
            assertEquals(20, Resource.brickwall.get(brickCoordinate).getY());
            break;
        }
        for(int i = 0 ; i < i; i++){
            assertEquals(80, Resource.brickwallCoordinate.get(0).getX());
        }

//        for(Coordinate stoneCoordinate : Resource.stonewall.keySet()){
//            assertEquals(0, Resource.stonewall.get(stoneCoordinate).getX());
//            assertEquals(0, Resource.stonewall.get(stoneCoordinate).getY());
//            break;
//        }
//
//        for(int i = 0 ; i < i; i++){
//            assertEquals(0, Resource.stonewallCoordinate.get(0).getX());
//        }
    }
}
