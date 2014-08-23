package mahjong.rules;

import java.util.LinkedList;
import java.util.List;
import mahjong.Game;
import mahjong.Helper;
import mahjong.Player;
import mahjong.tiles.Tile;
import mahjong.loggers.GameLogger;
import mahjong.rules.DefaultWinPattern;
import mahjong.rules.Judger;
import mahjong.rules.SevenPairWinPattern;
import mahjong.rules.ThirteenOrphansWinPattern;
import mahjong.rules.WinPattern;

/**
 *
 * @author jeky
 */
public class JPGameJudger extends Judger {

    public JPGameJudger() {
        winPatterns.add(new DefaultWinPattern());
        winPatterns.add(new SevenPairWinPattern());
        winPatterns.add(new ThirteenOrphansWinPattern());
    }

    @Override
    public boolean canFinish(Game game) {
        if (game.tileCount() <= 14) {
            return true;
        }

        for (WinPattern pattern : winPatterns) {
            List<Tile> tiles = Helper.copyTiles(game.currentPlayer().getTiles());
            if (pattern.match(tiles)) {
                currentWinPattern = pattern;
                return true;
            }
        }

        return false;
    }

    @Override
    public int getDefaultScore() {
        return 25000;
    }

    @Override
    public void setScores(List<Player> players, Player currentPlayer, GameLogger.Action action) {
    }

}
