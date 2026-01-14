import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * LeftDeliveryCounter is a DeliveryCounter rotated 90 degrees to face left.
 */
public class LeftDeliveryCounter extends DeliveryCounter
{
    /**
     * Creates a LeftDeliveryCounter (rotated 90 degrees).
     */
    public LeftDeliveryCounter() {
        super();
        
        for (int i=0; i<4; i++) {
            deliveryCounter[i].rotate (90);
            selectedDeliveryCounter[i].rotate (90);

        }
    
        setImage (deliveryCounter[0]);
    }
    
}
