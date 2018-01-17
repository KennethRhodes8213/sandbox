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
    // Rope
    private Line line1;
    private Line line2;
    private Line line3;
    // Body
    private Line line4; // Body
    private Line line5; // LArm
    private Line line6; // RArm
    private Line line7; // LLeg
    private Line line8; // RLeg
    
    private Text text1;
    private FramedRect rect1;
    private FilledOval oval1; // Head
    private FramedOval frameOval1;
    
    int clicks;
    // DrawingCanvas canvas; we get this for free by extending WindowController

    public void begin(){
        /*line1 = new Line(0, 0, 50, 50, canvas);
        text1 = new Text("Hello Java!!", 100, 100, canvas);
        rect1 = new FramedRect(95, 100, 75, 15, canvas);
        oval1 = new FilledOval(200, 200, 25, 25, canvas);
        oval1.setColor(Color.RED);
        
        frameOval1 = new FramedOval(175, 175, 75, 75, canvas);*/
        
        //               x , y, dx, dy
        // Draw Rope
        line1 = new Line(25, 125, 25, 25, canvas);
        line2 = new Line(25, 25, 75, 25, canvas);
        line3 = new Line(50, 25, 50, 50, canvas);
        
        // Draw Body
        oval1 = new FilledOval(40, 40, 20, 20, canvas);
        line4 = new Line(50, 60, 50, 85, canvas); // Body
        line5 = new Line(50, 75, 65, 65, canvas); // RAarm
        line6 = new Line(50, 75, 35, 65, canvas); // LArm
        line7 = new Line(50, 85, 65, 95, canvas); //RLeg
        line8 = new Line(50, 85, 35, 95, canvas); // LLeg
        
        // Hide parts
        oval1.hide();
        line4.hide();
        line5.hide();
        line6.hide();
        line7.hide();
        line8.hide();
    }

    public void onMouseClick(Location p){
        clicks++;
        if(clicks == 1){
            oval1.show();
        }else if(clicks == 2){
            line4.show();
        }else if(clicks == 3){
            line5.show();
        }else if(clicks == 4){
            line6.show();
        }else if(clicks == 5){
            line7.show();
        }else if(clicks == 6){
            line8.show();
        }
    }
    
    public void onMouseExit(Location p){
        oval1.hide();
        line4.hide();
        line5.hide();
        line6.hide();
        line7.hide();
        line8.hide();
        
        clicks = 0;
    }
}
