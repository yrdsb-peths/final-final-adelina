import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Order here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Order extends Actor
{
    private GreenfootImage tomatoSoupOrder = new GreenfootImage ("images/tomatoSoupOrder.PNG");
    private GreenfootImage mushroomSoupOrder = new GreenfootImage ("images/mushroomSoupOrder.PNG");
    private GreenfootImage onionSoupOrder = new GreenfootImage ("images/onionSoupOrder.PNG");
    private int width = 120;
    private int height = 90;
    
    public Order() {
        tomatoSoupOrder.scale(width, height);
        mushroomSoupOrder.scale(width, height);
        onionSoupOrder.scale(width, height);
    }
    public void act()
    {
        // Add your action code here.
    }
}
