package K;

import java.util.*;
public class RandomCreation {
    private int n,p;
    private static final Random generator = new Random(0);
    public RandomCreation(int m, int d){
        this.n = m;
        this.p = d;
    }
    public static Ponto[] points_Creation(int n){
        int j = 0;
        int[] Result_points = new int[(n)*2];
        Ponto[] Result = new Ponto[n];

        for (int i=0;i<Result_points.length;i++){
            Result_points[i] = generator.nextInt(100);
        }
        for (int i = 1;i<(Result_points.length)+1;i+=2){
            Result[j++] = new Ponto(Result_points[i-1],Result_points[i]);
        }
        return Result;
    }

    public static ArrayList<Ponto> random_Trajectory(int n,Ponto inicio,Ponto fim){
        ArrayList<Ponto> result = new ArrayList<>();
        result.add(inicio);
        Ponto[] Ponto_Creation = points_Creation(n);

        result.addAll(Arrays.asList(Ponto_Creation));
        result.add(fim);
        return result;
    }
}
