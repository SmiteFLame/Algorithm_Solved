package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_D2_1954_�絿�� {
	static int T, N, count;
	static int[][] data;
	static StringBuffer st = new StringBuffer();
	
	
	static void MakeCircle(int rad) {		
		// NXN�̹Ƿ� �ּҿ� �ִ� �� ã�Ƶα�
		int X = rad;
		int Y = N - rad - 1;
		
		// Ȧ�� �� �϶� ������ 
		if(X == Y) {
			data[X][Y] = count;
			return;
		}
		
		
		// ���� ��
		for(int i = 0; i < Y - X; i++) {
			data[X][X + i] = count++;
		}
		
		// ������ ��
		for(int i = 0; i < Y - X; i++) {
			data[X + i][Y] = count++;
		}
		
		// �Ʒ��� ��
		for(int i = 0; i < Y - X; i++) {
			data[Y][Y - i] = count++;
		}
		
		// ���� ��
		for(int i = 0; i < Y - X; i++) {
			data[Y - i][X] = count++;
		}
		
		// ¦���� �϶� ������
		if(X + 1 == Y) return;
		
		// ����Լ��� ���ؼ� ���� ����
		MakeCircle(rad + 1);
		
	}
	
	// ����ϴ� �Լ�
	static void print() {
		for(int[] d: data) {
			for(int num : d) {
				st.append(num).append(" ");
			}
			st.append("\n");
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st.append("#" + test_case + "\n");
			
			// �׽�Ʈ ���̽� ���� �ʿ��� ���� �ʱ�ȭ
			N = Integer.parseInt(in.readLine());
			count = 1;
			data = new int[N][N];
			
			MakeCircle(0);
			
			print();
		}
		
		//���������� ������� StringBuilder ���
		System.out.println(st.toString());
	}
}
