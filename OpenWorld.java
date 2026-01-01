import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OpenWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OpenWorld extends World
{
    GreenfootImage background = new GreenfootImage ("images/openGameImage.PNG");
    
    public OpenWorld()
    {    
        super(1000, 600, 1); 
        setBackground (background);
    }
}
