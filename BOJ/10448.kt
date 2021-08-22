package test

import java.lang.StringBuilder
import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    var sb = StringBuilder()
    var arr = IntArray(51) { 0 }

    for(i in 1..50){
        arr[i] = arr[i - 1] + i
    }
    var bAry = BooleanArray(1001) { false }
    for(i in 1..50){
        for(j in 1..50){
            for(k in 1..50){
                var now = arr[i] + arr[j] + arr[k];
                if(now > 1000) break
                bAry[now] = true
            }
        }
    }
    repeat(readLine().toInt()){
        if(bAry[readLine().toInt()]){
            sb.append("1\n")
        } else{
            sb.append("0\n")
        }
    }
    print(sb.toString())
}