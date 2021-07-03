package justonly;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_9613 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	private static int GCD(int X, int Y) {
		if(X == Y) return X;
		return GCD(Math.max(X - Y, Y), Math.min(X - Y, Y));
	}
	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(in.readLine());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int M = Integer.parseInt(st.nextToken());
			
			long sum = 0;
			
			int[] data = new int[M];
			for(int j = 0; j < M; j++) {
				data[j] = Integer.parseInt(st.nextToken());
			}
			for(int j = 0; j < M; j++) {
				for(int k = 0; k < j; k++) {
					sum += GCD(Math.max(data[j], data[k]), Math.min(data[j], data[k]));
				}
			}
			ot.write(sum + "\n");
		}
		ot.flush();
		ot.close();
	}

}
