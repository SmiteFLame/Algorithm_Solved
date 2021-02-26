package ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main_5397 {
	static int T;
	static String S;
	static LinkedList<Character> ans;
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));

	private static void init() throws IOException{
		S = io.readLine();
		ans = new LinkedList<>();
	}
	private static void implement() {
		int index = 0;
		for(int i = 0, end = S.length(); i < end; i++) {
			if(S.charAt(i) == '<') {
				index--;
				index = index < 0 ? 0 : index;
			} else if(S.charAt(i) == '>') {
				index++;
				index = index > ans.size() ? ans.size() : index;
			} else if(S.charAt(i) == '-') {
				if(ans.size() == 0 || index == 0) continue;
				ans.remove(--index);				
			} else {
				ans.add(index, S.charAt(i));
				index++;
				
			}
		}
	}
	private static void print() throws IOException{
		for(Character c : ans) {
			ot.write(c);
		}
		ot.write("\n");
	}
	
	public static void main(String[] args) throws IOException{
		T = Integer.parseInt(io.readLine());
		for(int tc = 1; tc <= T; tc++) {
			init();
			implement();
			print();
		}
		ot.flush();
		ot.close();

	}

}
