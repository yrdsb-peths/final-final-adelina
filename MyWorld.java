import greenfoot.*;

public class MyWorld extends World {
    public int unitWidth = 60;
    private int counterOffset = unitWidth/2;
    private GreenfootImage background = new GreenfootImage("images/background.PNG");
    
    public PlayerController player = new PlayerController();
    public PlayerImage playerImage = new PlayerImage();
    public PlateCounter plateCounter = new PlateCounter();
    private Label pointLabel;
    private Label countDownLabel;
    private int remainingGameTime = 180000;//3 min
    private int points = 0;
    
    public Order[] soupOrders = new Order[5];
    private int unitOrderEarning = 20;
    private int unitOrderDecrease = 10;
    
    public SimpleTimer newOrderTimer = new SimpleTimer();
    private int newOrderTime = 10000; //20 seconds 
    
    private int level;
    private int numOrderDelivered = 0;
    private int numOrderFailed = 0;
    
    public MyWorld(int level)
    {    
        super(1000, 600, 1); 
        
        background.scale (1000, 600);
        setBackground (background);
        
        setPaintOrder(Label.class, Clock.class, Coin.class, SuperStatBar.class, HoldableObject.class, PlayerImage.class, PlayerController.class, Counter.class);
        pointLabel = new Label(0, 60);
        countDownLabel = new Label("3:00", 60);
        
        addObject(player,20+11*unitWidth+counterOffset,7*unitWidth + counterOffset);
        addObject (playerImage, 0, 0);
        
        Coin coin = new Coin();
        addObject(coin, 20+unitWidth, 9*unitWidth - 20);
        addObject (pointLabel, 20+unitWidth, 9*unitWidth-10);
        Clock clock = new Clock();
        addObject(clock, 20+15*unitWidth, 9*unitWidth-20);
        addObject(countDownLabel, 20+15*unitWidth, 9*unitWidth-10);
        
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
        NormalCounter[] counter1 = new NormalCounter[3];
        for (int i=0; i<3; i++) {
            counter1[i] = new NormalCounter();
            addObject(counter1[i],20+(i+1)*unitWidth + counterOffset,2*unitWidth+counterOffset);
        }
        
        FoodCounter counter2 = new FoodCounter("onion");
        addObject(counter2,20+4*unitWidth + counterOffset,2*unitWidth+counterOffset);
        
        FoodCounter counter3 = new FoodCounter ("tomato");
        addObject(counter3,20+5*unitWidth + counterOffset,2*unitWidth+counterOffset);
        
        FoodCounter counter4 = new FoodCounter ("mushroom");
        addObject(counter4,20+6*unitWidth + counterOffset,2*unitWidth+counterOffset);
        
        NormalCounter[] counter5 = new NormalCounter[2];
        for (int i=0; i<2; i++) {
            counter5[i] = new NormalCounter();
            addObject(counter5[i],20+(7+i)*unitWidth + counterOffset,2*unitWidth+counterOffset);
        }
        
        StoveCounter counter6 = new StoveCounter();
        addObject(counter6,20+9*unitWidth + counterOffset,2*unitWidth+counterOffset);
        
        StoveCounter counter7 = new StoveCounter();
        addObject(counter7,20+10*unitWidth + counterOffset,2*unitWidth+counterOffset);
        
        NormalCounter[] counter8 = new NormalCounter[3];
        for (int i=0; i<3; i++) {
            counter8[i] = new NormalCounter();
            addObject(counter8[i],20+(11+i)*unitWidth + counterOffset,2*unitWidth+counterOffset);
        }
        Plate plate1 = new Plate();
        addObject(plate1, 20+12*unitWidth + counterOffset, 2*unitWidth+counterOffset);
        counter8[1].setObjectOnTop (plate1);
        
        //delivery counter
        NormalCounter counter12 = new NormalCounter();
        addObject (counter12, 20+(13)*unitWidth + counterOffset,3*unitWidth+counterOffset);
        
        LeftDeliveryCounter deliveryCounter = new LeftDeliveryCounter();
        addObject(deliveryCounter, 20+14*unitWidth, 5*unitWidth);
    
        addObject (plateCounter, 20+14*unitWidth - counterOffset, 6*unitWidth + counterOffset);
        
        // left column of counters
        NormalCounter[] counter9 = new NormalCounter[3];
        for (int i=0; i<3; i++) {
            counter9[i] = new NormalCounter();
            addObject(counter9[i],20+unitWidth+counterOffset,(i+3) * unitWidth + counterOffset);
        }
        
        // second row of counters
        NormalCounter[] counter10 = new NormalCounter[9];
        for (int i=0; i<4; i++) {
            counter10[i] = new NormalCounter();
            addObject(counter10[i],20+(i+2)*unitWidth + counterOffset, 5*unitWidth + counterOffset);
        }
        
        CuttingCounter counter11 = new CuttingCounter();
        addObject(counter11, 20+(6)*unitWidth + counterOffset, 5*unitWidth + counterOffset);
    }
    
