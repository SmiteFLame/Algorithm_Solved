package justonly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14891 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, answer;
	static boolean[] visited = new boolean[4];
	static String[] data = new String[4];
	
	private static void moving(int wheels, boolean watch) {
		visited[wheels] = true;

		if(wheels != 0 && !visited[wheels - 1]) {
			if(data[wheels].charAt(6) != data[wheels - 1].charAt(2)) {
				moving(wheels - 1, !watch);
			}			
		}
		
		if(wheels != 3 && !visited[wheels + 1]) {
			if(data[wheels].charAt(2) != data[wheels + 1].charAt(6)) {
				moving(wheels + 1, !watch);
			}	
		}

		if(watch) {
			data[wheels] = data[wheels].charAt(7) + data[wheels].substring(0, 7);
		} else {
			data[wheels] = data[wheels].substring(1, 8) + data[wheels].charAt(0);			
		}
	}	
	
	public static void main(String[] args) throws IOException{
		for(int i = 0; i < 4; i++) {
			data[i] = in.readLine();
		}
		
		N = Integer.parseInt(in.readLine());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			Arrays.fill(visited, false);
			moving(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) == 1);
		}
		
		for(int i = 0; i < 4; i++) {
			if(data[i].charAt(0) == '1') answer |= (1 << i);
		}
		
		System.out.println(answer);
		
	}
}
