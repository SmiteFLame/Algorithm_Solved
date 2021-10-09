import java.util.*;

class Solution {
    List<Integer>[] list;
    boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        list = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < n - 1; i++){
            list[wires[i][0]].add(wires[i][1]);
            list[wires[i][1]].add(wires[i][0]);
        }
        for(int i = 0; i < n - 1; i++){
            visited = new boolean[n + 1];
            visited[wires[i][0]] = true;
            visited[wires[i][1]] = true;
            int a = BFS(wires[i][0]);
            int b = BFS(wires[i][1]);
            answer = answer < Math.abs(a - b) ? answer : Math.abs(a - b);
        }
        
        return answer;
    }
    int BFS(int X){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(X);
        int cnt = 0;
        while(!queue.isEmpty()){
            int now = queue.poll();
            cnt++;
            for(Integer next : list[now]){
                if(visited[next]) continue;
                visited[next] = true;
                queue.offer(next);
            }
        }
        return cnt;
    }
}