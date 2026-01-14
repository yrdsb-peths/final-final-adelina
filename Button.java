import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button represents a clickable rectangular button in the game.
 * The button is rendered with a solid color and a specified width and height.
 */
public class Button extends Actor
{
    private GreenfootImage button;
    
    private int width;
    private int height;
    private Color color;
    
    /**
     * Creates a new Button with specified width, height, and color.
     * @param width the width of the button in pixels
     * @param height the height of the button in pixels
     * @param color the fill color of the button
     */
    public Button(int width, int height, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;
        
        button = new GreenfootImage (width, height);
        button.setColor (color);
        button.fill();
        
        setImage (button);
    }
    
}
