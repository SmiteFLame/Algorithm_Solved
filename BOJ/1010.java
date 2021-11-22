import java.util.*;

public class Main {
    public static void main(String[] ar) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] DP = new int[31][31];
        for (int i = 0; i < 31; i++) {
            DP[i][i] = DP[i][0] = 1;
            for (int j = 1; j <= i - 1; j++)
                DP[i][j] = DP[i - 1][j - 1] + DP[i - 1][j];
        }

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt(), M = sc.nextInt();
            System.out.println(DP[M][N]);
        }
    }
}