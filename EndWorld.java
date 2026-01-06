import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndWorld extends World
{
    GreenfootImage endImage = new GreenfootImage ("images/endImage.PNG");
    
    int level;
    int levelOneRecord;
    int levelTwoRecord;
    
    public EndWorld()
    {    
        super(1000, 600, 1); 
        
        setBackground(endImage);
    }
}
