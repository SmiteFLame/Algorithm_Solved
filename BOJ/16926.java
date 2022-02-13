import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[h][w];
        for(int i=0; i<h; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<w; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = Math.min(h, w) / 2; 
        for(int i=0; i<n; i++) {

            for(int j=0; j<count; j++) { 
                int temp = arr[j][j];

                if (w - j - (j + 1) >= 0) System.arraycopy(arr[j], j + 1, arr[j], j + 1 - 1, w - j - (j + 1));

                for(int k=j+1; k<h-j; k++)
                    arr[k-1][w-1-j] = arr[k][w-1-j];

                if (w - 2 - j + 1 - j >= 0)
                    System.arraycopy(arr[h - 1 - j], j, arr[h - 1 - j], j + 1, w - 2 - j + 1 - j);

                for(int k=h-2-j; k>=j; k--)
                    arr[k+1][j] = arr[k][j];

                arr[j+1][j] = temp;
            }
        }

        for(int j=0; j<h; j++) {
            for(int k=0; k<w; k++) {
                System.out.print(arr[j][k] + " ");
            }
            System.out.println();
        }
    }
}