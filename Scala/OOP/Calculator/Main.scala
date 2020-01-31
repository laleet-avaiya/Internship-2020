package Calculator

object Main {

  def main(args: Array[String]): Unit = {
    println("Multi Level Inheritance")
    var calculator = new Calculator3();
    var result = calculator.add(1,33)
    println(result)
  }

}
