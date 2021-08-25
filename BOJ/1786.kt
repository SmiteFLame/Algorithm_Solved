package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var str = readLine()
    var pat = readLine()

    var strlen = str.length
    var patlen = pat.length
    var KMP = IntArray(pat.length)

    var index = 0
    for(i in 1 until patlen){
        while(index > 0 && pat[i] != pat[index]){
            index = KMP[index - 1]
        }
        if(pat[i] == pat[index]){
            index++
            KMP[i] = index
        }
    }

    var cnt = 0
    var answer = StringBuilder()
    index = 0
    for(i in 0 until strlen){
        while(index > 0 && str[i] != pat[index]){
            index = KMP[index - 1]
        }
        if(str[i] == pat[index]){
            if(index == pat.length - 1){
                cnt++
                answer.append((i + 2 - pat.length).toString() + " ")
                index = KMP[index]
            } else{
                index++
            }
        }
    }

    println(cnt)
    print(answer.toString())
}
