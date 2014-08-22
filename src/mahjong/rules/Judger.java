package mahjong.rules;

import java.util.List;
import mahjong.Game;
import mahjong.Player;
import mahjong.loggers.GameLogger;

/**
 *
 * @author jeky
 */
public interface Judger {

    public boolean canFinish(Game game);

    public int getDefaultScore();

    public Player getResult();

    public void setScores(List<Player> players, Player currentPlayer, GameLogger.Action action);
    
}
