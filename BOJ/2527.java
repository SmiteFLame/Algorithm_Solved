package ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_S1_2527_¾çµ¿Çõ {
	static int score;
	static int[] data;
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	private static void init() throws IOException {
		st = new StringTokenizer(io.readLine());
		data = new int[8];
		for (int i = 0; i < 8; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		score = 0;
	}

	private static void implement() {
		for(int i = 0; i < 2; i++) {
			if(data[0 + i] <= data[4 + i] && data[4 + i] < data[2 + i]) {
				score += 3;
			} else if(data[4 + i] <= data[0 + i] && data[0 + i] < data[6 + i]) {
				score += 3;
			} else if(data[0 + i] == data[6 + i] || data[2 + i] == data[4 + i]) {
				score++;
			}
		}
	}

	private static void print() throws IOException{
		if(score == 6) ot.write("a");
		else if(score == 4) ot.write("b");
		else if(score == 2) ot.write("c");
		else ot.write("d");
		ot.write("\n");
	}
	
	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 4; i++) {
			init();
			implement();
			print();
		}
		ot.flush();
		ot.close();
	}

}
