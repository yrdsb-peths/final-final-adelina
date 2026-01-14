import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * NormalCounter is a basic Counter with no special functionality.
 */
public class NormalCounter extends Counter
{
    private GreenfootImage normalCounter = new GreenfootImage ("images/normalCounter.PNG");
    private GreenfootImage selectedNormalCounter = new GreenfootImage ("images/selectedNormalCounter.PNG");
    int width = 60;
    
    /**
     * Creates a NormalCounter.
     */
    public NormalCounter() {
        normalCounter.scale(width, width);
        selectedNormalCounter.scale(width, width);
        setImage (normalCounter);
    }
    
    /**
     * Changes its image when selected.
     */
    public void act()
    {
        // check if being selected, if so, change image to selectedNormalCounter
        if (isSelected()) setImage (selectedNormalCounter);
        else setImage (normalCounter);
    }
}
