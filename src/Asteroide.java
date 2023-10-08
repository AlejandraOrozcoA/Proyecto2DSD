// Proyecto 2
// Orozco Aguilar Alejandra 
// 4CM12

public class Asteroide extends PoligonoIrreg{

    private float perimetro;

    public Asteroide(int numVertices) {
        super(numVertices);
    }
    
    public float obtienePerimetro(){
        perimetro = 0;
        for (Coordenada coordenada : list) {
            if (list.indexOf(coordenada) > 0 && list.indexOf(coordenada) < list.size() - 1) {
                perimetro += calculaMagnitud(coordenada, list.get(list.indexOf(coordenada) - 1));
            }
        }
        perimetro += calculaMagnitud(list.get(0), list.get(list.size() - 1));
        return perimetro;
    }

    public float getPerimetro(){
        return perimetro;
    }
}
