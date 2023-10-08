// Proyecto 2
// Orozco Aguilar Alejandra 
// 4CM12

import java.util.ArrayList;
import java.util.List;

public class PoligonoIrreg {
    protected List<Coordenada> list;
    int numVertices;

    public PoligonoIrreg(int numVertices) {
        this.numVertices = numVertices;
        list = new ArrayList<Coordenada>(numVertices);
    }

    public void anadeVertice(Coordenada coordenada) {
        list.add(coordenada);
    }

    public void generaVertices(){
        for (int i = 0; i < numVertices; i++) {
            double x = Math.random() * 200 ;
            double y = Math.random() * 200 ;
            Coordenada vertice = new Coordenada(x, y);
            anadeVertice(vertice);
        }
    }

    public Coordenada getVerticeReferencia(List<Coordenada> list){
        double sumaAbcisas = 0;
        double sumaOrdenadas = 0;
        for (Coordenada coordenada : list) {
            sumaAbcisas += coordenada.abcisa();
            sumaOrdenadas += coordenada.ordenada();
        }
        double promedioAbcisas = sumaAbcisas / (list.size());
        double promedioOrdenadas = sumaOrdenadas / (list.size());
        Coordenada verticeReferencia = new Coordenada(promedioAbcisas, promedioOrdenadas);
        return verticeReferencia;
    }


    public double calculaAngulo(Coordenada verticeReferencia, Coordenada verticeActual){
        double hipotenusa = Math.sqrt(Math.pow(verticeActual.abcisa() - verticeReferencia.abcisa(), 2) + Math.pow(verticeActual.ordenada() - verticeReferencia.ordenada(), 2));
        double catetoAdyacente = verticeActual.abcisa() - verticeReferencia.abcisa();
        double catetoOpuesto = verticeActual.ordenada() - verticeReferencia.ordenada();
        double angulo = Math.toDegrees(Math.acos(catetoAdyacente / hipotenusa));
        if (catetoOpuesto > 0) {
            angulo = 360 - angulo;
        }
        return angulo;
    }

    public void ordenaVerticesPorAngulo(){
        Coordenada verticeReferencia = getVerticeReferencia(list);
        for (Coordenada verticeActual : list) {
            verticeActual.setAngulo(calculaAngulo(verticeReferencia, verticeActual));
        }
        Ordenar ordenar = new Ordenar();
        list.sort(ordenar.new OrdenPorAngulo());
    }

    public void centrarPoligono(int mitadX, int mitadY){
        Coordenada verticeReferencia = getVerticeReferencia(list);
        double dezplamientoX = mitadX - verticeReferencia.abcisa();
        double dezplamientoY = mitadY - verticeReferencia.ordenada();
        //dezplazamos todos los vertices
        for (Coordenada coordenada : list) {
            coordenada.setAbcisa(coordenada.abcisa() + dezplamientoX);
            coordenada.setOrdenada(coordenada.ordenada() + dezplamientoY);
        }
    }

    public List<Coordenada> getList() {
        return list;
    }

    public double calculaMagnitud(Coordenada coor1, Coordenada coor2){
        double magnitud = Math.sqrt(Math.pow(coor2.abcisa() - coor1.abcisa(), 2) + Math.pow(coor2.ordenada() - coor1.ordenada(), 2));
        return magnitud;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vértices del polígono irregular:\n");
        for (Coordenada coordenada : list) {
            sb.append("Abcisa: " + coordenada.abcisa() + ", Ordenada: " + coordenada.ordenada() + ", Angulo: " + coordenada.getAngulo() + "\n");
        }
        return sb.toString();
    }

}