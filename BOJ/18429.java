import java.util.Scanner;

public class Main {
    static int N, K, C = 0;
    static int[] D;
    static boolean[] B;
    static void DFS(int S, int V){
        if(V == N){
            C++;
            return;
        }
        for(int i = 0; i < N; i++){
            if(B[i]) continue;
            if(S + D[i] - K >= 0){
                B[i] = true;
                DFS(S + D[i] - K, V + 1);
                B[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        D = new int[N];
        B = new boolean[N];
        for(int i = 0; i < N; i++){
            D[i] = sc.nextInt();
        }
        DFS(0, 0);
        System.out.print(C);
    }
}
