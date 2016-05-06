package game;

import game.Game;

public class Launcher {

    private static String title;
    private static int width, height;
    
    public static void main(String[] args) {
        title = "My awesome game";
        width = 700;
        height = 400;
        Game game = new Game(title, width, height);
        game.start();
    }
    
}
