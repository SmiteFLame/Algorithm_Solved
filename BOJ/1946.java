package justonly;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1946 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		for(int t = 0, end = Integer.parseInt(in.readLine()); t < end; t++) {
			int N = Integer.parseInt(in.readLine());
			List<int[]> array = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				array.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}
			
			array.sort(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(o1[0], o2[0]);
				}
			});
			
			int ans = N;
			int next = array.get(0)[1];
			for(int i = 1, endi = array.size(); i < endi; i++) {
				int now = array.get(i)[1];
				if(next < now) ans--;
				if(next > now) next = now;
			}
			ot.write(ans + "\n");
		}
		ot.flush();
		ot.close();
	}

}
