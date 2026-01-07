import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Star here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Star extends Actor
{
    GreenfootImage zeroStar = new GreenfootImage ("images/zeroStar.PNG");
    GreenfootImage oneStar = new GreenfootImage ("images/oneStar.PNG");
    GreenfootImage twoStar = new GreenfootImage ("images/twoStar.PNG");
    GreenfootImage threeStar = new GreenfootImage ("images/threeStar.PNG");
    public Star(int starNum) {
        if (starNum == 0 ) setImage (zeroStar);
        else if (starNum == 1 ) setImage (oneStar);
        else if (starNum == 2 ) setImage (twoStar);
        else if (starNum == 3 ) setImage (threeStar);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
