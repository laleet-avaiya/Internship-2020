
class ComplexNumber(r : Float , i : Float)
{
  val real = r
  val image = i

  def + (that : ComplexNumber) : ComplexNumber = new ComplexNumber(real + that.real , image + that.image)

  def + (i : Int) : ComplexNumber = new ComplexNumber(real + i , image)

  def - (that : ComplexNumber) : ComplexNumber = new ComplexNumber(real - that.real , image - that.image)

  def - (i : Int) : ComplexNumber = new ComplexNumber(real - i , image)

  /*
  * (a+bi)(c+di) = ac + adi + bci + bdi2
  *              = (ac - bd) + i(ad + bc)
  */

  def * (that : ComplexNumber) : ComplexNumber = new ComplexNumber(real * that.real - image * that.image , real * that.image + image * that.real)

  def * (i : Int) : ComplexNumber = new ComplexNumber(i * real , i * image)

  /*
  * (a + bi) / (c + di) = (ac + bd) / (c2 + d2) + i ((bc - ad) / c2 + d2)
  */

  def / (that : ComplexNumber) : ComplexNumber = new ComplexNumber( ( real * that.real + image * that.image) / (that.real * that.real + that.image * that.image) ,
    ( image * that.real + real * that.image) / (that.real * that.real + that.image * that.image) )


  override def toString: String = {
    if(real != 0 && image != 0)
      real + " + " + image + " i"
    else if(real == 0 && image != 0)
      image + " i"
    else
      real + " "

  }

}
object Main {
  def main(args: Array[String]): Unit = {
    var oneRealTwoImage = new ComplexNumber(1,2)
    var oneRealThreeImage = new ComplexNumber(1,3)
    var oneRealZeroImage = new ComplexNumber(1,0)

    println(oneRealZeroImage.toString())
    println(oneRealTwoImage.toString())
    println(oneRealThreeImage.toString())
    
    var oneRealTwoImagePlusOneRealThreeImage = oneRealTwoImage + oneRealThreeImage
    var oneRealTwoImageSubOneRealThreeImage = oneRealTwoImage - oneRealThreeImage

    println("Addition : " + oneRealTwoImagePlusOneRealThreeImage.toString())
    println("Subtraction : " + oneRealTwoImageSubOneRealThreeImage.toString())
  }
}
