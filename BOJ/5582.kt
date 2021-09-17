package test

fun main() = with(System.`in`.bufferedReader()) {
    val str1 = readLine()
    val str2 = readLine()
    val array = Array<IntArray>(str1.length + 1){ IntArray(str2.length + 1) }
    var max = 0
    for(i in 1..str1.length){
        for(j in 1..str2.length){
            if(str1[i - 1] == str2[j - 1]){
                array[i][j] = array[i - 1][j - 1] + 1
                max = max.coerceAtLeast(array[i][j])
            }
        }
    }
    print(max)
}
