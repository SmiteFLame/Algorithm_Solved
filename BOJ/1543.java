import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1543 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String A = br.readLine();
        String B = br.readLine();
        int answer = 0;
        for (int i = 0, end = A.length() - B.length() + 1; i < end; i++) {
            String temp = A.substring(i, i + B.length());
            if (temp.equals(B)) {
                answer++;
                i += B.length();
                i--;
            }
        }
        System.out.println(answer);
    }

}
