import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * FrontDeliveryCounter is a specialized DeliveryCounter facing the front.
 */
public class FrontDeliveryCounter extends DeliveryCounter
{
    /**
     * Creates a FrontDeliveryCounter.
     */
    public FrontDeliveryCounter() {
        super();
        
        setImage (deliveryCounter[0]);
    }
}
