import scala.collection.immutable._  

object Collections{  
    def main(args:Array[String]){  
        val set1 = Set()                                        // An empty set  
        val games = Set("Cricket","Football","Hocky","Golf")    // Creating a set with elements  
        println(set1)  
        println(games)
        println(games.head)                                     // Returns first element present in the set  
        println(games.tail)                                     // Returns all elements except first element.  
        println(games.isEmpty)                                  // Returns either true or false  

        println("Elements in set: "+games.size)  
        println("Golf exists in the set : "+games.contains("Golf"))  
        println("Racing exists in the set : "+games.contains("Racing"))  

        games += "Racing"                                       // Adding new element  
        println(games)  
        games += "Cricket"                                      // Adding new element, it does not allow duplicacy.  
        println(games)  
        games -= "Golf"                                         // Removing element  
        println(games)  

        val alphabet = Set("A","B","C","D","E")   
        val mergeSet = games ++ alphabet                        // Merging two sets  
        println("Elements in games set: "+games.size)           // Return size of collection  
        println("Elements in alphabet set: "+alphabet.size)   
        println("Elements in mergeSet: "+mergeSet.size)  
        println(mergeSet)  

        games.for((game <- games) => println(game))             //  Iterating Set Elements using for loop
        games.foreach((element:String)=> println(element))

        // Set Operations
        games = Set("Cricket","Football","Hocky","Golf","C")  
        alphabet = Set("A","B","C","D","E","Golf")  
        var setIntersection = games.intersect(alphabet)  
        println("Intersection by using intersect method: "+setIntersection)  
        println("Intersection by using & operator: "+(games & alphabet))  
        var setUnion = games.union(alphabet)  
        println(setUnion)    



        // ---------------- Scala SortedSet ---------------------

        var numbers: SortedSet[Int] = SortedSet(5,8,1,2,9,6,4,7,2)  
        numbers.foreach((element:Int)=> println(element))  

        // ---------------- Scala HashSet ---------------------

        var hashset = HashSet(4,2,8,0,6,3,45)  
        hashset.foreach((element:Int) => println(element+" "))   

        // ---------------- Scala BitSet ---------------------

        var numbers = BitSet(1,5,8,6,9,0)  
        numbers.foreach((element:Int) => println(element))

        // ---------------- Scala ListSet ---------------------

        var listset = ListSet(4,2,8,0,6,3,45)  
        listset.foreach((element:Int) => println(element+" "))  


        // ---------------- Scala Seq ---------------------

        var seq:Seq[Int] = Seq(52,85,1,8,3,2,7)  
        seq.foreach((element:Int) => print(element+" "))  
        println("\nAccessing element by using index")  
        println(seq(2)) 
        println("\nis Empty: "+seq.isEmpty)  
        println("Ends with (2,7): "+ seq.endsWith(Seq(2,7)))  
        println("contains 8: "+ seq.contains(8))  
        println("last index of 3 : "+seq.lastIndexOf(3))  
        println("Reverse order of sequence: "+seq.reverse) 


        // ---------------- Scala Vector ---------------------

        var vector:Vector[Int] = Vector(5,8,3,6,9,4) //Or  
        var vector2 = Vector(5,2,6,3)  
        var vector3 = Vector.empty  
        println(vector)  
        println(vector2)  
        println(vector3)  

        vector = Vector("Hocky","Cricket","Golf")  
        vector2 = Vector("Swimming")  
        print("Vector Elements: ")  
        vector.foreach((element:String) => print(element+" "))  
        var newVector  = vector :+ "Racing"                             // Adding a new element into vector  
        print("\nVector Elements after adding: ")  
        newVector.foreach((element:String) => print(element+" "))  
        var mergeTwoVector = newVector ++ vector2                       // Merging two vector  
        print("\nVector Elements after merging: ")  
        mergeTwoVector.foreach((element:String) => print(element+" "))  
        var reverse = mergeTwoVector.reverse                            // Reversing vector elements  
        print("\nVector Elements after reversing: ")  
        reverse.foreach((element:String) => print(element+" "))  
        var sortedVector = mergeTwoVector.sorted                        // Sorting vector elements  
        print("\nVector Elements after sorting: ")  
        sortedVector.foreach((element:String) => print(element+" "))  


        // ---------------- Scala List ---------------------

        var list = List(1,8,5,6,9,58,23,15,4)  
        var list2 = List(88,100)  
        print("Elements: ")  
        list.foreach((element:Int) => print(element+" "))           // Iterating using foreach loop  
        print("\nElement at 2 index: "+list(2))                     // Accessing element of 2 index  
        var list3 = list ++ list2                                   // Merging two list  
        print("\nElement after merging list and list2: ")  
        list3.foreach((element:Int)=>print(element+" "))      
        var list4 = list3.sorted                                    // Sorting list  
        print("\nElement after sorting list3: ")  
        list4.foreach((element:Int)=>print(element+" "))    
        var list5 = list3.reverse                                   // Reversing list elements  
        print("\nElements in reverse order of list5: ")  
        list5.foreach((element:Int)=>print(element+" "))    


        // ---------------- Scala Stack ---------------------

        var s = Stack[Int]() 
      
        // pushing values 
        // one at a time 
        s.push(5) 
        s.push(1) 
        s.push(2) 
        println("s:" + s) 
  
        var s2 = Stack[Int]() 
  
        // pushing multiple values 
        s2.push(5,1,2) 
        println("s2:" + s2) 

        println("Popped:" + s.pop) 
        println("Popped:" + s.pop) 
        println("Popped:" + s.pop) 
        println("Empty:" + s.isEmpty) 
        println("Top: " + s.top)
        println("Size: " + s.size)


        // ---------------- Scala Queue ---------------------

        var queue = Queue(1,5,6,2,3,9,5,2,5)  
        print("Queue Elements: ")  
        queue.foreach((element:Int)=>print(element+" "))    
        var firstElement = queue.front  
        print("\nFirst element in the queue: "+ firstElement)         
        var enqueueQueue = queue.enqueue(100)  
        print("\nElement added in the queue: ")  
        enqueueQueue.foreach((element:Int)=>print(element+" "))  
        var dequeueQueue = queue.dequeue  
        print("\nElement deleted from this queue: "+ dequeueQueue)  

        // ---------------- Scala Stream ---------------------

        val stream = 100 #:: 200 #:: 85 #:: Stream.empty  
        println(stream)                                             // Stream(100, ?)

        // In the output, you can see that second element is not evaluated. 
        // Here, a question mark is displayed in place of element. Scala does not evaluate list until it is required.
        
        
        // ---------------- Scala Map ---------------------

        var map = Map(("A","Apple"),("B","Ball"))  
        var map2 = Map("A"->"Aple","B"->"Ball")  
        var emptyMap:Map[String,String] = Map.empty[String,String]   
        println(map)  
        println(map2)  
        println("Empty Map: "+emptyMap)

        println(map("A"))                                   // Accessing value by using key  
        var newMap = map+("C"->"Cat")                       // Adding a new element to map  
        println(newMap)  
        var removeElement = newMap - ("B")                  // Removing an element from map  
        println(removeElement)  


        // ---------------- Scala HashMap ---------------------

        var hashMap = HashMap("A"->"Apple","B"->"Ball","C"->"Cat")  
        println(hashMap)  

        hashMap.foreach {  
            case (key, value) => println (key + " -> " + value)         // Iterating elements  
        }  
        println(hashMap("B"))                                           // Accessing value by using key  
        var newHashMap = hashMap+("D"->"Doll")                          // Adding a new element to newHashMap

        newHashMap.foreach {  
            case (key, value) => println (key + " -> " + value)  
        }  

        // ---------------- Scala ListMap ---------------------

        var listMap = ListMap("Rice"->"100","Wheat"->"50","Gram"->"500")    // Creating listmap with elements  
        var emptyListMap = new ListMap()                                    // Creating an empty list map  
        var emptyListMap2 = ListMap.empty                                   // Creating an empty list map  
        println(listMap)  
        println(emptyListMap)  
        println(emptyListMap2)  

         
        listMap.foreach{  
            case(key,value)=>println(key+"->"+value)  
        }  
        println(listMap("Gram"))  
        
        var newListMap = listMap+("Pulses"->"550")  
        newListMap.foreach {  
            case (key, value) => println (key + " -> " + value)  
        }     

        // ---------------- Scala Tuple ---------------------

        var tuple = (1,5,8,6,4)                     // Tuple of integer values  
        var tuple2 = ("Apple","Banana","Gavava")    // Tuple of string values  
        var tuple3 = (2.5,8.4,10.50)                // Tuple of float values  
        var tuple4 = (1,2.5,"India")                // Tuple of mix type values  
        println(tuple)  
        println(tuple2)  
        println(tuple3)  
        println(tuple4)  

        var tupleValues = (1,2.5,"India")  
        println("iterating values: ")  
        tupleValues.productIterator.foreach(println)    // Iterating tuple values using productIterator  
        println("Accessing values: ")  
        println(tupleValues._1) // Fetching first value  
        println(tupleValues._2) // Fetching second value


        // Function Return Multiple Values:

        var tupleValues = tupleFunction()  
        println("Iterating values: ")  
        tupleValues.productIterator.foreach(println)    // Iterating tuple values using productIterator
    }  

    def tupleFunction()={  
        var tuple = (1,2.5,"India")  
        tuple  
    }  
}  