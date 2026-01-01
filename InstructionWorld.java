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
    
    public InstructionWorld()
    {    
        super(1000, 600, 1); 
        setBackground(instruction);
        
        continueButton = new Button ("continue", 160, 60, color, 35);
        addObject(continueButton, 890, 550);
    }
}
