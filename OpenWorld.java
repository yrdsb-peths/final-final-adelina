import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OpenWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OpenWorld extends World
{
    GreenfootImage background = new GreenfootImage ("images/openGameImage.PNG");
    Color color = new Color (0, 71, 87);
    Button startButton, instructionButton;
    Label startLabel, instructionLabel;
    
    // Sounds
    private GreenfootSound bgm;
    
    public OpenWorld()
    {    
        super(1000, 600, 1); 
        setBackground (background);
        setPaintOrder(Label.class, Button.class);
        
        instructionLabel = new Label ("HELP", 35);
        instructionButton = new Button(160, 60, color);
        addObject(instructionLabel, 110, 550);
        addObject(instructionButton, 110, 550);
        
        startLabel = new Label ("START", 35);
        startButton = new Button(160, 60, color);
        addObject(startLabel, 890, 550);
        addObject(startButton, 890, 550);
        
        bgm = new GreenfootSound("openAndLevel.mp3");
        bgm.playLoop();
        
        resetGameState ();
    }
    
    public void act(){
        if (Greenfoot.mouseClicked(instructionLabel) || Greenfoot.mouseClicked(instructionButton)) {
            Greenfoot.setWorld (new InstructionWorld(bgm));
        } else if (Greenfoot.mouseClicked(startLabel) || Greenfoot.mouseClicked(startButton)) {
            Greenfoot.setWorld (new LevelWorld(GameState.level1Unlocked, GameState.level2Unlocked, GameState.level3Unlocked,bgm));
        }
    }
    
    private void resetGameState (){
        GameState.level2Unlocked = false;
        GameState.level3Unlocked = false;
    }
}
