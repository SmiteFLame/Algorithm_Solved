import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_15685 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	private static int[][] NEWS = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };

	private static int max4(int X) {
		return X > 3 ? X - 4 : X;
	}

	public static void main(String[] args) throws IOException {
		Map<int[], Boolean> map = new TreeMap<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return Integer.compare(o1[1], o2[1]);
				return Integer.compare(o1[0], o2[0]);
			}
		});

		List<List<Integer>> gen = new ArrayList<>();
		List<Integer> first = new ArrayList<>();
		first.add(0);
		gen.add(first);
		for (int g = 1; g <= 10; g++) {
			List<Integer> next = new ArrayList<>(gen.get(g - 1));
			for (int i = next.size() - 1; i >= 0; i--) {
				next.add(max4(next.get(i) + 1));
			}
			gen.add(next);
		}

		for (int n = 0, endn = Integer.parseInt(in.readLine()); n < endn; n++) {
			st = new StringTokenizer(in.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			map.put(new int[] { X, Y }, true);
			int g = Integer.parseInt(st.nextToken());
			for (int c = 0, endc = gen.get(g).size(); c < endc; c++) {
				X += NEWS[max4(gen.get(g).get(c) + dir)][0];
				Y += NEWS[max4(gen.get(g).get(c) + dir)][1];
				map.put(new int[] { X, Y }, true);
			}
		}
		int answer = 0;
		for (int[] now : map.keySet()) {
			if (!map.containsKey(new int[] { now[0], now[1] + 1 }))
				continue;
			if (!map.containsKey(new int[] { now[0] + 1, now[1] }))
				continue;
			if (!map.containsKey(new int[] { now[0] + 1, now[1] + 1 }))
				continue;
			answer++;
		}

		System.out.println(answer);
	}
}
