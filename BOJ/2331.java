import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_16430 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		int B = Integer.parseInt(st.nextToken());
		List<String> array = new ArrayList<>();
		array.add(A);
		while(true) {
			int next = 0;
			for(int i = 0, end = A.length(); i < end; i++) {
				next += Math.pow(A.charAt(i) - '0', B);
			}
			A = Integer.toString(next);
			if(array.contains(A)) {
				System.out.println(array.indexOf(A));
				return;
			}
			array.add(A);
		}
	}

}
