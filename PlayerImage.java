import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Handles the visual representation and animation of the player, separate from gameplay logic.
 * Responsibilities: Display correct facing direction, Play chopping animations, 
 * Follow PlayerController
 */
public class PlayerImage extends Actor
{
    protected GreenfootImage FRONT;
    protected GreenfootImage BACK;
    protected GreenfootImage LEFT;
    protected GreenfootImage RIGHT;
    protected GreenfootImage[] choppingPlayerFront = new GreenfootImage[2];
    protected GreenfootImage[] choppingPlayerBack = new GreenfootImage[2];
    protected GreenfootImage[] choppingPlayerLeft = new GreenfootImage[2];
    protected GreenfootImage[] choppingPlayerRight = new GreenfootImage[2];
    protected int width = 85;
    protected int height = 135;
    protected String facingDirection;
    protected SimpleTimer animationTimer = new SimpleTimer();
    protected PlayerController controller;
    
    //image offset in the y direction in relation to the invisible player controller
    private int offSet = 20;
    private int animationGap = 100;
    private int imageIndex = 0;
    
    
    public PlayerImage() {
        
    }
    
    public void act()
    {
        // Add your action code here.
        moveWithPlayerController();
        changeDirection();
        
    }
    
    /**
     * when moving to a direction, change to the corresponding image
     */
    private void changeDirection() {
        if (Greenfoot.isKeyDown(controller.leftKey)) {
            facingDirection = "left";
            setImage(LEFT);
        } else if (Greenfoot.isKeyDown(controller.rightKey)) {
            facingDirection = "right";
            setImage(RIGHT);
        } else if (Greenfoot.isKeyDown(controller.upKey)) {
            facingDirection = "back";
            setImage(BACK);
        } else if (Greenfoot.isKeyDown(controller.downKey)) {
            facingDirection = "front";
            setImage(FRONT);
        }
    }
    
    /**
     * Plays the chopping animation based on the player's facing direction.
     */
    public void evokeChoppingAnimation() {
        if (facingDirection.equals("front")) {
            if(animationTimer.millisElapsed() < animationGap) {
                return;
            }
            animationTimer.mark();
            
            setImage (choppingPlayerFront[imageIndex]);
            imageIndex = (imageIndex+1) % 2;
        } else if (facingDirection.equals("back")) {
            if(animationTimer.millisElapsed() < animationGap) {
                return;
            }
            animationTimer.mark();
            
            setImage (choppingPlayerBack[imageIndex]);
            imageIndex = (imageIndex+1) % 2;
        } else if (facingDirection.equals("left")) {
            if(animationTimer.millisElapsed() < animationGap) {
                return;
            }
            animationTimer.mark();
            
            setImage (choppingPlayerLeft[imageIndex]);
            imageIndex = (imageIndex+1) % 2;
        } else if (facingDirection.equals("right")) {
            if(animationTimer.millisElapsed() < animationGap) {
                return;
            }
            animationTimer.mark();
            
            setImage (choppingPlayerRight[imageIndex]);
            imageIndex = (imageIndex+1) % 2;
        }
    }
    
    /**
     * moves with player controller
     */
    public void moveWithPlayerController () {
        setLocation (controller.getX(), controller.getY()-offSet);
    }
    
    /**
     * Returns the direction the player is currently facing.
     *
     * @return "front", "back", "left", or "right"
     */
    public String getFacingDirection() {
        return facingDirection;
    }
}
