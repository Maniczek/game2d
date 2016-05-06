package game.components;

import game.gfx.font.FontStyle;
import game.utils.Utils;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class LabelTempl extends MyComponent {

    private String label;
    private BufferedImage img;

    public LabelTempl(String label, int x, int y) {
        super(x, y, 1, 1);
        this.label = label;
        img = Utils.textToGraphics(label, new FontStyle(20, Color.black));
        updateSize();
    }
    
    @Override
    public void tick() {
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
        g.drawImage(img, x, y, width, height, null);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1 && bounds.contains(e.getLocationOnScreen())) {
            if (!"Clicked".equals(label)) {
                setLabel("Clicked");
            } else {
                setLabel("Original");
            }
        }
    }

    private void updateSize() {
        changeSize(img.getWidth(), img.getHeight());
    }
    
    public void setLabel(String label) {
        this.label = label;
        this.img = Utils.textToGraphics(label, new FontStyle(20, Color.black));
        updateSize();
    }
    
}
