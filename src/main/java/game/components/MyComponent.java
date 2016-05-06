package game.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JComponent;

public abstract class MyComponent extends JComponent implements MouseListener, MouseMotionListener {

    protected boolean hovered;
    protected int x, y;
    protected int width, height;
    protected Rectangle bounds;
    
    public MyComponent(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        bounds = new Rectangle(x, y, width, height);
    }

    public abstract void tick();
    
    @Override
    public abstract void paint(Graphics g);
    
    @Override
    public abstract void mouseClicked(MouseEvent e);
    
    private void refreshBounds() {
        bounds.x = this.x;
        bounds.y = this.y;
        bounds.width = this.width;
        bounds.height = this.height;
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
        hovered = bounds.contains(e.getLocationOnScreen());
    }
    
    public boolean isHovered() {
        return hovered;
    }

    public void changeSize(Dimension d) {
        changeSize(d.width, d.height);
    }
    
    public void changeSize(int width, int height) {
        this.width = width;
        this.height = height;
        refreshBounds();
    }
    

}
