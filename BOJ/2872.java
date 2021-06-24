package justonly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2872 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(in.readLine());

		int[] data = new int[N];

		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(in.readLine());
		}

		int answer = N;
		for (int i = N - 1; i >= 0; i--) {
			if (data[i] == answer)
				answer--;
		}
		
		System.out.println(answer);

	}

}
