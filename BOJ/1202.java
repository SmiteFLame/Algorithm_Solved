import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static class Jew{
        int M;
        int V;

        Jew(StringTokenizer st){
            this.M = Integer.parseInt(st.nextToken());
            this.V = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jew[] jew = new Jew[N];
        int[] backpack = new int[K];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            jew[i] = new Jew(st);
        }
        for(int i = 0; i < K; i++){
            backpack[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(jew, new Comparator<Jew>() {
            @Override
            public int compare(Jew o1, Jew o2) {
                return o1.M == o2.M ? Integer.compare(o2.V, o1.V) : Integer.compare(o1.M, o2.M);
            }
        });
        Arrays.sort(backpack);
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Comparator.reverseOrder());
        long answer = 0;
        int cnt = 0;
        for(int i = 0; i < K; i++){
            while(cnt < N && jew[cnt].M <= backpack[i]){
                pQueue.offer(jew[cnt++].V);
            }
            if(!pQueue.isEmpty()){
                answer += pQueue.poll();
            }
        }
        System.out.println(answer);
    }
}
