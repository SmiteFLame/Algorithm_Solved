import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long notCase = 1, inCase = 2;;
        for(int i = 1; i < N; i++){
            long temp = notCase;
            notCase = (inCase + notCase) % 9901;
            inCase = (temp * 2 + inCase) % 9901;
        }
        System.out.println((notCase + inCase) % 9901);
    }
}
