package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution_D4_1223_�絿�� {
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
//				���ϱⰡ ������ �� ���� ����� ���� ������ ����
				if(cal.charAt(i) == '+') {
					list.add(nowIndex);
					nowIndex = 0;
				}
				
			} else {
				
//				���ϱ⸦ ���� ������ ��� ���ϱ� �ǹǷ� ������ ���� ��� ��
				if(nowIndex == 0)
					nowIndex = (cal.charAt(i) - '0');
				else
					nowIndex *= (cal.charAt(i) - '0');
			}
		}
		
//		������ ����Ʈ���� ���� ����
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
