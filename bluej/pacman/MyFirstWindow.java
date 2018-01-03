import objectdraw.*;
import java.awt.*;


/**
 * Write a description of class MyFirstWindow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyFirstWindow extends WindowController
{    
    // instance variables - replace the example below with your own
    private Location pacmanInit = new Location(100, 100);
    private Location ghostInit = new Location(20, 100);
    private Line line1; // Top Border
    private Line line2; // Bottom Border
    private Text text1; // "Click to move!"
    private Text text2; // "You loose!"
    private FramedRect rect1; // Dot
    private FilledOval oval1; // Ghost Body
    private FilledArc filledArc1; // Pacman
    private double clickCount;
    // DrawingCanvas canvas; we get this for free by extending WindowController

    public void begin(){
        // Borders
        line1 = new Line(0, 75, canvas.getWidth(), 75, canvas);
        line2 = new Line(0, 175, canvas.getWidth(), 175, canvas);
        
        // Text
        text1 = new Text("Click to move!", 50, 50, canvas);
        text2 = new Text("You loose!", 50, 50, canvas);
        text2.hide();
        
        // PacMan
        filledArc1 = new FilledArc(pacmanInit, 50, 50, 320, -290, canvas);
        filledArc1.setColor(Color.YELLOW);
        
        // Dot
        rect1 = new FramedRect(175, 120, 20, 20, canvas);
        //rect1.setColor(Color.YELLOW);
        
        // STRETCH: Ghost
        oval1 = new FilledOval(ghostInit, 40, 60, canvas); // Body
        oval1.setColor(Color.BLUE);
        
        
    }

    public void onMouseClick(Location p){
        // Move Pacman and Ghost [ Ghost moves slightly faster! ]
        filledArc1.move(10, 0);
        oval1.move(15, 0);
        text1.hide();
        
        clickCount++;
        System.out.println(clickCount);
        if (clickCount == 5) {
            rect1.hide();
        }
        
        if (clickCount == 9) {
            filledArc1.hide();
            text2.show();
        }
        
    }
    
    public void onMouseExit(Location p){
        // Reset
        filledArc1.moveTo(pacmanInit);
        oval1.moveTo(ghostInit);
        
        clickCount = 0;
        if (rect1.isHidden()) {
            rect1.show();
        }
        
        if (filledArc1.isHidden()) {
            filledArc1.show();
        }
        
        if (text1.isHidden()) {
            text1.show();
        }
        
        if (!text2.isHidden()) {
            text2.hide();
        }
    }
}
