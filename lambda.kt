///////////////////////////////////////////
具名函数  

fun main() {
        showOnBoard("牙膏",::getdiscountwords)
    }

    private fun getdiscountwords(goodsName: String, hour: Int): String {
        val  currentYear =  2027
        return "${currentYear}年,双11${goodsName}促销倒计时：$hour 小时"
    }

    private fun showOnBoard(goodsName:String,getdiscountwords:(String,Int)->String){
        val hour:Int = (1..24).shuffled().last()
        println(getdiscountwords(goodsName,hour))
    }
    
    
    
    
///////////////////////////////////////////
匿名函数


fun main() {
        showOnBoard("卫生纸"){goodsName:String,hour:Int ->
           val currentYear = 2021
            "${currentYear}年,双11${goodsName}促销倒计时：$hour 小时"
       }
    }
        
        
  private fun showOnBoard(goodsName:String,getdiscountwords:(String,Int)->String){
        val hour:Int = (1..24).shuffled().last()
        println(getdiscountwords(goodsName,hour))
    }
}

//    fun main() {
//        val getdiscountwords ={goodsName:String,hour:Int ->
//            val currentYear = 2021
//            "${currentYear}年,双11${goodsName}促销倒计时：$hour 小时"
//        }
//        showOnBoard("卫生纸",getdiscountwords)
//    }
//    fun showOnBoard(goodsName:String,getdiscountwords:(String,Int)->String){
//        val hour:Int = (1..24).shuffled().last()
//        println(getdiscountwords(goodsName,hour))
//    }


/////////////////////////////////////////

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
