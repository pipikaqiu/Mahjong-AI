package mahjong.rules;

import java.util.List;
import mahjong.Helper;
import mahjong.Tile;

/**
 *
 * @author jeky
 */
public class DefaultWinPattern implements WinPattern {

    @Override
    public boolean match(List<Tile> tiles) {
        int prevLen = 0;
        while (prevLen != tiles.size()) {
            prevLen = tiles.size();

            Tile[] chow = Helper.findChow(tiles);
            for (Tile t : chow) {
                tiles.remove(t);
            }

            Tile[] kong = Helper.findKong(tiles);
            for (Tile t : kong) {
                tiles.remove(t);
            }

            Tile[] pung = Helper.findPung(tiles);
            for (Tile t : pung) {
                tiles.remove(t);
            }
        }

        if (tiles.size() == 2) {
            return tiles.get(0).equals(tiles.get(1));
        }else{
            return false;
        }
    }

}
