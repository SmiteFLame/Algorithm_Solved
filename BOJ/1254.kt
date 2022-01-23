package test

fun main() = with(System.`in`.bufferedReader()) {
    val str = readLine()

    fun isPalin(input: String): Boolean{
        for(i in input.indices){
            if(input[i] != input[input.length - i - 1]){
                return false
            }
        }
        return true
    }
    for(i in str.indices){
        if(isPalin(str.substring(i))){
            print(str.length + i)
            return
        }
    }
    print(str.length * 2)
}
