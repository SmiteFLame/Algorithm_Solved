import scala.io.StdIn

object Main {
  var money = Array[Int]()
  var parent = Array[Int]()

  def union(x: Int, y: Int): Unit ={
    val px = find(x)
    val py = find(y)

    if(px == py) return
    if(money(px) < money(py)){
      parent(py) = px
    } else{
      parent(px) = py
    }
  }

  def find(now: Int): Int ={
    if(parent(now) == now) now
    else find(parent(now))
  }

  def main(args: Array[String]) = {
    var br = StdIn.readLine().split(" ")
    val n = br(0).toInt
    val m = br(1).toInt
    val k = br(2).toInt

    money = Array.fill(n + 1)(0)
    parent = Array.fill(n + 1)(0)

    for(i <- 1 to n){
      parent(i) = i
    }

    br = StdIn.readLine().split(" ")
    for (i <- 1 to n){
      money(i) = br(i - 1).toInt
    }

    for(i <- 0 until m){
      br = StdIn.readLine().split(" ")
      union(br(0).toInt, br(1).toInt)
    }

    var answer = 0
    for(i <- 1 to n){
      if(parent(i) == i){
        answer += money(i)
      }
    }

    if(k < answer){
      println("Oh no")
    } else{
      print(answer)
    }
  }
}
