import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_12015 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		List<Integer> list = new ArrayList<>();
		list.add(0);
		
		for(int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			if(now > list.get(list.size() - 1)) {
				list.add(now);
			} else {
				int left = 0, right = list.size() - 1;
				while(left < right) {
					int mid = (left + right) / 2;
					if(now <= list.get(mid)) {
						right = mid;
					} else {
						left = mid + 1;
					}
				}
				list.set(right, now);
			}
		}
		System.out.println(list.size() - 1);
	}

}
