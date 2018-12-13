import scala.annotation.tailrec

object House {

  val prefix = "This is"
  val suffix = ".\n"
  val verses = List("the house that Jack built",
    "the malt that lay in",
    "the rat that ate",
    "the cat that killed",
    "the dog that worried",
    "the cow with the crumpled horn that tossed",
    "the maiden all forlorn that milked",
    "the man all tattered and torn that kissed",
    "the priest all shaven and shorn that married",
    "the rooster that crowed in the morn that woke",
    "the farmer sowing his corn that kept",
    "the horse and the hound and the horn that belonged to"
  )

  def recite(start: Int, end: Int): String = {
    @tailrec
    def rec(i: Int, acc: String): String = i match {
      case 0 => acc + " " + verses(0)
      case int: Int => rec(int - 1, acc + " " + verses(int))
    }

    (for (i <- start - 1 until end) yield prefix + rec(i, "") + suffix).mkString + "\n"
  }

}
