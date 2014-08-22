package mahjong.rules;

import java.util.List;
import mahjong.Tile;

/**
 *
 * @author jeky
 */
public interface WinPattern {

    public boolean match(List<Tile> tiles);
}
