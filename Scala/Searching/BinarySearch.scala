object Main{

    def binarySearch(array: Array[Int], searchValue: Int): Int = {

        var indexFound: Int = -1
        var start: Int = 0
        var end: Int = array.length

        breakable {
        while (start < end) {
            println(start + " " + end)
            var mid: Int = (start + end) / 2

            if (array(mid) == searchValue) {
            indexFound = mid
            break
            } else if (searchValue > array(mid))
            start = mid + 1
            else
            end = mid - 1
        }
        }

        indexFound
    }

    def main(args: Array[String]): Unit = {
        var array = Array(1,2,3,4,5,6,7,8)
        println("Element Found At Index : " + binarySearch(array,4))
  }
}