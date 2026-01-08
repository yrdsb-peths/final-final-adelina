import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    private HoldableObject objectOnTop = null;
    public boolean isSelected = false;
    public Counter(){
    }
    
    public void act()
    {
    }
    
    //a super class for its subclasses
    //when is being selected change image to the first parameter
    public void checkIfSelected (GreenfootImage selectedImage, GreenfootImage normalImage){
        MyWorld world = (MyWorld)getWorld();
        Counter playerBlueSelected = world.playerBlue.getSelectedCounter();
        Counter playerRedSelected = null;
        if (world.playerRed != null) {
             playerRedSelected = world.playerRed.getSelectedCounter();
        }
        
        
        // if one of the players has selected the counter, change image to selected
        if (this == playerBlueSelected || this == playerRedSelected){
            setImage(selectedImage);
            isSelected = true;
        } else {
            setImage(normalImage);
            isSelected = false;
        }
    }
    
    public HoldableObject getIntersectingHoldableObject() {
        return (HoldableObject)getOneIntersectingObject (HoldableObject.class);
    }
    
    public void setObjectOnTop(HoldableObject object) {
        objectOnTop = object;
    }
    
    public HoldableObject getObjectOnTop() {
        return objectOnTop;
    }
}
