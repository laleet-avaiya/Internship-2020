package Shape

class Square(side : Int) extends Shape {

  override def calculateArea(): Double = side * side
}
