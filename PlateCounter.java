import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * PlateCounter is a Counter that holds plates.
 * plate will regenerate on top of this counter
 * player can retrieve plate from this counter
 */
public class PlateCounter extends Counter
{
    private GreenfootImage plateCounter = new GreenfootImage ("images/plateCounter.PNG");
    private GreenfootImage selectedPlateCounter = new GreenfootImage ("images/selectedPlateCounter.PNG");
    
    int width = 60;
    
    int numPlateOnTop = 0;
    
    /**
     * Creates a PlateCounter.
     */
    public PlateCounter() {
        plateCounter.scale(width, width);
        selectedPlateCounter.scale(width, width);
        setImage (plateCounter);
    }
    
    /**
     * Changes its image when selected.
     */
    public void act()
    {
        if (isSelected()) setImage (selectedPlateCounter);
        else setImage (plateCounter);
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
