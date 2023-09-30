// Proyecto 2
// Orozco Aguilar Alejandra 
// 4CM12

class Coordenada {
    private double x;
    private double y;
    private double angulo;

    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double abcisa() {
        return x;
    }

    public double ordenada() {
        return y;
    }

    public double getAngulo() {
        return angulo;
    }

    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }
}


