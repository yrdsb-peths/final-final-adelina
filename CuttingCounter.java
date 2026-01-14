import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * CuttingCounter is a type of Counter used for chopping ingredients.
 * Changes its image when selected.
 */
public class CuttingCounter extends Counter
{
    private GreenfootImage cuttingCounter = new GreenfootImage ("images/cuttingCounter.PNG");
    private GreenfootImage selectedCuttingCounter = new GreenfootImage ("images/selectedCuttingCounter.PNG");
    
    int width = 60;

    /**
     * Creates a new CuttingCounter image
     */
    public CuttingCounter() {
        cuttingCounter.scale(width, width);
        selectedCuttingCounter.scale(width, width);
        setImage (cuttingCounter);
    }
    
    /**
     * Changes its image when selected.
     */
    public void act()
    {
        if (isSelected()) setImage(selectedCuttingCounter);
        else setImage (cuttingCounter);
    }
}
