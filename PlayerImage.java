import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerImage extends Actor
{
    private static final GreenfootImage FRONT = new GreenfootImage ("images/playerBlueFront.PNG");
    private static final GreenfootImage BACK = new GreenfootImage ("images/playerBlueBack.PNG");
    private static final GreenfootImage LEFT = new GreenfootImage ("images/playerBlueFacingLeft.PNG");
    private static final GreenfootImage RIGHT = new GreenfootImage ("images/playerBlueFacingRight.PNG");
    
    private String facingDirection;
    //image offset in the y direction in relation to the invisible player controller
    private int offSet = 15;
    
    public PlayerImage() {
        rescaleImages (85, 135);
        facingDirection = "front";
        setImage(FRONT);
    }
    /**
     * Act - do whatever the PlayerImage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        moveWithPlayerController();
        changeDirection();
    }
    
    public void rescaleImages(int width, int height) {
        FRONT.scale (width, height);
        BACK.scale (width, height);
        LEFT.scale (width, height);
        RIGHT.scale (width, height);
    }
    
    /**
     * when moving to a direction, change to the corresponding image
     */
    public void changeDirection() {
        if (Greenfoot.isKeyDown("left")) {
            facingDirection = "left";
            setImage(LEFT);
        } else if (Greenfoot.isKeyDown("right")) {
            facingDirection = "right";
            setImage(RIGHT);
        } else if (Greenfoot.isKeyDown("up")) {
            facingDirection = "back";
            setImage(BACK);
        } else if (Greenfoot.isKeyDown("down")) {
            facingDirection = "front";
            setImage(FRONT);
        }
    }
    
    /**
     * player image is covered on top of the invisible controller
     * so that when the controller collide with the counter, 
     * its upper half may overlap the counter image to appear to be closer to it
     */
    public void moveWithPlayerController () {
        MyWorld world = (MyWorld) getWorld();
        setLocation (world.player.getX(), world.player.getY()-offSet);
    }
    
    public String getFacingDirection() {
        return facingDirection;
    }
}
