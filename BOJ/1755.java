import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Algo1_����_08��_�絿�� {

	// ���� ���ں��� ���ĺ��� ����
	static final int[] order = { 9, 4, 8, 7, 2, 1, 6, 5, 0, 3 };

	static class numbers{
		int num;
		int orderlist;
		int level;

		numbers(int num, int orderlist, int level) {
			this.num = num;
			this.orderlist = orderlist;
			this.level = level;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());

		// �ʱ� �����͸� �Է� �޴´�.
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		// �� �����͵��� ����
		ArrayList<numbers> data = new ArrayList<>();

		// ��� ���ڿ� ���ؼ� �Ǻ�
		for (int i = start; i <= end; i++) {
			int level = 0;
			int orderlist = 0;
			int temp = i;
			
			// 1���� 99�������� ���ڸ� ���� if ������ ������ ����
			// �ڸ����� ������ �������� padding�� �ʿ���
			
			// �� �ڸ� �� �̸� ������ �ڸ��� ���� �켱������ �߰��ϱ�
			if(temp / 10 != 0) {
				for(int j = 0; j < 2; j++) {
					orderlist += Math.pow(10, j) * order[temp % 10];
					temp /= 10;
				}
				data.add(new numbers(i, orderlist, 2));
			
			// ���ڸ� �� �̸� �켱������ *10�� �Ͽ� �켱���� �����
			} else {
				data.add(new numbers(i, order[temp] * 10, 1));
			}
		}
		
		// ������ ���� ������ �켱������ ���� ������� ���
		// �켱 ������ ������ ���ڸ� �� �� ���� ���
		data.sort(new Comparator<numbers>() {
			@Override
			public int compare(numbers o1, numbers o2) {
				if(o1.orderlist != o2.orderlist) return Integer.compare(o1.orderlist, o2.orderlist);
				return o1.level - o2.level;
			}
		});
		
		// ��� �����͸� ���
		// 10 �ڸ����� \n �߰�
		int cnt = 0;
		for(numbers numb : data) {
			ot.write(numb.num + " ");
			cnt++;
			if(cnt == 10) {
				cnt = 0;
				ot.write("\n");
			}
		}
		
		ot.flush();
		ot.close();
		
	}
}
