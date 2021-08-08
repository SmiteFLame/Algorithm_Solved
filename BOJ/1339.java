import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_1339 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	static int N, max;
	static String[] data;
	static int[] array;
	static List<Character> alpa = new ArrayList<>();

	private static void back(int idx, int flag) {
		if (idx == alpa.size()) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				int now = 0;
				for (int j = 0, endj = data[i].length(); j < endj; j++) {
					now *= 10;
					now += array[alpa.indexOf(data[i].charAt(j))];
				}
				sum += now;
			}
			max = sum > max ? sum : max;
			return;
		}

		for (int i = 0; i <= 9; i++) {
			if ((flag & 1 << i) != 0) continue;
			array[idx] = i;
			back(idx + 1, flag | 1 << i);
		}
	}

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(in.readLine());
		data = new String[N];

		for (int i = 0; i < N; i++) {
			data[i] = in.readLine();
			for (int j = 0, end = data[i].length(); j < end; j++) {
				if(alpa.contains(data[i].charAt(j))) continue;
				alpa.add(data[i].charAt(j));
			}
		}

		array = new int[alpa.size()];
		back(0, 0);
		System.out.println(max);
	}
}
