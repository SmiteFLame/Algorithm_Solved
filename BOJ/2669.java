package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_2669 {

	public static void main(String[] args) throws IOException{
		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Map<int[], Integer> map = new HashMap<>();
		for(int i = 0; i < 4; i++) {
			String[] S = io.readLine().split(" ");
			for(int k = Integer.parseInt(S[0]), endk = Integer.parseInt(S[2]); k < endk; k++) {
				next:
				for(int l = Integer.parseInt(S[1]), endl = Integer.parseInt(S[3]); l < endl; l++) {
					for ( int[] key : map.keySet() ) {
						if(key[0] == k && key[1] == l)
							continue next;
					}
					
					map.put(new int[] {k, l}, 1);
				}	
			}
		}
		System.out.println(map.size());
	}
}
