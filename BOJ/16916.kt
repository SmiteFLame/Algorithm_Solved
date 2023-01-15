package test

fun main() = with(System.`in`.bufferedReader()) {
    val str1 = readLine()
    val str2 = readLine()
    val pi = Array(str2.length) { 0 }
    var j = 0
    fun kmp() : Int{
        for (i in 1 until str2.length) {
            while (j > 0 && str2[i] != str2[j]) j = pi[j - 1]
            if (str2[i] == str2[j]) pi[i] = ++j
        }
        j = 0
        for (i in str1.indices) {
            while (j > 0 && str1[i] != str2[j]) j = pi[j - 1]
            if (str1[i] == str2[j]) {
                if (j == str2.length - 1) {
                    return 1
                } else ++j
            }
        }
        return 0
    }
    println(kmp())
}
