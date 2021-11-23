package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val p = st.nextToken().toInt()

    var cnt = 1
    var num = n
    val array = Array(1001) { 0 }
    while (true) {
        num = (num * n) % p
        cnt++
        if(array[num] != 0){
            print(cnt - array[num])
            return
        }
        array[num] = cnt
    }

}
