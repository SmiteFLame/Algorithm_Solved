import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[] cards;
    static int[][][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            cards = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                cards[i] = Integer.parseInt(st.nextToken());
            }

            dp = new int[2][N + 1][N + 1];
            for (int i = 0; i < 2; i++) {
                for (int j = 1; j <= N; j++) {
                    for (int k = 1; k <= N; k++) {
                        dp[i][j][k] = -1;
                    }
                }
            }

            sb.append(recursion(0, 1, N) + "\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    public static int recursion(int turn, int start, int end) {
        if (dp[turn][start][end] != -1) {
            return dp[turn][start][end];
        }
        if (start >= end) {
            if (turn == 0) {
                return cards[start];
            } else {
                return 0;
            }
        }

        dp[turn][start][end] = 0;

        if (turn == 0) {
            dp[turn][start][end] = Math.max(recursion(turn + 1, start + 1, end) + cards[start],
                    recursion(turn + 1, start, end - 1) + cards[end]);
        } else {
            dp[turn][start][end] = Math.min(recursion(turn - 1, start + 1, end), recursion(turn - 1, start, end - 1));
        }

        return dp[turn][start][end];
    }
}