package mahjong;

import mahjong.tiles.Tile;
import mahjong.rules.JPGameJudger;
import mahjong.loggers.StdLogger;
import mahjong.ai.DefaultAI;
import mahjong.tiles.*;

/**
 *
 * @author jeky
 */
public class GameMain {

    public static void main(String[] args) {
        Game game = new Game(new JPTileGenerator(), new JPGameJudger(), new StdLogger());
        String[] names = {"a", "b", "c", "d"};

        for (String name : names) {
            game.addPlayer(new Player(new DefaultAI(), name));
        }

        game.init();

        while (!game.finish()) {
            Tile t = game.currentPlayer().drop();
            game.dropPoolAdd(t);

            boolean picked = game.checkKong() && game.checkPung() && game.checkChow();

            if (!picked) {
                game.nextRound();
                game.currentPlayer().pick(game.getOneTile());
            }
        }
    }

}
