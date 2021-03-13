package ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_9934 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N, end;
	static int[] data;
	static boolean[] visited;
	private static void init() throws IOException{
		N = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		end = (int) Math.pow(2, N) - 1;
		data = new int[end];
		visited = new boolean[end];
		
		for(int i = 0; i < end; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	private static void implement() throws IOException{
		for(int i = (int) Math.pow(2, N - 1); i > 0; i /= 2) {
			for(int j = i - 1; j < end; j += i) {
				if(visited[j]) continue;
				visited[j] = true;
				ot.write(data[j] + " ");
			}
			ot.write("\n");
		}
	}
	
	private static void print() throws IOException{
		ot.flush();
		ot.close();
	}

	public static void main(String[] args) throws IOException{
		init();
		implement();
		print();
	}
}
