import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tomato is a Food item that can be chopped into a tomato ingredient.
 */
public class Tomato extends Food
{    
    private GreenfootImage tomato = new GreenfootImage ("images/tomato.PNG");
    public GreenfootImage choppedTomato = new GreenfootImage ("images/choppedTomato.PNG");
    int width = 80;
    int width2 = 60;
    
    /**
     * Creates a Tomato with default images and chopping settings.
     */
    public Tomato() {
        tomato.scale(width, width);
        choppedTomato.scale(width2, width2);
        setImage (tomato);
        
        this.setType("tomato");
        cuttingTimer.mark();
        cuttingStatusBar = new SuperStatBar(requiredCuttingTime, 0, this, 50, 10, 22, green, grey, true);
        cuttingStatusBar.setToInvisible();
        
    }
    
}
