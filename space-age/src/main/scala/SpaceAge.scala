import scala.math.BigDecimal

trait Planet {
  type EarthYears = Double
  val orbitalPeriod: EarthYears

  def getSpaceAge(age: BigDecimal): Double =
    BigDecimal(age.toDouble / (orbitalPeriod * 31557600))
    .setScale(2, BigDecimal.RoundingMode.HALF_UP)
    .toDouble
}

case object Earth extends Planet {
  val orbitalPeriod: EarthYears = 1
}

case object Mercury extends Planet {
  val orbitalPeriod: EarthYears = 0.2408467
}

case object Venus extends Planet {
  val orbitalPeriod: EarthYears = 0.61519726
}

case object Mars extends Planet {
  val orbitalPeriod: EarthYears = 1.8808158
}

case object Jupiter extends Planet {
  val orbitalPeriod: EarthYears = 11.862615
}

case object Saturn extends Planet {
  val orbitalPeriod: EarthYears = 29.447498
}

case object Uranus extends Planet {
  val orbitalPeriod: EarthYears = 84.016846
}

case object Neptune extends Planet {
  val orbitalPeriod: EarthYears = 164.79132
}

object SpaceAge {

  def onEarth(age: BigDecimal): Double = Earth.getSpaceAge(age)

  def onMercury(age: BigDecimal): Double = Mercury.getSpaceAge(age)

  def onVenus(age: BigDecimal): Double = Venus.getSpaceAge(age)

  def onMars(age: BigDecimal): Double = Mars.getSpaceAge(age)

  def onJupiter(age: BigDecimal): Double = Jupiter.getSpaceAge(age)

  def onSaturn(age: BigDecimal): Double = Saturn.getSpaceAge(age)

  def onUranus(age: BigDecimal): Double = Uranus.getSpaceAge(age)

  def onNeptune(age: BigDecimal): Double = Neptune.getSpaceAge(age)

}
