import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1138 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] data = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int now = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= N; j++) {
                if (now == 0 && data[j] == 0) {
                    data[j] = i;
                    break;
                } else if (data[j] == 0) {
                    now--;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(data[i] + " ");
        }

    }

}
