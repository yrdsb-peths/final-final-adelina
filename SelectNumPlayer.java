import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * SelectNumPlayer is the world where the player selects the number of players (1 or 2) before starting a level.
 * It shows level information, record score, and provides buttons for selection.
 */
public class SelectNumPlayer extends World
{
    GreenfootImage background = new GreenfootImage ("images/selectNumPlayerBackground.PNG");

    int level;
    
    Label levelLabel;
    Label recordLabel = new Label ("Record", 30);
    Label recordNum;
    
    Label returnLabel, onePlayerLabel, twoPlayerLabel;
    Button returnButton, onePlayerButton, twoPlayerButton;
    
    Color white = new Color (255, 255, 255);
    Color blue = new Color (0, 71, 87);
    
    private GreenfootSound click = new GreenfootSound("sounds/clicking.mp3");
        
    /**
     * Constructs the world for selecting the number of players before a level.
     *
     * @param level The level number being selected.
     */
    public SelectNumPlayer(int level)
    {    
        super(1000, 600, 1); 
        setBackground (background);
        
        this.level = level;
        
        setUpLabelAndButton();
        click.setVolume(40);
        
    }
    
    /**
     * Handles user interaction each frame.
     * Navigates back, or starts the game with one or two players.
     */
    public void act() {
        if (Greenfoot.mouseClicked(returnLabel) || Greenfoot.mouseClicked(returnButton)) {
            Greenfoot.setWorld (new LevelWorld(GameState.level1Unlocked, GameState.level2Unlocked, GameState.level3Unlocked));
            click.play();
        } else if (Greenfoot.mouseClicked(onePlayerLabel) || Greenfoot.mouseClicked(onePlayerButton)) {
            Greenfoot.setWorld (new MyWorld(level, 1));
            click.play();
        } else if (Greenfoot.mouseClicked(twoPlayerLabel) || Greenfoot.mouseClicked(twoPlayerButton)) {
            Greenfoot.setWorld (new MyWorld(level, 2));
            click.play();
        } 
    }
    
    private void setUpLabelAndButton() {
        levelLabel = new Label ("Level " + level, 60);
        addObject (levelLabel, 500, 60+30);
        
        addObject (recordLabel,7*60+15,3*60 + 30);
        recordNum = new Label (GameState.levelRecordScore[level-1], 30);
        addObject (recordNum, 9*60 + 20 + 30, 3*60 + 30);
        
        returnLabel = new Label ("back", 35);
        returnButton = new Button(240, 60, blue);
        addObject(returnButton,500 , 7*60 + 30);
        addObject(returnLabel, 500, 7*60 + 30);
    
        onePlayerLabel = new Label ("one player", 25);
        onePlayerButton = new Button(160, 30, white);
        addObject(onePlayerButton, 25 + 2*60 + 30, 7*60 + 30);
        addObject(onePlayerLabel, 25 + 2*60 + 30, 7*60 + 30);
        
        twoPlayerLabel = new Label ("two players", 25);
        twoPlayerButton = new Button(160, 30, white);
        addObject(twoPlayerButton, 1000 - (25 + 2*60 + 30), 7*60 + 30);
        addObject(twoPlayerLabel, 1000 - (25 + 2*60 + 30), 7*60 + 30);
    }
    
}
