import org.scalatest.FunSuite

class GameOfLifeTestScala extends FunSuite {

  test("nextGeneration") {
    var gameOfLife = new GameOfLife(4,4 , Array(Array(1,1),Array(1,2),Array(2,1),Array(2,2)))
    var nextGenerationGameOfLifeExpected = new GameOfLife(4,4 , Array(Array(1,1),Array(1,2),Array(2,1),Array(2,2)))
    assert(nextGenerationGameOfLifeExpected === gameOfLife.nextGeneration())

    gameOfLife = new GameOfLife(5,5, Array(Array(0,1),Array(1,0),Array(2,1),Array(0,2),Array(1,2)))
    nextGenerationGameOfLifeExpected = new GameOfLife(5,5, Array(Array(0,1),Array(1,0),Array(2,1),Array(0,2),Array(1,2)))
    assert(nextGenerationGameOfLifeExpected === gameOfLife.nextGeneration())

    gameOfLife = new GameOfLife(3,3, Array(Array(1,1),Array(1,0),Array(1,2)))
    nextGenerationGameOfLifeExpected = new GameOfLife(3,3, Array(Array(1,1),Array(0,1),Array(2,1)))
    assert(nextGenerationGameOfLifeExpected === gameOfLife.nextGeneration())

    gameOfLife = new GameOfLife(6,6, Array(Array(1,1),Array(1,0),Array(1,2)))
    nextGenerationGameOfLifeExpected = new GameOfLife(3,3, Array(Array(1,1),Array(0,1),Array(2,1)))
    assert(nextGenerationGameOfLifeExpected != gameOfLife.nextGeneration())
  }

  test("notEqualGameOfLife") {
    var gameOfLife1 = new GameOfLife(4,4 , Array(Array(1,1),Array(1,2),Array(2,1),Array(2,2)))
    var gameOfLife2 = new GameOfLife(1,1, Array())
    assert(gameOfLife1 != gameOfLife2)
  }

  test("equalGameOfLife") {
    var gameOfLife1 = new GameOfLife(1,1 , Array())
    var gameOfLife2 = new GameOfLife(1,1, Array())
    assert(gameOfLife1 === gameOfLife2)
  }
}