    private void prepareLevelTwo() {
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
        
    }
    
    private void prepareLevelThree() {
        NormalCounter[] counter1 = new NormalCounter[3];
        for (int i=0; i<3; i++) {
            counter1[i] = new NormalCounter();
            addObject(counter1[i],20+(i+1)*unitWidth + counterOffset,2*unitWidth+counterOffset);
        }
        
        FoodCounter counter2 = new FoodCounter("onion");
        addObject(counter2,20+4*unitWidth + counterOffset,2*unitWidth+counterOffset);
        
        FoodCounter counter3 = new FoodCounter ("tomato");
        addObject(counter3,20+5*unitWidth + counterOffset,2*unitWidth+counterOffset);
        
        FoodCounter counter4 = new FoodCounter ("mushroom");
        addObject(counter4,20+6*unitWidth + counterOffset,2*unitWidth+counterOffset);
        
        NormalCounter[] counter5 = new NormalCounter[2];
        for (int i=0; i<2; i++) {
            counter5[i] = new NormalCounter();
            addObject(counter5[i],20+(7+i)*unitWidth + counterOffset,2*unitWidth+counterOffset);
        }
        
        StoveCounter counter6 = new StoveCounter();
        addObject(counter6,20+9*unitWidth + counterOffset,2*unitWidth+counterOffset);
        
        StoveCounter counter7 = new StoveCounter();
        addObject(counter7,20+10*unitWidth + counterOffset,2*unitWidth+counterOffset);
        
        NormalCounter[] counter8 = new NormalCounter[3];
        for (int i=0; i<3; i++) {
            counter8[i] = new NormalCounter();
            addObject(counter8[i],20+(11+i)*unitWidth + counterOffset,2*unitWidth+counterOffset);
        }
        Plate plate1 = new Plate();
        addObject(plate1, 20+12*unitWidth + counterOffset, 2*unitWidth+counterOffset);
        counter8[1].setObjectOnTop (plate1);
        
        //delivery counter
        NormalCounter counter12 = new NormalCounter();
        addObject (counter12, 20+(13)*unitWidth + counterOffset,3*unitWidth+counterOffset);
        
        LeftDeliveryCounter deliveryCounter = new LeftDeliveryCounter();
        addObject(deliveryCounter, 20+14*unitWidth, 5*unitWidth);
    
        addObject (plateCounter, 20+14*unitWidth - counterOffset, 6*unitWidth + counterOffset);
        
        // left column of counters
        NormalCounter[] counter9 = new NormalCounter[3];
        for (int i=0; i<3; i++) {
            counter9[i] = new NormalCounter();
            addObject(counter9[i],20+unitWidth+counterOffset,(i+3) * unitWidth + counterOffset);
        }
        
        // second row of counters
        NormalCounter[] counter10 = new NormalCounter[9];
        for (int i=0; i<4; i++) {
            counter10[i] = new NormalCounter();
            addObject(counter10[i],20+(i+2)*unitWidth + counterOffset, 5*unitWidth + counterOffset);
        }
        
        CuttingCounter counter11 = new CuttingCounter();
        addObject(counter11, 20+(6)*unitWidth + counterOffset, 5*unitWidth + counterOffset);
    }
    
    public Onion generateOnion() {
        Onion onion = new Onion();
        addObject(onion, player.getX(), player.getY());
        onion.setIsBeingHeld (true);
        return onion;
    }
    public Mushroom generateMushroom() {
        Mushroom mushroom = new Mushroom();
        addObject(mushroom, player.getX(), player.getY());
        mushroom.setIsBeingHeld (true);
        return mushroom;
    }
    public Tomato generateTomato() {
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
