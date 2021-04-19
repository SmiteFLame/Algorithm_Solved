package justonly;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solutuin_D4_8382 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		for(int tc = 1, end = Integer.parseInt(in.readLine()); tc <= end; tc++) {
			st = new StringTokenizer(in.readLine());
			int SX = Integer.parseInt(st.nextToken());
			int SY = Integer.parseInt(st.nextToken());
			int EX = Integer.parseInt(st.nextToken());
			int EY = Integer.parseInt(st.nextToken());
			int minusX = Math.abs(SX - EX);
			int minusY = Math.abs(SY - EY);
			int sum = minusX + minusY;
			
			if(Math.abs(minusX - minusY) > 1) {
				sum += Math.abs(minusX - minusY) % 2 == 0 ? Math.abs(minusX - minusY) : Math.abs(minusX - minusY) - 1;
			}
			
			ot.write("#" + tc + " " + sum + "\n");
		}
		ot.flush();
		ot.close();
	}
}
