package mahjong.tiles;

import mahjong.Player;

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

    protected final Tile tile;
    protected final Player from;
    protected Player to;
}
