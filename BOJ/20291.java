package ssafy.study.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_20291 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// Ʈ�� ���� Ȱ���ؼ� key�� ����
		Map<String, Integer> map = new TreeMap<>(); 
		for (int i = 0, end = Integer.parseInt(in.readLine()); i < end; i++) {
			
			// �Է� ���� �����͸� �и�
			StringTokenizer st = new StringTokenizer(in.readLine(), ".");
			
			// ù ������ �н�
			st.nextToken();
			
			// Ȯ���� ������ ��������
			String extension = st.nextToken();
			
			// �����Ͱ� ���ٸ� �⺻ 0�� �߰�
			map.putIfAbsent(extension, 0);
			
			// �������� ������ �Ѱ� �� �߰�
			map.put(extension, map.get(extension) + 1);
		}
		
		// ��� �����͵��� Ȯ����(��������)���� ���
		map.forEach((key,value) -> sb.append(key + " " + value + "\n"));
		System.out.println(sb.toString());
	}
}
