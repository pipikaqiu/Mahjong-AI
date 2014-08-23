package mahjong.rules;

import java.util.*;
import mahjong.tiles.Tile;

/**
 *
 * @author jeky
 */
public class ThirteenOrphansWinPattern implements WinPattern {

    @Override
    public boolean match(List<Tile> tiles) {
        if(tiles.size() != 14){
            return false;
        }
        
        int[] count = new int[100];
        int[] needTileIndex = new int[]{0, 8, 9, 17, 18, 26, 27, 28, 29, 30, 31, 32, 33};

        for (Tile t : tiles) {
            count[t.hashCode()]++;
        }

        for (int index : needTileIndex) {
            if (count[index] == 0) {
                return false;
            }
        }

        return true;
    }

}
