package FileHandling

import java.io.{File, PrintWriter}

import scala.io.Source

/*
              Scala File handling

Scala provides predefined methods to deal with file.
You can create, open, write and read file.
Scala provides a complete package scala.io for file handling.
 */

object FileHandling {
  def main(args: Array[String]): Unit = {

    val filePath = "/Users/laleet.avaiya/IdeaProjects/Game/src/main/scala/FileHandling/sample.txt"
    println(Source.fromFile(filePath)) // returns scala.io.BufferedSource non-empty iterator instance

    val s1 = Source.fromFile(filePath).mkString //returns the file data as String
    println(s1)

    //splitting String data with white space and calculating the number of word in the file
    val counts = s1.split("\\s+")
    println(counts.length)


    /*
    Word count line by line: Sometimes there arises a need to process each line rather than the whole contents of the file.
    This can be achieved through the getLines method. For example below code;
     */

    println(Source.fromFile(filePath).getLines())
    Source.fromFile(filePath).getLines.foreach { x => println(x) }
    Source.fromFile(filePath).getLines.take(1).foreach { x => println(x) };
    Source.fromFile(filePath).getLines.slice(0, 1).foreach { x => println(x) };


    // Scala Write to File

    val writer = new PrintWriter(new File("Write.txt"))
    writer.write("Hello Developer, Welcome to Scala Programming.")
    writer.close()
    Source.fromFile("Write.txt").foreach { x => print(x) }
  }
}
