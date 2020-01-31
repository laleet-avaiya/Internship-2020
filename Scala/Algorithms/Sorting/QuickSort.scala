object Main {
    def quickSort(array: Array[Int]){
        def swap(i : Int, j : Int){
            var t = array(i)
            array(i) = array(j)
            array(j) = t
        }
        def sort(l : Int, r : Int){
            val pivot = array((l + r) / 2)
            var i = l
            var j = r
            while (i <= j) {
                while (array(i) < pivot) 
                    i += 1
                while (array(j) > pivot) 
                    j -= 1
                if (i <= j) {
                    swap(i, j)
                    i += 1
                    j -= 1
                }
            }
            if (l < j) 
                sort(l, j)
            if (j < r) 
                sort(i, r)
        }
        sort(0, array.length - 1)
    }
	def main(args: Array[String]) {
	    var array = Array(11,23,-3,4,5)
	    quickSort(array)
	    
	    for(i <- 0 to array.length -1 )
		    println(array(i))
	}
}