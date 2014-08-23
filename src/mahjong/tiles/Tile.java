package mahjong.tiles;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Tile in Mahjong Game. If it has suit(s,m,p), it will also has number.
 * Otherwise it will only has type.
 *
 * @author jeky
 */
public class Tile implements Comparable<Tile> {

    public static final String CHARACTER = "m";
    public static final String DOT = "p";
    public static final String BAMBOO = "s";
    public static final String EAST = "E";
    public static final String SOUTH = "S";
    public static final String WEST = "W";
    public static final String NORTH = "N";
    public static final String WHITE = "P";
    public static final String GREEN = "F";
    public static final String RED = "C";

    public static final String[] SUITS = new String[]{CHARACTER, DOT, BAMBOO};
    public static final String[] OTHER_TYPES = new String[]{EAST, SOUTH, WEST, NORTH, WHITE, GREEN, RED};

    public Tile(int num, String type) {
        this.num = num;
        this.type = type;
    }

    public Tile(String type) {
        this(0, type);
    }

    public int getNum() {
        return num;
    }

    public String getType() {
        return type;
    }

    public static int getTileIndex(Tile t) {
        return t.num + TYPE_INDEX_MAP.get(t.type);
    }
    @Override
    public int compareTo(Tile t) {
        return getTileIndex(this) - getTileIndex(t);
    }

    @Override
    public int hashCode() {
        return getTileIndex(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tile other = (Tile) obj;
        if (this.num != other.num) {
            return false;
        }
        if (!this.type.equals(other.type)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if (num == 0) {
            return "" + type;
        } else {
            return "" + num + type;
        }
    }
    protected static final Map<String, Integer> TYPE_INDEX_MAP = new HashMap<>();
    static{
        TYPE_INDEX_MAP.put(CHARACTER, -1);
        TYPE_INDEX_MAP.put(DOT, 8);
        TYPE_INDEX_MAP.put(BAMBOO, 17);
        TYPE_INDEX_MAP.put(EAST, 27);
        TYPE_INDEX_MAP.put(SOUTH, 28);
        TYPE_INDEX_MAP.put(WEST, 29);
        TYPE_INDEX_MAP.put(NORTH, 30);
        TYPE_INDEX_MAP.put(WHITE, 31);
        TYPE_INDEX_MAP.put(GREEN, 32);
        TYPE_INDEX_MAP.put(RED, 33);
    }
    protected final int num;
    protected final String type;
}
