package game;

import game.screen.Screen;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game {

    //GAME ENVIROMENT VARIABLES
    private final int FPS = 120;

    //Game screen 
    private Screen screen;
    private String title;
    private int width, height;
    
    private int x,y;
    
    //Render
    private BufferStrategy bs;
    private Graphics g;

    //Loop vars
    private boolean running;
    private volatile boolean rendered = false;
    private volatile boolean timeToChange = false;
    
    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        x = y = 0;
    }
    
    private void init() {
        screen = new Screen(title, width, height);
        
    }
    
    private synchronized void tick() {
        screen.getUi().tick();
        move();
    }
    
    private void move() {
        Random rnd = new Random();
        int tmp = rnd.nextInt(1000);
        if (tmp % 3 == 0) x++;
        if (tmp % 4 == 0) y++;
        if (tmp % 6 == 0) y--;
        if (tmp % 8 == 0) x--;
    } 
    
    private synchronized void render() {
        bs = screen.getFrame().getBufferStrategy();
        //bs = screen.getCanvas().getBufferStrategy();
        if (bs == null) {
            //screen.getCanvas().createBufferStrategy(3);
            screen.getFrame().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //clear screen
        g.clearRect(0, 0, width, height);
        //start drawing
        g.setColor(Color.red);
        g.fillRect(x, y, 100, 100);
        screen.getUi().paintComponents(g);
        //stop drawing
        bs.show();
        g.dispose();        
    }
    
    public void start() {
        if (running) return;
        running = true;
        rendered = true; // first time need to set true, fps controls how many time it should have been looped
        
        init();
        fpsLimiterThread();
        loopThread();        
    }
    
    public void stop() {
        if (!running) return;
        running = false;
    }
    
    private void fpsLimiterThread() {
        new Thread(() -> {
            double timePerTick = 1000000000 / FPS;
            double delta = 0;
            long now;
            long lastTime = System.nanoTime();
            long timer = 0;
            int ticks = 0;

            while (running) {
                now = System.nanoTime();
                delta += (now - lastTime) / timePerTick;
                timer += now - lastTime;
                lastTime = now;

                if (delta >= 1 && rendered) {
                    timeToChange = true;
                    rendered = false;
                    delta--;
                    ticks++;
                }

                if (timer >= 1000000000) {
                    System.out.println(ticks);
                    timer = 0;
                    ticks = 0;
                }
            }
        }).start();
    }

    private void loopThread() {
        new Thread(() -> {
            while (running) {
                if (timeToChange) {
                    tick();
                    render();
                    timeToChange = false;
                    rendered = true;
                }
            }
        }).start();
    }   
    
}
