import java.util.Scanner;

public class Main_1789 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long L = sc.nextLong();
		long S = 0;
		while(L > 0) {
			S++;
			L -= S;
		}
		if(L < 0) S--;
		System.out.println(S);
	}
}
