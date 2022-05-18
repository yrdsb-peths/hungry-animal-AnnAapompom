import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Frog here.
 */
public class Frog extends Actor
{
    private GreenfootImage[] images;
    private GreenfootImage[] rightImages;
    private GreenfootImage[] leftImages;

    private SimpleTimer animTimer;
    private int delay = 0;
    private boolean isFacingRight = true;
    
    public Frog()
    {
        images = new GreenfootImage[5];        
        images[0] = new GreenfootImage("images/frog_animate/frog0.png");
        for(int i = 0; i < images.length; i++)
        {
            images[i] = new GreenfootImage("images/frog_animate/frog" + i + ".png");
            rightImages = new GreenfootImage[5]; 
            leftImages = new GreenfootImage[5];        
            for( i = 0; i < rightImages.length; i++)
            {
                rightImages[i] = new GreenfootImage("images/frog_animate/frog" + i + ".png");
                //rightImages[i].scale(100,100);
                leftImages[i] = new GreenfootImage("images/frog_animate/frog" + i + ".png"); 
                leftImages[i].mirrorHorizontally();
                //leftImages[i].scale(100,100);
            }
        }
        setImage(images[0]);
        setImage(rightImages[0]);
        animTimer = new SimpleTimer();
        animTimer.mark();
    }    
    
    int curIndex = 0;
    public void animate()
    {
        setImage(images[curIndex]);
        curIndex++;
        curIndex %= 5;
        if(animTimer.millisElapsed() > 800)
        {
            if(isFacingRight)
            {
                setImage(rightImages[curIndex]);
            }
            else
            {
                setImage(leftImages[curIndex]);
            }
            curIndex++;
            curIndex %= 5;
            animTimer.mark();
        }
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("a"))
        {
            isFacingRight = false;
            move(-3);
        }
        if(Greenfoot.isKeyDown("d"))
        {
            isFacingRight = true;
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