package mahjong.rules;

import java.util.*;
import mahjong.Tile;

/**
 *
 * @author jeky
 */
public class ThirteenOrphansWinPattern implements WinPattern {

    @Override
    public boolean match(List<Tile> tiles) {
        // slots for 1s,9s,1m,9m,1p,9p,E,S,W,N,C,F,P
        int[] count = new int[13];
        for (Tile t : tiles) {
            if (t.getNum() == 1 && t.getType() == Tile.Type.Bamboo) {
                count[0]++;
            } else if (t.getNum() == 9 && t.getType() == Tile.Type.Bamboo) {
                count[1]++;
            } else if (t.getNum() == 1 && t.getType() == Tile.Type.Char) {
                count[2]++;
            } else if (t.getNum() == 9 && t.getType() == Tile.Type.Char) {
                count[3]++;
            } else if (t.getNum() == 1 && t.getType() == Tile.Type.Dot) {
                count[4]++;
            } else if (t.getNum() == 9 && t.getType() == Tile.Type.Dot) {
                count[5]++;
            } else {
                switch (t.getType()) {
                    case East:
                        count[6]++;
                        break;
                    case South:
                        count[7]++;
                        break;
                    case West:
                        count[8]++;
                        break;
                    case North:
                        count[9]++;
                        break;
                    case Red:
                        count[10]++;
                        break;
                    case Green:
                        count[11]++;
                        break;
                    case White:
                        count[12]++;
                        break;
                }
            }
        }

        for (int c : count) {
            if (c == 0) {
                return false;
            }
        }

        return true;
    }

}
