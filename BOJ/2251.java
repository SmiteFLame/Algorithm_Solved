package ssafy.study.week11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2251 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] bottle = new int[3];
		for (int i = 0; i < 3; i++) {
			bottle[i] = sc.nextInt();
		}

		// C�� ��� �� �ִ� ��� ��

		ArrayList<Integer> answer = new ArrayList<>();

		// A�� ������� �� C�� ����ִ� ��
		boolean[][][] visited = new boolean[201][201][201];

		Queue<int[]> queue = new LinkedList<>();

		// A�� B����ְ�, C�� ä����
		queue.add(new int[] { 0, 0, bottle[2] });

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			if (visited[now[0]][now[1]][now[2]])
				continue;
			visited[now[0]][now[1]][now[2]] = true;

			if (now[0] == 0)
				answer.add(now[2]);

			// j�� �ִ� ���� i�� �ִ´�

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (i == j)
						continue;

					int[] next = Arrays.copyOf(now, 3);
					int sum, rest;
					if (now[i] + now[j] > bottle[i]) {
						sum = bottle[i];
						rest = now[i] + now[j] - bottle[i];
					} else {
						sum = now[i] + now[j];
						rest = 0;
					}
					next[i] = sum;
					next[j] = rest;
					queue.add(next);
				}
			}

		}
		answer.sort((a, b) -> a.compareTo(b));
		for(Integer x : answer) {
			System.out.print(x + " ");
		}
	}
}
