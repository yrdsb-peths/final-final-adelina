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
        super();
        
        for (int i=0; i<4; i++) {
            deliveryCounter[i].rotate (-90);
            selectedDeliveryCounter[i].rotate (-90);
        }
        
        setImage (deliveryCounter[0]);
        
    }
    
}
