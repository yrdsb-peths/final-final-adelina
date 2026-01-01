import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelWorld extends World
{
    GreenfootImage background = new GreenfootImage ("images/levelBackground.PNG");
    LevelButton level1, level2, level3 ;
    
    public LevelWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        setBackground (background);
        
        level1 = new LevelButton (1, true);
        level2 = new LevelButton (2, false);
        level3 = new LevelButton (3, false);
        
        addObject (level1,235, 300);
        addObject (level2,500, 300);
        addObject (level3,765, 300);
        
        Label levels = new Label ("LEVELS", 100);
        addObject(levels, 500, 90);
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(level1)) {
            Greenfoot.setWorld (new MyWorld());
        } else if (Greenfoot.mouseClicked(level2) && level2.isUnlocked()) {
            Greenfoot.setWorld (new MyWorld());
        } else if (Greenfoot.mouseClicked(level3) && level3.isUnlocked()) {
            Greenfoot.setWorld (new MyWorld());
        } 
    }
}
