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
        controlPlayer();
    }
    
    /**
     * use arrows to move the player
     * "a" to get or place down holdable objects
     */
    public void controlPlayer() {
        int newX = getX();
        int newY = getY();
    
        if (Greenfoot.isKeyDown("left"))  newX -= SPEED;
        if (Greenfoot.isKeyDown("right")) newX += SPEED;
        if (Greenfoot.isKeyDown("up"))    newY -= SPEED;
        if (Greenfoot.isKeyDown("down"))  newY += SPEED;
    
        // Check BEFORE moving
        if (!willCollide(newX, newY)) {
            setLocation(newX, newY);
        }
    }

    private boolean willCollide(int nextX, int nextY) {

        // Temporarily move to next position
        int oldX = getX();
        int oldY = getY();
        setLocation(nextX, nextY);
    
        Actor counter = getOneIntersectingObject(Counter.class);
    
        // Move back immediately
        setLocation(oldX, oldY);
    
        return counter != null;
    }
}
