package J;

public class Circunferencia extends FiguraGeometrica{
    Ponto a;
    int raio;
    public Circunferencia(String s){
        super();
        String[] x = s.split(" ",-1);
        this.a = new Ponto(Integer.parseInt(x[1]), Integer.parseInt(x[2]));
        this.raio = Integer.parseInt(x[3]);
    }

    @Override
    public boolean intercecao(Trajectory y) {
        int size = y.getpontos().size();
        for (int i=0;i<size;i++){
            Ponto p1 = y.getpontos().get(i);
            Ponto p2 = y.getpontos().get(i+1);
        double d1 = Math.sqrt(Math.pow(p1.getX() - a.getX(), 2) + Math.pow(p1.getY() - a.getY(), 2));
        double d2 = Math.sqrt(Math.pow(p2.getX() - a.getX(), 2) + Math.pow(p2.getY() - a.getY(), 2));
        if (d1 < raio && d2 < raio) {
            return false;
        } else if (d1 < raio || d2 < raio) {
            return true;
        }
        double m = (double) (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
        double b = p1.getY() - m * p1.getX();
        double A = Math.pow(m, 2) + 1;
        double B = 2 * m * b - 2 * a.getX() - 2 * a.getY() * m;
        double C = Math.pow(a.getX(), 2) + Math.pow(a.getY(), 2) + Math.pow(b, 2) - 2 * a.getY() * b - Math.pow(raio, 2);
        double delta = Math.pow(B, 2) - 4 * A * C;
        if (delta < 0) {
            return false;
        }
        double x1 = (-B + Math.sqrt(delta)) / (2 * A);
        double y1 = m * x1 + b;
        double x2 = (-B - Math.sqrt(delta)) / (2 * A);
        double y2 = m * x2 + b;
        double minX = Math.min(p1.getX(), p2.getX());
        double maxX = Math.max(p1.getX(), p2.getY());
        double minY = Math.min(p1.getY(), p2.getY());
        double maxY = Math.max(p1.getY(), p2.getY());
        if (x1 >= minX && x1 <= maxX && y1 >= minY && y1 <= maxY) {
            return true;
        }
        if (x2 >= minX && x2 <= maxX && y2 >= minY && y2 <= maxY) {
            return true;
        }
        }
        return false;

    }


    @Override
    public void check(){
        if (this.raio < 0) {
            System.out.println("Circunferencia: vi");
            System.exit(0);
        }
    }
}