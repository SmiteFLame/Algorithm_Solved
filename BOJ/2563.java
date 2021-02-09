package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_2563_�絿�� {
	static int N, X, Y, answer = 0;
	static boolean[][] map;
	static BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;

	private static void init() throws IOException {
		N = Integer.parseInt(io.readLine());
		
		// �ִ� ���̰� 100 * 100 �̹Ƿ� �̸� �����Ѵ�.
		map = new boolean[100][100];
	}

	private static void implement() throws IOException {
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(io.readLine());
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			
			// �Է� ���� ������ ���� 10 *10 map�� �����͸� �߰��Ѵ�
			
			// �ִ� ������ �Ѿ�� �ʵ��� Math.min(100, X + 10)�� ���ؼ� ���� ������ ������ �ش�.
			for (int k = X, endK = Math.min(100, X + 10); k < endK; k++) {
				for (int l = Y, endL = Math.min(100, Y + 10); l < endL; l++) {
					
					// map���� �÷����� ĥ������ ���� ���� ���ϰ� ���̸� �߰��Ѵ�
					// ĥ���� ������ true�� �ٲ۴�.
					if(!map[k][l]) {
						answer++;
						map[k][l] = true;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		init();
		implement();
		System.out.println(answer);
	}
}
