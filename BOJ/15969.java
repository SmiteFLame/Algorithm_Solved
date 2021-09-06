import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15969 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] array = new int[N];
		for(int i = 0; i< N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(array);
		System.out.println(array[N - 1] - array[0]);

	}

}
