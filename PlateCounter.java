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
    
    int numPlateOnTop = 0;
    
    public PlateCounter() {
        plateCounter.scale(width, width);
        selectedPlateCounter.scale(width, width);
        setImage (plateCounter);
    }
    
    public void act()
    {
        checkIfSelected(selectedPlateCounter, plateCounter);
        
    }
    
    /**
     * increases the number of plate on top by one
     * generate a plate on top if there is previously none
     */
    public void increaseNumPlateOnTop() {
        numPlateOnTop ++;
        if (this.getObjectOnTop() == null) {
            MyWorld w = (MyWorld) getWorld();
            Plate plate = new Plate();
            setObjectOnTop(plate);
            w.addObject(plate, getX(), getY());
        }
    }
    
    /**
     * decrease the number of plate on top by one
     * if the num on top is not zero, add a new plate
     */
    public void decreaseNumPlateOnTop() {
        numPlateOnTop --;
        
        if (numPlateOnTop > 0) {
            MyWorld w = (MyWorld) getWorld();
            Plate plate = new Plate();
            setObjectOnTop(plate);
            w.addObject(plate, getX(), getY());
        } 
    }
}
