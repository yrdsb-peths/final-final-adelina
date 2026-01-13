import greenfoot.*;

public class MyWorld extends World {
    public int unitWidth = 60;
    private int counterOffset = unitWidth/2;
    private GreenfootImage background = new GreenfootImage("images/background.PNG");
    
    public PlayerController playerBlue;
    public PlayerImage playerBlueImage;
    public PlayerController playerRed;
    public PlayerImage playerRedImage;
    
    public PlateCounter plateCounter = new PlateCounter();
    private Label pointLabel;
    private Label countDownLabel;
    private int remainingGameTime = 120000;//3 min
    private int points = 0;
    
    public Order[] soupOrders = new Order[5];
    private int unitOrderEarning = 20;
    private int unitOrderDecrease = 10;
    
    public SimpleTimer newOrderTimer = new SimpleTimer();
    private int newOrderTime = 10000; //20 seconds 
    
    private int level;
    private int numOrderDelivered = 0;
    private int numOrderFailed = 0;
    
    
    private GreenfootSound bgm;
    
    public MyWorld(int level, int numPlayer)
    {    
        super(1000, 600, 1); 
        
        bgm = new GreenfootSound ("gameSound.mp3");
        bgm.setVolume (60);
        bgm.playLoop();
        
        background.scale (1000, 600);
        setBackground (background);
        
        setPaintOrder(Label.class, Clock.class, Coin.class, SuperStatBar.class, HoldableObject.class, PlayerImage.class, PlayerController.class, Counter.class);
        
        
        playerBlue = new PlayerController("left", "right", "up", "down", "/", ".");
        playerBlueImage = new PlayerBlueImage(playerBlue);
        addObject(playerBlue,20+11*unitWidth+counterOffset,7*unitWidth + counterOffset);
        addObject (playerBlueImage, 0, 0);
        if (numPlayer == 2) {
            playerRed = new PlayerController("a", "d", "w", "s", "e", "q");
            playerRedImage = new PlayerRedImage(playerRed);
            addObject(playerRed,20+5*unitWidth+counterOffset,7*unitWidth + counterOffset);
            addObject (playerRedImage, 0, 0);
        }
        
        
        //initiate point and countdown
        pointLabel = new Label(0, 60);
        countDownLabel = new Label("2:00", 60);
        Coin coin = new Coin();
        addObject(coin, 20+unitWidth, 9*unitWidth - 20);
        addObject (pointLabel, 20+unitWidth, 9*unitWidth-10);
        Clock clock = new Clock();
        addObject(clock, 20+15*unitWidth, 9*unitWidth-20);
        addObject(countDownLabel, 20+15*unitWidth, 9*unitWidth-10);
        
        //initiate orders
        soupOrders[0] = new Order();
        addObject(soupOrders[0],20+unitWidth, 90/2);
        newOrderTimer.mark();
        
        this.level = level;
        if (level == 1) {
            prepareLevelOne();
        } else if (level == 2) {
            prepareLevelTwo();
        } else if (level == 3) {
            prepareLevelThree();
        }
    }
    public void act() {
        generateNewOrder();
        
        remainingGameTime -= 20; //act runs once in approx 20 millis
        if (remainingGameTime%1000 == 0) {
            updateCountDownLabel();
        }
        
        if (remainingGameTime == 0) {
            bgm.stop();
            Greenfoot.setWorld(new EndWorld(level, numOrderDelivered, numOrderFailed));
        }
    }
    
    private void updateCountDownLabel() {
        int mins = remainingGameTime / 60000; // remaningGameTime/numMillisInSecond
        int seconds = (remainingGameTime % 60000) / 1000;
        if (seconds>=10) countDownLabel.setValue (mins + ":" + seconds);
        else countDownLabel.setValue (mins + ":0" + seconds);
    }
    
    private int getFirstEmptyOrderSlot() {
        for (int i = 0; i < soupOrders.length; i++) {
            if (soupOrders[i] == null) {
                return i;
            }
        }
        return -1; // no empty slot
    }
    
