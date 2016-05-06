package game.gfx.font;

import java.awt.Color;
import java.awt.Font;

public class FontStyle {
 public static final int DEFAULT_SIZE = 28, DEFAULT_STYLE = Font.PLAIN;
    public static final String DEFAULT_FONTNAME = "Arial";
    public static final Color DEFAULT_COLOR = Color.RED;
    
    private String fontName;
    private int size;
    private Color color;
    private int style;

    public FontStyle(String fontName, int size, Color color, int style) {
        this.fontName = fontName;
        this.size = size;
        this.color = color;
        this.style = style;
    }

    public FontStyle() {
        fontName = DEFAULT_FONTNAME;
        size = DEFAULT_SIZE;
        color = DEFAULT_COLOR;
        style = DEFAULT_STYLE;
    }

    public FontStyle(String fontName, int size, Color color) {
        this.fontName = fontName;
        this.size = size;
        this.color = color;
        this.style = DEFAULT_STYLE;
    }

    public FontStyle(int size, Color color) {
        this.size = size;
        this.color = color;
        this.fontName = DEFAULT_FONTNAME;
        this.style = DEFAULT_STYLE;
    }

    /**
     * @return name of the font 
     */
    public String getFontName() {
        return fontName;
    }

    /**
     * @return size of font 
     */
    public int getSize() {
        return size;
    }

    /**
     * @return color of the font 
     */
    public Color getColor() {
        return color;
    }

    /**
     * @return get style of font 
     */
    public int getStyle() {
        return style;
    }

    /**
     * changes name of this font
     * @param fontName 
     */
    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    /**
     * changes size of this font
     * @param size 
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * changes color of this font
     * @param color 
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * changes style of this font
     * @param style 
     */
    public void setStyle(int style) {
        this.style = style;
    }
    
    
    
    
}
