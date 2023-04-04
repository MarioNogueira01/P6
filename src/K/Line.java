/**
 * @author Mario_Nogueira a76947
 * @version 1.1 26/02/2023
 * @inv verifica a intercecao de cada segmento de reta do quadrado com o segmento de reta original
 */

package K;

class Line {

    Ponto a,b;
    public Line(Ponto x,Ponto y){
        this.a = x;
        this.b = y;
    }


    public Ponto getA() { return a; }
    public Ponto getB() { return b; }

    public static void check(Line x){
        if (x.getA().getX() == x.getB().getX() && x.getA().getY() == x.getB().getY()){
            System.out.println("Segmento:vi");
            System.exit(0);
        }
    }

    private static boolean onSegment(Ponto a, Ponto b, Ponto c)
    {
        return b.getX() <= Math.max(a.getX(), c.getX()) && b.getX() >= Math.min(a.getX(), c.getX()) &&
                b.getY() <= Math.max(a.getY(), c.getY()) && b.getY() >= Math.min(a.getY(), c.getY());
    }

    private static int orientation(Ponto a, Ponto b, Ponto c)
    {
        int val = (b.getY() - a.getY()) * (c.getX() - b.getX()) -
                (b.getX() - a.getX()) * (c.getY() - b.getY());

        if (val == 0) return 0;

        return (val > 0)? 1: 2;
    }

    public static boolean intersection(Ponto a, Ponto b, Ponto c, Ponto d){
        int o1 = orientation(a,b,c);
        int o2 = orientation(a,b,d);
        int o3 = orientation(c,d,a);
        int o4 = orientation(c,d,b);

        if (o1 != o2 && o3 != o4) return true;

        if (o1 == 0 && onSegment(a, c, b)) return true;

        if (o2 == 0 && onSegment(a, d, b)) return true;

        if (o3 == 0 && onSegment(c, a, d)) return true;

        if (o4 == 0 && onSegment(c, b, d)) return true;

        return false;
    }

}
