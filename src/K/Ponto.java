/**
 * @author Mario_Nogueira a76947
 * @version 1.1 26/02/2023
 * @inv confirma se os pontos estao no primeiro quadrante
 */

package K;

class Ponto {
    private int x;
    private int y;
    public Ponto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void check(Ponto a) {//confirma que os pontos estao no primeiro quadrante sendo maiores do que 0
        if (a.getX()<0 || a.getY()<0){
            System.out.println("Ponto:vi");
            System.exit(0);
        }
    }
    public int getX() { return x; }
    public int getY() { return y; }

    double dist (Ponto p) {//calcula a distancia entre dois pontos
        double dx = x - p.x;
        double dy = y - p.y;

        return Math.sqrt(dx*dx + dy*dy);
    }

    public String toPrint(){
        return "(" +
                this.getX() +
                ";" +
                this.getY() +
                ")";
    }

}
