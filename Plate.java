import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Stores cooked soup and allows delivery to orders.
 */
public class Plate extends HoldableObject
{
    private GreenfootImage emptyPlate = new GreenfootImage ("images/emptyPlate.PNG");
    private GreenfootImage tomatoSoupPlate = new GreenfootImage ("images/tomatoSoupPlate.PNG");
    private GreenfootImage onionSoupPlate = new GreenfootImage ("images/onionSoupPlate.PNG");
    private GreenfootImage mushroomSoupPlate = new GreenfootImage ("images/mushroomSoupPlate.PNG");
    int width = 60;
    int height = 80;
    
    private boolean isEmpty;
    private String type;
    
    /**
     * Creates an empty Plate.
     */
    public Plate() {
        emptyPlate.scale(width, height);
        tomatoSoupPlate.scale(width, height);
        onionSoupPlate.scale(width, height);
        mushroomSoupPlate.scale(width, height);
        
        setImage(emptyPlate);
        isEmpty = true;
    }
    
    /**
     * Checks whether the plate is empty.
     *
     * @return true if empty
     */
    public boolean isEmpty() {
        return isEmpty;
    }
    
    /**
     * Sets the soup type currently on the plate.
     *
     * @param type the soup type
     */
    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * Changes the plate image to tomato soup.
     */
    public void setImageToTomatoSoupPlate() {
        setImage (tomatoSoupPlate);
    }
    
    /**
     * Changes the plate image to onion soup.
     */
    public void setImageToOnionSoupPlate() {
        setImage (onionSoupPlate);
    }
    
    /**
     * Changes the plate image to mushroom soup.
     */
    public void setImageToMushroomSoupPlate() {
        setImage (mushroomSoupPlate);
    }
    
    /**
    * Sets whether the plate is empty.
    *
    * @param isEmpty true if empty, false otherwise
    */
    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }
    
    /**
     * Returns the type of soup on this plate.
     *
     * @return soup type
     */
    public String getType() {
        return type;
    }
}
