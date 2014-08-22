package mahjong.rules;

import java.util.LinkedList;
import java.util.List;
import mahjong.Game;
import mahjong.Player;
import mahjong.loggers.GameLogger;

/**
 *
 * @author jeky
 */
public abstract class Judger {
    
    public Judger(){
        this.winPatterns = new LinkedList<>();
    }

    public abstract boolean canFinish(Game game);

    public abstract int getDefaultScore();

    public Player getWinner() {
        return winner;
    }

    public abstract void setScores(List<Player> players, Player currentPlayer, GameLogger.Action action);

    protected List<WinPattern> winPatterns;
    protected Player winner;
    protected WinPattern currentWinPattern;
}
