import java.util.*;

public class Main {
    public static void main(String[] ar) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = 0;
        for(int i = 64; i > 0; i /= 2){
            S += (N / i);
            N %= i;
        }
        System.out.print(S);
    }
}
