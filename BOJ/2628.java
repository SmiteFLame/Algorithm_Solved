package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_2628 {
	public static void main(String[] args) throws IOException{
		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(io.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(io.readLine());
		
		ArrayList<Integer> ver = new ArrayList<>();
		ArrayList<Integer> hor = new ArrayList<>();
		ArrayList<Integer> ans = new ArrayList<>();
		ver.add(0);
		hor.add(0);
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(io.readLine());
			if(Integer.parseInt(st.nextToken()) == 0) {
				hor.add(Integer.parseInt(st.nextToken()));
			}else {
				ver.add(Integer.parseInt(st.nextToken()));				
			}
		}

		ver.add(N);
		hor.add(M);
		Collections.sort(ver);
		Collections.sort(hor);
		
		int max = 0;
		
		for(int i = 1, endi = hor.size(); i < endi; i++) {
			for(int j = 1, endj = ver.size(); j < endj; j++) {
				int X = (hor.get(i) - hor.get(i - 1)) * (ver.get(j) - ver.get(j - 1));
				max = max > X ? max : X;
			}
		}
		
		System.out.println(max);
	}
}
