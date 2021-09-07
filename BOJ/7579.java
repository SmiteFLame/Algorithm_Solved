import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7579 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;
        int[] app = new int[N + 1];
        int[] cost = new int[N + 1];
        int[][] DP = new int[N + 1][100001];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            app[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= 100000; j++) {
                DP[i][j] = j < cost[i] ? DP[i - 1][j] : Math.max(DP[i - 1][j], DP[i - 1][j - cost[i]] + app[i]);
            }
        }
        for (int i = 1; i <= 100000; i++) {
            if (DP[N][i] >= M) {
                System.out.println(i);
                return;
            }
        }

    }
}
