import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static final int[][] NEWS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static int N;
    static int[][] map, visited;

    private static boolean canMove(int X, int Y) {
        return !(X < 0 || Y < 0 || X >= N || Y >= N);
    }

    public static void main(String[] args) throws IOException {
        int cnt = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            map = new int[N][N];
            visited = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
                Arrays.fill(visited[i], Integer.MAX_VALUE);
            }

            visited[0][0] = map[0][0];
            PriorityQueue<int[]> pQueue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[2], o2[2]);
                }
            });
            pQueue.offer(new int[]{0, 0, map[0][0]});
            while (!pQueue.isEmpty()) {
                int[] now = pQueue.poll();
                for (int x = 0; x < 4; x++) {
                    int nx = now[0] + NEWS[x][0];
                    int ny = now[1] + NEWS[x][1];

                    if (!canMove(nx, ny)) continue;
                    if (now[2] + map[nx][ny] >= visited[nx][ny]) continue;
                    visited[nx][ny] = now[2] + map[nx][ny];
                    if (nx == N - 1 && ny == N - 1) {
                        bw.write("Problem " + cnt + ": " + visited[N - 1][N - 1] + "\n");
                    }
                    pQueue.offer(new int[]{nx, ny, visited[nx][ny]});
                }
            }

            cnt++;
        }

        bw.flush();
        bw.close();
    }
}
