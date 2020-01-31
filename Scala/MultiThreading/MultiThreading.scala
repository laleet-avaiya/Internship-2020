package Multihreading

// Scala Thread Example by Extending Thread Class

class ThreadByExtendingThreadClass extends Thread {
  override def run(): Unit = {
    println("Thread By Extending Thread Class is running...")
  }
}

// Scala Thread Example by Extending Runnable Interface

class ThreadByExtendingRunnableInterface extends Runnable {
  override def run(): Unit = {
    println("Thread By Extending Runnable Interface is running...")
  }
}

object MultiThreading {
  def main(args: Array[String]): Unit = {
    var thread1 = new ThreadByExtendingThreadClass()
    thread1.start()

    var thread2 = new ThreadByExtendingRunnableInterface()
    var thread3 = new Thread(thread2)
    thread3.start()
  }
}
