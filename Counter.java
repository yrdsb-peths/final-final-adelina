import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    public Counter() {
    }
    
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
    }
    
    /*
     * public void checkIfSelected(GreenfootImage selectedImageVersion, GreenfootImage normalImage){
        MyWorld world = (MyWorld) getWorld();
        setImage (normalImage);
        if (world.playerImage.getFacingDirection().equals ("front")) {
            if (getOneObjectAtOffset (0, -40, PlayerController.class) != null) {
                setImage (selectedImageVersion);
            }
        } else if (world.playerImage.getFacingDirection().equals ("left")) {
            if (getOneObjectAtOffset (-40, 0, PlayerController.class) != null) {
                setImage (selectedImageVersion);
            }
        } else if (world.playerImage.getFacingDirection().equals ("right")) {
            if (getOneObjectAtOffset (40, 0, PlayerController.class) != null) {
                setImage (selectedImageVersion);
            }
        } else if (world.playerImage.getFacingDirection().equals ("back")) {
            if (getOneObjectAtOffset (0, 40, PlayerController.class) != null) {
                setImage (selectedImageVersion);
            }
        } 
    }
     */
    
    public void checkIfSelected (GreenfootImage selectedImageVersion, GreenfootImage normalImage){
        if (getOneObjectAtOffset (0, -40, PlayerController.class) != null) {
                setImage (selectedImageVersion);
        } else if (getOneObjectAtOffset (-40, 0, PlayerController.class) != null) {
                setImage (selectedImageVersion);
        } else if (getOneObjectAtOffset (40, 0, PlayerController.class) != null) {
                setImage (selectedImageVersion);
        } else if (getOneObjectAtOffset (0, 40, PlayerController.class) != null) {
                setImage (selectedImageVersion);
        } else {
            setImage (normalImage);
        }
    }
}
