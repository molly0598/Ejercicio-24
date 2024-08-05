public class Esfera {
    private double masa;

    public Esfera(double masa) {
        this.masa = masa;
    }

    public double obtenerMasa() {
        return masa;
    }

    public static Esfera determinarEsferaMasPesada(Esfera x, Esfera y, Esfera z) {
        if (x.obtenerMasa() > y.obtenerMasa() && x.obtenerMasa() > z.obtenerMasa()) {
            return x;
        } else if (y.obtenerMasa() > x.obtenerMasa() && y.obtenerMasa() > z.obtenerMasa()) {
            return y;
        } else {
            return z;
        }
    }
}