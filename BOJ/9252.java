import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_9252 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		String A = in.readLine(), B = in.readLine();
		int endi = A.length(), endj = B.length();
		int[][] LCS = new int[endi + 1][endj + 1];
		for(int i = 1; i <= endi; i++) {
			for(int j = 1; j <= endj; j++) {
				if(A.charAt(i - 1) == B.charAt(j - 1)) {
					LCS[i][j] = LCS[i - 1][j - 1] + 1;
				} else {
					LCS[i][j] = LCS[i - 1][j] < LCS[i][j - 1] ? LCS[i][j - 1] : LCS[i - 1][j]; 
				}
			}
		}
		System.out.println(LCS[endi][endj]);
		String answer = "";
		while(endi >= 1 && endj >= 1) {
			if(LCS[endi][endj] == LCS[endi - 1][endj]) {
				endi--;
			} else if(LCS[endi][endj] == LCS[endi][endj - 1]) {
				endj--;
			} else {
				endi--;
				endj--;
				answer = A.charAt(endi) + answer;
			}
		}
		System.out.println(answer);
	}
}
