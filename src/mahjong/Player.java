package mahjong;

import java.util.Collections;
import java.util.LinkedList;
import mahjong.ai.AI;

/**
 *
 * @author jeky
 */
public class Player {

    public Player(AI ai, String name) {
        this.ai = ai;
        this.name = name;
        this.tiles = new LinkedList<>();
        this.meld = false;
    }

    public void pick(Tile t) {
        tiles.add(t);
        Collections.sort(tiles);
    }

    public void pick(DroppedTile t) {
        pick(t.getTile());
        t.meld(this);
        meld = true;
    }
    
    public boolean wannaPickFromOther(){
        return ai.wannaPickFromOther(game, game.getLastDroppedTile());
    }
    
    public Tile drop(){
        Tile t = ai.chooseWorst(tiles, game);
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
        return meld;
    }

    public LinkedList<Tile> getTiles() {
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
    private final LinkedList<Tile> tiles;
    private int score;
    private Game.Direction direction;
    private boolean meld;
    private Game game;
}
