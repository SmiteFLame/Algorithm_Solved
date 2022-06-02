import java.util.StringTokenizer
import scala.io.StdIn

object Main {
  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()
    var array = new Array[Int](n)
    val st = new StringTokenizer(StdIn.readLine())
    for(i <- 0 until n){
      array(i) = st.nextToken().toInt
    }
    array = array.sorted
    println(array((n - 1) / 2))
  }
}
