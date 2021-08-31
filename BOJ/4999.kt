package test

fun main() = with(System.`in`.bufferedReader()) {
    val a = readLine()
    val b = readLine()
    if(a.length >= b.length){
        println("go")
    } else{
        println("no")
    }
}