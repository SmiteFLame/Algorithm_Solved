import java.io.*;
import java.util.StringTokenizer;

public class Main_2740 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] array1 = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < M; j++){
                array1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(in.readLine());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] array2 = new int[M][K];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < K; j++){
                array2[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] answer = new int[N][K];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < K; j++){
                for(int x = 0; x < M; x++){
                    answer[i][j] += array1[i][x] * array2[x][j];
                }
                ot.write(answer[i][j] + " ");
            }
            ot.write("\n");
        }
        ot.flush();
        ot.close();

    }
}