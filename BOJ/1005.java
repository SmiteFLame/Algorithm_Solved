import java.util.*;

public class Main {
    static int T,N,K,X,Y,test_case = 0;
    static int[] time;
    static int[] time_temp;
    static Vec[] order;

    static class Vec{
        Vector<Integer> V = new Vector<>();
    }

    static int DFS(int S){
        int A = time[S];
        for(int v : order[S].V){
            if(time_temp[v] == -1){
                A = Math.max(A, DFS(v) + time[S]);
            }
            else{
                A = Math.max(A,time_temp[v] + time[S]);
            }
        }
        time_temp[S] = A;
        return A;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for(;test_case < T; test_case++){
            N = sc.nextInt();
            K = sc.nextInt();
            time = new int[N];
            time_temp = new int[N];
            order = new Vec[N];
            for(int i = 0; i < N; i++){
                time[i] = sc.nextInt();
                order[i] = new Vec();
                time_temp[i] = -1;
            }
            for(int i = 0; i < K; i++) {
                X = sc.nextInt() - 1;
                Y = sc.nextInt() - 1;
                order[Y].V.add(X);
            }
            System.out.println(DFS(sc.nextInt() - 1));
        }
    }
}