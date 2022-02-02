import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Long> list = new ArrayList<>();
        for(int i = 0 ; i < N; i++){
            long a = Long.parseLong(st.nextToken());
            if(a == 0) continue;
            list.add(a);
        }
        int disc = Integer.parseInt(br.readLine());
        long ans = 0L;
        for(int i = 0; i < list.size(); i++){
            ans += (long) list.get(i) % disc == 0 ? (long) disc * list.get(i) / disc : (long) disc * (list.get(i) / disc + 1);
        }
        bw.write(ans + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}