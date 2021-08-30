import java.io.*;
import java.math.BigInteger;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        BigInteger A = new BigInteger(br.readLine());
        char C = br.readLine().charAt(0);
        BigInteger B = new BigInteger(br.readLine());
        if(C == '+'){
            System.out.println(A.add(B));
        } else{
            System.out.println(A.multiply(B));
        }
    }
}
