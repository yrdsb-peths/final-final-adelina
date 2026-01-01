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
    
    private String text;
    private int width;
    private int height;
    private Color color;
    private int fontSize;
    
    public Button(String text, int width, int height, Color color, int fontSize) {
        this.text = text;
        this.width = width;
        this.height = height;
        this.color = color;
        this.fontSize = fontSize;
        
        button = new GreenfootImage (width, height);
        button.setColor (color);
        button.fill();
        
        setImage (button);
    }
    
    public void addedToWorld(World w) {
        Label label = new Label(text, fontSize);
        w.addObject(label, getX(), getY());
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
