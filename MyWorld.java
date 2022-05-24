import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public static int score = 0;
    
    public Label scoreLabel = new Label(0,80);
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 375, 1, false); 
        TitleScreenWorld title = new TitleScreenWorld();
        Greenfoot.setWorld(title);
        if(Greenfoot.isKeyDown("space"))
        {
            Frog f = new Frog();
            addObject(f,300, 340);
            //Add a label
            addObject(scoreLabel, 50, 50);
            //Add a pizza
            spawnPizza(); 
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    public void spawnPizza()
    {
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        
        Pizza pizza = new Pizza();
        addObject(pizza,x, y);
    }  
    public void spawnFries()
    {
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        
        Fries fries = new Fries();
        addObject(fries, x, y);
    } 
    
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over!", 100);
        addObject(gameOverLabel, 300, 200);   
        GameOverWorld world = new GameOverWorld();
        Greenfoot.setWorld(world);
    }
}
