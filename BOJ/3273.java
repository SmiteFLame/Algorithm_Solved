import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] data = new int[N];
        for(int i = 0; i< N; i++){
            data[i] = sc.nextInt();
        }
        Arrays.sort(data);
        int K = sc.nextInt();
        int L = 0, R = N - 1;
        int A = 0;
        while(L < R){
            int sum = data[L] + data[R];
            if(sum == K) A++;
            if(sum > K) R--;
            else L++;
        }
        System.out.println(A);
    }
}