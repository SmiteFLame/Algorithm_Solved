package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = Array(n) { 0 }
    val cal = Array(4){0}
    var st = StringTokenizer(readLine())
    for (i in 0 until n) {
        array[i] = st.nextToken().toInt()
    }
    st = StringTokenizer(readLine())
    for(i in 0..3){
        cal[i] = st.nextToken().toInt()
    }

    var max = Int.MIN_VALUE
    var min = Int.MAX_VALUE


    fun dfs(idx: Int, sum: Int){
        if(idx == n){
            max = max.coerceAtLeast(sum)
            min = min.coerceAtMost(sum)
            return
        }

        for(i in 0..3){
            if(cal[i] == 0)continue
            cal[i]--
            when(i){
                0 -> dfs(idx + 1, sum + array[idx])
                1 -> dfs(idx + 1, sum - array[idx])
                2 -> dfs(idx + 1, sum * array[idx])
                3 -> dfs(idx + 1, sum / array[idx])
            }
            cal[i]++
        }
    }

    dfs(1, array[0])

    print("$max\n$min")
}
