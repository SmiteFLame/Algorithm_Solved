import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 1][M + 1];
        map[0][1] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }
        if(K == 0){
            System.out.println(map[N][M]);
        } else{
            int X = K / M + (K % M != 0 ? 1: 0);
            int Y = K - (X - 1) * M;
            System.out.println(map[X][Y] * map[N - X + 1][M - Y + 1]);
        }
    }
}
