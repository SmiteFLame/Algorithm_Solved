package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_G5_2493_양동혁 {
	static int highest, nextData, N;
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(io.readLine());

		st = new StringTokenizer(io.readLine());
		
		Stack<int[]> stack = new Stack<>();
		
		
		for(int i = 0; i < N; i++) {
			nextData = Integer.parseInt(st.nextToken());
			
//			가장 앞에 있는 가장 높은 타워 찾기
//			못 찾으면 -1 값 유지
			highest = -1;
			while(!stack.isEmpty()) {
				
//				앞에 잇는 타워가 자신보다 낮으면 스택에서 제외
				if(stack.peek()[1] < nextData) {
					stack.pop();
					
//					높거나 같으면 충돌한 최상층 높이를 초기화 한 후 while문 통과
				} else {
					highest = stack.peek()[0];
					break;
				}
			}
			sb.append((highest + 1) + " ");
			stack.add(new int[] {i, nextData});
		}
		System.out.println(sb.toString());
	}
}
