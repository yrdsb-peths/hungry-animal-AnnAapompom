import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Frog here.
 */
public class Frog extends Actor
{
    private GreenfootImage[] images;
    
    public Frog()
    {
        images = new GreenfootImage[3];
        images[0] = new GreenfootImage("images/frog_animate/frog0.png");
        for(int i = 0; i < images.length; i++)
        {
            images[i] = new GreenfootImage("images/frog_animate/frog" + i + ".png"); //complete   
        }
        setImage(images[0]);
    }    
    int curIndex = 0;
    public void animate()
    {
        setImage(images[curIndex]);   
        curIndex++;
        curIndex %= 3;
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("a"))
        {
            move(-3);
        }
        if(Greenfoot.isKeyDown("d"))
        {
            move(3);
        }
        eat();
        animate();
    }
    public void eat()
    {
        if(isTouching(Pizza.class))
        {
            Greenfoot.playSound("frog_sound.mp3");
            removeTouching(Pizza.class);
            MyWorld world = (MyWorld) getWorld();
            world.increaseScore();
            world.spawnFries();
        }
        if(isTouching(Fries.class))
        {
            Greenfoot.playSound("frog_sound.mp3");
            removeTouching(Fries.class);
            MyWorld world = (MyWorld) getWorld();
            world.increaseScore();
            world.spawnPizza();
        }
    }
}