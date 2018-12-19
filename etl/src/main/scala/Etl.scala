object Etl {
  def transform(origin: Map[Int, Seq[String]]): Map[String, Int] =
    origin.flatMap {
      case (score, letters) => Map(letters.map(_.toLowerCase -> score): _*)
    }
}
