class RationalNumber(n : Int, d : Int)
{
  require(d != 0)

  val numer: Int = n
  val denom: Int = d

  def this(n : Int) = this(n,1)

  def + (that : RationalNumber) : RationalNumber = new RationalNumber(numer * that.denom + that.numer * denom, denom * that.denom)

  def + (i : Int) : RationalNumber = new RationalNumber(numer + i * denom, denom)

  def - (that : RationalNumber) : RationalNumber = new RationalNumber(numer * that.denom + that.numer * denom , denom * that.denom)

  def - (i : Int) : RationalNumber = new RationalNumber(numer - i * denom, denom)

  def * (that : RationalNumber) : RationalNumber = new RationalNumber(numer * that.numer , denom * that.denom)

  def * (i : Int) : RationalNumber = new RationalNumber(numer * i , denom)

  def / (that : RationalNumber) : RationalNumber = new RationalNumber(numer * that.denom , denom * that.numer)

  def / (i : Int) : RationalNumber = new RationalNumber(numer, denom * i)

  override def toString: String = numer + "/" + denom
}

object Rational {
  def main(args: Array[String]): Unit = {
    var oneHalf :RationalNumber = new RationalNumber(1,2)
    var twoThird : RationalNumber = new RationalNumber(2,3)
    var oneHalfPlusTwoThird = oneHalf + twoThird
    println(oneHalfPlusTwoThird.toString())
  }
}
