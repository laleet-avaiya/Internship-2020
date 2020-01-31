package Shape

class Triangle(width : Int, height : Int) extends Shape {

  override def calculateArea(): Double = 0.5 * width * height
}
