import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DeliveryCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DeliveryCounter extends Counter
{
    GreenfootImage[] deliveryCounter = new GreenfootImage[4];
    GreenfootImage[] selectedDeliveryCounter = new GreenfootImage[4];
  
    int width = 120;
    int height = 60;
    int imageIndex = 0;
    
    SimpleTimer animationTimer = new SimpleTimer();
    
    public DeliveryCounter() {
        for (int i=0; i<deliveryCounter.length; i++) {
            deliveryCounter[i] = new GreenfootImage("images/deliveryCounter/deliveryCounter" + i + ".PNG");
            deliveryCounter[i].scale (width, height);
        
        }
        
        for (int i=0; i<selectedDeliveryCounter.length; i++) {
            selectedDeliveryCounter[i] = new GreenfootImage("images/selectedDeliveryCounter/deliveryCounter" + i + ".PNG");
            selectedDeliveryCounter[i].scale (width, height);
        }
        
        animationTimer.mark();
    }
    
    public void act()
    {
        // Add your action code here.
        if (isSelected()) animateDeliveryCounter (selectedDeliveryCounter);
        else animateDeliveryCounter (deliveryCounter);
    }
    
    public void animateDeliveryCounter(GreenfootImage[] image) {
        if (animationTimer.millisElapsed() < 100) {
            return;
        }
        animationTimer.mark();
        
        setImage(image[imageIndex]);
        imageIndex = (imageIndex + 1) % image.length;
        
    }
}
