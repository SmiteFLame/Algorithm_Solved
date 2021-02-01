import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 0;
        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = sc.nextInt();
            sum += data[i];
        }
        Arrays.sort(data);
        int M = sc.nextInt();
        if (sum <= M) System.out.print(data[N - 1]);
        else {
            int L = 0, R = M, C = 0, Answer = 0;
            while (L <= R) {
                C = (L + R) / 2;
                int temp = 0;
                for (int i = 0; i < N; i++) {
                    temp += Math.min(C, data[i]);
                }
                if (M < temp){
                    R = C - 1;
                }
                else{
                    Answer = C;
                    L = C + 1;
                }
            }
            System.out.print(Answer);
        }
    }
}