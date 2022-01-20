package test

import kotlin.collections.ArrayList

fun main() = with(System.`in`.bufferedReader()) {
    val list = ArrayList<String>()
    repeat(readLine().toInt()){
        val str = readLine()
        val rs = StringBuffer(str).reverse().toString()
        if(list.contains(rs) || str == rs){
            print("${str.length} ${str[str.length / 2]}")
            return
        } else{
            list.add(str)
        }
    }
}
