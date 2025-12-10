import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerImage extends Actor
{
    public PlayerImage() {
        setImage("images/playerBlueFront.PNG");
    }
    /**
     * Act - do whatever the PlayerImage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        moveWithPlayerController();
    }
    
    /**
     * player image is covered on top of the invisible controller
     * so that when the controller collide with the counter, 
     * its upper half may overlap the counter image to appear to be closer to it
     */
    private int offSet = 35;
    public void moveWithPlayerController () {
        MyWorld world = (MyWorld) getWorld();
        setLocation (world.player.getX(), world.player.getY()-offSet);
    }
}
