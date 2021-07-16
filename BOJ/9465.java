import java.util.*;

public class Main {
    public static void main(String[] ar) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int[][] D = new int[2][N];
            for (int i = 0; i < N; i++) D[0][i] = sc.nextInt();
            for (int i = 0; i < N; i++) D[1][i] = sc.nextInt();
            for (int i = 1; i < N; i++) {
                D[0][i] = Math.max(D[0][i - 1], D[1][i - 1] + D[0][i]);
                D[1][i] = Math.max(D[1][i - 1], D[0][i - 1] + D[1][i]);
            }
            System.out.println(Math.max(D[0][N - 1], D[1][N - 1]));
        }
    }
}
