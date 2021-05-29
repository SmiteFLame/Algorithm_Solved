import java.util.*;

public class Main {
    public static void main(String[] ar) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] D = new int[N];
        for (int i = 0; i < N; i++) D[i] = sc.nextInt();
        Arrays.sort(D);
        int L = 1, R = D[N - 1];
        while(L <= R){
            long H = 0;
            int C = (L + R) / 2;
            for(int i = 0; i < N; i++){
                if(D[i] >= C){
                    H += (D[i] - C);
                }
            }
            if(H >= M) L = C + 1;
            else R = C - 1;
        }
        System.out.print(R);
    }
}
