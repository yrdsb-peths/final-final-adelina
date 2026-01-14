import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * DeliveryCounter is a Counter for completing and delivering orders.
 * It has an animated image that cycles through frames, and a selected animation when chosen.
 */
public class DeliveryCounter extends Counter
{
    GreenfootImage[] deliveryCounter = new GreenfootImage[4];
    GreenfootImage[] selectedDeliveryCounter = new GreenfootImage[4];
  
    int width = 120;
    int imageIndex = 0;
    
    SimpleTimer animationTimer = new SimpleTimer();
    
    /**
     * Creates a new DeliveryCounter with animated frames.
     */
    public DeliveryCounter() {
        for (int i=0; i<deliveryCounter.length; i++) {
            deliveryCounter[i] = new GreenfootImage("images/deliveryCounter/deliveryCounter" + i + ".PNG");
            deliveryCounter[i].scale(width, width);
        }
        
        for (int i=0; i<selectedDeliveryCounter.length; i++) {
            selectedDeliveryCounter[i] = new GreenfootImage("images/selectedDeliveryCounter/deliveryCounter" + i + ".PNG");
            selectedDeliveryCounter[i].scale(width, width);
        }
        
        animationTimer.mark();
    }
    
    /**
     * Animates the delivery counter frames.
     */
    public void act()
    {
        // Add your action code here.
        if (isSelected()) animateDeliveryCounter (selectedDeliveryCounter);
        else animateDeliveryCounter (deliveryCounter);
    }
    
    private void animateDeliveryCounter(GreenfootImage[] image) {
        if (animationTimer.millisElapsed() < 100) {
            return;
        }
        animationTimer.mark();
        
        setImage(image[imageIndex]);
        imageIndex = (imageIndex + 1) % image.length;
        
    }
}
