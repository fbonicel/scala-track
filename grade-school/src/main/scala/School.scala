import scala.collection._

class School {
  type DB = Map[Int, Seq[String]]

  private val myDb = mutable.Map.empty[Int, Seq[String]]

  def db: DB = myDb

  def add(name: String, g: Int) = myDb.get(g) match {
    case Some(seq) => myDb.put(g, seq ++ Seq(name))
    case None => myDb.put(g, Seq(name))
  }

  def grade(g: Int): Seq[String] = myDb.get(g).getOrElse(Seq.empty[String])

  def sorted: DB = Map(myDb.toSeq.sortBy(_._1):_*).mapValues(_.sorted)
}
