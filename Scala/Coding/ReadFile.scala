import scala.io.Source

object Main{

  // Read File
  def processFile(fileName : String, width : Int): Unit ={
    val source = Source.fromFile(fileName)

    for(line <- source.getLines())
      processLine(line , fileName , width)
  }

  // Process Line
  def processLine(line : String , fileName : String , width : Int): Unit ={

    if(line.length > width)
      println(fileName + ": " +line)
  }

  def main(args: Array[String]): Unit = {
    processFile("<File Path>",60)
  }
}