import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String S = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = S.charAt(j);
            }
        }
        int length = 2;
        int max = 1;

        while (length <= M && length <= N) {
            for (int i = 0; i + length - 1 < N; i++) {
                for (int j = 0; j + length - 1 < M; j++) {
                    if (map[i][j] == map[i + length - 1][j] && map[i + length - 1][j] == map[i][j + length - 1] && map[i][j + length - 1] == map[i + length - 1][j + length - 1]) {
                        if (max < length)
                            max = length;
                    }
                }
            }
            length++;
        }

        System.out.println(max * max);
    }
}
