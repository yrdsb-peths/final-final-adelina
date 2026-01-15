import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Represents a customer order in the game.
 * 
 * An Order displays a requested soup type and includes a countdown timer.
 * If the order is not fulfilled before time runs out, the player loses points
 * and the order is marked as failed.
 */
public class Order extends Actor
{
    private GreenfootImage tomatoSoupOrder = new GreenfootImage ("images/tomatoSoupOrder.PNG");
    private GreenfootImage mushroomSoupOrder = new GreenfootImage ("images/mushroomSoupOrder.PNG");
    private GreenfootImage onionSoupOrder = new GreenfootImage ("images/onionSoupOrder.PNG");
    private int width = 120;
    private int height = 90;
    
    private int orderTime = 120000; 
    private SimpleTimer orderTimer = new SimpleTimer();
    private SuperStatBar countDownBar;
    Color green = new Color (56, 255, 119);
    Color grey = new Color (112, 112, 112);
    Color yellow = new Color (227, 204, 0);
    Color red = new Color (196, 23, 0);
    
    private String type;
    
    private GreenfootSound failedSound = new GreenfootSound ("sounds/failedSound.mp3");
    
    /**
     * Creates a new Order with a randomly selected soup type.
     * Initializes the order timer and countdown progress bar.
     */
    public Order() {
        tomatoSoupOrder.scale(width, height);
        mushroomSoupOrder.scale(width, height);
        onionSoupOrder.scale(width, height);
        
        createRandomOrder();
        orderTimer.mark();
        
        countDownBar = new SuperStatBar(orderTime, orderTime, this, 110, 5, -40, green, grey);
    }
    
    /**
     * Updates the order countdown timer.
     * 
     * If the timer expires, the order is removed, points are deducted,
     * and a failure sound is played.
     */
    public void act()
    {
        updateCountDownBar();
        if (orderTimer.millisElapsed() > orderTime) {
            MyWorld w = (MyWorld) getWorld();
            w.decreasePoints();
            w.increaseNumOrderFailed();
            failedSound.play();
            removeSelf();
        }
    }
    
    /**
    * Called when this orde is added to the world.
    * Adds the order countdown bar.
    *
    * @param w the world this pot was added to
    */
    protected void addedToWorld(World w) {
        w.addObject(countDownBar, getX(), getY() - 30);
    }
    
    private void createRandomOrder() {
        int num = Greenfoot.getRandomNumber(3);
        if (num == 0){
            setImage(tomatoSoupOrder);
            type = "tomato";
        } else if (num == 1){
            setImage(mushroomSoupOrder);
            type = "mushroom";
        } else if (num == 2){
            setImage (onionSoupOrder);
            type = "onion";
        }
    }
    
    /**
     * Removes this order from the world and clears its reference
     * from the world's active order list.
     */
    public void removeSelf() {
        MyWorld w = (MyWorld) getWorld();
    
        // Remove from array
        for (int i = 0; i < w.soupOrders.length; i++) {
            if (w.soupOrders[i] == this) {
                w.soupOrders[i] = null;
                break;
            }
        }
    
        w.removeObject(this);
        w.removeObject(countDownBar);
    }
    
    private void updateCountDownBar() {
        int elapsed = orderTimer.millisElapsed();
        int remainingTime = orderTime - elapsed;
        countDownBar.update (remainingTime);
        
        if (remainingTime < 5000) {
            countDownBar.setColors(red, grey);
        } else if (remainingTime < 10000) {
            countDownBar.setColors(yellow, grey);
        } else {
            countDownBar.setColors(green, grey);
        }
    }
    
    /**
     * Returns the type of soup requested by this order.
     *
     * @return the soup type as a String (e.g. "tomato", "onion", "mushroom")
     */
    public String getType() {
        return type;
    }
}
