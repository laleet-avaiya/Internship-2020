
object MainApp{

  def linearSearch(array: Array[Int],searchValue: Int): Int ={

    var arrayLength = array.length
    var ans = -1
    for( index <- 0 to arrayLength-1)
      {
        if(array(index) == searchValue)
          ans = index
      }
    ans
  }

  def main(args: Array[String]): Unit = {
    var array = Array(1,2,3,4,5,6,7,8)

    println("Element Found At Index : " + linearSearch(array,4))

  }
}