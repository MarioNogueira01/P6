package K;

import java.lang.reflect.*;
import java.util.*;

public class Main {
    public static String capitalize(String s) {
        String res = s.toLowerCase();
        char initial = Character.toUpperCase(res.charAt(0));
        StringBuilder sb = new StringBuilder(res);
        sb.setCharAt(0, initial);
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] starting = readLines.readLine(sc.nextLine());
        Ponto startingPoint = new Ponto(starting[0], starting[1]);

        int[] finish = readLines.readLine(sc.nextLine());
        Ponto endPonint = new Ponto(finish[0], finish[1]);

        int t = sc.nextInt();
        int[] points_n = new int[t];

        for (int i = 0; i < t; i++) {
            points_n[i] = sc.nextInt();
        }

        Trajectory[] result = new Trajectory[t];

        List<FiguraGeometrica> obstaculos = new ArrayList<>();
        Constructor<?> constructor;

        FiguraGeometrica f;
        String s;
        String[] aos;
        for (int i = 0; i < t; i++) {
            ArrayList<Ponto> test = RandomCreation.random_Trajectory(points_n[i], startingPoint, endPonint);
            result[i] = new Trajectory(test);
        }
        sc.nextLine();
        while (sc.hasNextLine()) {
            s = sc.nextLine();
            aos = s.split(" ");
            try {
                Class<?> cl = Class.forName("J." + capitalize(aos[0]));// da a class que vai ser usada
                constructor = cl.getConstructor(String.class);
                f = (FiguraGeometrica) constructor.newInstance(s);
                f.check();
                obstaculos.add(f);
            } catch (Exception e) {
                System.out.println("Tipo de obstaculo desconhecido");
                System.exit(0);
            }
        }

        TrajectoryEvaluation[] evaluations = new TrajectoryEvaluation[t];

        for (int i = 0; i < t; i++) {
            evaluations[i] = new TrajectoryEvaluation(result[i], result[i].avaluation(obstaculos));
        }

        // Sorting evaluations
        Arrays.sort(evaluations);

        // Printing sorted trajectories
        for (TrajectoryEvaluation eval : evaluations) {
            System.out.println(eval.trajectory.toString());
        }

        sc.close();
    }
}