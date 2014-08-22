
package mahjong.ai;

import java.util.LinkedList;
import mahjong.DroppedTile;
import mahjong.Game;
import mahjong.Tile;

/**
 *
 * @author jeky
 */
public class DefaultAI implements AI{

    @Override
    public Tile chooseWorst(LinkedList<Tile> tiles, Game game) {
        return tiles.get(0);
    }

    @Override
    public boolean wannaPickFromOther(Game game, DroppedTile tile) {
        return false;
    }
    
}
