package justonly;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1620 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, M;
	static Map<String, Integer> map = new HashMap<>();
	static String[] reverse;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		reverse = new String[N + 1];
		
		for(int i = 1; i <= N; i++) {
			String now = in.readLine();
			map.put(now, i);
			reverse[i] = now;
		}
		
		for(int i = 0; i < M; i++) {
			String now = in.readLine();
			if(now.charAt(0) >= '0' && now.charAt(0) <= '9') {
				ot.write(reverse[Integer.parseInt(now)]);
			} else {
				ot.write(map.get(now)+"");
			}
			ot.write("\n");
		}
		ot.flush();
		ot.close();
		
	}

}
