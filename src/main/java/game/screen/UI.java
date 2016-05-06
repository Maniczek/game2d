package game.screen;

import game.components.LabelTempl;
import game.components.MyComponent;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;

public class UI extends JPanel {
    
    BufferedImage img;
    List<Component> ui = new LinkedList<>();
    
    public UI() {
        super();
        init();
    }

    private void init() {
        this.setDoubleBuffered(true);
        this.setOpaque(false);
        MyComponent tmp = new LabelTempl("ahoj", 300, 100);
        
        this.add(tmp);
        this.addMouseListener(tmp);
    }

    public void tick() {
        
    }
    
    @Override
    public void paintComponents(Graphics g) {
        for (Component c : this.getComponents()) {
            MyComponent d = (MyComponent) c;
            d.tick();
            d.paint(g);
        }
        //g.setColor(Color.black);
        //g.fillRect(200, 50, 100, 100);
        //super.paintComponents(g);
    }
    
    
}
