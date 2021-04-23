package justonly;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main_11723 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		boolean[] array = new boolean[21];
		for (int tc = 1, end = Integer.parseInt(in.readLine()); tc <= end; tc++) {
			st = new StringTokenizer(in.readLine());
			String order = st.nextToken();
			if(order.equals("add")) {
				int now = Integer.parseInt(st.nextToken());
				array[now] = true;
			} else if(order.equals("remove")) {
				int now = Integer.parseInt(st.nextToken());
				array[now] = false;				
			} else if(order.equals("check")) {
				int now = Integer.parseInt(st.nextToken());				
				ot.write(array[now] ? '1' : '0');
				ot.write("\n");
				
			} else if(order.equals("toggle")) {
				int now = Integer.parseInt(st.nextToken());
				array[now] = !array[now];
				
			} else if(order.equals("all")) {
				Arrays.fill(array, true);
			} else if(order.equals("empty")) {
				Arrays.fill(array, false);
			}
		}
		ot.flush();
		ot.close();
	}

}
