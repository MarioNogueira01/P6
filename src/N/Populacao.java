package N;

import java.util.ArrayList;
import java.util.Random;

public class Populacao {

    private static final Random generator = new Random(0);
    private final ArrayList<Trajectory> trajetorias;

    private static Ponto random_point_creation(int x, int y){
        return new Ponto(x,y);
    }
    public Populacao (int n, int [] sizes_traj) {
        trajetorias = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Ponto> pontos = new ArrayList<>();
            for (int j = 0; j < sizes_traj[i]; j++) {
                Ponto p1 = random_point_creation(generator.nextInt(100),generator.nextInt(100));
                pontos.add(p1);
            }
            trajetorias.add(new Trajectory(pontos));
        }
    }

    public static void Remove_random(Populacao x, double prob, int[] sizes) {
        for (int i = 0;i<sizes.length;i++) {
            double r = generator.nextDouble();
            if (r<prob && sizes[i]>2){
                int place = generator.nextInt(sizes[i] - 2) + 1;
                x.trajetorias.get(i).getpontos().remove(place);
            }
        }
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