import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n  = Integer.parseInt(br.readLine());
        int[] hp = new int[n + 1];
        int[] happy = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            hp[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            happy[i] = Integer.parseInt(st.nextToken());
        }

        int[][] best = new int[n + 1][101];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= 99; j++){
                if(hp[i] <= j){
                    best[i][j] = Math.max(best[i - 1][j - hp[i]] + happy[i], best[i - 1][j]);
                } else{
                    best[i][j] = best[i - 1][j];
                }
            }
        }
        System.out.println(best[n][99]);
    }
}