import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndWorld extends World
{
    GreenfootImage endImage = new GreenfootImage ("images/endImage.PNG");
    
    Label completeLabel = new Label ("COMPLETE", 60);
    Label ordersDeliveredLabel = new Label ("Orders Delivered", 20);
    Label ordersFailedLabel = new Label ("Orders Failed", 20);
    Label totalLabel = new Label ("TOTAL", 30);
    
    Label levelLabel;
    Label ordersDeliveredCalculation;
    Label ordersFailedCalculation;
    Label totalCalculation;
    
    Color color = new Color (100, 100, 100);
    
    Button continueButton;
    Color blue = new Color (0, 71, 87);
    Label continueLabel;
    
    Star star = new Star();
    
    public EndWorld(int level, int numDelivered, int numFailed)
    {    
        super(1000, 600, 1); 
        setBackground(endImage);
        
        addObject(completeLabel, 8*60 + 20, 60+30);
        addObject(ordersDeliveredLabel, 6*60 + 63, 3*60 + 3);
        addObject(ordersFailedLabel, 6*60 + 50, 4*60);
        addObject(totalLabel, 6*60 + 50,5*60+3);
        
        levelLabel = new Label ("Level " + level, 30);
        addObject (levelLabel, 8*60 + 20, 2*60+15);
        
        ordersDeliveredCalculation = new Label (numDelivered + " x 20 = " + (numDelivered*20), 20);
        addObject (ordersDeliveredCalculation, 9*60 + 20 + 30, 3*60 + 3);
        ordersFailedCalculation = new Label (numFailed + " x 10 = " + (numFailed*10), 20);
        addObject (ordersFailedCalculation, 9*60 + 20 + 30, 4*60);
        totalCalculation = new Label (numDelivered*20-numFailed*10, 50);
        addObject (totalCalculation, 9*60 + 20 + 30, 5*60+3);
        
        ordersDeliveredCalculation.setFillColor(color);
        ordersFailedCalculation.setFillColor(color);
        levelLabel.setFillColor(color);
        ordersDeliveredLabel.setFillColor(color);
        ordersFailedLabel.setFillColor(color);
        totalCalculation.setFillColor(color);
        totalLabel.setFillColor(color);
        
        ordersDeliveredCalculation.setLineColor(color);
        ordersFailedCalculation.setLineColor(color);
        levelLabel.setLineColor(color);
        ordersDeliveredLabel.setLineColor(color);
        ordersFailedLabel.setLineColor(color);
        totalCalculation.setLineColor(color);
        totalLabel.setLineColor(color);
        
        continueLabel = new Label ("continue", 35);
        continueButton = new Button (160, 60, blue);
        addObject(continueButton, 8*60 + 20, 8*60 + 20);
        addObject(continueLabel, 8*60 + 20, 8*60 + 20);
        
        addObject(star, 8*60 + 20, 6*60 + 20);
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(continueLabel) || Greenfoot.mouseClicked(continueButton)) {
            GameState s = new GameState();
            Greenfoot.setWorld (new LevelWorld(s.level1Unlocked, s.level2Unlocked, s.level3Unlocked));
            
        }
    }
}
