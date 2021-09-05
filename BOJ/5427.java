import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Queue<int[]> FIRE = new LinkedList<>();
            Queue<int[]> SANG = new LinkedList<>();
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            String[][] field = new String[h][w];
            int[][] Fvisited = new int[h][w];
            int[][] Svisited = new int[h][w];
            for (int i = 0; i < h; i++) {
                Arrays.fill(Fvisited[i], -1);
                Arrays.fill(Svisited[i], -1);
                field[i] = br.readLine().split("");
                for (int j = 0; j < w; j++) {
                    if (field[i][j].equals("*")) {
                        FIRE.offer(new int[]{i, j});
                        Fvisited[i][j] = 0;
                    }
                    if (field[i][j].equals("@")) {
                        SANG.offer(new int[]{i, j});
                        Svisited[i][j] = 0;
                    }
                }
            }
            while (!FIRE.isEmpty()) {
                int[] cur = FIRE.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur[1] + dx[dir];
                    int ny = cur[0] + dy[dir];
                    if (nx < 0 || ny < 0 || nx >= w || ny >= h) continue;
                    if (Fvisited[ny][nx] >= 0 || field[ny][nx].equals("#")) continue;
                    Fvisited[ny][nx] = Fvisited[cur[0]][cur[1]] + 1;
                    FIRE.offer(new int[]{ny, nx});
                }
            }
            int result = -1;
            while (!SANG.isEmpty()) {
                int[] cur = SANG.poll();
                if (result != -1) break;
                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur[1] + dx[dir];
                    int ny = cur[0] + dy[dir];
                    if (nx < 0 || ny < 0 || nx >= w || ny >= h) {
                        result = Svisited[cur[0]][cur[1]] + 1;
                        break;
                    }
                    if (Svisited[ny][nx] >= 0 || field[ny][nx].equals("#")) continue;
                    if (Svisited[cur[0]][cur[1]] + 1 >= Fvisited[ny][nx] && Fvisited[ny][nx] != -1) continue;
                    Svisited[ny][nx] = Svisited[cur[0]][cur[1]] + 1;
                    SANG.offer(new int[]{ny, nx});
                }
            }
            System.out.println(result == -1 ? "IMPOSSIBLE" : result);
        }
    }
}
