import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Coin displays a coin image on the screen.
 */
public class Coin extends Actor
{
    GreenfootImage coin = new GreenfootImage("images/coin.PNG");
    
    /**
     * Creates a new Coin actor displaying a coin image.
     */
    public Coin() {
        coin.scale(120, 120);
        setImage(coin);
    }
    
}
