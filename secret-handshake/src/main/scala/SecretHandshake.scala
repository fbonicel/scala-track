object SecretHandshake {

  private val handshakeMap = Map("1" -> "wink",
    "10" -> "double blink",
    "100" -> "close your eyes",
    "1000" -> "jump")

  private val reverseHandshake = "10000"

  def commands(value: Int): List[String] = {
    val result = handshakeMap
      .filterKeys(check(value, _))
      .values
      .toList
    if (check(value, reverseHandshake)) result.reverse else result
  }

  private def check(value: Int, binaryString: String): Boolean = {
    val bin = Integer.parseInt(binaryString, 2)
    (value & bin) == bin
  }

}
