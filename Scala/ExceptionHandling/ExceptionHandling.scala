package ExceptionHandling

class ExceptionExample {
  def divide(a: Int, b: Int): Unit = {
    a / b
    println("Done.")
  }
}


// Handle Arithmetic Exception

class HandleExceptionExample {
  def divide(a: Int, b: Int): Unit = {
    try {
      a / b
    }
    catch {
      case e: ArithmeticException => println(e)
    }
    println("Done.")
  }
}


// multiple Exception

class HandleMultipleExceptionExample {
  def divide(a: Int, b: Int): Unit = {
    try {
      a / b
      var arr = Array(1, 2)
      arr(10)
    }
    catch {
      case e: ArithmeticException => println(e)
      case ex: Throwable => println("found a unknown exception" + ex)
    }
    println("Done.")
  }
}


// Scala Finally

class ExceptionExampleWithFinally{
  def divide(a:Int, b:Int) = {
    try{
      a/b
      var arr = Array(1,2)
      arr(10)
    }catch{
      case e: ArithmeticException => println(e)
      case ex: Exception =>println(ex)
      case th: Throwable=>println("found a unknown exception"+th)
    }
    finally{
      println("Finaly block always executes")
    }
    println("Rest of the code is executing...")
  }
}

/*
Scala Throw keyword
You can throw exception explicitly in you code.
Scala provides throw keyword to throw exception.
The throw keyword mainly used to throw custom exception.
An example is given below of using scala throw exception keyword.

Scala Throws Keyword
Scala provides throws keyword to declare exception.
You can declare exception with method definition.
It provides information to the caller function that this method may throw this exception.
It helps to caller function to handle and enclose that code in try-catch block to avoid abnormal termination of program.
In scala, you can either use throws keyword or throws annotation to declare exception.
 */

class ExceptionExampleWithThrow{

  @throws(classOf[ArithmeticException])
  def validate(age:Int)={
    if(age<18)
      throw new ArithmeticException("You are not eligible")
    else println("You are eligible")
  }
}


/*

Scala Custom Exception
In scala, you can create your own exception.
It is also known as custom exceptions.
You must extend Exception class while declaring custom exception class.
You can create your own exception message in custom class. Let's see an example.
 */



class InvalidAgeException(s:String) extends Exception(s){}

class CustomExceptionExample{
  @throws(classOf[InvalidAgeException])
  def validate(age:Int){
    if(age<18){
      throw new InvalidAgeException("Not eligible")
    }else{
      println("You are eligible")
    }
  }
}


object ExceptionHandling {
  def main(args: Array[String]): Unit = {
    var excObject = new CustomExceptionExample()
    try{
      excObject.validate(5)
    }
    catch {
      case e: InvalidAgeException => println("False")
    }
  }
}
