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
    
    public OpenWorld()
    {    
        super(1000, 600, 1); 
        setBackground (background);
        
        instructionButton = new Button("HELP", 160, 60, color, 35);
        addObject(instructionButton, 110, 550);
        
        startButton = new Button("START", 160, 60, color, 35);
        addObject(startButton, 890, 550);
    }
    
    public void act(){
        if (Greenfoot.mouseClicked(instructionButton)) {
            Greenfoot.setWorld (new InstructionWorld());
        }
    }
}
