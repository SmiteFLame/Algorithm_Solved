import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_10820 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		while(true) {
			String S = in.readLine();
			if(S == null) break;
			int[] data = new int[4];
			for(int i = 0, e = S.length(); i < e; i++) {
				if(S.charAt(i) >= 'a' && S.charAt(i) <= 'z') {
					data[0]++;
				} else if(S.charAt(i) >= 'A' && S.charAt(i) <= 'Z') {
					data[1]++;
				} else if(S.charAt(i) >= '0' && S.charAt(i) <= '9') {
					data[2]++;
				} else if(S.charAt(i) == ' '){
					data[3]++;
				}
			}
			ot.write(data[0] + " " + data[1] + " " + data[2] + " " + data[3] + " " + "\n");
		}
		ot.flush();
		ot.close();
	}
}
