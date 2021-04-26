package ssafy.study.week11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_9327 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		for(int tc = 1, end = Integer.parseInt(in.readLine()); tc <= end; tc++) {
			st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			
			for(int m = 0; m < M; m++) {
				st = new StringTokenizer(in.readLine());
			}
			ot.write((N - 1) + "\n");		
		}
		ot.flush();
		ot.close();
	}
}
