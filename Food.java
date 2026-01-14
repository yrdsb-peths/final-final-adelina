import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Food here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    
    public void setType(String type) {
        this.type = type;
    }
    
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
