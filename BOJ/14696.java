package ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_14696 {

	public static void main(String[] args) throws IOException {
		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(io.readLine());
		next:
		for (int i = 0; i < N; i++) {
			int[][] data = new int[2][4];
			for (int j = 0; j < 2; j++) {
				StringTokenizer st = new StringTokenizer(io.readLine());
				for (int k = 0, end = Integer.parseInt(st.nextToken()); k < end; k++) {
					data[j][Integer.parseInt(st.nextToken()) - 1]++;
				}
			}
			for (int j = 3; j >= 0; j--) {
				if (data[0][j] == data[1][j])
					continue;
				if (data[0][j] > data[1][j])
					ot.write("A\n");
				else
					ot.write("B\n");
				continue next;
			}
			ot.write("D\n");
		}
		ot.flush();

	}

}
