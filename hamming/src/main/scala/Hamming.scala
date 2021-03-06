object Hamming {
  def distanceRec(firstDna: String, secondDna: String): Option[Int] = (firstDna, secondDna) match {
    case (a, b) if (a.length != b.length) => None
    case ("", "") => Some(0)
    case (a, b) if (a.head.equals(b.head)) => distance(a.tail, b.tail)
    case (a, b) if (!a.head.equals(b.head)) => distance(a.tail, b.tail).map(_ + 1)
  }

  def distance(firstDna: String, secondDna: String): Option[Int] = (firstDna, secondDna) match {
    case (a, b) if (a.length != b.length) => None
    case ("", "") => Some(0)
    case (a, b) => Some(a.zip(b).filterNot{case (a,b) => a.equals(b)}.length)
  }
}
