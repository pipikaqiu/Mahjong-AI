package mahjong.tiles;

/**
 *
 * @author jeky
 */
public class JPTile extends Tile {

    public JPTile(int num, String type, boolean red) {
        super(num, type);
        this.red = red;
    }

    public JPTile(String type) {
        super(type);
        this.red = false;
    }

    public boolean isRed() {
        return red;
    }

    @Override
    public String toString() {
        return (red ? "r" : "" )+ super.toString();
    }

    private final boolean red;

}
