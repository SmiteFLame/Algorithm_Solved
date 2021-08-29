import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static int[][] unit;

    private static int[][] multiple(int[][] m1, int[][] m2) {
        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++)
                    matrix[i][j] += (m1[i][k] * m2[k][j]) % 1000;
                matrix[i][j] %= 1000;
            }
        }

        return matrix;
    }

    private static int[][] pow(long n, int[][] now) {
        if (n == 0) {
            return unit;
        }
        if (n == 1) {
            return now;
        }
        int[][] next = pow(n / 2, now);
        next = multiple(next, next);

        return n % 2 == 0 ? next : multiple(next, now);
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int[][] array = new int[N][N];
        int[][] unit = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                array[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
            unit[i][i] = 1;
        }

        array = pow(B, array);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(array[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
