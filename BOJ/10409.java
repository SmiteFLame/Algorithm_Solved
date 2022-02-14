import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());	
		int T = Integer.parseInt(st.nextToken());	
		int count = 0;	
		int sum = 0;	
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i=0; i<arr.length; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
			
			if(sum > T)	
				break;
			
			count ++;
		}
		
		System.out.println(count);
		br.close();
	}

}