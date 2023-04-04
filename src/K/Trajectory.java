/**
 * @author Mario_Nogueira a76947
 * @version 1.3 03/03/2023
 * @inv verifica se a trajetoria intercepta a si mesma
 */
package K;
import java.util.ArrayList;
import java.util.List;

public class Trajectory {

    private final ArrayList<Ponto> ponto;


    public Trajectory(ArrayList<Ponto> ponto) {
        this.ponto = ponto;
    }

    public ArrayList<Ponto> getpontos(){
        return ponto;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < ponto.size(); i++) {
            sb.append(ponto.get(i).toPrint());
            if (i < ponto.size() - 1) {
                sb.append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public double distance(){
        double dist = 0;
        for(int i = 0; i < ponto.size()-1; i++){
            dist += ponto.get(i).dist(ponto.get(i+1));
        }
        return dist;
    }


    public int internum(List<FiguraGeometrica> figuraGeometricas){
        int num=0;
        for(FiguraGeometrica fig: figuraGeometricas){
            if(fig.intercecao(this)){
                num++;
            }
        }
        return num;
    }


    public double avaluation(List<FiguraGeometrica> figuraGeometricas){
        double dist = this.distance();
        int num = this.internum(figuraGeometricas);
        return 1/(dist + Math.exp(num));

    }
}
