import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N, S, M, K, sum, score;
	static int[] scoreArray = new int[3];
	static LinkedList<Integer> personalScore = new LinkedList<>();
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	private static void init() throws IOException {
		st = new StringTokenizer(io.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		personalScore.clear();
	}

	private static void implement() throws IOException {

		next: for (int i = 0; i < N; i++) {
			sum = 0;
			st = new StringTokenizer(io.readLine());
			for (int j = 0; j < 3; j++) {
				score = Integer.parseInt(st.nextToken());
				if (score < M)
					continue next;
				sum += score;
				scoreArray[j] = score;
			}
			if (sum < S)
				continue next;
			for (int j = 0; j < 3; j++) {
				personalScore.add(scoreArray[j]);
			}
		}
	}

	private static void print() {
		sb.append(personalScore.size() / 3).append("\n");
		for(int data : personalScore) {
			sb.append(data).append(" ");
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		init();
		implement();
		print();
	}
}