import java.util.Arrays

class GameOfLife(numberOfRows: Int, numberOfColumns: Int, listOfAliveCells: Array[Array[Int]]) {

  private var grid: Array[Array[Char]] = Array.ofDim[Char](numberOfRows, numberOfColumns)

  for (row <- grid) {
    Arrays.fill(row, '-')
  }

  for (row <- listOfAliveCells) {
    grid(row(0))(row(1)) = 'X'
  }

  def nextGeneration(): GameOfLife = {

    var nextGenerationGameOfLife = new GameOfLife(numberOfRows, numberOfColumns, Array())
    var nextGenerationGrid = nextGenerationGameOfLife.getGrid()

    for (i <- 0 until numberOfRows) {
      for (j <- 0 until numberOfColumns) {
        var numberOfLiveNeighbours: Int = aliveNeighbours(i, j)

        if ((numberOfLiveNeighbours == 3) && (grid(i)(j) == '-'))
          nextGenerationGrid(i)(j) = 'X'
        else if (numberOfLiveNeighbours < 2 || numberOfLiveNeighbours > 3)
          nextGenerationGrid(i)(j) = '-'
        else
          nextGenerationGrid(i)(j) = grid(i)(j)
      }
    }
    nextGenerationGameOfLife
  }

  private def aliveNeighbours(x: Int, y: Int): Int = {
    var rowDirection: Array[Int] = Array(-1, -1, 0, 1, 1, 1, 0, -1)
    var columnDirection: Array[Int] = Array(0, 1, 1, 1, 0, -1, -1, -1)
    var totalAliveNeighbours = 0

    for (i <- 0 until 8) {
      var newX = x + rowDirection(i)
      var newY = y + columnDirection(i)

      if (newX >= 0 && newY >= 0 && newX < numberOfRows && newY < numberOfColumns && grid(newX)(newY) == 'X')
        totalAliveNeighbours += 1
    }
    totalAliveNeighbours
  }

  private def getGrid(): Array[Array[Char]] = {
      grid
  }

  override def toString: String = {
    var gridString = ""
    for (i <- 0 until numberOfRows) {
      for (j <- 0 until numberOfColumns) {
        gridString = gridString + grid(i)(j) + " "
      }
      gridString = gridString + "\n"
    }
    gridString
  }

  override def equals(obj: Any): Boolean = {
    var equalResult = true

    if(!(obj.isInstanceOf[GameOfLife]))
      return false


    val gameOfLifeObject = obj.asInstanceOf[GameOfLife]
    val gridObj = gameOfLifeObject.getGrid()

    if(numberOfRows != gridObj.length || numberOfColumns != gridObj(0).length)
      return false

    for(i <- 0 until numberOfRows)
      {
        for(j <- 0 until numberOfColumns){
            if(grid(i)(j) != gridObj(i)(j))
              equalResult = false
        }
      }
    equalResult
  }
}
