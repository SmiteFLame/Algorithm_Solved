import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11066 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		for(int t = 0, end = Integer.parseInt(in.readLine()); t < end; t++) {
			int N = Integer.parseInt(in.readLine());
			int[] sum = new int[N + 1];
			int[][] DP = new int[N + 1][N + 1];
			
			st = new StringTokenizer(in.readLine());
			
			for(int i = 1; i <= N; i++) {
				sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
			}
			
			for(int x = 1; x < N; x++) {
				for(int i = 1; i + x <= N; i++) {
					int j = x + i;
					DP[i][j] = Integer.MAX_VALUE;
					for(int z = i; z < j; z++) {
						DP[i][j] = Math.min(DP[i][j], DP[i][z] + DP[z + 1][j] + sum[j] - sum[i - 1]); 
					}
				}
				
			}
			ot.write(DP[1][N] + "\n");
		}
		ot.flush();
		ot.close();
	}
}
