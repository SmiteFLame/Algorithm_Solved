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
		
		// 트리 맵을 활용해서 key값 정렬
		Map<String, Integer> map = new TreeMap<>(); 
		for (int i = 0, end = Integer.parseInt(in.readLine()); i < end; i++) {
			
			// 입력 받은 데이터를 분리
			StringTokenizer st = new StringTokenizer(in.readLine(), ".");
			
			// 첫 데이터 패스
			st.nextToken();
			
			// 확장자 데이터 가져오기
			String extension = st.nextToken();
			
			// 데이터가 없다면 기본 0값 추가
			map.putIfAbsent(extension, 0);
			
			// 데이터의 개수를 한개 더 추가
			map.put(extension, map.get(extension) + 1);
		}
		
		// 모든 데이터들을 확장자(오름차순)으로 출력
		map.forEach((key,value) -> sb.append(key + " " + value + "\n"));
		System.out.println(sb.toString());
	}
}
