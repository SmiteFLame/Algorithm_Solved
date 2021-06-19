import java.util.*;

public class Main {
    static int GCD(int A, int B){
        return A % B == 0 ? B : GCD(B, A % B);
    }

    public static void main(String[] ar) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int first = sc.nextInt();
        for(int i = 0; i < N - 1; i++){
            int F = sc.nextInt();
            int X = GCD(Math.max(F, first), Math.min(F, first));
            System.out.println(first / X + "/" + F / X);
        }
    }
}