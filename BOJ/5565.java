package justonly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5565 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException{
		int sum = Integer.parseInt(in.readLine());
		for(int i = 0; i < 9; i++) {
			sum -= Integer.parseInt(in.readLine());
		}
		System.out.println(sum);
	}

}
