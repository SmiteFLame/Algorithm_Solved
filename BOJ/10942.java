import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_10942 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	

	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(in.readLine());
		int[] data = new int[N + 1];
		st = new StringTokenizer(in.readLine());
		for(int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		next:
		for(int x = 0, end = Integer.parseInt(in.readLine()); x < end; x++) {
			st = new StringTokenizer(in.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			while(left <= right) {
				if(data[left] != data[right]) {
					ot.write(0 + "\n");
					continue next;
				}
				left++;
				right--;
			}
			ot.write(1 + "\n");
		}
		ot.flush();
		ot.close();
		
	}

}
