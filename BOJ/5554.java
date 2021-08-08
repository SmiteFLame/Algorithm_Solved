import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5554 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException{
		int sum = 0;
		for(int i = 0; i < 4; i++) {
			sum += Integer.parseInt(in.readLine());
		}
		System.out.println(sum / 60);
		System.out.println(sum % 60);
	}

}
