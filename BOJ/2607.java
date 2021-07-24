import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;

public class Main_2607 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	private static Map<Character, Integer> countChar(String X){
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0, endi = X.length(); i < endi; i++) {
			map.putIfAbsent(X.charAt(i), 0);
			map.replace(X.charAt(i), map.get(X.charAt(i)) + 1);
		}
		return map;
	}

	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(in.readLine());
		String now = in.readLine();
		int answer = 0;
		Map<Character, Integer> nowMap = countChar(now);
		
		nextLine:
		for(int i = 1; i < N; i++) {
			String next = in.readLine();
			if(Math.abs(now.length() - next.length()) > 1) continue;
			Map<Character, Integer> nextMap = countChar(next);
			for(Character c : nowMap.keySet()) {
				nextMap.putIfAbsent(c, 0);
				nextMap.replace(c, nextMap.get(c) - nowMap.get(c));
				if(nextMap.get(c) == 0) nextMap.remove(c);
			}
			if(nextMap.size() > 2) continue;
			int sum = 0;
			for(Character c : nextMap.keySet()) {
				if(Math.abs(nextMap.get(c)) > 1) continue nextLine;
				sum += nextMap.get(c);
			}
			if(!(nextMap.size() == 0) || !(sum == 0 && nextMap.size() == 2) || !(Math.abs(sum) == 1 && nextMap.size() == 1))
			answer++;
		}

		System.out.println(answer);
	}

}
