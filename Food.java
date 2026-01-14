import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Represents ingredients that can be chopped and added to pots.
 * Responsibilities: Track chopping progress, Manage chopped state, 
 * Provide food type
 */
public class Food extends HoldableObject
{
    protected int requiredCuttingTime = 200;
    protected SimpleTimer cuttingTimer = new SimpleTimer();
    protected SuperStatBar cuttingStatusBar;
    protected Color green = new Color (56, 255, 119);
    protected Color grey = new Color (112, 112, 112);
    
    private boolean hasBeenChopped = false;
    private int currentCuttingTime = 0;
    private String type;
    
    
    
    
    public void act()
    {
        super.act();
    }
    
    /**
     * sets the type of this food.
     *
     * @param type The food type as a string, "mushroom", "onion", or "tomato"
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * Returns the type of this food.
     *
     * @return the food type as a string, "mushroom", "onion", or "tomato"
     */
    public String getType() {
        return type;
    }
    
    public void increaseCurrentCuttingTime() {
        if(cuttingTimer.millisElapsed() >= 5 && currentCuttingTime < requiredCuttingTime)currentCuttingTime += 5;
        else return;
        cuttingTimer.mark();
        
        cuttingStatusBar.update(currentCuttingTime);
    }
    
    protected void addedToWorld(World w) {
        w.addObject(cuttingStatusBar, getX(), getY() + 22);
    }
    /**
     * Checks whether this food has been fully chopped.
     *
     * @return true if chopped, false otherwise
     */
    public boolean hasBeenChopped() {
        return hasBeenChopped;
    }
    
    public boolean hasFinishedChopping() {
        return currentCuttingTime == requiredCuttingTime;
    }
    
    public void setHasBeenChopped(boolean hasBeenChopped) {
        this.hasBeenChopped = hasBeenChopped;
    }
}
