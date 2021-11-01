import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int T;
    static int n, m;
    static int[] A, B;
    static List<Integer> listA = new ArrayList<>();
    static List<Integer> listB = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        T = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        A = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            A[i] = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++)
            B[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                listA.add(sum);
            }
        }
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += B[j];
                listB.add(sum);
            }
        }

        Collections.sort(listA);
        Collections.sort(listB);

        bw.write(getCount() + "\n");
        bw.flush();

    }

    public static long getCount() {

        int left = 0;
        int right = listB.size() - 1;
        long cnt = 0;

        while (left < listA.size() && right >= 0) {

            long sum = listA.get(left) + listB.get(right);

            if (sum == T) {

                int a = listA.get(left);
                int b = listB.get(right);
                long aCnt = 0;
                long bCnt = 0;

                while (left < listA.size() && listA.get(left) == a) {
                    aCnt++;
                    left++;
                }
                while (right >= 0 && listB.get(right) == b) {
                    bCnt++;
                    right--;
                }

                cnt += aCnt * bCnt;
            }

            else if (sum < T)
                left++;

            else if (sum > T)
                right--;
        }

        return cnt;

    }
}