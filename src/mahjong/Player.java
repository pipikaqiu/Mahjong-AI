package mahjong;

import mahjong.tiles.Tile;
import mahjong.tiles.DroppedTile;
import java.util.*;
import mahjong.ai.AI;

/**
 *
 * @author jeky
 */
public class Player {

    public Player(AI ai, String name) {
        this.ai = ai;
        this.name = name;
        this.tiles = new ArrayList<>();

        this.meldedTiles = new LinkedList<>();
    }

    public void pick(Tile t) {
        tiles.add(t);
        Collections.sort(tiles);
    }

    public boolean kong(DroppedTile lastDroppedTile) {
        Tile[] others = ai.wannaKong(game, this, lastDroppedTile);
        return afterMeld(others, lastDroppedTile);
    }

    public boolean pung(DroppedTile lastDroppedTile) {
        Tile[] others = ai.wannaPung(game, this, lastDroppedTile);
        return afterMeld(others, lastDroppedTile);
    }

    public boolean chow(DroppedTile lastDroppedTile) {
        Tile[] others = ai.wannaChow(game, this, lastDroppedTile);
        return afterMeld(others, lastDroppedTile);
    }

    private boolean afterMeld(Tile[] others, DroppedTile lastDroppedTile) {
        if (others != null) {
            meldedTiles.addAll(Arrays.asList(others));
            meldedTiles.add(lastDroppedTile.getTile());
            lastDroppedTile.meld(this);
            return true;
        }

        return false;
    }

    public Tile drop() {
        Tile t = ai.chooseWorst(game, this, tiles);
        tiles.remove(t);

        return t;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Game.Direction getDirection() {
        return direction;
    }

    public void setDirection(Game.Direction direction) {
        this.direction = direction;
    }

    public boolean isMelded() {
        return !meldedTiles.isEmpty();
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    @Override
    public String toString() {
        return name + tiles;
    }

    public String getName() {
        return name;
    }

    private final AI ai;
    private final String name;
    private final List<Tile> tiles;
    private final List<Tile> meldedTiles;
    private int score;
    private Game.Direction direction;
    private Game game;
}
