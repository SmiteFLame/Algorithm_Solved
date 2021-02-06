package SmiteFLame.BOJ_1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182 {
    static int N, M, answer = 0;
    static int[] data;
    static boolean[] subset;
    static StringTokenizer st = null;
    static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));

    // 데이터 관리
    public static  void init() throws IOException {
        st = new StringTokenizer(io.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        data = new int[N];
        subset = new boolean[N];
        st = new StringTokenizer(io.readLine());

        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void makeSubset() {
        // 모든 경우의수를 확인하기 위해서 subSet을 bit마스크로 제작
        for (int i = 1, end = 1 << N; i < end; i++) {
            for (int j = 0; j < N; j++) {
                if ((i & 1 << j) != 0) {
                    subset[j] = true;
                }
                else {
                    subset[j] = false;
                }
            }

            // Subset 완성
            implement();
        }
    }

    // 모든 데이터의 값을 확인하기 위해서 데이터 값을 넣어봐서 확인
    public static void implement() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += subset[i] ? data[i] : 0;
        }
        if (sum == M) {
            answer++;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        makeSubset();
        System.out.println(answer);
    }
}
