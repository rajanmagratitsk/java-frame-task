import java.applet.Applet;
import java.awt.*;
public class AnimationExample extends Applet {
public void paint(Graphics g)
{
 int x=150,y=150,a=10,b=10;
 for(int i=0;i<15;i++)
 {
 try
 {
 Thread.sleep(1000);
 }
 catch(InterruptedException e)
 {
 
 }
 g.drawOval(x,y,a,b);
 x=x-10;
 y=y-10;
 a=a+8;
 b=b+8;
 }
}
 public void init() {
 // TODO start asynchronous download of heavy resources
 }
 // TODO overwrite start(), stop() and destroy() methods
}