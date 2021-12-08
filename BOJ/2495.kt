package test

fun main() = with(System.`in`.bufferedReader()) {
    repeat(3){
        val str = readLine()
        var char = str[0]
        var count = 0
        var max = 0
        str.forEach { now ->
            if(char == now){
                count++
                max = count.coerceAtLeast(max)
            } else{
                char = now
                count = 1
            }
        }
        println(max)
    }
}
