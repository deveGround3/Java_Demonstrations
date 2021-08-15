
import java.awt.*;
import javax.swing.JPanel;
import java.io.*;
import java.util.Arrays;
import javax.imageio.ImageIO;

public class MapArtContentDisplay extends JPanel {
    Color RGBcolor;
    String[][] type2;
    int Mapdim;
    Image grassTile;
    Image waterTile;
    Image mountainTile;
    Image fortTile;
    Image forestTile;
    boolean Gamerunning;
    boolean Gameliving;
    boolean Gamepaused;
    
    public MapArtContentDisplay(String[][] type2, int Mapdim){
        this.type2 = type2;
        this.Mapdim = Mapdim;
        Gamerunning = false;
        Gameliving = false;
        try {   //reads the tile images and assigns them
            grassTile = ImageIO.read(new File("src/Map_Tiles/Pixel Art #1.png"));
            waterTile = ImageIO.read(new File("src/Map_Tiles/Water Tile.png"));
            mountainTile = ImageIO.read(new File("src/Map_Tiles/Mountain Tile.png"));
            fortTile = ImageIO.read(new File("src/Map_Tiles/Fortress Tile.png"));
            forestTile = ImageIO.read(new File("src/Map_Tiles/Forest Tile.png"));
        } catch (IOException e) {
        }
        System.out.println(Arrays.deepToString(type2));
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.white);
        for (int y = 0; y < type2.length; y++) {
            for (int x = 0; x < type2[y].length; x++) {
                int CoordinateX = (Mapdim / type2.length) * x;  
                int CoordinateY = (Mapdim / type2.length) * y;
                switch (type2[y][x]) {
                    case "Field":
                        g.drawImage(grassTile, CoordinateX, CoordinateY, this);
                        break;
                    case "Forest":
                        g.drawImage(forestTile, CoordinateX, CoordinateY, this);
                        break;
                    case "Fort":
                        g.drawImage(fortTile, CoordinateX, CoordinateY, this);
                        break;
                    case "Mountain":
                        g.drawImage(mountainTile, CoordinateX, CoordinateY, this);
                        break;
                    case "Water":
                        g.drawImage(waterTile, CoordinateX, CoordinateY, this);
                        break;
                }
            }
        }
    }
    @Override
    public void paint(Graphics g) { //delete later
        super.paint(g);
    }
    public void SetLiveStatus() {
        Gamerunning = true;     //boolean for handling pausing 
        Gameliving = true;      //boolean for handling game overs
    }
    public void AnimationRun() {
        final double GAME_HERTZ = 30;
        final double UPDATE_INTERVAL = 1000000000/GAME_HERTZ;
        
        double lastUpdateT = System.nanoTime();
        double lastRenderT = System.nanoTime();
        //Used to get the desired amount of time for each frame
        final double TARGET_FPS = 60;
        final double TARGET_UPDATE_INTERVAL = 1000000000/TARGET_FPS;
        //Used to find the current frames per second in the animation
        int FrameTime = (int)(lastUpdateT/1000000000);
        while (Gamerunning) {
            double now = System.nanoTime();
            if (!Gamepaused) {
                while (now - lastUpdateT > UPDATE_INTERVAL) {
                    Update();
                    lastUpdateT += UPDATE_INTERVAL;
                }
            }
        }
    }
    private void Update() {
        
    }
}
