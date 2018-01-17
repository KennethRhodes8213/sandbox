import objectdraw.*;
import java.awt.*;

// A program that displays the words "Pressed" and "Released"
// where the mouse button is pressed and released while connecting
// each such pair of points with a line.
public class ConnectTwo extends WindowController{
    
    private FilledRect FilledRect1;
    private Location initPoint;
    private FilledRect FilledRect2;
    Color FilledRect1Color = new Color(196, 204, 252, 100);
    
    public void onMousePress(Location pressPoint){
        FilledRect1 = new FilledRect(pressPoint, pressPoint, canvas);
        initPoint = pressPoint;
    }
    
    public void onMouseDrag(Location point){
       FilledRect1.hide();
       FilledRect1 = new FilledRect(initPoint, point, canvas);
       FilledRect1.setColor(FilledRect1Color);
    }
    
    public void onMouseRelease(Location releasePoint){
        FilledRect2 = new FilledRect(initPoint, releasePoint, canvas);
    }
    
    public void onMouseExit(Location point){
        canvas.clear();
    }

}