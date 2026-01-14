import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * LevelButton represents a selectable level button in the level menu.
 */
public class LevelButton extends Actor
{
    GreenfootImage level1Unlocked = new GreenfootImage ("images/level1Unlocked.PNG");
    GreenfootImage level2Unlocked = new GreenfootImage ("images/level2Unlocked.PNG");
    GreenfootImage level3Unlocked = new GreenfootImage ("images/level3Unlocked.PNG");
    GreenfootImage level2Locked = new GreenfootImage ("images/level2Locked.PNG");
    GreenfootImage level3Locked = new GreenfootImage ("images/level3Locked.PNG");
    
    private int level;
    private boolean unlocked;
    
    /**
     * Creates a LevelButton for a specific level.
     *
     * @param level the level number
     * @param unlocked whether the level is unlocked
     */
    public LevelButton(int level, boolean unlocked) {
        this.level = level;
        this.unlocked = unlocked;
        
        if (level == 1) {
            setImage (level1Unlocked);
        } else if (level == 2) {
            if (unlocked) setImage(level2Unlocked);
            else setImage (level2Locked);
        } else if (level == 3) {
            if (unlocked) setImage(level3Unlocked);
            else setImage (level3Locked);
        }
    }
    
     /**
     * Returns whether this level is unlocked.
     *
     * @return true if unlocked, false otherwise
     */
    public boolean isUnlocked() {
        return unlocked;
    }
}
