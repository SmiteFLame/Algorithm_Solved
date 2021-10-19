import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[]args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(map[i][j], min);
                max = Math.max(map[i][j], max);
            }
        }

        int answerSecond = Integer.MAX_VALUE;
        int answerHeight = -1;
        for(int x = min; x <= max; x++){
            int second = 0;
            int inven = b;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    int diff = map[i][j] - x;
                    if (diff > 0) {
                        second += Math.abs(diff) * 2;
                        inven += Math.abs(diff);
                    } else if (diff < 0) {
                        second += Math.abs(diff);
                        inven -= Math.abs(diff);
                    }
                }
            }
            if (inven >= 0 && second <= answerSecond) {
                answerSecond = second;
                answerHeight = x;
            }
        }
        System.out.println(answerSecond + " " + answerHeight);
    }
}