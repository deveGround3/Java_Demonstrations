
public class Displaystatus {
    private int mapnum;
    private boolean marked [][];
    private String type [][];
    
    public Displaystatus(int mapnum) {
        this.mapnum = mapnum;
        marked = new boolean[mapnum][mapnum];
        type = new String [mapnum][mapnum];
    }
    public void Initialize() {
        
        //initializing the values for lists
        for (int i = 0; i < marked.length; i++) {
            for (int i2 = 0; i2 < marked[i].length; i2++) {
                marked[i][i2] = false;
            }
        }
        for (int j = 0; j < type.length; j++) {
            for (int j2 = 0; j2 < type[j].length; j2++) {
                type[j][j2] = "None";
            }
        }
    }
    public boolean[][] getCompleteValues() {
        return marked;
    }
    public String[][] getTerrainValues() {
        return type;
    }
    public void UpdateValues(boolean[][] markedU, String[][] typeU)  {
        marked = markedU;
        type = typeU;
    }
}
