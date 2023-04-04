package J;

import java.util.ArrayList;

public class Triangulo extends FiguraGeometrica {
    Ponto a,b,c;
    public Triangulo(String s){
        super();
        String[] x = s.split(" ",-1);
        this.a = new Ponto(Integer.parseInt(x[1]), Integer.parseInt(x[2]));
        this.b = new Ponto(Integer.parseInt(x[3]), Integer.parseInt(x[4]));
        this.c = new Ponto(Integer.parseInt(x[5]), Integer.parseInt(x[6]));
    }

    @Override
    public boolean intercecao(Trajectory y) {
        ArrayList<Ponto> pontos = y.getpontos();
        boolean test = false;
        for (int j = 0;j<pontos.size()-1;j++){
            boolean a = Line.intersection(this.getA(), this.getB(), pontos.get(j), pontos.get(j+1));
            boolean b = Line.intersection(this.getB(), this.getC(), pontos.get(j), pontos.get(j+1));
            boolean c = Line.intersection(this.getC(), this.getA(), pontos.get(j), pontos.get(j+1));

            if(a || b || c){
                return true;
            }
        }
        return test;
    }

    public Ponto getA(){return a;}
    public Ponto getB(){return b;}
    public Ponto getC(){return c;}

    @Override
    public void check(){
        if(a.dist(b) + b.dist(c) <= c.dist(a) || a.dist(b) + a.dist(c) <= b.dist(c) || b.dist(c) + a.dist(c) <= a.dist(b)){
            System.out.println("Triangulo:vi");
            System.exit(0);
        }
        if(a.getX() == b.getX() && a.getX() == c.getX() || a.getY() == b.getY() && a.getY() == c.getY() || a.getX() == a.getY() && b.getX() == b.getY() && c.getX() == c.getY()){
            System.out.println("Triangulo:vi");
            System.exit(0);
        }
    }
}
