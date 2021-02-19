package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_2370 {
	static int N;
	static int[][] data;
	static int[] array;
	static ArrayList<Integer> number = new ArrayList<>();
	static Set<Integer> set = new HashSet<>();
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	private static void init() throws IOException {
		N = Integer.parseInt(io.readLine());
		data = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(io.readLine());
			data[i][0] = Integer.parseInt(st.nextToken());
			data[i][1] = Integer.parseInt(st.nextToken());
			if(!number.contains(data[i][0])) number.add(data[i][0]);
			if(!number.contains(data[i][1])) number.add(data[i][1]);
		}
		Collections.sort(number);
		
		array = new int[number.size()];
	}
	
	private static void implement() {
		for(int i = 0; i < N; i++) {
			int X = number.indexOf(data[i][0]);
			int Y = number.indexOf(data[i][1]);
			for(int j = X; j <= Y; j++) {
				array[j] = i;
			}
		}
		
		for(int i = 0, end = number.size(); i < end; i++) {
			set.add(array[i]);
		}
	}
	private static void print() {
		System.out.println(set.size());
	}
	
	public static void main(String[] args) throws IOException{
		init();
		implement();
		print();
	}
}
