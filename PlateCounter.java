import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlateCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlateCounter extends Counter
{
    private GreenfootImage plateCounter = new GreenfootImage ("images/plateCounter.PNG");
    private GreenfootImage selectedPlateCounter = new GreenfootImage ("images/selectedPlateCounter.PNG");
    
    int width = 60;
    
    public PlateCounter() {
        plateCounter.scale(width, width);
        selectedPlateCounter.scale(width, width);
        setImage (plateCounter);
    }
    
    public void act()
    {
        checkIfSelected(selectedPlateCounter, plateCounter);
        
    }
}
