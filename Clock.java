import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clock displays a clock image on the screen.
 */
public class Clock extends Actor
{
    GreenfootImage clock = new GreenfootImage ("images/clock.PNG");
    
    /**
     * Creates a new Clock actor displaying a clock image.
     */
    public Clock() {
        clock.scale (120, 120);
        setImage(clock);
    }
}
