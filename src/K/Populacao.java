package K;

import java.util.ArrayList;
import java.util.Random;

public class Populacao {

    private static final Random generator = new Random(0);
    private final ArrayList<Trajectory> trajetorias;

    public Populacao (ArrayList<int[]> traj) {
        trajetorias = new ArrayList<>();

        for (int i = 0; i < traj.size(); i++) {
            ArrayList<Ponto> pontos = new ArrayList<>();
            int[] points = traj.get(i);
            for (int j = 0; j < points.length - 1; j += 2) {
                int x = points[j];
                int y = points[j + 1];
                Ponto p1 = new Ponto(x, y);
                pontos.add(p1);
            }
            trajetorias.add(new Trajectory(pontos));
        }
    }

    private ArrayList<Ponto> addiction(ArrayList<Ponto> x,int start,int end) {
        ArrayList<Ponto> result = new ArrayList<>();
        for (int i = start;i<end;i++){
            result.add(x.get(i));
        }
        return result;
    }

    private ArrayList<Ponto> creating(ArrayList<Ponto> x, ArrayList<Ponto> y) {
        ArrayList<Ponto> result = new ArrayList<>();
        result.addAll(x);
        result.addAll(y);
        for (int i = 0;i<result.size()-1;i++){
            if (Ponto.iseqauls(result.get(i),result.get(i+1))){
                result.remove(i);
            }
        }
        return result;
    }
    public void cut(){

        int size = trajetorias.get(0).getpontos().size();
        int size_1 = trajetorias.get(1).getpontos().size();
        int c = (size == 0) ? 1 : (generator.nextInt(size-1)+1);
        int d = (size_1 == 0) ? 1 : (generator.nextInt(size_1-1)+1);
        ArrayList<Ponto> a = addiction(trajetorias.get(0).getpontos(),0,c);
        ArrayList<Ponto> a_1 = addiction(trajetorias.get(0).getpontos(),c,size);
        ArrayList<Ponto> b = addiction(trajetorias.get(1).getpontos(),0,d);
        ArrayList<Ponto> b_1 = addiction(trajetorias.get(1).getpontos(),d,size_1);


        trajetorias.get(0).getpontos().clear();
        trajetorias.get(0).getpontos().addAll(creating(a,b_1));

        trajetorias.get(1).getpontos().clear();
        trajetorias.get(1).getpontos().addAll(creating(b,a_1));
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
