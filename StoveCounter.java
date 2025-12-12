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
    private GreenfootImage startingPot = new GreenfootImage("images/emptyPot.PNG");
    private GreenfootImage currentPot = new GreenfootImage("images/emptyPot.PNG");
    int offset = 5;
    int width = 60;
    
    public StoveCounter() {
        stoveCounter.scale(width, width);
        selectedStoveCounter.scale(width, width);
        setImage (stoveCounter);
        startingPot.scale(width - offset, width - offset);
    }
    /**
     * Act - do whatever the stoveCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        checkIfSelected(selectedStoveCounter, stoveCounter);
        startingPot();
        placeFood();
    }
    public void startingPot()
    {
        stoveCounter.drawImage(startingPot, 1, -8);
    }
    
    public void placeFood()
    {
        if(checkIfSelected == true)
        {
        
        }
    }
}
