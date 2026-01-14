import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Mushroom is a Food item that can be chopped into a mushroom ingredient.
 */
public class Mushroom extends Food
{
    private GreenfootImage mushroom = new GreenfootImage ("images/mushroom.PNG");
    public GreenfootImage choppedMushroom = new GreenfootImage ("images/choppedMushroom.PNG");
    int width = 80;
    int width2 = 60;
    
    /**
     * Creates a Mushroom with default images and chopping settings.
     */
    public Mushroom() {
        mushroom.scale(width, width);
        choppedMushroom.scale(width2, width2);
        setImage (mushroom);
        
        this.setType("mushroom");
        cuttingTimer.mark();
        cuttingStatusBar = new SuperStatBar(requiredCuttingTime, 0, this, 50, 10, 22, green, grey, true);
        cuttingStatusBar.setToInvisible();
        
    }

}
