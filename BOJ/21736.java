import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;
    private static final int[][] NEWS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static char[][] map;
    private static int n;
    private static int m;
    private static int answer = 0;


    public static class Pair{
        int x;
        int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        Pair start = null;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'I'){
                    start = new Pair(i, j);
                }
            }
        }
        dfs(start);

        System.out.println(answer == 0 ? "TT" : answer);
    }

    public static void dfs(Pair loc){
        map[loc.x][loc.y] = 'X';
        for(int r = 0; r < 4; r++){
            int nextX = loc.x + NEWS[r][0];
            int nextY = loc.y + NEWS[r][1];
            if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
            if(map[nextX][nextY] == 'X') continue;
            if(map[nextX][nextY] == 'P') answer++;
            dfs(new Pair(nextX, nextY));
        }
    }
}