import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static long N;
    static int[] arr = new int[6];
    static long[] num = new long[4];
    static long res;

    public static void main(String[] args) throws Exception {

        N = Integer.parseInt(br.readLine());

        num[1] = 5 * (N - 2) * (N - 2) + 4 * (N - 2);
        num[2] = 8 * (N - 2) + 4;
        num[3] = 4;

        String[] sarr = br.readLine().split(" ");
        for (int i = 0; i < 6; i++)
            arr[i] = Integer.parseInt(sarr[i]);

        if (N == 1) {
            Arrays.sort(arr);
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += arr[i];
            }
            bw.write(sum + "\n");
        } else {
            long min = arr[0];
            for (int i = 1; i < 6; i++) {
                min = Math.min(min, arr[i]);
            }
            res += num[1] * min;

            min = Long.MAX_VALUE;
            for (int i = 0; i < 6; i++) {
                for (int j = i + 1; j < 6; j++) {
                    if (j + i != 5) {
                        min = Math.min(min, arr[i] + arr[j]);
                    }
                }
            }
            res += num[2] * min;

            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += Math.min(arr[i], arr[5 - i]);
            }
            res += num[3] * sum;

            bw.write(res + "\n");
        }
        bw.flush();

    }

}