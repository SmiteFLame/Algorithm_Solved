package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution_D4_1223_양동혁 {
	static int T = 10, N;
	static String cal;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		cal = br.readLine();
	}
	
	public static void implement() {
		LinkedList<Integer> list = new LinkedList<>();
		
		int nowIndex = cal.charAt(0) - '0';
		
		for(int i = 1; i < N; i++) {
			if(i % 2 == 1) {
//				더하기가 나오면 그 동안 계산한 값을 리스테 저장
				if(cal.charAt(i) == '+') {
					list.add(nowIndex);
					nowIndex = 0;
				}
				
			} else {
				
//				더하기를 하지 않으면 계속 곱하기 되므로 나오는 값을 계속 곱
				if(nowIndex == 0)
					nowIndex = (cal.charAt(i) - '0');
				else
					nowIndex *= (cal.charAt(i) - '0');
			}
		}
		
//		마지막 리스트까지 전부 저장
		list.add(nowIndex);
		
		int sum = 0;
		for(int i : list) {
			sum += i;
		}
		sb.append(sum).append("\n");
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			init();
			implement();
		}
		System.out.println(sb.toString());
	}

}
