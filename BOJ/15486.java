package ssafy.study.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15486 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(in.readLine());
		int[] DP = new int[N + 1];
		int answer = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());	
			
			// ����Ǵ� ���� �� �ݾ�
			int during = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			
			// �� ���� ������� �߿��� �ְ��� ����� ��� �����ϱ�
			answer = DP[i] > answer ? DP[i] : answer;
			
			// �ش��ϴ� ��¥�� �����͸� ���� �� �ִ� ��쿡�� �����͸� �߰��ϱ�
			if(i + during > N) continue;
			DP[i + during] = DP[i + during] > answer + price ? DP[i + during] : answer + price;
		}
		
		// �������� ������ �߰��� ��츦 Ȯ���ϱ� ���ؼ� ���� �ִ밪�� ���� �̱�
		System.out.println(answer > DP[N] ? answer : DP[N]);
	}
}
