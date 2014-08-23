
package mahjong.ai;

import java.util.List;
import mahjong.tiles.DroppedTile;
import mahjong.Game;
import mahjong.Player;
import mahjong.tiles.Tile;

/**
 *
 * @author jeky
 */
public class DefaultAI implements AI{

    @Override
    public Tile[] wannaKong(Game game, Player player, DroppedTile lastDroppedTile) {
        return null;
    }

    @Override
    public Tile[] wannaPung(Game game, Player player, DroppedTile lastDroppedTile) {
        return null;
    }

    @Override
    public Tile[] wannaChow(Game game, Player player, DroppedTile lastDroppedTile) {
        return null;
    }

    @Override
    public Tile chooseWorst(Game game, Player player, List<Tile> tiles) {
        return tiles.get(tiles.size() - 1);
    }

    
}
