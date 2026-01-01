import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instruction here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructionWorld extends World
{
    GreenfootImage instruction = new GreenfootImage ("images/instruction.PNG");
    Button continueButton;
    Color color = new Color (0, 71, 87);
    Label continueLabel;
    
    
    public InstructionWorld()
    {    
        super(1000, 600, 1); 
        setBackground(instruction);
        setPaintOrder(Label.class, Button.class);

        continueLabel = new Label ("continue", 35);
        continueButton = new Button (160, 60, color);
        addObject(continueLabel, 890, 550);
        addObject(continueButton, 890, 550);
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(continueLabel) || Greenfoot.mouseClicked(continueButton)) {
            Greenfoot.setWorld (new LevelWorld());
        }
    }
}
