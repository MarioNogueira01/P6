/**
 * @author Mario_Nogueira a76947
 * @version 1.1 26/02/2023
 * @inv verifica a intercecao de cada segmento de reta do quadrado com o segmento de reta original
 */

package L;

class Line {

    Ponto a,b;
    public Line(Ponto x, Ponto y){
        this.a = x;
        this.b = y;
    }


    public Ponto getA() { return a; }
    public Ponto getB() { return b; }


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

}
