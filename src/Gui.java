// Proyecto 2
// Orozco Aguilar Alejandra 
// 4CM12

import javax.swing.JFrame;
import javax.swing.JPanel;

import java. awt.*;

public class Gui extends JFrame {
    public static void main(String[] args){ 
        int vertices = Integer.parseInt(args[0]);
        Gui gui = new Gui(vertices); 
        gui.setVisible(true);
    }
    
    public Gui(int vertices){
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel p = new Panel(vertices);
        add(p);
    }

    
    private class Panel extends JPanel {  
        
        PoligonoIrreg poligonoIrreg;

        public Panel(int vertices){
            super();
            setBackground(Color.white);
            poligonoIrreg = new PoligonoIrreg(vertices);
            poligonoIrreg.generaVertices();
            poligonoIrreg.ordenaVerticesPorAngulo();
        }  

        @Override
        public void paintComponent(Graphics g){
            g.setColor(Color.blue);
            Polygon poligono=new Polygon();
            for (Coordenada coordenada : poligonoIrreg.getList()) {
                poligono.addPoint((int)coordenada.abcisa(), (int)coordenada.ordenada());
            }
            g.drawPolygon(poligono);
            System.out.println(poligonoIrreg);
        }
    }
}   
