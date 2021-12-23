package test

fun main() = with(System.`in`.bufferedReader()) {
    val array = arrayOf('U', 'C', 'P', 'C')
    val str = readLine()
    var index = 0
    str.forEach { now ->
        if(now == array[index]){
            index++
        }
        if(index == 4){
            print("I love UCPC")
            return
        }
    }

    print("I hate UCPC")
}
