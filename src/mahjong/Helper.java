package mahjong;

import mahjong.tiles.Tile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jeky
 */
public class Helper {

    /**
     * Check whether there is one chow, which is a set of three tiles of the
     * same suit and consecutive numbers.
     *
     * @param tiles
     * @return
     */
    public static boolean hasChow(List<Tile> tiles) {
        Tile[] indexes = findChow(tiles);
        return indexes[0] != null;
    }

    /**
     * Check whether there is one pung, which is a set of three identical tiles.
     *
     * @param tiles
     * @return
     */
    public static boolean hasPung(List<Tile> tiles) {
        Tile[] indexes = findKong(tiles);
        return indexes[0] != null;
    }

    /**
     * Check whether there is one kong, is a set of 4 identical tiles.
     *
     * @param tiles
     * @return
     */
    public static boolean hasKong(List<Tile> tiles) {
        Tile[] indexes = findKong(tiles);
        return indexes[0] != null;
    }

    /**
     * Find one chow
     *
     * @param tiles
     * @return tile array
     */
    public static Tile[] findChow(List<Tile> tiles) {
        Tile[] r = new Tile[3];
        for (String t : Tile.SUITS) {
            int[] count = new int[9];
            for (Tile tile : tiles) {
                if(tile.getNum() == 0){
                    continue;
                }
                if (tile.getType().equals(t)) {
                    count[tile.getNum() - 1]++;
                }
            }

            for (int i = 0; i < 9 - 2; i++) {
                if (count[i] > 0 && count[i + 1] > 0 && count[i + 2] > 0) {
                    int loc = 0;
                    for (Tile tile : tiles) {
                        if (tile.getNum() == i + loc) {
                            r[loc] = tile;
                            loc++;
                        }
                        if(loc == 3){
                            break;
                        }
                    }
                }
            }
        }

        return r;
    }

    /**
     * Find one pung
     *
     * @param tiles
     * @return tile array
     */
    public static Tile[] findPung(List<Tile> tiles) {
        for (int i = 0; i < tiles.size() - 2; i++) {
            if (tiles.get(i).equals(tiles.get(i + 1))
                    && tiles.get(i).equals(tiles.get(i + 2))) {
                return new Tile[]{tiles.get(i), tiles.get(i + 1), tiles.get(i + 2)};
            }
        }

        return new Tile[]{null};
    }

    /**
     * Find one kong
     *
     * @param tiles
     * @return tile array
     */
    public static Tile[] findKong(List<Tile> tiles) {
        for (int i = 0; i < tiles.size() - 3; i++) {
            if (tiles.get(i).equals(tiles.get(i + 1))
                    && tiles.get(i).equals(tiles.get(i + 2))
                    && tiles.get(i).equals(tiles.get(i + 3))) {
                return new Tile[]{tiles.get(i), tiles.get(i + 1), 
                    tiles.get(i + 2), tiles.get(i + 3)};
            }
        }

        return new Tile[]{null};
    }
    
    public static List<Tile> copyTiles(List<Tile> tiles){
        List<Tile> newTiles = new LinkedList<>();
        
        for(Tile t: tiles){
            newTiles.add(new Tile(t.getNum(), t.getType()));
        }       
        
        return newTiles;
    }

    public static int indexOf(Object[] array, Object o) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == o) {
                return i;
            }
        }

        return -1;
    }

    public static String appendSpace(String pStr, int length) {
        StringBuilder buf = new StringBuilder();
        buf.append(pStr);
        while (buf.length() < length) {
            buf.append(" ");
        }

        return buf.toString();
    }

    public static boolean canChow(List<Tile> tiles, Tile tile) {
        List<Tile> allTiles = new ArrayList<>();
        allTiles.addAll(tiles);
        allTiles.add(tile);
        Collections.sort(allTiles);
        
        return hasChow(tiles);
    }

    public static boolean canPung(List<Tile> tiles, Tile tile) {
        List<Tile> allTiles = new ArrayList<>();
        allTiles.addAll(tiles);
        allTiles.add(tile);
        Collections.sort(allTiles);
        
        return hasPung(tiles);
    }

    public static boolean canKong(List<Tile> tiles, Tile tile) {
        List<Tile> allTiles = new ArrayList<>();
        allTiles.addAll(tiles);
        allTiles.add(tile);
        Collections.sort(allTiles);
        
        return hasKong(tiles);
    }
}
