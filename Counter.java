import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Counter is the base class for all counters in the kitchen.
 * Counters can hold objects, be selected by players, and change appearance based on selection.
 * 
 * Responsibilities:
 * - Track an object placed on top.
 * - Determine if the counter is currently selected by any player.
 * - Update the displayed image based on selection state.
 * - Provide utility methods for interaction with holdable objects.
 */
public class Counter extends Actor
{
    private HoldableObject objectOnTop = null;
    public boolean isSelected = false;
    public Counter(){
    }
    
    /**
     * Checks if this counter is currently selected by a player.
     * @return true if selected, false otherwise
     */
    public boolean isSelected (){
        MyWorld world = (MyWorld)getWorld();
        Counter playerBlueSelected = world.playerBlue.getSelectedCounter();
        Counter playerRedSelected = null;
        if (world.playerRed != null) {
             playerRedSelected = world.playerRed.getSelectedCounter();
        }
        
        return this == playerBlueSelected || this == playerRedSelected;
        
    }
    
    /**
     * Changes the displayed image based on selection state.
     * @param selectedImage image to show when selected
     * @param normalImage image to show when not selected
     */
    public void changeToSelectedImage(GreenfootImage selectedImage, GreenfootImage normalImage) {
        // if one of the players has selected the counter, change image to selected
        if (isSelected()){
            setImage(selectedImage);
            isSelected = true;
        } else {
            setImage(normalImage);
            isSelected = false;
        }
    }
    
    /**
     * Sets an object on top of this counter.
     * @param object the HoldableObject to place on top
     */
    public void setObjectOnTop(HoldableObject object) {
        objectOnTop = object;
    }
    
    /**
     * Returns the object currently on top of this counter.
     * @return the HoldableObject on top, or null if none
     */
    public HoldableObject getObjectOnTop() {
        return objectOnTop;
    }
}
