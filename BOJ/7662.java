import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_7662 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		for (int t = 0, endt = Integer.parseInt(br.readLine()); t < endt; t++) {
			TreeMap<Integer, Integer> map = new TreeMap<>();
			for (int n = 0, endn = Integer.parseInt(br.readLine()); n < endn; n++) {
				st = new StringTokenizer(br.readLine());
				if (st.nextToken().equals("I")) {
					int now = Integer.parseInt(st.nextToken());
					map.put(now, map.getOrDefault(now, 0) + 1);
				} else {
					if (map.size() == 0)
						continue;
					int now = 0;
					if (st.nextToken().equals("1")) {
						now = map.lastKey();
					} else {
						now = map.firstKey();
					}
					if (map.put(now, map.get(now) - 1) == 1) {
						map.remove(now);
					}
				}

			}
			bw.write((map.size() == 0 ? "EMPTY" : (map.lastKey() + " " + map.firstKey())) + "\n");
		}
		bw.flush();
		bw.close();
	}
}
