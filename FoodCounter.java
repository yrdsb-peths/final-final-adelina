import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * FoodCounter is a Counter representing a food ingredient station.
 * Different types of food (mushroom, tomato, onion) determine the displayed image.
 * Provide access to the type of food stored on the counter.
 */
public class FoodCounter extends Counter
{
    //variables
    private String type;
    private GreenfootImage mushroomCounter = new GreenfootImage ("images/mushroomCounter.PNG");
    private GreenfootImage tomatoCounter = new GreenfootImage ("images/tomatoCounter.PNG");
    private GreenfootImage onionCounter = new GreenfootImage ("images/onionCounter.PNG");
    private GreenfootImage selectedMushroomCounter = new GreenfootImage ("images/selectedMushroomCounter.PNG");
    private GreenfootImage selectedTomatoCounter = new GreenfootImage ("images/selectedTomatoCounter.PNG");
    private GreenfootImage selectedOnionCounter = new GreenfootImage ("images/selectedOnionCounter.PNG");
    
    int width = 60;
    
    /**
     * Creates a FoodCounter of the given type.
     * @param type the type of food ("mushroom", "tomato", "onion")
     */
    public FoodCounter(String type) {

        this.type = type;
        //set different images according to the vegtable type
        if (type.equals ("mushroom")) {
            mushroomCounter.scale(width, width);
            selectedMushroomCounter.scale(width, width);
            setImage (mushroomCounter);
        } else if (type.equals ("tomato")) {
            tomatoCounter.scale(width, width);
            selectedTomatoCounter.scale(width, width);
            setImage (tomatoCounter);
        } else if (type.equals ("onion")) {
            onionCounter.scale(width, width);
            selectedOnionCounter.scale(width, width);
            setImage (onionCounter);
        }
    }
    
    /**
     * Changes its image when selected.
     */
    public void act()
    {
        // Add your action code here.
        if (type.equals ("mushroom")) {
            if (isSelected()) setImage (selectedMushroomCounter);
            else setImage (mushroomCounter);
        } else if (type.equals ("tomato")) {
            if (isSelected()) setImage (selectedTomatoCounter);
            else setImage (tomatoCounter);
        } else if (type.equals ("onion")) {
            if (isSelected()) setImage (selectedOnionCounter);
            else setImage (onionCounter);
        }
    }
    
    /**
     * Returns the type of food this counter represents.
     * @return type of food as a String
     */
    public String getType() {
        return type;
    }
}
