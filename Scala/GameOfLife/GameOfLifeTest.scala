import org.junit.{Assert, Test, After, Before}

class GameOfLifeTest {

  @Test
  def nextGenerationTest = {
    var gameOfLife = new GameOfLife(4,4 , Array(Array(1,1),Array(1,2),Array(2,1),Array(2,2)))
    var nextGenerationGameOfLifeExpected = new GameOfLife(4,4 , Array(Array(1,1),Array(1,2),Array(2,1),Array(2,2)))
    Assert.assertEquals(nextGenerationGameOfLifeExpected, gameOfLife.nextGeneration())

    gameOfLife = new GameOfLife(5,5, Array(Array(0,1),Array(1,0),Array(2,1),Array(0,2),Array(1,2)))
    nextGenerationGameOfLifeExpected = new GameOfLife(5,5, Array(Array(0,1),Array(1,0),Array(2,1),Array(0,2),Array(1,2)))
    Assert.assertEquals(nextGenerationGameOfLifeExpected, gameOfLife.nextGeneration())

    gameOfLife = new GameOfLife(3,3, Array(Array(1,1),Array(1,0),Array(1,2)))
    nextGenerationGameOfLifeExpected = new GameOfLife(3,3, Array(Array(1,1),Array(0,1),Array(2,1)))
    Assert.assertEquals(nextGenerationGameOfLifeExpected, gameOfLife.nextGeneration())

    gameOfLife = new GameOfLife(6,6, Array(Array(1,1),Array(1,0),Array(1,2)))
    nextGenerationGameOfLifeExpected = new GameOfLife(3,3, Array(Array(1,1),Array(0,1),Array(2,1)))
    Assert.assertNotEquals(nextGenerationGameOfLifeExpected, gameOfLife.nextGeneration())
  }
}
