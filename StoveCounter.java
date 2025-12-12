import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class stoveCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StoveCounter extends Counter
{
    private GreenfootImage stoveCounter = new GreenfootImage ("images/stoveCounter.PNG");
    private GreenfootImage selectedStoveCounter = new GreenfootImage ("images/selectedStoveCounter.PNG");
    private GreenfootImage emptyPot = new GreenfootImage("images/emptyPot.PNG");
    private Pots pots = new Pots();
    int offset = 5;
    int width = 60;
    
    public StoveCounter() {
        stoveCounter.scale(width, width);
        selectedStoveCounter.scale(width, width);
        setImage (stoveCounter);
        emptyPot.scale(width - offset, width - offset);
        startingPot();
    }
    /**
     * Act - do whatever the stoveCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        checkIfSelected(selectedStoveCounter, stoveCounter);
        placeFood();
    }
    public void startingPot()
    {
        stoveCounter.drawImage(emptyPot, 1, -8);
    }
    
    public void placeFood()
    {
        if(isSelected)
        {
            World world = getWorld();
            world.addObject(pots, getX(), getY());
        }
    }
}
