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
    Label recordLabel = new Label ("record", 18);
    
    Label levelLabel;
    Label ordersDeliveredCalculation;
    Label ordersFailedCalculation;
    Label totalCalculation;
    Label recordNum;
    Label continueLabel;
    
    Color color = new Color (100, 100, 100);
    Color blue = new Color (0, 71, 87);
    
    Button continueButton;
    Star star;
    
    int totalScore;
    int levelOneOneStarScore = 30;
    int levelOneTwoStarScore = 80;
    int levelOneThreeStarScore = 120;
    
    int levelTwoOneStarScore = 30;
    int levelTwoTwoStarScore = 60;
    int levelTwoThreeStarScore = 90;
    
    int levelThreeOneStarScore = 30;
    int levelThreeTwoStarScore = 50;
    int levelThreeThreeStarScore = 70;
    
    int level;
    int numDelivered;
    int numFailed;
    int recordScore;
    
    
    private GreenfootSound endSound = new GreenfootSound ("sounds/levelVictorySound.mp3");
    private GreenfootSound click = new GreenfootSound("sounds/clicking.mp3");

    public EndWorld(int level, int numDelivered, int numFailed)
    {    
        super(1000, 600, 1); 
        setBackground(endImage);
        
        this.level = level;
        totalScore = numDelivered*20-numFailed*10;
        this.numDelivered = numDelivered;
        this.numFailed = numFailed;
        updateGameState();
        
        addTexts();
        setTextColor();
        addContinueButton();
        setStarImage();
        
        endSound.setVolume(60);
        endSound.play();
        click.setVolume(40);
    }
    
    public void act() {
        //if clicks on the continue button, go to level world
        if (Greenfoot.mouseClicked(continueLabel) || Greenfoot.mouseClicked(continueButton)) {
            click.play();
            Greenfoot.setWorld (new LevelWorld(GameState.level1Unlocked, GameState.level2Unlocked, GameState.level3Unlocked));
        }
    }
    
    public void updateGameState() {
        //if player scores one star or higher on level one, level 2 will be unlocked
        if (level == 1 && totalScore >= levelOneOneStarScore) GameState.level2Unlocked = true;
        
        //if player scores one star or higher on level two, level 3 will be unlocked
        if (level == 2 && totalScore >= levelTwoOneStarScore) GameState.level3Unlocked = true;
        
        //if player total score is higher than record score, update record
        if (level == 1 && totalScore > GameState.levelRecordScore[0]){
            GameState.levelRecordScore[0] = totalScore;
            recordScore = GameState.levelRecordScore[0];
        }
        if (level == 2 && totalScore > GameState.levelRecordScore[1]){
            GameState.levelRecordScore[1] = totalScore;
            recordScore = GameState.levelRecordScore[1];
        }
        if (level == 3 && totalScore > GameState.levelRecordScore[2]){
            GameState.levelRecordScore[2] = totalScore;
            recordScore = GameState.levelRecordScore[2];
        }
    }
    
    public void addTexts() {
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
        
        totalCalculation = new Label (totalScore, 50);
        addObject (totalCalculation, 9*60 + 20 + 30, 5*60+3);
        
        addObject (recordLabel,6*60 + 50 ,7*60 + 20);
        recordNum = new Label (recordScore, 18);
        addObject (recordNum, 9*60 + 20 + 30, 7*60 + 20);
    }
    
    public void setTextColor() {
        ordersDeliveredCalculation.setFillColor(color);
        ordersFailedCalculation.setFillColor(color);
        levelLabel.setFillColor(color);
        ordersDeliveredLabel.setFillColor(color);
        ordersFailedLabel.setFillColor(color);
        totalCalculation.setFillColor(color);
        totalLabel.setFillColor(color);
        recordLabel.setFillColor(color);
        recordNum.setFillColor(color);
        
        ordersDeliveredCalculation.setLineColor(color);
        ordersFailedCalculation.setLineColor(color);
        levelLabel.setLineColor(color);
        ordersDeliveredLabel.setLineColor(color);
        ordersFailedLabel.setLineColor(color);
        totalCalculation.setLineColor(color);
        totalLabel.setLineColor(color);
        recordLabel.setLineColor(color);
        recordNum.setLineColor(color);
    }
    
    public void addContinueButton() {
        continueLabel = new Label ("continue", 35);
        continueButton = new Button (160, 60, blue);
        addObject(continueButton, 8*60 + 20, 8*60 + 20);
        addObject(continueLabel, 8*60 + 20, 8*60 + 20);
    }
    
    public void setStarImage() {
        if (level == 1) {
            if (totalScore < levelOneOneStarScore){
                star = new Star (0);
            } else if (totalScore >= levelOneOneStarScore && totalScore < levelOneTwoStarScore) {
                star = new Star (1);
            } else if (totalScore >= levelOneTwoStarScore && totalScore < levelOneThreeStarScore) {
                star = new Star (2);
            } else {
                star = new Star (3);
            }
        }
        
        if (level == 2) {
            if (totalScore < levelTwoOneStarScore){
                star = new Star (0);
            } else if (totalScore >= levelTwoOneStarScore && totalScore < levelTwoTwoStarScore) {
                star = new Star (1);
            } else if (totalScore >= levelTwoTwoStarScore && totalScore < levelTwoThreeStarScore) {
                star = new Star (2);
            } else {
                star = new Star (3);
            }
        }
        
        if (level == 3) {
            if (totalScore < levelThreeOneStarScore){
                star = new Star (0);
            } else if (totalScore >= levelThreeOneStarScore && totalScore < levelThreeTwoStarScore) {
                star = new Star (1);
            } else if (totalScore >= levelThreeTwoStarScore && totalScore < levelThreeThreeStarScore) {
                star = new Star (2);
            } else {
                star = new Star (3);
            }
        }
        addObject(star, 8*60 + 20, 6*60 + 20);
    }
}
