import scala.io.StdIn

object Main {
  def main(args: Array[String]): Unit = {
    var n = StdIn.readLine()
    var count = 0
    while(n.length != 1){
      count += 1
      var next = 0L
      n.foreach(x => next += (x.toLong - 48))
      n = String.valueOf(next)
    }
    println(count)
    if(n.toInt % 3 == 0){
      println("YES")
    } else{
      println("NO")
    }
  }
}
