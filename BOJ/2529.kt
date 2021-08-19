package test

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

var k : Int = 0
var sign = CharArray(0)
var answer = ArrayList<String>()
var visited = BooleanArray(10)

private fun DFS(cnt : Int, left : Int, now : String){
    if(cnt == k){
        answer.add(now);
        visited[left] = false;
        return;
    }
    for(i in 0..9){
        if(visited[i] || left == i) continue;
        if(sign[cnt] == '>'){
            if(left < i) continue;
        } else if(left > i){
            continue;
        }
        visited[i] = true
        DFS(cnt + 1, i, now + i)
    }
    visited[left] = false
}

fun main(){
    var br = BufferedReader(InputStreamReader(System.`in`))
    k = Integer.parseInt(br.readLine())
    sign = CharArray(k)
    var st = StringTokenizer(br.readLine())
    for (i in 0 until k){
        sign[i] = st.nextToken()[0]
    }
    for(i in 0..9){
        visited[i] = true
        DFS(0, i, i.toString())
    }
    println(answer.get(answer.size - 1))
    println(answer.get(0))
}