object MainApp{
    
  def bubbleSort(array : Array[Int]){
    var lengthOfArray : Int = array.length

    for(i <- 0 until  lengthOfArray)
    {
      for(j <- 0 until lengthOfArray-i-1)
      {
        if(array(j) > array(j + 1))
        {
          var swap : Int = array(j)
          array(j) = array(j+1)
          array(j+1) = swap
        }
      }
    }
    
    for(i <- 0 to lengthOfArray-1)
      print(array(i) + " ")
  }


  def main(args: Array[String]): Unit = {
    var array : Array[Int] = Array(-5,0,50,1,2,3,6,4)
    bubbleSort(array)

  }
}