import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_9093 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		for(int i = 0, end = Integer.parseInt(in.readLine()); i < end; i++) {
			st = new StringTokenizer(in.readLine());
			while(st.hasMoreTokens()) {
				String now = st.nextToken();
				for(int j = 0, endj = now.length(); j < endj; j++) {
					ot.write(now.charAt(endj - j - 1));
				}
				ot.write(" ");
			}
			ot.write("\n");
		}
		ot.flush();
		ot.close();

	}

}
