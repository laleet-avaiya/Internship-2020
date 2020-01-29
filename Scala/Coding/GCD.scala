object Main{

    def gcdRecursive(a : Long , b : Long) : Long = {
        if(a ==0)
        b
        else
        gcdRecursive(b % a , a)
    }

    def gcdIterative(a :Long, b : Long) : Long = {
        var x = a
        var y = b

        while( x != 0){
        var temp = x
        x = y % x
        y = temp
        }
        y
    }

    def main(args : Array[String]) : Unit {
        println(gcdRecursive(30,250))       // 10
        println(gcdIterative(30,250))       // 10

    }
}