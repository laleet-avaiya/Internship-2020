package Shape
/*
  We need to calculate area of square , rectangle , circle, triangle

  All must define their own are method
 */
object DriverCode {
  def main(args: Array[String]): Unit = {
    var square = new Square(4)
    println(square.calculateArea())

    var rectangle = new Rectangle(4,5)
    println(rectangle.calculateArea())

    var triangle = new Triangle(2,3)
    println(triangle.calculateArea())
  }
}
