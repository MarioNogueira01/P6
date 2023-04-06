/**
 * @author Mario_Nogueira a76947
 * @version 1.1 26/02/2023
 * @inv confirma se os pontos estao no primeiro quadrante
 */

package L;

class Ponto {
    private final int x;
    private final int y;
    public Ponto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public String toPrint(){
        return "(" +
                this.getX() +
                ";" +
                this.getY() +
                ")";
    }

    public static boolean iseqauls(Ponto x, Ponto y){
        return x.getX() == y.getX() && x.getY() == y.getY();
    }
}
