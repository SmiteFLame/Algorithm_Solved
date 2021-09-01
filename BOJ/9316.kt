package test

fun main() = with(System.`in`.bufferedReader()) {
    for(i in 1..readLine().toInt()){
        println("Hello World, Judge $i!")
    }
}