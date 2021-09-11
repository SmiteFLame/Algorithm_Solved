import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1267 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int M = 0, Y = 0;
		for(int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			Y += 10 * (now / 30 + 1);
			M += 15 * (now / 60 + 1);
		}
		if(M == Y) {
			System.out.println("Y M " + M);
		} else if(M < Y) {
			System.out.println("M " + M);
		} else{
			System.out.println("Y " + Y);
		}
	}

}
