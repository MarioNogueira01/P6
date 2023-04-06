/**
 * @author Mario_Nogueira a76947
 * @version 1.3 03/03/2023
 * @inv verifica se a trajetoria intercepta a si mesma
 */
package L;

import java.util.ArrayList;

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

}
