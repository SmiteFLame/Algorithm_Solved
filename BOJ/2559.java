package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2559 {
	public static void main(String[] args) throws IOException{
		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(io.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] data = new int[N];
		
		st = new StringTokenizer(io.readLine());
		
		for(int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		
		for(int i = 0; i < K; i++) {
			sum += data[i];
		}
		
		int max = sum;
		
		for(int i = K; i < N; i++) {
			sum -= data[i - K];
			sum += data[i];
			max = sum > max ? sum : max;
		}
		
		System.out.println(max);
	}

}
