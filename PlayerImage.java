import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    
    public void rescaleAndSetImages(int width, int height) {
        FRONT.scale (width, height);
        BACK.scale (width, height);
        LEFT.scale (width, height);
        RIGHT.scale (width, height);
        
        for (int i=0; i<2; i++) {
            choppingPlayerFront[i] = new GreenfootImage ("images/playerChoppingFront/playerBlueChoppingFront" + i + ".PNG");
            choppingPlayerFront[i].scale(width, height);
        }
        for (int i=0; i<2; i++) {
            choppingPlayerBack[i] = new GreenfootImage ("images/playerChoppingBack/playerBlueChoppingBack" + i + ".PNG");
            choppingPlayerBack[i].scale(width, height);
        }
        for (int i=0; i<2; i++) {
            choppingPlayerLeft[i] = new GreenfootImage ("images/playerChoppingLeft/playerBlueChoppingLeft" + i + ".PNG");
            choppingPlayerLeft[i].scale(width, height);
        }
        for (int i=0; i<2; i++) {
            choppingPlayerRight[i] = new GreenfootImage ("images/playerChoppingRight/playerBlueChoppingRight" + i + ".PNG");
            choppingPlayerRight[i].scale(width, height);
        }
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
     * player image is covered on top of the invisible controller
     * so that when the controller collide with the counter, 
     * its upper half may overlap the counter image to appear to be closer to it
     */
    public void moveWithPlayerController () {
        setLocation (controller.getX(), controller.getY()-offSet);
    }
    
    public String getFacingDirection() {
        return facingDirection;
    }
}
