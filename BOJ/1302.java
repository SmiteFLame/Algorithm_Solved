import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main_1302 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int N = Integer.parseInt(br.readLine());
		String str = new String();
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			if (map.containsKey(str)) {
				map.replace(str, map.get(str) + 1);
			} else {
				map.put(str, 1);
			}
		}
		int max = 0;
		for (String a : map.keySet()) {
			max = Math.max(max, map.get(a));
		}

		ArrayList<String> al = new ArrayList<String>(map.keySet());
		Collections.sort(al);
		for (String a : al) {
			if (map.get(a) == max) {
				System.out.println(a);
				break;
			}
		}
	}

}
