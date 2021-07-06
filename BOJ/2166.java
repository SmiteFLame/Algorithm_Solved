import java.util.*;

public class Main {
    static int N;
    static double S = 0.0f;
    static double A = 0, B = 0;

    static class Point{
        long X;
        long Y;
        Point(int _X, int _Y){
            this.X = _X;
            this.Y = _Y;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Point Pre = new Point(sc.nextInt(), sc.nextInt());
        Point temp = Pre;
        for(int i = 1; i < N; i++){
            Point Post = new Point(sc.nextInt(), sc.nextInt());
            A += temp.X * Post.Y;
            B += temp.Y * Post.X;
            temp = Post;
        }

        A += temp.X * Pre.Y;
        B += temp.Y * Pre.X;
        System.out.printf("%.1f", Math.abs(A - B) * 0.5f);
    }
}