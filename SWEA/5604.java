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
		
		// 10^i - 1 까지의 개수를 더하기
		sum[0] = 0;
		sum[1] = 45;
		for (int i = 2; i <= 15; i++) {
			sum[i] = (long) (sum[i - 1] * 10 + (Math.pow(10, i - 1) * 45));
		}

		// 각 한 자리수에서 데이터 합을 구하기
		for (int i = 1; i < 10; i++) {
			temp[i] = temp[i - 1] + i;
		}

	}

	private static long getSum(String X, boolean isLast) {
		long result = 0;
		
		// 맨 앞자리수를 지워나가면서 결과 추가
		for (int i = 0, end = X.length(); i < end; i++) {
			
			// 현재 숫자
			String now = X.substring(i);
			
			// 몇 제곱인지
			int tenPow = now.length() - 1;

			// 맨 앞자리 숫자
			int nowHead = now.charAt(0) - '0';

			// 0이면 계산할 필요 없으므로 continue;
			if (nowHead == 0)
				continue;

			// 현재 자리수 앞까지의 10^i의 결과의 합	 	(256이라고 할때 99까지의 결과 * 2번)
			result += (sum[tenPow] * nowHead);

			// 맨 앞자리수의 추가 결과값 더하기			(256이라고 할때 200까지의 세번째 자리수)
			result += temp[nowHead - 1] * Math.pow(10, tenPow);

			// 추가로 계산해야되는 결과값 추기			(256이라고 하면 200부터 256 까지의 맨 앞자리수(2) 추가)
			if (i != end - 1) {
				result += nowHead * Long.parseLong(X.substring(i + 1));
			}
			
			// 마지막 숫자라면 데이터 추가
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
