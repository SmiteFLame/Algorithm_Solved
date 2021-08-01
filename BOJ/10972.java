import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10972 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N;
	static int[] data;
	public static void swap(int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}


	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(in.readLine());
		data = new int[N];
		st = new StringTokenizer(in.readLine());

		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		int i = N - 1;
		while (i > 0 && data[i - 1] >= data[i]) {
			i -= 1;
		}

		if (i <= 0) {
			System.out.println("-1");
			return;
		}
		int j = N - 1;
		while (data[j] <= data[i - 1]) {
			j -= 1;
		}

		swap(i - 1, j);

		j = N - 1;
		while (i < j) {
			swap(i, j);
			i += 1;
			j -= 1;
		}
		
		for(int n = 0; n < N; n++) {
			System.out.print(data[n] + " ");
		}
	}

}
