import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RightDeliveryCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RightDeliveryCounter extends DeliveryCounter
{
    public RightDeliveryCounter() {
        deliveryCounter.scale (width, width);
        selectedDeliveryCounter.scale (width, width);
        
        deliveryCounter.rotate (-90);
        selectedDeliveryCounter.rotate (-90);
        
        setImage (deliveryCounter);
        
        facingDirection = "right";
    }
    
    public void act()
    {
        checkIfSelected(selectedDeliveryCounter, deliveryCounter);
    }
}
