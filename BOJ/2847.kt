package test


fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val level = Array<Int>(n){0}
    for(i in 0 until n){
        level[i] = readLine().toInt()
    }

    if(n == 1){
        println(0)
    } else{
        var answer = 0
        for(i in n - 2 downTo 0){
            val h = level[i + 1]
            val l = level[i]
            if(l >= h){
                answer += l - h + 1
                level[i] = h - 1
            }
        }
        println(answer)
    }
}