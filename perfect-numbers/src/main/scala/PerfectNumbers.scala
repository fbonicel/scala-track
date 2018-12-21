import NumberType.{NumberType, _}

object PerfectNumbers {
  def classify(number: Int): Either[String, NumberType] =
    if (number < 1)
      Left("Classification is only possible for natural numbers.")
    else
    (for (i <- 1 until number; if (number % i == 0)) yield i).sum match {
      case s if (s == number) => Right(NumberType.Perfect)
      case s if (s > number) => Right(NumberType.Abundant)
      case s if (s < number) => Right(NumberType.Deficient)
    }
}
