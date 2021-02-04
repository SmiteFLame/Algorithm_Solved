package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_G5_2493_�絿�� {
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
			
//			���� �տ� �ִ� ���� ���� Ÿ�� ã��
//			�� ã���� -1 �� ����
			highest = -1;
			while(!stack.isEmpty()) {
				
//				�տ� �մ� Ÿ���� �ڽź��� ������ ���ÿ��� ����
				if(stack.peek()[1] < nextData) {
					stack.pop();
					
//					���ų� ������ �浹�� �ֻ��� ���̸� �ʱ�ȭ �� �� while�� ���
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
