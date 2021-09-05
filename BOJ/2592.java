import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_2592 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int arr[] = new int[1001];
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			int N = Integer.parseInt(br.readLine());
			sum += N;
			arr[N]++;
		}
		int max = 0;
		int maxIdx = 0;
		for (int i = 0; i < 1001; i++) {
			if (max < arr[i]) {
				max = arr[i];
				maxIdx = i;
			}
		}
		System.out.println(sum / 10);
		System.out.println(maxIdx);
	}

}
