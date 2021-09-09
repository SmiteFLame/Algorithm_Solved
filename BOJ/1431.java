import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main_1431 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String[] S = new String[N];
        for (int i = 0; i < N; i++) {
            S[i] = br.readLine();
        }
        Arrays.sort(S, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return Integer.compare(o1.length(), o2.length());
                }
                int o1N = 0;
                int o2N = 0;
                for (int i = 0, end = o1.length(); i < end; i++) {
                    if (o1.charAt(i) >= '0' && o1.charAt(i) <= '9') {
                        o1N += o1.charAt(i) - '0';
                    }
                    if (o2.charAt(i) >= '0' && o2.charAt(i) <= '9') {
                        o2N += o2.charAt(i) - '0';
                    }
                }
                if (o1N != o2N) {
                    return Integer.compare(o1N, o2N);
                }
                return o1.compareTo(o2);
            }
        });
        for (int i = 0; i < N; i++) {
            System.out.println(S[i]);
        }
    }

}
