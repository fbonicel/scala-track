
object PrimeFactors {
  def factors(num: Long): List[Int] = {
    def rec(count: Int, num: Long): List[Int] = num match {
      case _ if (num == 1) => List.empty[Int]
      case num if (num == count) => List(count)
      case num if (num % count > 0) => rec(count + 1, num)
      case num if (num % count == 0) => count :: rec(count, num / count)
    }
    rec(2, num)
  }

}
