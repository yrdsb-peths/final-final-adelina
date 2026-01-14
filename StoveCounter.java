import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * StoveCounter is a Counter representing a stove for cooking.
 * It automatically spawns a Pot object when added to the world.
 * soup can only be cooked when placed on top stove counters
 */
public class StoveCounter extends Counter
{
    private GreenfootImage stoveCounter = new GreenfootImage ("images/stoveCounter.PNG");
    private GreenfootImage selectedStoveCounter = new GreenfootImage ("images/selectedStoveCounter.PNG");
    
    int width = 60;
    
    /**
     * Creates a StoveCounter.
     */
    public StoveCounter() {
        stoveCounter.scale(width, width);
        selectedStoveCounter.scale(width, width);
        setImage (stoveCounter);
        
    }
    
    /**
     * Changes its image when selected.
     */
    public void act()
    {
        if (isSelected()) setImage (selectedStoveCounter);
        else setImage (stoveCounter);
    }
    
    /**
     * Called when this counter is added to the world.
     * Automatically adds a Pot object at the stove's location.
     * @param w the world this counter was added to
     */
    protected void addedToWorld(World w)
    {
        Pot pot = new Pot();

        // add pot at the stove's position
        w.addObject(pot, getX(), getY());
        this.setObjectOnTop(pot);
    }
}
