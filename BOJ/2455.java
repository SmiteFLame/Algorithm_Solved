import java.util.*;

public class Main {

    public static void main(String[] ar) {
        Scanner sc = new Scanner(System.in);
        int C = 0, S = 0;
        for(int i = 0; i < 4; i++){
            C = C - sc.nextInt() + sc.nextInt();
            S = Math.max(S, C);
        }
        System.out.print(S);
    }
}