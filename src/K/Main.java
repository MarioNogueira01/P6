package K;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<int[]> traj = new ArrayList<>();

        for (int i = 0; i<2;i++){
            traj.add(readLines.readLine(sc.nextLine()));
        }

        Populacao x = new Populacao(traj);
        x.cut();
        System.out.println(x);
        sc.close();
    }
}