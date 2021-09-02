import java.io.*;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N, M;
    static int[] data;
    static int[] answer;
    private static void subset(int cnt) throws IOException{
        if(cnt == M){
            for(int i = 0; i < M; i++){
                bw.write(answer[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i = 0; i < N; i++){
            answer[cnt] = data[i];
            subset(cnt + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = new int[M];
        st = new StringTokenizer(br.readLine());
        Set<Integer> set = new TreeSet<>();
        for(int i = 0; i < N; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        N = set.size();
        data = new int[N];
        int cnt = 0;
        for(Integer st : set){
            data[cnt++] = st;
        }
        subset(0);
        bw.flush();
        bw.close();
    }
}
