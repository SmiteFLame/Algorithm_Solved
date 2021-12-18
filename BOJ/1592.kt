package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val l = st.nextToken().toInt()
    val array = Array(n + 1){0}
    var answer = 0
    array[1] = 1
    var count = 1
    while(true){
        if(array[count] == m) break
        if(array[count] % 2 == 1){
            count += l
        }
        else{
            count -= l
        }
        if(count > n){
            count %= n
        } else if(count < 1){
            count += n
        }

        array[count]++
        answer++
    }
    print(answer)
}
