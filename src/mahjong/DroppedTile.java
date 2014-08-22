package mahjong;

/**
 *
 * @author jeky
 */
public class DroppedTile {

    public DroppedTile(Tile tile, Player from) {
        this.tile = tile;
        this.from = from;
    }

    public Tile getTile() {
        return tile;
    }

    public Player getFrom() {
        return from;
    }

    public Player getTo() {
        return to;
    }

    public boolean isMelded() {
        return this.to != null;
    }

    public void meld(Player p) {
        this.to = p;
    }

    @Override
    public String toString() {
        return "from: " + from + " [" + tile + "]";
    }

    private final Tile tile;
    private final Player from;
    private Player to;
}
