class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] node = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                node[i][j] = 200 * 100000 + 1;
            }
            node[i][i] = 0;
        }
        for(int i = 0, end = fares.length; i < end; i++){
            node[fares[i][0]][fares[i][1]] = fares[i][2];
            node[fares[i][1]][fares[i][0]] = fares[i][2];
        }
        
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(node[i][j] > node[i][k] + node[k][j]) {
                        node[i][j] = node[i][k] + node[k][j];
                    }
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            answer = Math.min(answer, node[s][i] + node[i][a] + node[i][b]);
        }
        return answer;
    }
}