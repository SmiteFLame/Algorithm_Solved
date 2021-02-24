package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2605 {
	public static void main(String[] args) throws IOException{
		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(io.readLine());
		LinkedList<Integer> std = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(io.readLine());
		for(int i = 1; i <= N; i++) {
			std.add(std.size() - Integer.parseInt(st.nextToken()), i);
		}	
		for(Integer j : std) {
			System.out.print(j + " ");
		}
	}

}
