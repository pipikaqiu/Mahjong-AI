package mahjong.rules;

import java.util.List;
import mahjong.tiles.Tile;

/**
 *
 * @author jeky
 */
public interface WinPattern {

    public boolean match(List<Tile> tiles);
}
