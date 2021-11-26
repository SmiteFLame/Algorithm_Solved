package test

fun main() = with(System.`in`.bufferedReader()) {
    val str = readLine()
    if(str[0] == '0' && str[1] == 'x'){
        print(Integer.parseInt(str.substring(2), 16))
    } else if(str[0] == '0'){
        print(Integer.parseInt(str.substring(1), 8))
    } else{
        print(str)
    }

}
