// Proyecto 2
// Orozco Aguilar Alejandra 
// 4CM12

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java. awt.*;

public class Gui extends JFrame {
    public static void main(String[] args){ 
        int asteroides = Integer.parseInt(args[0]);
        Gui gui = new Gui(asteroides); 
        gui.setVisible(true);
    }
    
    public Gui(int asteroides){
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel p = new Panel(asteroides);
        add(p);
    }

    private class Panel extends JPanel {  
        
        Asteroide poligonoIrreg;
        List<Asteroide> asteroides;
        List<Asteroide> asteroidesADibujar;
        private Timer timer;
        private boolean flag = false;

        public Panel(int numAsteroides){
            super();
            setBackground(Color.white);
            this.asteroides = new ArrayList<Asteroide>(numAsteroides);
            for (int i = 0; i < numAsteroides; i++) {
                //Numero de vertices aleatorio entre 5 y 20
                int vertices = (int)(Math.random() * 15) + 5;
                poligonoIrreg = new Asteroide(vertices);
                poligonoIrreg.generaVertices();
                poligonoIrreg.ordenaVerticesPorAngulo();
                asteroides.add(poligonoIrreg);
            }
            asteroidesADibujar = this.asteroides;
            timer = new Timer();
            timer.schedule(new TimerTask(){
                @Override
                public void run(){
                    SwingUtilities.invokeLater(() -> {
                        asteroidesADibujar.clear();
                        repaint();
                    });
                }
            },3000);
        }  

        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            for (Asteroide poligonoIrreg : asteroidesADibujar) {
                //Color aleatorio para cada asteroide
                int r = (int)(Math.random() * 255);
                int gr = (int)(Math.random() * 255);
                int b = (int)(Math.random() * 255);
                g.setColor(new Color(r, gr, b));
                g2d.setStroke(new BasicStroke(2));
                Polygon poligono=new Polygon();
                for (Coordenada coordenada : poligonoIrreg.getList()) {
                    poligono.addPoint((int)coordenada.abcisa(), (int)coordenada.ordenada());
                }
                g.drawPolygon(poligono);
            }
        }
    }
}   
