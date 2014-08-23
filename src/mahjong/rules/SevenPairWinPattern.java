package mahjong.rules;

import java.util.List;
import mahjong.tiles.Tile;

/**
 * 
 * @author jeky
 */
public class SevenPairWinPattern implements WinPattern {

  @Override
  public boolean match(List<Tile> tiles) {
    for (int i = 0; i < 7; i++) {
      if (!tiles.get(i * 2).equals(tiles.get(i * 2 + 1))) {
        return false;
      }
    }

    return true;
  }
}
