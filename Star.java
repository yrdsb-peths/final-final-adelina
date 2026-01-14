import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Represents a star rating image.
 * Can show zero, one, two, or three stars.
 */
public class Star extends Actor
{
    private GreenfootImage zeroStar = new GreenfootImage ("images/zeroStar.PNG");
    private GreenfootImage oneStar = new GreenfootImage ("images/oneStar.PNG");
    private GreenfootImage twoStar = new GreenfootImage ("images/twoStar.PNG");
    private GreenfootImage threeStar = new GreenfootImage ("images/threeStar.PNG");
    
    /**
     * Creates a Star image with a specific rating.
     *
     * @param starNum the number of stars (0–3)
     */

    public Star(int starNum) {
        if (starNum == 0 ) setImage (zeroStar);
        else if (starNum == 1 ) setImage (oneStar);
        else if (starNum == 2 ) setImage (twoStar);
        else if (starNum == 3 ) setImage (threeStar);
    }
    
}
