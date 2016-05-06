package game.screen;

import game.components.MyComponent;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Screen {
    
    private JFrame frame;
    //private Canvas canvas;
    private JPanel canvas;
    private UI ui;
    
    private String title;
    private int width, height;

    public Screen(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        
        createDisplay();
    }
    
    private void createDisplay() {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        
        //canvas = new Canvas();
        canvas = new JPanel();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);
        canvas.setVisible(true);
        
        ui = new UI();
        ui.setPreferredSize(new Dimension(width, height));
        ui.setMaximumSize(new Dimension(width, height));
        ui.setMinimumSize(new Dimension(width, height));
        ui.setFocusable(false);
        //ui.setOpaque(true);
        //ui.setBackground(new Color(0, 255, 0, 20));
        
        
        
        //frame.getContentPane().add(canvas);
        //frame.getContentPane().add(ui);
        frame.add(canvas);
        frame.add(ui);
        frame.pack();
    }

    public JFrame getFrame() {
        return frame;
    }

    public JPanel getCanvas() {
        return canvas;
    }

    public UI getUi() {
        return ui;
    }
 
    
    
}
