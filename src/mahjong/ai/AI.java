package mahjong.ai;

import java.util.LinkedList;
import mahjong.DroppedTile;
import mahjong.Game;
import mahjong.Tile;

/**
 *
 * @author jeky
 */
public interface AI {

    public Tile chooseWorst(LinkedList<Tile> tiles, Game game);

    public boolean wannaPickFromOther(Game game, DroppedTile tile);
    
}
