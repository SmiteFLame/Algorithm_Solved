package test

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(){
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))
    var T = Integer.parseInt(br.readLine())
    for(i in 1..T){
        var N = Integer.parseInt(br.readLine())
        var cnt = 0
        for(j in 1..N){
            if(j * j <= N) cnt++
        }
        bw.write(cnt.toString() + "\n")
    }
    bw.flush()
    bw.close()
}