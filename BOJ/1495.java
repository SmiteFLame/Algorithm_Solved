import java.io.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] diff = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            diff[i] = Integer.parseInt(st.nextToken());
        }

        int[] volume = new int[M + 1];
        for(int i=0; i<=M; i++){
            volume[i] = -1;
        }
        volume[S] = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=1; i<=N; i++){
            list.clear();
            for(int j=0; j<=M; j++) {
                if(volume[j] == i-1) {
                    if (0 <= j - diff[i] && j - diff[i] <= M) {
                        list.add(j - diff[i]);
                    }
                    if (0 <= j + diff[i] && j + diff[i] <= M) {
                        list.add(j + diff[i]);
                    }
                }
            }
            for (int v : list) {
                volume[v] = i;
            }
        }

        for(int i=M; i>=0; i--){
            if(volume[i] == N){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}
