import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1525 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static final int[][] NEWS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	
	private static boolean canMove(int X, int Y) {
		return !(X < 0 || Y < 0 || X >= 3 || Y >= 3);
	}

	public static void main(String[] args) throws IOException {
		String start = "";
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				start += st.nextToken();
			}
		}
		Queue<String> queue = new LinkedList<>();
		Map<String, Integer> map = new HashMap<>();
		map.put(start, 0);
		queue.add(start);
		while(!queue.isEmpty()) {
			String now = queue.poll();
			int zero = now.indexOf("0");
			int x = zero / 3;
			int y = zero % 3;
			for(int n = 0; n < 4; n++) {
				int nx = x + NEWS[n][0];
				int ny = y + NEWS[n][1];
				if(!canMove(nx, ny)) continue;
				int next = nx * 3 + ny;
				StringBuilder sb = new StringBuilder(now);
				char temp = sb.charAt(next);
				sb.setCharAt(next, '0');
				sb.setCharAt(zero, temp);
				String S = sb.toString();
				if(map.containsKey(S)) continue;
				map.put(S, map.get(now) + 1);
				queue.add(S);
			}
		}
		
		System.out.println(map.containsKey("123456780") ? map.get("123456780") : -1);
	}

}
