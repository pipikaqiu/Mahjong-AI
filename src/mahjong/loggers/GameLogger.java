package mahjong.loggers;

import mahjong.Player;
import mahjong.Tile;

/**
 *
 * @author jeky
 */
public interface GameLogger {
    
    public void log(String msg);

    public void debug(String msg);

    public void logAction(Action action, Player player, Tile t);

    public static enum Action{
        DROP, PICK, DRAW_END, END
    }
}
