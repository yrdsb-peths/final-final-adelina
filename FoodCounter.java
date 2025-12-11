import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class foodCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FoodCounter extends Counter
{
    //variables
    private String type;
    private GreenfootImage mushroomCounter = new GreenfootImage ("images/mushroomCounter.PNG");
    private GreenfootImage tomatoCounter = new GreenfootImage ("images/tomatoCounter.PNG");
    private GreenfootImage onionCounter = new GreenfootImage ("images/onionCounter.PNG");
    
    
    public FoodCounter(String type) {

        this.type = type;
        //set different images according to the vegtable type
        if (type.equals ("mushroom")) {
            mushroomCounter.scale(70, 70);
            setImage (mushroomCounter);
        } else if (type.equals ("tomato")) {
            tomatoCounter.scale(70, 70);
            setImage (tomatoCounter);
        } else if (type.equals ("onion")) {
            onionCounter.scale(70, 70);
            setImage (onionCounter);
        }
    }
    /**
     * Act - do whatever the foodCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
