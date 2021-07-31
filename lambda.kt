fun main() {

    val total:Int = "hello".count()
    println(total)

    val total1:Int =  "hello".count { e->
        e == 'l'
    }
    println(total1)

    val blessingFunction:()->String ={
        val h = "xxxxxxxxxxxx"
        "happy $h"
    }
    println(blessingFunction.toString())
