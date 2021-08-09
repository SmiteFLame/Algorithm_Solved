import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5597 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException{
		boolean[] data = new boolean[31];
		for(int i = 0; i < 28; i++) {
			data[Integer.parseInt(in.readLine())] = true;
		}

		for(int i = 1; i <= 30; i++) {
			if(data[i]) continue;
			System.out.println(i);
		}
	}

}
