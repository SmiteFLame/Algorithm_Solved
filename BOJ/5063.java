import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_5063 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		for(int i = 0, end = Integer.parseInt(in.readLine()); i < end; i++) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			if(A + C == B) {
				ot.write("does not matter\n");
			} else if(A + C < B) {
				ot.write("advertise\n");
			} else {
				ot.write("do not advertise\n");
			}
		}
		ot.flush();
		ot.close();
	}
}
