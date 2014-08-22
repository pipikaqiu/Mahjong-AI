package mahjong.loggers;

import mahjong.Helper;
import mahjong.Player;
import mahjong.Tile;

/**
 *
 * @author jeky
 */
public class StdLogger implements GameLogger {

    public StdLogger(boolean debug) {
        this.debug = debug;
    }

    public StdLogger() {
        this(false);
    }

    @Override
    public void log(String msg) {
        System.out.println(msg);
    }

    @Override
    public void debug(String msg) {
        if (debug) {
            System.out.println(msg);
        }
    }

    @Override
    public void logAction(Action action, Player player, Tile t) {
        String aStr = action.toString();
        aStr = Helper.appendSpace(aStr, 10);

        String pStr = null;
        if (player != null) {
            pStr = player.toString();
            pStr = Helper.appendSpace(pStr, 54);
        }

        System.out.println(aStr
                + (pStr == null ? "" : ": "+ pStr)
                + (t == null ? "" : ": " + t));
    }
    private final boolean debug;

}
