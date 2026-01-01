import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    private GreenfootImage button;
    
    private int width;
    private int height;
    private Color color;
    
    public Button(int width, int height, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;
        
        button = new GreenfootImage (width, height);
        button.setColor (color);
        button.fill();
        
        setImage (button);
    }
    
    
    public void act()
    {
        // Add your action code here.
    }
}