    /**
     * generates new order when there is an open slot
     */
    private void generateNewOrder() {
        // Check if enough time has passed
        if (newOrderTimer.millisElapsed() < newOrderTime) return;
    
        int index = getFirstEmptyOrderSlot();
        if (index == -1) return; // order list full
    
        Order order = new Order();
        addObject(order, 20+unitWidth + index * 2 * unitWidth, 90/2);
    
        soupOrders[index] = order;
        newOrderTimer.mark();
        
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepareLevelOne()
    {
        //first row of counters
        Counter[] counterRow1 = new Counter[13];
        for (int i=0; i< counterRow1.length; i++) {
            if (i == 3) {
                counterRow1[i] = new FoodCounter("onion");                
            } else if (i == 4) {
                counterRow1[i] = new FoodCounter("tomato");
            } else if (i == 5) {
                counterRow1[i] = new FoodCounter("mushroom");
            } else if (i == 8 || i == 9) {
                counterRow1[i] = new StoveCounter();
            } else {
                counterRow1[i] = new NormalCounter();
            }
            addObject (counterRow1[i], 20 + (i+1)*unitWidth + counterOffset, 2*unitWidth + counterOffset);
        }
        Plate plate1 = new Plate();
        Plate plate2 = new Plate();
        addObject (plate1, 20 + (11)*unitWidth + counterOffset, 2*unitWidth + counterOffset);
        addObject (plate2, 20 + (12)*unitWidth + counterOffset, 2*unitWidth + counterOffset);
        counterRow1[10].setObjectOnTop(plate1);
        counterRow1[11].setObjectOnTop(plate2);
        
        Counter[] counterRow2 = new Counter[6];
        for (int i=0; i< counterRow2.length; i++) {
            if (i == 3 || i == 5) {
                counterRow2[i] = new CuttingCounter();                
            } else {
                counterRow2[i] = new NormalCounter();
            }
            addObject (counterRow2[i], 20 + (i+1)*unitWidth + counterOffset, 5*unitWidth + counterOffset);
        }
        
        Counter[] counterColumn1 = new Counter[2];
        for (int i=0; i< counterColumn1.length; i++) {
            counterRow1[i] = new NormalCounter();
            addObject (counterRow1[i], 20 + (1)*unitWidth + counterOffset, (3+i)*unitWidth + counterOffset);
        }
        
        NormalCounter counter12 = new NormalCounter();
        addObject (counter12, 20+(13)*unitWidth + counterOffset,3*unitWidth+counterOffset);
        LeftDeliveryCounter deliveryCounter = new LeftDeliveryCounter();
        addObject(deliveryCounter, 20+14*unitWidth, 5*unitWidth);
        addObject (plateCounter, 20+14*unitWidth - counterOffset, 6*unitWidth + counterOffset);
        
    }
    
    private void prepareLevelThree() {
        Counter[] counterRow1 = new Counter[5];
        for (int i=0; i<counterRow1.length; i++) {
            if (i==0 || i==2){
                counterRow1[i] = new StoveCounter();
            } else {
                counterRow1[i] = new NormalCounter();
            }
            
            addObject(counterRow1[i], 20 + counterOffset + (5+i)*unitWidth, counterOffset + 2*unitWidth);
        }
        FrontDeliveryCounter deliveryCounter = new FrontDeliveryCounter();
        addObject(deliveryCounter, 20 + 11*unitWidth, 2*unitWidth);
        addObject (plateCounter, 20 + 12*unitWidth + counterOffset, 2*unitWidth+counterOffset);
        NormalCounter singleCounter1 = new NormalCounter();
        addObject (singleCounter1, 20 + 13*unitWidth + counterOffset, 2*unitWidth+counterOffset);
        
        
        Counter[] counterRow2 = new Counter[11];
        for (int i=0; i<counterRow2.length; i++) {
            if (i==1 || i==4){
                counterRow2[i] = new CuttingCounter();
            } else if (i==8){
                counterRow2[i] = new FoodCounter("onion");
            }else if (i==9){
                counterRow2[i] = new FoodCounter("tomato");
            }else if (i==10){
                counterRow2[i] = new FoodCounter("mushroom");
            } else {
                counterRow2[i] = new NormalCounter();
            }
            
            addObject(counterRow2[i], 20 + counterOffset + (2+i)*unitWidth, counterOffset + 8*unitWidth);
        }
        
        NormalCounter[] counterColumn1 = new NormalCounter[5];
        for (int i=0; i<counterColumn1.length; i++) {
            counterColumn1[i] = new NormalCounter();
            addObject(counterColumn1[i], 20 + counterOffset + 2*unitWidth, counterOffset + (3+i)*unitWidth);
        }
        
        NormalCounter[] counterColumn2 = new NormalCounter[5];
        for (int i=0; i<counterColumn2.length; i++) {
            counterColumn2[i] = new NormalCounter();
            addObject(counterColumn2[i], 20 + counterOffset + 8*unitWidth, counterOffset + (3+i)*unitWidth);
        }
        
        Plate plate1 = new Plate();
        Plate plate2 = new Plate();
        Plate plate3 = new Plate();
        addObject (plate1, 20 + counterOffset + 2*unitWidth, counterOffset + (4)*unitWidth);
        addObject (plate2, 20 + counterOffset + 2*unitWidth, counterOffset + (5)*unitWidth);
        addObject (plate3, 20 + counterOffset + 2*unitWidth, counterOffset + (6)*unitWidth);
        counterColumn1[1].setObjectOnTop(plate1);
        counterColumn1[2].setObjectOnTop(plate2);
        counterColumn1[3].setObjectOnTop(plate3);
    }
    
    private void prepareLevelTwo() {
        Counter[] counterRow11 = new Counter[6];
        for (int i=0; i<counterRow11.length; i++) {
            if (i==2 || i==4){
                counterRow11[i] = new StoveCounter();
            } else {
                counterRow11[i] = new NormalCounter();
            }
            
            addObject(counterRow11[i], 20 + counterOffset + (1+i)*unitWidth, counterOffset + 2*unitWidth);
        }
        
        Counter[] counterRow12 = new Counter[5];
        for (int i=0; i<counterRow12.length; i++) {
            counterRow12[i] = new NormalCounter();
            addObject(counterRow12[i], 20 + counterOffset + (9+i)*unitWidth, counterOffset + 2*unitWidth);
        }
        
        Counter[] counterRow21 = new Counter[6];
        for (int i=0; i<counterRow21.length; i++) {
            if (i==2 || i==4){
                counterRow21[i] = new CuttingCounter();
            } else {
                counterRow21[i] = new NormalCounter();
            }
            addObject(counterRow21[i], 20 + counterOffset + (1+i)*unitWidth, counterOffset + 8*unitWidth);
        }
        
        Counter[] counterRow22 = new Counter[5];
        for (int i=0; i<counterRow22.length; i++) {
            if (i==1){
                counterRow22[i] = new FoodCounter("mushroom");
            } else if (i == 2) {
                counterRow22[i] = new FoodCounter("tomato");
            } else if (i == 3) {
                counterRow22[i] = new FoodCounter("onion");
            } else {
                counterRow22[i] = new NormalCounter();
            }
            addObject(counterRow22[i], 20 + counterOffset + (9+i)*unitWidth, counterOffset + 8*unitWidth);
        }
        
        Counter[] counterColumn1 = new Counter[2];
        for (int i=0; i<counterColumn1.length; i++) {
            counterColumn1[i] = new NormalCounter();
            addObject(counterColumn1[i], 20 + counterOffset + (6)*unitWidth, counterOffset + (3+i)*unitWidth);
        }
        
        Counter[] counterColumn2 = new Counter[3];
        for (int i=0; i<counterColumn2.length; i++) {
            counterColumn2[i] = new NormalCounter();
            addObject(counterColumn2[i], 20 + counterOffset + (9)*unitWidth, counterOffset + (5+i)*unitWidth);
        }
        Plate plate1 = new Plate ();
        Plate plate2 = new Plate ();
        addObject (plate1, 20 + counterOffset + (9)*unitWidth, counterOffset + (5)*unitWidth);
        addObject (plate2, 20 + counterOffset + (9)*unitWidth, counterOffset + (6)*unitWidth);
        counterColumn2[0].setObjectOnTop(plate1);
        counterColumn2[1].setObjectOnTop(plate2);
        
        LeftDeliveryCounter deliveryCounter = new LeftDeliveryCounter();
        addObject(deliveryCounter, 20 + (15)*unitWidth, 5*unitWidth);
        addObject(plateCounter, 20 + (15)*unitWidth - counterOffset, 6*unitWidth + counterOffset);
        
    }
    
    public Onion generateOnion(PlayerController player) {
        Onion onion = new Onion();
        addObject(onion, player.getX(), player.getY());
        onion.setIsBeingHeld (true);
        return onion;
    }
    public Mushroom generateMushroom(PlayerController player) {
        Mushroom mushroom = new Mushroom();
        addObject(mushroom, player.getX(), player.getY());
        mushroom.setIsBeingHeld (true);
        return mushroom;
    }
    public Tomato generateTomato(PlayerController player) {
        Tomato tomato = new Tomato();
        addObject(tomato, player.getX(), player.getY());
        tomato.setIsBeingHeld (true);
        return tomato;
    }
    
    public void increasePoints() {
        points += unitOrderEarning;
        pointLabel.setValue (points);
    }
    public void decreasePoints() {
        points -= unitOrderDecrease;
        pointLabel.setValue (points);
    }
    
    public void increaseNumOrderDelivered() {
        numOrderDelivered ++;
    }
    
    public void increaseNumOrderFailed() {
        numOrderFailed ++;
    }

}
