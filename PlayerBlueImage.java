import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerBlueImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerBlueImage extends PlayerImage
{
    public PlayerBlueImage(PlayerController controller) {
        //set the controller that this image will follow
        this.controller = controller;
        controller.setPlayerImage(this);
        
        rescaleAndSetImages(this.width, this.height);
        
        facingDirection = "front";
        
        setImage(FRONT);
        animationTimer.mark();
    }
    
    public void rescaleAndSetImages(int width, int height) {
        FRONT = new GreenfootImage ("images/playerBlueFront.PNG");
        BACK = new GreenfootImage ("images/playerBlueBack.PNG");
        LEFT = new GreenfootImage ("images/playerBlueFacingLeft.PNG");
        RIGHT = new GreenfootImage ("images/playerBlueFacingRight.PNG");
        
        FRONT.scale (width, height);
        BACK.scale (width, height);
        LEFT.scale (width, height);
        RIGHT.scale (width, height);
        
        for (int i=0; i<2; i++) {
            choppingPlayerFront[i] = new GreenfootImage ("images/playerBlueChoppingFront/playerBlueChoppingFront" + i + ".PNG");
            choppingPlayerFront[i].scale(width, height);
        }
        for (int i=0; i<2; i++) {
            choppingPlayerBack[i] = new GreenfootImage ("images/playerBlueChoppingBack/playerBlueChoppingBack" + i + ".PNG");
            choppingPlayerBack[i].scale(width, height);
        }
        for (int i=0; i<2; i++) {
            choppingPlayerLeft[i] = new GreenfootImage ("images/playerBlueChoppingLeft/playerBlueChoppingLeft" + i + ".PNG");
            choppingPlayerLeft[i].scale(width, height);
        }
        for (int i=0; i<2; i++) {
            choppingPlayerRight[i] = new GreenfootImage ("images/playerBlueChoppingRight/playerBlueChoppingRight" + i + ".PNG");
            choppingPlayerRight[i].scale(width, height);
        }
    }
}
