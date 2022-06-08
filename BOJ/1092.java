import java.util.*;
 
public class Main {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
 
        int n = scan.nextInt();
        
        ArrayList<Integer> crane = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            crane.add(scan.nextInt());
        }
        Collections.sort(crane, Collections.reverseOrder());
        
        int m = scan.nextInt();
        ArrayList<Integer> box = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            box.add(scan.nextInt());
        }
        Collections.sort(box, Collections.reverseOrder());
        
        if(crane.get(0) < box.get(0)) System.out.println("-1");
        else {
            int time = 0;
            while(!box.isEmpty()) {
                int idx = 0;
                for(int i = 0; i < crane.size();) {
                    if(idx == box.size()) break;
                    else if(crane.get(i) >= box.get(idx)) {
                        box.remove(idx);
                        i++;
                    }
                    else idx++;
                }
                time++;
            }
            System.out.println(time);
        }
    }
}    
 
