import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectNumPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectNumPlayer extends World
{
    GreenfootImage background = new GreenfootImage ("images/selectNumPlayerBackground.PNG");

    int level;
    
    Label levelLabel;
    Label recordLabel = new Label ("Record", 30);
    Label recordNum;
    
    Label continueLabel, returnLabel, onePlayerLabel, twoPlayerLabel;
    Button continueButton, returnButton, onePlayerButton, twoPlayerButton;
    
    Color white = new Color (255, 255, 255);
    Color blue = new Color (0, 71, 87);
    
    public SelectNumPlayer(int level)
    {    
        super(1000, 600, 1); 
        setBackground (background);
        
        this.level = level;
        
        setUpLabelAndButton();
        
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(returnLabel) || Greenfoot.mouseClicked(returnButton)) {
            Greenfoot.setWorld (new LevelWorld(GameState.level1Unlocked, GameState.level2Unlocked, GameState.level3Unlocked));
            
        } else if (Greenfoot.mouseClicked(onePlayerLabel) || Greenfoot.mouseClicked(onePlayerButton)) {
            Greenfoot.setWorld (new MyWorld(level, 1));
            
        } else if (Greenfoot.mouseClicked(twoPlayerLabel) || Greenfoot.mouseClicked(twoPlayerButton)) {
            Greenfoot.setWorld (new MyWorld(level, 2));
        } 
    }
    
    private void setUpLabelAndButton() {
        levelLabel = new Label ("Level " + level, 60);
        addObject (levelLabel, 500, 60+30);
        
        addObject (recordLabel,7*60+15,3*60 + 30);
        recordNum = new Label (GameState.levelRecordScore[level], 30);
        addObject (recordNum, 9*60 + 20 + 30, 3*60 + 30);
        
        continueLabel = new Label ("continue", 35);
        continueButton = new Button(240, 60, blue);
        addObject(continueButton, 500, 8*60 + 30);
        addObject(continueLabel, 500, 8*60 + 30);
        
        returnLabel = new Label ("back", 35);
        returnButton = new Button(240, 60, blue);
        addObject(returnButton,500 , 6*60 + 30);
        addObject(returnLabel, 500, 6*60 + 30);
    
        onePlayerLabel = new Label ("choose", 35);
        onePlayerButton = new Button(120, 30, white);
        addObject(onePlayerButton, 25 + 2*60 + 30, 7*60 + 30);
        addObject(onePlayerLabel, 25 + 2*60 + 30, 7*60 + 30);
        
        twoPlayerLabel = new Label ("choose", 35);
        twoPlayerButton = new Button(120, 30, white);
        addObject(twoPlayerButton, 1000 - (25 + 2*60 + 30), 7*60 + 30);
        addObject(twoPlayerLabel, 1000 - (25 + 2*60 + 30), 7*60 + 30);
    }
    
}
