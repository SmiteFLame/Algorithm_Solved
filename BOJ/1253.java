import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        int answer = 0;

        for(int i = 0; i < n; i++){
            int left = 0;
            int right = n - 1;
            while(true){
                if(left == i) left++;
                else if(right == i) right--;

                if(left >= right) break;

                if(array[left] + array[right] > array[i]) right--;
                else if(array[left] + array[right] < array[i]) left++;
                else {
                    answer++;
                    break;
                }
            }
        }

        bw.write(String.format("%d", answer));
        bw.flush();

        bw.close();
        br.close();
    }
}