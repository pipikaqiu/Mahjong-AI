package mahjong;

import mahjong.loggers.StdLogger;
import mahjong.ai.DefaultAI;
import mahjong.rules.*;

/**
 *
 * @author jeky
 */
public class GameMain {
    
    public static void main(String[] args) {
        Game game = new Game(new JPGameJudger(), new StdLogger());
        String[] names = {"a", "b", "c", "d"};
        
        for (String name : names) {
            game.addPlayer(new Player(new DefaultAI(), name));
        }
        
        game.init();
                
        while(!game.finish()){
            Tile t = game.currentPlayer().drop();
            game.dropPoolAdd(t);
            
            boolean picked = false;
            
            for(Player p : game.getPlayers()){
                if(p != game.currentPlayer() && p.wannaPickFromOther()){
                    game.changePlayer(p);
                    p.pick(game.getLastDroppedTile());
                    picked = true;
                }
            }
            
            if(!picked){
                game.nextRound();
                game.currentPlayer().pick(game.getOneTile());
            }
        }
    }
    
}
