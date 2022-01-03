package test

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()){
        val map = Array('Z' - 'A' + 1){false}
        readLine().forEach { now ->
            map[now - 'A'] = true
        }
        var sum = 0
        for(i in 0 until 'Z' - 'A' + 1){
            if(!map[i]) {
                sum += (i + 'A'.toInt())
            }
        }
        sb.append("$sum\n")
    }
    print(sb.toString())
}
