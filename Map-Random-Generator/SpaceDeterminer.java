
import java.util.Random;


public class SpaceDeterminer {
    private Displaystatus display;
    public boolean[][] marked;
    public String[][] type;
    
    public SpaceDeterminer(Displaystatus display) {
        this.display = display;
    }
    public void getValues() {
        marked = display.getCompleteValues(); 
        type = display.getTerrainValues();
    }
    public String[][] TerrainMaker() {
        //Determines the type of terrain for each square
        
        for (int i = 0; i < type.length; i++) {
            for (int i2 = 0; i2 < type[i].length; i2++) {
                if (marked[i][i2] == false) {
                    Random rand2 = new Random();
                    
                    //Random decides a terrain type for the square (Probalities subject to change later)
                    double num2 = (double)(Math.random() * 100);
                    if (num2 <= 75.00) {
                        type[i][i2] = "Field";
                    }
                    else if (num2 <= 85.00) {
                        type[i][i2] = "Forest";
                    }
                    else if (num2 <= 90.00) {
                        type[i][i2] = "Water";
                    }
                    else if (num2 <= 95.00) {
                        type[i][i2] = "Mountain";
                    }
                    else {
                        type[i][i2] = "Fort";
                    }
                    marked[i][i2] = true;
                }
            }
        }
        display.UpdateValues(marked, type);
        return type;
    }
}
