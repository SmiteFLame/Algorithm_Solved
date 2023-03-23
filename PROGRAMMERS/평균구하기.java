class Solution {
    public double solution(int[] arr) {
        int sum = 0;
        for(int i = 0, end = arr.length; i < end; i ++ ){
            sum += arr[i];
        }
        return (double) sum / arr.length;
    }
}