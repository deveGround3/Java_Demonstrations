/*BattleField Protptype Version 3
  Nicholas Schons */

import java.util.Random;

public class BattleField_Main {
    final static int DEFAULT_FPS = 60;//Frames per second for the game
    
    public static void main (String[] args) {
        int fps = DEFAULT_FPS;
        long period = (long) 1000000000/fps;    //converts to milliseconds
        Random rand = new Random();
        int mapnum = 0;
        int mapnum2 = 0;
        int num = rand.nextInt(3);  //randomly selects a number for game
        switch (num) {      //chooses the map size based on the number
            case 0: 
                mapnum = 7;
                mapnum2 = 350;  
                break;
            case 1: 
                mapnum = 9;
                mapnum2 = 450;
                break;
            case 2: 
                mapnum = 11;
                mapnum2 = 550;
                break;
        }
        Displaystatus display = new Displaystatus(mapnum);  //Displays and initializes the status for the map tiles
        display.Initialize();
        SpaceDeterminer spacelog = new SpaceDeterminer(display);    //Determines the terrain for each tile on the board
        spacelog.getValues();
        String[][] type2 = spacelog.TerrainMaker();
        MapArt map = new MapArt(type2, mapnum2, period);
    }
}
