import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * InstructionWorld displays the game instructions to the player.
 * It shows a static instruction image and a continue button to proceed to the level selection.
 */

public class InstructionWorld extends World
{
    GreenfootImage instruction = new GreenfootImage ("images/instruction.PNG");
    Button continueButton;
    Color color = new Color (0, 71, 87);
    Label continueLabel;
    
    private GreenfootSound bgm;
    private GreenfootSound click = new GreenfootSound("sounds/clicking.mp3");

    /**
     * Constructs the InstructionWorld screen.
     * Displays game instructions and a continue button.
     *
     * @param bgm Background music to continue playing.
     */
    public InstructionWorld(GreenfootSound bgm)
    {    
        super(1000, 600, 1); 
        setBackground(instruction);
        setPaintOrder(Label.class, Button.class);

        continueLabel = new Label ("continue", 35);
        continueButton = new Button (160, 60, color);
        addObject(continueLabel, 890, 550);
        addObject(continueButton, 890, 550);
        
        this.bgm = bgm;
        click.setVolume(40);
    }
    
    /**
     * Handles user interaction every frame.
     * Moves to the level selection screen if the continue button is clicked.
     */
    public void act() {
        if (Greenfoot.mouseClicked(continueLabel) || Greenfoot.mouseClicked(continueButton)) {
            GameState s = new GameState();
            Greenfoot.setWorld (new LevelWorld(s.level1Unlocked, s.level2Unlocked, s.level3Unlocked,bgm));
            click.play();
        }
    }
}
