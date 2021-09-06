import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_3968 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		for(int i = 0; i < N; i++) {
			String S = br.readLine();
			Stack<Character> stack = new Stack<>();
			for(int j = 0, end = S.length(); j < end; j++) {
				if(stack.size() != 0 && stack.peek() == S.charAt(j)) {
					stack.pop();
				} else {
					stack.add(S.charAt(j));
				}
			}
			if(stack.size() == 0) {
				answer++;
			}
		}
		System.out.println(answer);

	}

}
