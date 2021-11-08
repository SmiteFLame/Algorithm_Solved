package test

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val str = readLine()
    var a = 0
    var b = 0
    str.forEach { now ->
       if(now == 'A'){
           a++
       } else{
           b++
       }
    }
    if(a == b){
        print("Tie")
    } else if(a > b){
        print("A")
    } else{
        print("B")
    }
}
