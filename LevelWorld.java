import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelWorld extends World
{
    GreenfootImage background = new GreenfootImage ("images/levelBackground.PNG");
    LevelButton level1, level2, level3 ;
    
    private GreenfootSound bgm;
    
    Button instructionButton;
    Label instructionLabel;
    
    Color color = new Color (0, 71, 87);
    
    public LevelWorld(boolean level1Unlocked, boolean level2Unlocked, boolean level3Unlocked)
    {    
        super(1000, 600, 1); 
        setBackground (background);
        
        level1 = new LevelButton (1, level1Unlocked);
        level2 = new LevelButton (2, level2Unlocked);
        level3 = new LevelButton (3, level3Unlocked);
        
        addObject (level1,235, 300);
        addObject (level2,500, 300);
        addObject (level3,765, 300);
        
        Label levels = new Label ("LEVELS", 100);
        addObject(levels, 500, 90);
        
        instructionLabel = new Label ("HELP", 35);
        instructionButton = new Button(160, 60, color);
        addObject(instructionButton, 110, 550);
        addObject(instructionLabel, 110, 550);
        
        bgm = new GreenfootSound("openAndLevel.mp3");
        bgm.playLoop();
        
    }
    
    public LevelWorld(boolean level1Unlocked, boolean level2Unlocked, boolean level3Unlocked, GreenfootSound bgm)
    {    
        super(1000, 600, 1); 
        setBackground (background);
        
        level1 = new LevelButton (1, level1Unlocked);
        level2 = new LevelButton (2, level2Unlocked);
        level3 = new LevelButton (3, level3Unlocked);
        
        addObject (level1,235, 300);
        addObject (level2,500, 300);
        addObject (level3,765, 300);
        
        Label levels = new Label ("LEVELS", 100);
        addObject(levels, 500, 90);
        
        instructionLabel = new Label ("HELP", 35);
        instructionButton = new Button(160, 60, color);
        addObject(instructionButton, 110, 550);
        addObject(instructionLabel, 110, 550);
        
        this.bgm = bgm;
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(level1)) {
            bgm.stop();
            Greenfoot.setWorld (new SelectNumPlayer(1));
        } else if (Greenfoot.mouseClicked(level2) && level2.isUnlocked()) {
            bgm.stop();
            Greenfoot.setWorld (new SelectNumPlayer(2));
        } else if (Greenfoot.mouseClicked(level3) && level3.isUnlocked()) {
            bgm.stop();
            Greenfoot.setWorld (new SelectNumPlayer(3));
        } else if (Greenfoot.mouseClicked(instructionLabel) || Greenfoot.mouseClicked(instructionButton)) {
            Greenfoot.setWorld (new InstructionWorld(bgm));
        } 
    }
}
