import java.awt.*;
import java.io.IOException;
import javax.swing.*;

public class MapArt extends JFrame {
    String[][] type2;
    private int mapDim;
    private long period;
    MapArtContentDisplay content;
    
    public MapArt (String[][] type2, int mapDim, long period) {
        this.type2 = type2;
        this.mapDim = mapDim;
        this.period = period;
        
        content = new MapArtContentDisplay(type2, mapDim);   //creates a new object for the JPanel
        content.setPreferredSize(new Dimension(mapDim, mapDim));    //sets the size of the panel
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(content);
        pack();
        setVisible(true);
        for (int i = 0; i < 3; i++) {
            content.repaint();
        }
    }
}
