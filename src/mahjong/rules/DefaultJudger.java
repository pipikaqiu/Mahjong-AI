package mahjong.rules;

import java.util.List;
import mahjong.Game;
import mahjong.Helper;
import mahjong.Player;
import mahjong.Tile;
import mahjong.loggers.GameLogger;

/**
 *
 * @author jeky
 */
public class DefaultJudger implements Judger {

    @Override
    public boolean canFinish(Game game) {
        if(game.tileCount() <= 14){
            return true;
        }
        
        List<Tile> tiles = Helper.copyTiles(game.currentPlayer().getTiles());
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
        } else {
            return false;
        }
    }

    @Override
    public int getDefaultScore() {
        return 25000;
    }

    @Override
    public Player getResult() {
        return null;
    }

    @Override
    public void setScores(List<Player> players, Player currentPlayer, GameLogger.Action action) {
    }

}
