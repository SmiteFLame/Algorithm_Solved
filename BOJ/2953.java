package justonly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2953 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int max = 0;
		int sum = 0;
		for(int i = 1; i <= 5; i++) {
			int temp = 0;
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < 4; j++) {
				temp += Integer.parseInt(st.nextToken());
			}
			if(temp > sum) {
				sum = temp;
				max = i;
			}
		}
		System.out.println(max + " " + sum);
	}
}
