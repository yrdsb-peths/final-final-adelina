import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * OpenWorld is the starting screen of the game.
 * It displays the game title, start button, and help button for instructions.
 * 
 * Responsibilities:
 * - Provide entry point for the game.
 * - Navigate to InstructionWorld or LevelWorld based on player input.
 */
public class OpenWorld extends World
{
    GreenfootImage background = new GreenfootImage ("images/openGameImage.PNG");
    Color color = new Color (0, 71, 87);
    Button startButton, instructionButton;
    Label startLabel, instructionLabel;
    
    // Sounds
    private GreenfootSound bgm;
    private GreenfootSound click = new GreenfootSound("sounds/clicking.mp3");
    
    /**
     * Constructs the opening world of the game.
     * Displays start and help buttons.
     */
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
        click.setVolume(40);
        
        resetGameState ();

    }
    
    /**
     * Handles user interaction each frame.
     * Moves to the instruction screen or level selection screen based on button clicks.
     */
    public void act(){
        if (Greenfoot.mouseClicked(instructionLabel) || Greenfoot.mouseClicked(instructionButton)) {
            click.play();
            Greenfoot.setWorld (new InstructionWorld(bgm));
        } else if (Greenfoot.mouseClicked(startLabel) || Greenfoot.mouseClicked(startButton)) {
            click.play();
            Greenfoot.setWorld (new LevelWorld(GameState.level1Unlocked, GameState.level2Unlocked, GameState.level3Unlocked,bgm));
        }
    }
    
    /**
     * Called when the world starts or resumes.
     * Plays background music if available.
     */
    public void started() {
        if (bgm != null) {
            bgm.playLoop();
        }
    }
    
    /**
     * Called when the world is paused or stopped.
     * Pauses background music if available.
     */
    public void stopped() {
        if (bgm != null) {
            bgm.pause();
        }
    }
    
    private void resetGameState (){
        GameState.level2Unlocked = false;
        GameState.level3Unlocked = false;
    }
}
