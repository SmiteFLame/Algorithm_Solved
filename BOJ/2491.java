package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_2491_¾çµ¿Çõ {
	static int N, K, cntUP, cntDN, max;
	static int[] data;
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;


	private static void init() throws IOException {
		N = Integer.parseInt(io.readLine());
		data = new int[N];
		
		st = new StringTokenizer(io.readLine());
		for(int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
	}

	private static void implement() {
		for(int i = 1; i < N; i++) {
			if(data[i - 1] <= data[i]) {
				cntUP++;
			} else {
				max = cntUP > max ? cntUP : max;
				cntUP = 0;
			}
			
			if(data[i - 1] >= data[i]) {
				cntDN++;
			} else {
				max = cntDN > max ? cntDN : max;
				cntDN = 0;
			}
			max = cntUP > max ? cntUP : max;
			max = cntDN > max ? cntDN : max;
		}
	}

	private static void print() {
		System.out.println(max + 1);
	}

	public static void main(String[] args) throws IOException {
		init();
		implement();
		print();
	}

}
