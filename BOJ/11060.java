import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11060 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] data = new int[N];
        int[] visited = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[0] = 0;

        for (int i = 0; i < N; i++) {
            if (visited[i] != Integer.MAX_VALUE) {
                int jump = data[i];
                for (int j = 1; j <= jump; j++) {
                    if (i + j >= N)
                        continue;
                    visited[i + j] = Math.min(visited[i] + 1, visited[i + j]);
                }
            }
        }

        System.out.println(visited[N - 1] == Integer.MAX_VALUE ? -1 : visited[N - 1]);

    }

}
