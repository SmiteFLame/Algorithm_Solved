import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static final int[][] NEWS = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static final int[] DIR = {1, 2, 4, 8};

    static int N, M, room = 0, max = 0;
    static int[][] map, wall;
    static Deque<int[]> deque = new ArrayDeque<>();
    static ArrayList<Integer> space = new ArrayList();
    static HashMap<Integer, Set<Integer>> side = new HashMap<>();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        wall = new int[N][M];
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                wall[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int num = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    bfs(i, j, num++);
                    room++;
                }
            }
        }

        bw.write(room + "\n");
        bw.write(max + "\n");
        int sum = 0;
        for (int i = 1; i <= room; i++) {
            if (side.get(i) != null) {
                for (int j : side.get(i)) {
                    sum = Math.max(space.get(i - 1) + space.get(j - 1), sum);
                }
            }
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }

    private static void bfs(int x, int y, int num) {
        int cnt = 0;
        deque.add(new int[]{x, y});
        map[x][y] = num;
        Set<Integer> set = new HashSet<>();

        while (!deque.isEmpty()) {
            int[] now = deque.poll();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + NEWS[i][0];
                int ny = now[1] + NEWS[i][1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                if (map[nx][ny] != 0 && map[nx][ny] != num) {
                    set.add(map[nx][ny]);
                    continue;
                }

                if ((wall[now[0]][now[1]] & DIR[i]) == 0
                        && map[nx][ny] == 0) {
                    deque.add(new int[]{nx, ny});
                    map[nx][ny] = num;
                }

            }
        }
        side.put(num, set);
        space.add(cnt);
        max = Math.max(max, cnt);
    }
}