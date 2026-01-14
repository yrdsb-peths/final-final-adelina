import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Manages soup cooking logic, including ingredient tracking, cooking time, and visual updates.
 * Responsibilities: Accept valid food, Track cooking progress, 
 * Expose cooking state
 */
public class Pot extends HoldableObject
{
    private GreenfootImage[] tomatoSoup = new GreenfootImage[3];
    private GreenfootImage[] mushroomSoup = new GreenfootImage[3];
    private GreenfootImage[] onionSoup = new GreenfootImage[3];
    private GreenfootImage emptyPot = new GreenfootImage("images/emptyPot.PNG");
    
    int width = 60;
    int height = 105;
    
    private int numFoodInside;
    private String type;
    
    private int requiredCookingTime = 0;
    private int currentCookingTime = 0;
    
    private SimpleTimer cookingTimer = new SimpleTimer();
    private SuperStatBar cookingStatusBar;
    private Color green = new Color (56, 255, 119);
    private Color grey = new Color (112, 112, 112);
    
    private boolean finishedCooking = false;
    
    /**
     * Creates an empty Pot with cooking animations and a progress bar.
     */
    public Pot() {
        emptyPot.scale(width, height);
        numFoodInside = 0;
        for (int i=0; i<3; i++) {
            tomatoSoup[i] = new GreenfootImage ("images/tomatoSoup/tomatoSoup" + i + ".PNG");
            tomatoSoup[i].scale(width, height);
        }
        for (int i=0; i<3; i++) {
            mushroomSoup[i] = new GreenfootImage ("images/mushroomSoup/mushroomSoup" + i + ".PNG");
            mushroomSoup[i].scale(width, height);
        }
        for (int i=0; i<3; i++) {
            onionSoup[i] = new GreenfootImage ("images/onionSoup/onionSoup" + i + ".PNG");
            onionSoup[i].scale(width, height);
        }
        
        cookingTimer.mark();
        cookingStatusBar = new SuperStatBar(requiredCookingTime, currentCookingTime, this, 50, 10, 22, green, grey, true);
        cookingStatusBar.setToInvisible();
        
        setImage(emptyPot);
    }

    /**
     * Increases cooking time if placed on a stove.
     */
    public void act()
    {
        if(getOneObjectAtOffset(0, 0, Counter.class) instanceof StoveCounter) {
            increaseCurrentCuttingTime();
        }
    }
    
    /**
    * Called when this pot is added to the world.
    * Adds the cooking progress bar.
    *
    * @param w the world this pot was added to
    */
    protected void addedToWorld(World w) {
        w.addObject(cookingStatusBar, getX(), getY() + 22);
    }
    
    private void increaseCurrentCuttingTime() {
        if(cookingTimer.millisElapsed() >= 5 && currentCookingTime < requiredCookingTime)currentCookingTime += 5;
        else return;
        cookingTimer.mark();
        
        cookingStatusBar.update(currentCookingTime);
    }
    
    /**
    * Returns whether the soup has finished cooking.
    *
    * @return true if cooking is complete
    */
    public boolean hasFinishedCooking() {
        return currentCookingTime == requiredCookingTime && numFoodInside == 3;
    }
    
    /**
     * initialize all variables and timers to an empty pot
     */
    public void setToEmptyPotStatus() {
        requiredCookingTime = 0;
        currentCookingTime = 0;
        
        cookingStatusBar.setMaxVal (0);
        cookingStatusBar.update(currentCookingTime);
        cookingStatusBar.setToInvisible();
        
        numFoodInside = 0;
        type = null;
        setImage (emptyPot);
        cookingTimer.mark();
        
    }

    /**
     * Returns the soup type.
     *
     * @return soup type
     */
    public String getType() {
        return type;
    }

    /**
     * Attempts to add a food item to the pot.
     * The food must be chopped and match the pot's current soup type.
     *
     * @param food the Food to add
     * @return true if the food was successfully added
     */
    public boolean tryAddFood(Food food) {
        // First food defines soup type
        if (numFoodInside == 0) {
            type = food.getType();
            setSoupStage(0);
            setCookingTime(500);
            numFoodInside = 1;
            return true;
        }
    
        // Subsequent foods must match type
        if (!food.getType().equals(type)) return false;
    
        if (numFoodInside == 1) {
            setSoupStage(1);
            setCookingTime(800);
            numFoodInside = 2;
            return true;
        }
    
        if (numFoodInside == 2) {
            setSoupStage(2);
            setCookingTime(1100);
            numFoodInside = 3;
            return true;
        }
    
        return false;
    }
    
    private void setSoupStage(int stage) {
        if (type.equals("mushroom")) {
            setImage(mushroomSoup[stage]);
        } else if (type.equals("onion")) {
            setImage(onionSoup[stage]);
        } else if (type.equals("tomato")) {
            setImage(tomatoSoup[stage]);
        }
    }
    
    private void setCookingTime(int time) {
        requiredCookingTime = time;
        cookingStatusBar.setMaxVal(time);
        cookingTimer.mark();
    }

}
