
object BeerSong {

  def recite(bottles: Int, times: Int): String =
      (
        for (i <- 0 until times)
          yield s"${mkBottlesString(bottles - i).capitalize} of beer on the wall, ${mkBottlesString(bottles - i)} of beer.${mkPassItOrStoreString(bottles - i)}"
      ).mkString("\n")


  private def mkPassItOrStoreString(i: Int): String = i match {
    case 0 => "\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
    case _ => s"\nTake ${if (i == 1) "it" else "one"} down and pass it around, ${mkBottlesString(i - 1)} of beer on the wall.\n"
  }

  private def mkBottlesString(i: Int): String = i match {
    case -1 => "99 bottles"
    case 0 => "no more bottles"
    case 1 => s"$i bottle"
    case _ => s"$i bottles"
  }


}
