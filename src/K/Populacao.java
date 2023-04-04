package K;

import java.util.ArrayList;
import java.util.Random;

public class Populacao {

    private static final Random generator = new Random(0);
    private ArrayList<Trajectory> trajetorias;

    public Populacao (int n, ArrayList<int[]> traj) {
        trajetorias = new ArrayList<>();

        for (int i = 0; i < traj.size(); i++) {
            ArrayList<Ponto> pontos = new ArrayList<>();
            int[] points = traj.get(i);
            for (int j = 0; j < points.length-1; j+=2) {
                int x = points[i];
                int y = points[i+1];
                Ponto p1 = new Ponto(x, y);
                pontos.add(p1);
            }
            trajetorias.add(new Trajectory(pontos));
        }
    }

    public void cut(){
        int c = generator.nextInt(trajetorias.get(0).getpontos().size());
        //TODO: acabar esta função
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
