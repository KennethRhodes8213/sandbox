import objectdraw.*;
import java.awt.*;

public class RisingSun extends WindowController{
    
    private FilledOval sun;
    private Text instructions;
    private Location initialLocation = new Location(150, 350);
    
    public void begin(){
        // Create a circle at location (150, 350) with rad 100
        sun = new FilledOval(initialLocation, 100, 100, canvas);
        
        Color myColor = new Color(0, 200, 255);
        
        sun.setColor(myColor);
        instructions = new Text("Please click the mouse repeatedly", 20, 20, canvas);
        
    }
    
    public void onMouseClick(Location point){
        sun.move(0, -10);
        instructions.hide();
    }
    
    public void onMouseExit(Location point){
        sun.moveTo(initialLocation);
        instructions.show();
    }
}
