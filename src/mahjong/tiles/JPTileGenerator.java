package mahjong.tiles;

import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author jeky
 */
public class JPTileGenerator implements TileGenerator{

    @Override
    public LinkedList<Tile> initTiles() {
        LinkedList<Tile> allTiles = new LinkedList<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 1; k < 10; k++) {
                    if(i == 0 && k == 5){ // red dora
                        allTiles.add(new JPTile(k, Tile.SUITS[j], true));
                    }else{
                        allTiles.add(new JPTile(k, Tile.SUITS[j], false));
                    }
                }
            }
            for (int j = 3; j < Tile.OTHER_TYPES.length; j++) {
                allTiles.add(new JPTile(Tile.OTHER_TYPES[j]));
            }
        }

        Collections.shuffle(allTiles);
        return allTiles;
    }
    
}
