package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_2304 {

	public static void main(String[] args) throws IOException {
		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(io.readLine());
		ArrayList<int[]> data = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(io.readLine());
			data.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}

		data.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		int[] min = new int[N];

		int max = 0;
		for (int i = 0; i < N; i++) {
			max = data.get(i)[1] > max ? data.get(i)[1] : max;
			min[i] = max;
		}

		max = 0;

		for (int i = N - 1; i >= 0; i--) {
			max = data.get(i)[1] > max ? data.get(i)[1] : max;
			min[i] = min[i] < max ? min[i] : max;
		}

		int area = 0;

		for (int i = 0; i < N - 1; i++) {
			if (data.get(i + 1)[1] > data.get(i)[1]) {
				area += (data.get(i + 1)[0] - data.get(i)[0]) * min[i];
			} else {
				area += (data.get(i + 1)[0] - data.get(i)[0]) * min[i + 1];
				area += (min[i] - min[i + 1]);
			}
		}
		
		area += min[N - 1];
		
		System.out.println(area);
	}

}
