import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, result = 0;
    static int arr[][];

    public static void main(String[] args) throws NumberFormatException, IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= N; j++) {
                char ch = str.charAt(j - 1);

                if (ch == 'Y')
                    arr[i][j] = 1;

                else if (i != j)
                    arr[i][j] = 987654321;

            }
        }
        
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j || j == k || i == k)
                        continue;
                    else if (arr[i][j] > arr[i][k] + arr[k][j])
                        arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            int tmp = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j)
                    continue;
                else if (arr[i][j] <= 2)
                    tmp++;
            }
            result = Math.max(result, tmp);
        }
        System.out.println(result);
    }


}