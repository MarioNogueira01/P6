package K;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Populacao {

    private static final Random generator = new Random(0);
    private ArrayList<Trajectory> trajetorias;

    public Populacao (int n, int [] traj, Ponto inicial, Ponto fim) {
        trajetorias = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Ponto> pontos = new ArrayList<>();
            for (int j = 0; j < traj[i]; j++) {
                int x = generator.nextInt(100);
                int y = generator.nextInt(100);
                Ponto p1 = new Ponto(x, y);
                pontos.add(p1);
            }
            pontos.add(0,inicial);
            pontos.add(fim);
            trajetorias.add(new Trajectory(pontos));
        }
    }

    public void orden(List<FiguraGeometrica> fig){
        ArrayList<Trajectory> trajord = new ArrayList<>();
        for(int i = 0; i < trajetorias.size(); i++){
            Trajectory traj1 = trajetorias.get(generator.nextInt(trajetorias.size()));
            Trajectory traj2 = trajetorias.get(generator.nextInt(trajetorias.size()));
            if(traj1.avaluation(fig) >= traj2.avaluation(fig)){
                trajord.add(traj1);
            }
            else {
                trajord.add(traj2);
            }
        }
        this.trajetorias = trajord;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < trajetorias.size(); i++) {
            sb.append(trajetorias.get(i).toString());
            if (i != trajetorias.size() - 1) {
                sb.append("\n"); // Adiciona uma quebra de linha após cada trajetória, exceto a última
            }
        }
        return sb.toString();
    }
}
