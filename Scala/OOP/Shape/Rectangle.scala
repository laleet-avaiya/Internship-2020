package Shape

class Rectangle(height : Int , width : Int) extends Shape {
  override def calculateArea(): Double = height * width
}
