import java.io.*;
import java.util.Stack;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        long result = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            while (!s.isEmpty() && s.peek() <= tmp) {
                s.pop();
            }
            s.push(tmp);
            result += s.size() - 1;

        }

        System.out.println(result);
    }
}