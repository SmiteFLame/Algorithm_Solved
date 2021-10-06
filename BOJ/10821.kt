package test

fun main() = with(System.`in`.bufferedReader()) {
    val str = readLine()
    var cnt = 1
    str.forEach { n ->
        if(n == ','){
            cnt++
        }
    }
    print(cnt)
}
