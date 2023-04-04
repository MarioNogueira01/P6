/**
 * @author Mario_Nogueira a76947
 * @version 1.2 03/03/2023
 * @inv verifica se cada lado do retangulo interceta com a trajetoria de reta
 */

package J;

import java.util.ArrayList;

class Retangulo extends FiguraGeometrica {
     Ponto a,b,c,d;
    public Retangulo(String s){
        super();
        String[] x = s.split(" ",-1);
        this.a = new Ponto(Integer.parseInt(x[1]), Integer.parseInt(x[2]));
        this.b = new Ponto(Integer.parseInt(x[3]), Integer.parseInt(x[4]));
        this.c = new Ponto(Integer.parseInt(x[5]), Integer.parseInt(x[6]));
        this.d = new Ponto(Integer.parseInt(x[7]), Integer.parseInt(x[8]));
    }

    @Override
    public boolean intercecao(Trajectory y) {
        ArrayList<Ponto> pontos = y.getpontos();
        boolean test = false;
        for (int j = 0;j<pontos.size()-1;j++){
            boolean a = Line.intersection(this.getA(), this.getB(), pontos.get(j), pontos.get(j+1));
            boolean b = Line.intersection(this.getB(), this.getC(), pontos.get(j), pontos.get(j+1));
            boolean c = Line.intersection(this.getC(), this.getD(), pontos.get(j), pontos.get(j+1));
            boolean d = Line.intersection(this.getA(), this.getD(), pontos.get(j), pontos.get(j+1));

            if(a || b || c || d){
                return true;
            }
        }
        return test;
    }

    public Ponto getA(){return a;}
    public Ponto getB(){return b;}
    public Ponto getC(){return c;}
    public Ponto getD(){return d;}

    @Override
    public void check(){//confirma que e um rectangulo
        if (this.a.dist(this.c) != this.b.dist(this.d) && this.a.dist(this.c) == 0){
            System.out.println("Retangulo:vi");
            System.exit(0);
        }
    }
}
