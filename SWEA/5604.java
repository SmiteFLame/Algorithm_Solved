package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_5604 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static long[] sum = new long[16];
	static int[] temp = new int[10];

	private static void start() {
		
		// 10^i - 1 ������ ������ ���ϱ�
		sum[0] = 0;
		sum[1] = 45;
		for (int i = 2; i <= 15; i++) {
			sum[i] = (long) (sum[i - 1] * 10 + (Math.pow(10, i - 1) * 45));
		}

		// �� �� �ڸ������� ������ ���� ���ϱ�
		for (int i = 1; i < 10; i++) {
			temp[i] = temp[i - 1] + i;
		}

	}

	private static long getSum(String X, boolean isLast) {
		long result = 0;
		
		// �� ���ڸ����� ���������鼭 ��� �߰�
		for (int i = 0, end = X.length(); i < end; i++) {
			
			// ���� ����
			String now = X.substring(i);
			
			// �� ��������
			int tenPow = now.length() - 1;

			// �� ���ڸ� ����
			int nowHead = now.charAt(0) - '0';

			// 0�̸� ����� �ʿ� �����Ƿ� continue;
			if (nowHead == 0)
				continue;

			// ���� �ڸ��� �ձ����� 10^i�� ����� ��	 	(256�̶�� �Ҷ� 99������ ��� * 2��)
			result += (sum[tenPow] * nowHead);

			// �� ���ڸ����� �߰� ����� ���ϱ�			(256�̶�� �Ҷ� 200������ ����° �ڸ���)
			result += temp[nowHead - 1] * Math.pow(10, tenPow);

			// �߰��� ����ؾߵǴ� ����� �߱�			(256�̶�� �ϸ� 200���� 256 ������ �� ���ڸ���(2) �߰�)
			if (i != end - 1) {
				result += nowHead * Long.parseLong(X.substring(i + 1));
			}
			
			// ������ ���ڶ�� ������ �߰�
			if(isLast) {
				result += nowHead;
			}
		}	
		return result;
	}

	public static void main(String[] args) throws IOException {
		start();
		for (int tc = 1, end = Integer.parseInt(in.readLine()); tc <= end; tc++) {
			long answer = 0;
			st = new StringTokenizer(in.readLine());
			answer = -(getSum(st.nextToken(), false) - getSum(st.nextToken(), true));

			ot.write("#" + tc + " " + answer + "\n");
		}
		ot.flush();
		ot.close();
	}
}
