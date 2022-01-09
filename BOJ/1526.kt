package test

fun main() = with(System.`in`.bufferedReader()) {
    var n = readLine().toInt()
    while(n > 0){
        var isRight = true
        n.toString().forEach { now ->
            if(now != '4' && now != '7'){
                isRight = false
            }
        }
        if(isRight){
            break
        }
        n--
    }
    println(n)
}
