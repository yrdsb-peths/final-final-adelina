import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerController extends SuperSmoothMover
{
    //constant
    private static final int SPEED = 20;
    //variables
    private GreenfootImage controller = new GreenfootImage ("images/emptyController.PNG");
    int width = 60;
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public PlayerController () {
        controller.scale(width,width);
        setImage (controller);
    }
    public void act()
    {
        // check collision
        int originalX = this.getX();
        int originalY = this.getY();
        
        controlPlayer();
        
        if (getOneIntersectingObject(Counter.class) != null) {
            setLocation (originalX, originalY);
        }
    }
    
    /**
     * use arrows to move the player
     * "a" to get or place down holdable objects
     */
    public void controlPlayer() {
        if (Greenfoot.isKeyDown("left")) {
            setLocation (getX() - SPEED, getY());
        } else if (Greenfoot.isKeyDown("right")) {
            setLocation (getX()+ SPEED, getY());
        } else if (Greenfoot.isKeyDown("up")) {
            setLocation (getX(), getY() - SPEED);
        } else if (Greenfoot.isKeyDown("down")) {
            setLocation (getX(), getY() + SPEED);
        }
        
        if (Greenfoot.isKeyDown("a")) {
            if (!getObjectsInRange(1, Counter.class).isEmpty()) {
                MyWorld world = (MyWorld) getWorld();
                world.getOnion();
            }
        }
    }
    
    /*public void controlPlayer() {
        if (Greenfoot.isKeyDown("left")) {
            setLocation (getX() - SPEED, getY());
        } else if (Greenfoot.isKeyDown("right")) {
            setLocation (getX()+ SPEED, getY());
        } else if (Greenfoot.isKeyDown("up")) {
            setLocation (getX(), getY() - SPEED);
        } else if (Greenfoot.isKeyDown("down")) {
            setLocation (getX(), getY() + SPEED);
        }
        
        if (Greenfoot.isKeyDown("a")) {
            if (!getObjectsInRange(1, Counter.class).isEmpty()) {
                MyWorld world = (MyWorld) getWorld();
                world.getOnion();
            }
        }
    }
    */
}
