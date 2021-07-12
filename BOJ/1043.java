import java.util.*;

public class Main {

    static class Vec{
        Vector<Integer> V = new Vector<>();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        int temp1, temp2, N, M, i, j, X, A = 0;
        N = sc.nextInt();
        M = sc.nextInt();

        boolean[] B = new boolean[M];
        boolean[] C = new boolean[N];

        Vec[] D = new Vec[M];
        Vec[] P = new Vec[N];

        Queue<Integer> Q = new LinkedList<>();
        for(i = 0; i < M; i++) D[i] = new Vec();
        for(i = 0; i < N; i++) P[i] = new Vec();

        temp1 = sc.nextInt();
        for(i = 0; i < temp1; i++){
            temp2 = sc.nextInt() - 1;
            Q.offer(temp2);
            C[temp2] = true;
        }

        for(i = 0; i < M; i++){
            temp1 = sc.nextInt();
            for(j = 0; j < temp1; j++){
                temp2 = sc.nextInt();
                D[i].V.add(temp2 - 1);
                P[temp2 - 1].V.add(i);
            }
        }

        while(!Q.isEmpty()){
            X = Q.poll();
            for(int p : P[X].V){
                if(B[p]) continue;
                B[p] = true;
                for(int d : D[p].V){
                    if(C[d]) continue;
                    C[d] = true;
                    Q.offer(d);
                }

            }
        }
        for(i = 0; i < M; i++){
            if(!B[i]) A++;
        }
        System.out.print(A);
    }
}
