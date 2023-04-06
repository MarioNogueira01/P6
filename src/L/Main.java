package L;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] t = new int[n];

        for (int i = 0; i<n; i++){
            t[i] = sc.nextInt();
        }

        double prob = sc.nextDouble();

        Populacao x = new Populacao(n,t);
        Populacao.mut(x,prob,t);
        System.out.println(x);
        sc.close();
    }
}