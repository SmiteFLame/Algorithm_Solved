import java.util.*;

public class Main {
    public static void main(String[] ar) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt() - 1;
        int Ranking = 1;
        boolean[] checked = new boolean[N];
        int[][] data = new int[N][3];
        for (int i = 0; i < N; i++) {
            int T = sc.nextInt() - 1;
            for (int j = 0; j < 3; j++) {
                data[T][j] = sc.nextInt();
            }
        }
        for (int x = 0; x < 3; x++) {
            for (int i = 0; i < N; i++) {
                if (checked[i]) continue;
                if (data[i][x] > data[K][x]) {
                    Ranking++;
                    checked[i] = true;
                } else if (data[i][x] < data[K][x]) {
                    checked[i] = true;
                }
            }
        }
        System.out.print(Ranking);
    }
}