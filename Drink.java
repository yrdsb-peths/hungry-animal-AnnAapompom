import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Drink here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Drink extends Actor
{
    private int speed = 1;

    public void act()
    {
        int x = getX();
        int y = getY();
        setLocation(x, y + 2);
        setLocation(x, y + speed);

        MyWorld world = (MyWorld) getWorld();
        if(getY() >= getWorld().getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
    }
}
