package M;

import java.util.ArrayList;
import java.util.Random;

public class Populacao {

    private static final Random generator = new Random(0);
    private final ArrayList<Trajectory> trajetorias;

    private static Ponto random_point_creation(int x, int y){
        return new Ponto (x,y);
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

    public static void adiction_random(Populacao x, double prob, int[] sizes) {
        int size = sizes.length;
        for (int i = 0;i<size;i++){
            double r = generator.nextDouble(1);
            int size_traj = sizes[i];
            int place;
            if (r < prob) {
                if (size_traj>2){
                    place = generator.nextInt(size_traj) + 1;
                }else{
                    place = 1;
                }


                Ponto point_to_add = random_point_creation(generator.nextInt(100), generator.nextInt(100));
                if (x.trajetorias.get(i).getpontos().contains(point_to_add)) {
                    continue;
                }

                x.trajetorias.get(i).getpontos().add(place, point_to_add);
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