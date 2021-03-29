import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Algo1_서울_08반_양동혁 {

	// 각자 숫자별로 알파벳의 순서
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

		// 초기 데이터를 입력 받는다.
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		// 각 데이터들을 저장
		ArrayList<numbers> data = new ArrayList<>();

		// 모든 숫자에 대해서 판별
		for (int i = start; i <= end; i++) {
			int level = 0;
			int orderlist = 0;
			int temp = i;
			
			// 1부터 99까지여서 두자리 수를 if 문으로 나눠서 설정
			// 자리수가 제한이 없었으면 padding이 필요함
			
			// 두 자리 수 이면 각각의 자리수 마다 우선순위를 추가하기
			if(temp / 10 != 0) {
				for(int j = 0; j < 2; j++) {
					orderlist += Math.pow(10, j) * order[temp % 10];
					temp /= 10;
				}
				data.add(new numbers(i, orderlist, 2));
			
			// 한자리 수 이면 우선순위를 *10배 하여 우선순위 만들기
			} else {
				data.add(new numbers(i, order[temp] * 10, 1));
			}
		}
		
		// 데이터 정렬 순서는 우선순위가 작은 순서대로 출력
		// 우선 순위가 같으면 한자리 수 를 먼저 출력
		data.sort(new Comparator<numbers>() {
			@Override
			public int compare(numbers o1, numbers o2) {
				if(o1.orderlist != o2.orderlist) return Integer.compare(o1.orderlist, o2.orderlist);
				return o1.level - o2.level;
			}
		});
		
		// 모든 데이터를 출력
		// 10 자리마다 \n 추가
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
