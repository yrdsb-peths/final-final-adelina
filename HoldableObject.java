import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * HoldableObject is the base class for all objects that can be picked up
 * and carried by a player.
 * 
 * Examples include food items, plates, and pots.
 */
public class HoldableObject extends Actor
{
    private boolean isBeingHeld;
    
    /**
     * Moves this object to the same location as the given player.
     * Used when the object is being held.
     *
     * @param player the player holding this object
     */
    public void moveWithPlayer(PlayerController player) {
        setLocation (player.getX(), player.getY());
    }
    
    /**
     * Sets whether this object is currently being held by a player.
     *
     * @param isBeingHeld true if the object is held, false otherwise
     */
    public void setIsBeingHeld(boolean isBeingHeld) {
        this.isBeingHeld = isBeingHeld;
    }
    
    /**
     * Returns whether this object is currently being held.
     *
     * @return true if being held, false otherwise
     */
    public boolean getIsBeingHeld() {
        return isBeingHeld;
    }
    
}
