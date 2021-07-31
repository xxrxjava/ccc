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

    val blessingFunction1:(String)-> String = {
        name ->
        val h = "xxxxxxxxxxxx"
        "$name,happy $h"
    }
    println(    blessingFunction1("jjj")
    )

    val blessingFunction2:(String)-> String = {
        val h = "xxxxxxxxxxxx"
        "$it,happy $h"
    }

    val blessingFunction3={
        val h = "xxxxxxxxxxxx"
        "happy $h"
    }
    val blessingFunction4:(String,Int)->String = {
        name,year ->
        val h = "xxxxxxxxxxxx"
        "$name,happy $h $year"
    }
    println(blessingFunction4("ooo",18))


    val blessingFunction5 = {
            name:String,year:Int ->
        val h = "xxxxxxxxxxxx"
        "$name,happy $h $year"
    }
    println(blessingFunction4("ooo",18))
