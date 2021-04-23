package justonly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2525 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int A, B, C;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(in.readLine());

		B += C;
		A += B / 60;
		B %= 60;

		A %= 24;
		
		System.out.println(A + " " + B);
	}
}
