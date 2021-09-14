import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1725 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		int[] data = new int[N + 2];
		for(int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for(int i = 1; i <= N + 1; i++) {
			while(!stack.isEmpty()) {
				int now = stack.peek();
				if(data[now] <= data[i]) break;
				answer = Math.max(answer, data[stack.pop()] * (i - stack.peek() - 1));
			}
			stack.add(i);
		}
		System.out.println(answer);
	}

}
