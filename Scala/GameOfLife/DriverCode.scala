import scala.io.StdIn.readLine

object Main {
  
  def startGameOfLife(): GameOfLife = {
    var numberOfRows = 0
    var numberOfColumns = 0

    println("How many cells alive?")
    val numberOfCellAlive: Int = Integer.parseInt(readLine())

    val listOfAliveCells = Array.ofDim[Int](numberOfCellAlive, 2)

    for (i <- 0 until (numberOfCellAlive)) {
      var inputRow = readLine()
      var inputRowArray = inputRow.split(",")

      listOfAliveCells(i)(0) = Integer.parseInt(inputRowArray(0).strip())
      listOfAliveCells(i)(1) = Integer.parseInt(inputRowArray(1).strip())

      numberOfRows = Math.max(numberOfRows, listOfAliveCells(i)(0))
      numberOfColumns = Math.max(numberOfColumns, listOfAliveCells(i)(1))
    }

    numberOfRows += 2
    numberOfColumns += 2

    new GameOfLife(numberOfRows, numberOfColumns, listOfAliveCells)
  }


  def main(args: Array[String]): Unit = {

    var gameOfLife = startGameOfLife()
    print(gameOfLife.toString())

    println("\nNext Generation :")
    var nextGeneration = gameOfLife.nextGeneration()
    println(nextGeneration.toString())

  }


}