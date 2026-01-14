import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Represents the red player character.
 */
public class PlayerRedImage extends PlayerImage
{
    /**
     * Constructs a new PlayerRedImage that follows a PlayerController.
     *
     * @param controller the PlayerController that this image will follow
     */
    public PlayerRedImage(PlayerController controller) {
        //set the controller that this image will follow
        this.controller = controller;
        controller.setPlayerImage(this);
        
        rescaleAndSetImages(this.width, this.height);
        
        facingDirection = "front";
        
        setImage(FRONT);
        animationTimer.mark();
    }
    
    private void rescaleAndSetImages(int width, int height) {
        FRONT = new GreenfootImage ("images/playerRedFront.PNG");
        BACK = new GreenfootImage ("images/playerRedBack.PNG");
        LEFT = new GreenfootImage ("images/playerRedFacingLeft.PNG");
        RIGHT = new GreenfootImage ("images/playerRedFacingRight.PNG");
        
        FRONT.scale (width, height);
        BACK.scale (width, height);
        LEFT.scale (width, height);
        RIGHT.scale (width, height);
        
        for (int i=0; i<2; i++) {
            choppingPlayerFront[i] = new GreenfootImage ("images/playerRedChoppingFront/playerRedChoppingFront" + i + ".PNG");
            choppingPlayerFront[i].scale(width, height);
        }
        for (int i=0; i<2; i++) {
            choppingPlayerBack[i] = new GreenfootImage ("images/playerRedChoppingBack/playerRedChoppingBack" + i + ".PNG");
            choppingPlayerBack[i].scale(width, height);
        }
        for (int i=0; i<2; i++) {
            choppingPlayerLeft[i] = new GreenfootImage ("images/playerRedChoppingLeft/playerRedChoppingLeft" + i + ".PNG");
            choppingPlayerLeft[i].scale(width, height);
        }
        for (int i=0; i<2; i++) {
            choppingPlayerRight[i] = new GreenfootImage ("images/playerRedChoppingRight/playerRedChoppingRight" + i + ".PNG");
            choppingPlayerRight[i].scale(width, height);
        }
    }
}
