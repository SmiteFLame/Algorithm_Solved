import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    private static boolean checking(int X){
        return !(X < 0 || X > 100000);
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] cnt = new int[100001];
        int[] data = new int[100001];
        Arrays.fill(data, Integer.MAX_VALUE);

        cnt[N] = 1;
        data[N] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        while (!queue.isEmpty()){
            int now = queue.poll();
            if(data[now] >= data[K]) break;
            for(int i = 0; i < 3; i++){
                int next = 0;
                if(i == 0)  next = now + 1;
                if(i == 1)  next = now - 1;
                if(i == 2)  next = now * 2;

                if(checking(next)){
                    if(data[next] == data[now] + 1){
                        cnt[next] += cnt[now];
                    }
                    if(data[next] > data[now] + 1){
                        cnt[next] = cnt[now];
                        data[next] = data[now] + 1;
                        queue.offer(next);
                    }
                }
            }
        }
        System.out.println(data[K]);
        System.out.println(cnt[K]);
    }
}
