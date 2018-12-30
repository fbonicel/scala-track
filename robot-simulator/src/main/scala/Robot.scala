import Bearing._

sealed trait Movable {
  def turnLeft: Robot

  def turnRight: Robot

  def advance: Robot

  def simulate(instructions: String): Robot
}

case class Position(x: Int, y: Int)

case class Robot(bearing: Bearing, position: Position) extends Movable {

  val coordinates: (Int, Int) = (this.position.x, this.position.y)

  override def turnLeft: Robot = bearing match {
    case North => this.copy(bearing = West)
    case South => this.copy(bearing = East)
    case East => this.copy(bearing = North)
    case West => this.copy(bearing = South)
  }

  override def turnRight: Robot = bearing match {
    case North => this.copy(bearing = East)
    case South => this.copy(bearing = West)
    case East => this.copy(bearing = South)
    case West => this.copy(bearing = North)
  }

  override def advance: Robot = bearing match {
    case North => this.copy(position = Position(position.x, position.y + 1))
    case South => this.copy(position = Position(position.x, position.y - 1))
    case East => this.copy(position = Position(position.x + 1, position.y))
    case West => this.copy(position = Position(position.x - 1, position.y))
  }

  override def simulate(instructions: String): Robot = instructions.foldLeft(this)((robot, instruction) => {
    instruction match {
      case 'L' => robot.turnLeft
      case 'R' => robot.turnRight
      case 'A' => robot.advance
    }
  })

}

object Robot {
  def apply(orientation: Bearing, coordinates: (Int, Int)) = new Robot(orientation, Position(coordinates._1, coordinates._2))
}
