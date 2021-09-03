import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        double[] data = new double[N];
        String S = br.readLine();
        for(int i = 0; i < N; i++){
            data[i] = Double.parseDouble(br.readLine());
        }
        Stack<Double> stack = new Stack<>();
        for(int i = 0, end = S.length(); i < end; i++){
            if(S.charAt(i) >= 65 && S.charAt(i) <= 90){
                stack.push(data[S.charAt(i) - 65]);
                continue;
            }
            double X = stack.pop();
            double Y = stack.pop();
            double result = 0;
            if(S.charAt(i) == '+'){
                result = Y + X;
            } else if(S.charAt(i) == '-'){
                result = Y - X;
            } else if(S.charAt(i) == '*'){
                result = Y * X;
            } else if(S.charAt(i) == '/'){
                result = Y / X;
            }
            stack.push(result);
        }
        System.out.printf("%.2f", stack.pop());
    }
}
