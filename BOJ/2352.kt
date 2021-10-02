package test

import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val data = Array<Int>(n) { 0 }
    for (i in 0 until n) {
        data[i] = st.nextToken().toInt()
    }
    val list = Array<Int>(n) { 0 }
    list[0] = data[0]
    var idx = 1
    var temp = 0
    for(i in 1 until n){
        if(list[idx - 1] < data[i]){
            list[idx++] = data[i]
        } else if(list[0] > data[i]){
            list[0] = data[i]
        } else{
            temp = Arrays.binarySearch(list, 0, idx, data[i])
            if(temp < 0){
                list[-temp - 1] = data[i]
            } else{
                list[temp] = data[i]
            }
        }
    }
    print(idx)
}