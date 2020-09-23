//variable arguments function
fun sum(vararg numbers:Int,name:String):Long{
    var sum = 0
    for (number in numbers){
        sum += number
    }
    return sum.toLong()
}

abstract class Animal{
    abstract val animalType:String 
    abstract fun makeSound()
}

class Dog(override val animalType:String):Animal(){
    override fun makeSound() {
        println("Make sounds from ${this.animalType}....")
    }

}

fun fibonacci(limit:Int,firstNum:Int,secondNum:Int):Int{
    if(limit==0) {
        return secondNum
    }
    else
{
    return fibonacci(limit - 1, firstNum + secondNum, firstNum)
}
}

interface MyInter{
    fun exetuce(sum:Int)
}

class Program{
    fun addNumbers(num1:Int,num2:Int,action:(Int)->Unit){
        val sum = num1 + num2
        action(sum)
    }
    fun addNumbers(num1:Int,num2:Int,action:MyInter){
        val sum = num1 + num2
        action.exetuce(sum)
    }

}

val pi:Float by lazy { 3.14f }  //lazy help to not waste memory, when we use pi then it take memory,otheriwse it dont take.. we only use lazy with val not var. it stored in cache memory....

class Tohir{
    var age:Int? = null
    var isMarried:Boolean? = null
}

fun main() {

    var person:Person? = null
    person?.run {     //run function is combination of with and let function
        println("Tohir is $age years old....")
    }

    var key = Tohir().apply {
        age = 20
        isMarried = false
    }
    with(key){
        println("Tohir is $age years old....")
        if (isMarried==true){
            println("Tohir is married....")
        }
        else{
            println("Tohir is not married yet....")
        }
    }

    var numbersList = mutableListOf(7,8,9,12,17)
    println("Original format = $numbersList")
    numbersList.also {
        it.add(29)
        println("After adding = $it")
        it.set(2,25)
        println("After setting = $it")
        it.removeAt(4)
        println("After removing = $it")
    }
    println("After all changing = $numbersList")
    

/*
    var name:String? = null
    println("Your name is ${name?.length}")
    println("Your name is ${name!!.length}")
*/

    var elements = listOf(1,2,5,4,6,8,5,6,95,6,6,5,6,859,959,879)
    var newElements = elements.filter { it<12 }.map {
        if(it%2==0){
            it
        }
        else{
            ""
        }
    }
    for (element in newElements){
        println(element)
    }

    var myLambdaCheck = {number:Int->number>10}

    val allNumbers = elements.all(myLambdaCheck)
    val anyNumbers = elements.any(myLambdaCheck)
    val countNumbers = elements.count(myLambdaCheck)
    val findFirstNumber = elements.find(myLambdaCheck)
    println("$allNumbers\t$anyNumbers\t$countNumbers\t$findFirstNumber")
    println("============")

    val myLambda: (Int)->Unit = {sum -> println("Sum = $sum")}
    Program().addNumbers(8,9,myLambda)

    Program().addNumbers(7,8,object : MyInter{
        override fun exetuce(sum: Int) {
            println("Sum = $sum")
        }

    })


    println("============\n============")

    Person().qalesan()

    var limit:Int
    println("Enter a position which is finding....")
    limit = readLine()!!.toInt()
    var findFibonacciNumber = fibonacci(limit,1,0)
    println("$findFibonacciNumber is placed in $limit")
    toxta@for (i in 1..4){
        for (j in 1..3){
            if (i==2){
                break@toxta
            }
            println("$i $j")
        }
    }

   /*  Dog("Dog").makeSound()
    println("Sum = ${sum(1,2,3,4,5,6,7,8,9)}\n============================================")
    var person = Person()
     person.lastName = "Tohir"
    println("Your name is ${person.lastName}")
    person.age = 18
    println("You are ${person.age}")
*/
}

fun Person.qalesan(){
    println("Salom....")
}

class Person{
     var name:String = "Tohir"//if we want to initilize later we can use before var lateinit
     set(name) {
         if (name != null) {
             field = if(name.length<5) "It is too low" else name
         }
     }
     var lastName:String? = null
     set(value) {
             field = value?.toUpperCase()
         }
     get() = field?.toLowerCase()

    var age:Int? = null
    set(value) {
        if (value?.compareTo(18)!! <0) throw Exception("You are young..")

        else field = value
        }
    constructor(){
        println("nothing")
    }

    constructor(name:String,lastname:String):this(){
        this.name = name
        this.lastName = lastName
        println("print secondary constructor")
    }

    fun smth(){
            println("First name is ${this.name}")
    }
}