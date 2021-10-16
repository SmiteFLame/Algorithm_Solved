package test

import java.lang.StringBuilder
import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val sb = StringBuilder()
    val n = st.nextToken().toLong()
    var l = st.nextToken().toLong()
    var flag = true

    while (l <= 100 && flag) {
        var sum = l * (l - 1) / 2
        var idx: Long = 0
        while (true) {
            if (sum == n) {
                for (k in 0 until l) sb.append("${idx + k} ")
                flag = false
                break
            }
            sum += l
            idx += 1
            if (sum > n) break
        }
        l++
    }
    if(flag){
        sb.append("-1")
    }
    print(sb.toString())
}
