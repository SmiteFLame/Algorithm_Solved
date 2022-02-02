import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] num = new int[n];
        int left = 0;
        int right = 0;
        int length = Integer.MAX_VALUE;
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            if (sum >= s) {
                sum -= num[left++];
                length = Math.min(length, (right - left) + 1);
            } else if (right == n) {
                break;
            } else {
                sum += num[right++];
            }
        }

        if (length == Integer.MAX_VALUE) {
            bw.write(0 + "\n");
        } else {
            bw.write(length + "\n");
        }

        bw.flush();
        bw.close();
    }

}