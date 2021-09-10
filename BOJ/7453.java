import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_7453 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int NN = N * N;
		int[] A = new int[N], B = new int[N], C = new int[N], D = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}
		int[] leftNum = new int[NN], rightNum = new int[NN];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				leftNum[i * N + j] = A[i] + B[j];
				rightNum[i * N + j] = C[i] + D[j];
			}
		}
		Arrays.sort(leftNum);
		Arrays.sort(rightNum);
		int left = 0;
		int right = NN - 1;
		long answer = 0;
		while (left < NN && right >= 0) {
			int leftNow = leftNum[left];
			int rightNow = rightNum[right];
			long leftCnt = 0;
			long rightCnt = 0;
			int Sum = leftNow + rightNow;
			if (leftNow + rightNow == 0) {
				while (left < NN && leftNow == leftNum[left]) {
					left++;
					leftCnt++;
				}
				while (right >= 0 && rightNow == rightNum[right]) {
					right--;
					rightCnt++;
				}
				answer += leftCnt * rightCnt;
			}
			else if(leftNow + rightNow > 0) {
				right--;
			} else {
				left++;
			}
		}
		System.out.println(answer);

	}

}
