import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String S = br.readLine();
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        Boolean check = false;
        for(int i = 0, end = S.length(); i < end; i++){
            if(S.charAt(i) == '<'){
                check = true;
                sb.append(temp.reverse() + "<");
                temp = new StringBuilder();
            } else if(S.charAt(i) == '>'){
                check = false;
                sb.append(">");
            } else if(check){
                sb.append(S.charAt(i));
            } else if(S.charAt(i) == ' '){
                sb.append(temp.reverse() + " ");
                temp = new StringBuilder();
            } else{
                temp.append(S.charAt(i));
            }
        }
        sb.append(temp.reverse());
        System.out.println(sb.toString());
    }
}
