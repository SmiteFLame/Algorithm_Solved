import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_3003 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine());
		int[] array = { 1, 1, 2, 2, 2, 8 };
		for(int i = 0; i < 6; i++) {
			ot.write(array[i] - Integer.parseInt(st.nextToken()) + " ");
		}
		ot.flush();
		ot.close();
	}

}
