import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LeftDeliveryCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LeftDeliveryCounter extends DeliveryCounter
{
    public LeftDeliveryCounter() {
        deliveryCounter.scale (width, width);
        selectedDeliveryCounter.scale (width, width);
        
        deliveryCounter.rotate (90);
        selectedDeliveryCounter.rotate (90);
        
        setImage (deliveryCounter);
        
        facingDirection = "left";
    }
    
    public void act()
    {
        checkIfSelected(selectedDeliveryCounter, deliveryCounter);
    }
}
