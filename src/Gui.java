// Proyecto 2
// Orozco Aguilar Alejandra 
// 4CM12

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.List;
import java.util.ArrayList;

import java. awt.*;

public class Gui extends JFrame {
    public static void main(String[] args){ 
        int asteroides = Integer.parseInt(args[0]);
        Gui gui = new Gui(asteroides); 
        gui.setVisible(true);
    }
    
    public Gui(int asteroides){
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel p = new Panel(asteroides);
        add(p);
    }

    private class Panel extends JPanel {  
        
        Asteroide poligonoIrreg;
        List<Asteroide> asteroides;

        public Panel(int numAsteroides){
            super();
            setBackground(Color.white);
            this.asteroides = new ArrayList<Asteroide>(numAsteroides);
            for (int i = 0; i < numAsteroides; i++) {
                int vertices = (int)(Math.random() * 20 + 1);
                poligonoIrreg = new Asteroide(vertices);
                poligonoIrreg.generaVertices();
                poligonoIrreg.ordenaVerticesPorAngulo();
                asteroides.add(poligonoIrreg);
            }
        }  

        @Override
        public void paintComponent(Graphics g){
            for (Asteroide poligonoIrreg : asteroides) {
                //Color aleatorio para cada asteroide
                int r = (int)(Math.random() * 255);
                int gr = (int)(Math.random() * 255);
                int b = (int)(Math.random() * 255);
                g.setColor(new Color(r, gr, b));
                Polygon poligono=new Polygon();
                for (Coordenada coordenada : poligonoIrreg.getList()) {
                    poligono.addPoint((int)coordenada.abcisa(), (int)coordenada.ordenada());
                }
                g.drawPolygon(poligono);
            }
            
        }
    }
}   
