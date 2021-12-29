package test

fun main() = with(System.`in`.bufferedReader()) {
    if(readLine().toLong() % 2 == 1L){
        print("SK")
    } else{
        print("CY")
    }
}
