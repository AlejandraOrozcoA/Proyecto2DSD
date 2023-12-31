// Proyecto 2
// Orozco Aguilar Alejandra 
// 4CM12

import java.util.Comparator;

    public class Ordenar {
        
        public class OrdenPorAbcisa implements Comparator<Coordenada> {
            @Override
            public int compare(Coordenada c1, Coordenada c2) {
                return Double.compare(c1.abcisa(), c2.abcisa());
            }
        }

        public class OrdenPorAngulo implements Comparator<Coordenada> {
            @Override
            public int compare(Coordenada c1, Coordenada c2) {
                return Double.compare(c1.getAngulo(), c2.getAngulo());
            }
        }
        
        //Ordena por perimetro
        public class OrdenPorPerimetro implements Comparator<Asteroide> {
            @Override
            public int compare(Asteroide a1, Asteroide a2) {
                return Float.compare(a1.getPerimetro(), a2.getPerimetro());
            }
        }
}
