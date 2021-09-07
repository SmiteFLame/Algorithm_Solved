public

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2661 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;

    private static void subset(String S) {
        if (S.length() == N) {
            System.out.println(S);
            System.exit(0);
        }
        for (int i = 1; i <= 3; i++) {
            if (check(S + i)) {
                subset(S + i);
            }
        }

    }

    private static boolean check(String s) {
        for (int i = 1, end = s.length() / 2; i <= end; i++) {
            if (s.substring(s.length() - i).equals(s.substring(s.length() - 2 * i, s.length() - i))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        subset("");
    }
}class 2661{

}
