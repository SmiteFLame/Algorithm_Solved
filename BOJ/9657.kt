package test

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt() % 7
    if(n == 0 || n == 2){
        print("CY")
    } else{
        print("SK")
    }
}
