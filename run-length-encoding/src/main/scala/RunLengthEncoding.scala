object RunLengthEncoding {
  def encode(stringToEncode: String): String = stringToEncode match {
    case "" => ""
    case s => {
      val (l, r) = s.span(_.equals(s.head))
      val prefix = if (l.length > 1) l.length else ""
      s"${prefix}${l.head}${encode(r)}"
    }
  }

  def decode(stringToDecode: String): String = stringToDecode match {
    case "" => ""
    case s => {
      val (digits, tail) = s.span(_.isDigit)
      var prefix = ""
      if (digits.length > 0) {
        prefix = tail.head.toString * digits.toInt
      } else {
        prefix = tail.head.toString
      }
      s"$prefix${decode(tail.tail)}"
    }
  }
}
