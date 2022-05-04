import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Frog here.
 */
public class Frog extends Actor
{
    /**
     * Act - do whatever the Frog wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("a"))
        {
            move(-2);
        }
        if(Greenfoot.isKeyDown("d"))
        {
            move(2);
        }// 
        spawnPizza();
    }
    
    public void spawnPizza()
    {
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        if(isTouching(Pizza.class))
        {
            removeTouching(Pizza.class);
            
            addObject(pizza, x, y);
        }   
    }
}
