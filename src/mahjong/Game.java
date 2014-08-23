package mahjong;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import mahjong.loggers.GameLogger;
import mahjong.rules.Judger;
import mahjong.tiles.DroppedTile;
import mahjong.tiles.Tile;
import mahjong.tiles.TileGenerator;

/**
 *
 * @author jeky
 */
public class Game {

    public Game(TileGenerator generator, Judger judger, GameLogger logger) {
        this.judger = judger;
        this.logger = logger;

        this.tiles = generator.initTiles();
        logger.debug("Finish init tiles: " + tiles);
        this.dropPool = new LinkedList<>();
        this.players = new LinkedList<>();
        this.playerIndex = 0;
    }

    public boolean addPlayer(Player p) {
        return players.add(p);
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public Player removePlayer(int index) {
        return players.remove(index);
    }

    public void init() {
        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);
            p.setGame(this);
            p.setScore(judger.getDefaultScore());
            for (int j = 0; j < 13; j++) {
                p.pick(tiles.poll());
            }
            p.setDirection(Direction.values()[i]);
        }
        currentPlayer().pick(getOneTile());
    }

    public boolean finish() {
        boolean finish = judger.canFinish(this);
        if (finish) {
            Player winner = judger.getWinner();
            if (winner == null) {
                judger.setScores(players, currentPlayer(), GameLogger.Action.DRAW_END);
                logger.logAction(GameLogger.Action.DRAW_END, null, null);
            } else {
                judger.setScores(players, currentPlayer(), GameLogger.Action.END);
                logger.logAction(GameLogger.Action.DRAW_END, currentPlayer(), null);
            }
            StringBuilder buf = new StringBuilder();
            buf.append("STATUS");
            while (buf.length() < 10) {
                buf.append(" ");
            }
            buf.append(": ");
            for (Player p : players) {
                buf.append(p.getName()).append("[").append(p.getScore()).append("]  ");
            }

            logger.log(buf.toString());
        }

        return finish;
    }

    public Player currentPlayer() {
        return players.get(playerIndex);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public DroppedTile getLastDroppedTile() {
        return dropPool.getLast();
    }

    public void changePlayer(Player p) {
        playerIndex = players.indexOf(p);
    }

    public void dropPoolAdd(Tile t) {
        logger.logAction(GameLogger.Action.DROP, currentPlayer(), t);
        dropPool.add(new DroppedTile(t, currentPlayer()));
    }

    public void nextRound() {
        playerIndex = (playerIndex + 1) % players.size();
    }

    public Tile getOneTile() {
        logger.logAction(GameLogger.Action.PICK, currentPlayer(), tiles.peek());
        return tiles.poll();
    }

    public int tileCount() {
        return tiles.size();
    }

    public LinkedList<Tile> getTiles() {
        return tiles;
    }

    public boolean checkKong() {
        for(Player p : players){
            if(p != currentPlayer() && Helper.canKong(p.getTiles(), getLastDroppedTile().getTile())){
                return p.kong(getLastDroppedTile());
            }
        }
        
        return false;
    }

    public boolean checkPung() {
        for(Player p : players){
            if(p != currentPlayer() && Helper.canPung(p.getTiles(), getLastDroppedTile().getTile())){
                boolean isPung = p.pung(getLastDroppedTile());
                if(isPung){
                    p.pick(getOneTile());
                }
            }
        }
        
        return false;
    }

    public boolean checkChow() {
        Player next = players.get((playerIndex + 1) % players.size());
        if(Helper.canChow(next.getTiles(), getLastDroppedTile().getTile())){
            return next.chow(getLastDroppedTile());
        }
        
        return false;
    }


    public static enum Direction {

        EAST, SOUTH, WEST, NORTH
    }


    protected final LinkedList<Tile> tiles;
    protected final LinkedList<DroppedTile> dropPool;
    protected final List<Player> players;
    protected final Judger judger;
    protected final GameLogger logger;

    protected int playerIndex;
}
