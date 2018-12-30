object Bearing {
  sealed trait Bearing {
    val name: Char
  }

  case object North extends Bearing {
    val name = 'N'
  }

  case object South extends Bearing {
    val name = 'S'
  }

  case object East extends Bearing {
    val name = 'E'
  }

  case object West extends Bearing {
    val name = 'W'
  }

  val bearings = Seq(North,South,East,West)
  def forName(name: Char): Option[Bearing] = bearings.find(_.name == name)

}
