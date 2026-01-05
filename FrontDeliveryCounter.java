import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FrontDeliveryCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FrontDeliveryCounter extends DeliveryCounter
{
    public FrontDeliveryCounter() {
        deliveryCounter.scale (width, width);
        selectedDeliveryCounter.scale (width, width);
        
        setImage (deliveryCounter);
        
        facingDirection = "front";
    }
    
    public void act()
    {
        checkIfSelected(selectedDeliveryCounter, deliveryCounter);
    }
}
