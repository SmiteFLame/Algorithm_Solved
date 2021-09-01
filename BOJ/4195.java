import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static Map<String, String> parent = new HashMap<>();
    static Map<String, Integer> count = new HashMap<>();

    private static String find(String X){
        if(!parent.get(X).equals(X)){
            parent.replace(X, find(parent.get(X)));
        }
        return parent.get(X);
    }

    private static int union(String A, String B){
        String PA = find(A);
        String PB = find(B);
        if(PA.equals(PB)){
            return count.get(PA);
        } else if(count.get(PA) > count.get(PB)){
            count.replace(PA, count.get(PA) + count.get(PB));
            parent.replace(PB, PA);
            return count.get(PA);
        } else{
            count.replace(PB, count.get(PA) + count.get(PB));
            parent.replace(PA, PB);
            return count.get(PB);
        }
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine());
            for(int n = 0; n < N; n++){
                st = new StringTokenizer(br.readLine());
                String A = st.nextToken();
                String B = st.nextToken();
                parent.putIfAbsent(A, A);
                parent.putIfAbsent(B, B);
                count.putIfAbsent(A, 1);
                count.putIfAbsent(B, 1);
                bw.write(union(A, B) + "\n");
            }
            count.clear();
            parent.clear();
        }

        bw.flush();
        bw.close();
    }
}
