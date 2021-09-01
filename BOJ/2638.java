import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static final int[][] NEWS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int N, M;

    private static boolean canMove(int X, int Y) {
        return !(X < 0 || Y < 0 || X >= N || Y >= M);
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) cnt++;
            }
        }
        int answer = 0;
        while(cnt > 0){
            answer++;
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[] {0, 0});
            int[][] visited = new int[N][M];
            while (!queue.isEmpty()){
                int[] now = queue.poll();
                for(int i = 0; i < 4; i++){
                    int nx = now[0] + NEWS[i][0];
                    int ny = now[1] + NEWS[i][1];
                    if(!canMove(nx, ny)) continue;
                    if (map[nx][ny] == 0 && visited[nx][ny] == 0){
                        visited[nx][ny] = 1;
                        queue.offer(new int[] {nx, ny});
                    }
                    if(map[nx][ny] == 1){
                        visited[nx][ny]++;
                        if(visited[nx][ny] >= 2){
                            map[nx][ny] = 0;
                            cnt--;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
