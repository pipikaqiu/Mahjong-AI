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
public interface AI {

    public Tile[] wannaKong(Game game, Player player, DroppedTile lastDroppedTile);

    public Tile[] wannaPung(Game game, Player player, DroppedTile lastDroppedTile);

    public Tile[] wannaChow(Game game, Player player, DroppedTile lastDroppedTile);

    public Tile chooseWorst(Game game, Player player, List<Tile> tiles);

}
