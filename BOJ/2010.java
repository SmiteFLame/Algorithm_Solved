package justonly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2010 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(in.readLine());
		int S = - N + 1;
		for(int i = 0; i < N; i++) {
			S += Integer.parseInt(in.readLine());
		}
		System.out.println(S);
	}

}
