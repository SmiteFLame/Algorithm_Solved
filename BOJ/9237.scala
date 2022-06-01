import scala.collection.mutable
import scala.io.StdIn

object Main {
  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()
    val st = StdIn.readLine().split(" ")
    var array = new Array[Int](n)
    for (i <- 0 until n) {
      array(i) = st(i).toInt
    }
    array = array.sorted.reverse
    var date = 2
    var answer = 0
    for (i <- 0 until n) {
      answer = Math.max(answer, date + array(i))
      date += 1
    }
    println(answer)
  }
}
