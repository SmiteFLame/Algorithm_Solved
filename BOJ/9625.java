import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9625 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int A = 0;
        int B = 1;
        int C = 1;
        for (int i = 1; i < N; i++) {
            C = A + B;
            A = B;
            B = C;
        }
        System.out.println(A + " " + B);
    }

}
