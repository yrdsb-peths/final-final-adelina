import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Onion is a Food item that can be chopped into an onion ingredient.
 */
public class Onion extends Food
{
    private GreenfootImage onion = new GreenfootImage("images/onion.PNG");
    public GreenfootImage choppedOnion = new GreenfootImage ("images/choppedOnion.PNG");
    int width = 80;
    int width2 = 60;
    
    /**
     * Creates an Onion with default images and chopping settings.
     */
    public Onion() {
        onion.scale(width, width);
        choppedOnion.scale(width2, width2);
        setImage (onion);
        
        this.setType("onion");
        cuttingTimer.mark();
        cuttingStatusBar = new SuperStatBar(requiredCuttingTime, 0, this, 50, 10, 22, green, grey, true);
        cuttingStatusBar.setToInvisible();
        
    }
    
}
