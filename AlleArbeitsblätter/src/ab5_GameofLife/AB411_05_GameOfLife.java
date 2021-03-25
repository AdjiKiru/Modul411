package ab5_GameofLife;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class AB411_05_GameOfLife extends JFrame {

    final static int DIM1 = 10;
    final static int DIM2 = 10;
    private JFrame frame;

    public static void main(String[] args) {


        boolean[][] welt = initWelt();
        System.out.println("Startkonstellation");
        zeigeWelt(welt);
        for (int i = 1; i <= 100; i++){
            welt = wendeRegelnAn(welt);
            System.out.println("Generation "+i);
            zeigeWelt(welt);
        }
    }

    public static boolean[][] initWelt() {
        return new boolean[DIM1][DIM2];
    }
    public static void zeigeWelt(boolean[][] welt){
        for (int i = 0; i < welt.length; i++) {
            for (int j = 0; j < welt[i].length; j++){
                welt[i][j] = Math.random() > 0.4;
                System.out.print(welt[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static int anzNachbarn(boolean[][] welt, int x, int y) {
        int ret = 0;
        try {
            for (int i = x - 1; i <= x + 1 ; ++i)
                for (int j = y - 1; j <= y + 1 ; ++j)
                    if (welt[i][j])
                        ret += 1;
        }
        catch (ArrayIndexOutOfBoundsException ignored){

        }
        return ret;
    }
    public static boolean[][] wendeRegelnAn(boolean[][] welt){
        for (int i = 0; i< welt.length; i++) {
            for (int j = 0; j < welt[i].length; j++){
                int nachbaren = anzNachbarn(welt, i, j);
                if(welt[i][j] && nachbaren < 2 || welt[i][j] && nachbaren > 3){
                    welt[i][j] = false;
                }
                else if(!welt[i][j] && nachbaren == 3){
                    welt[i][j] = true;
                }
            }
        }
        return welt;
    }
}
