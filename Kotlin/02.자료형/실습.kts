import java.lang.IllegalArgumentException

val numbers = intArrayOf(5,10,15)

for (numbers in numbers){
    println(numbers)
}
println("--------------------------")
for((index,value) in numbers.withIndex()){
    println(index)
    println(value)
}
println("--------------------------")


val numbers7 = listOf<Int>(1,2,3)
try{
    numbers7.get(5)
}catch(exception : Exception){
    println(exception)
}

try{
    numbers7.get(5)
}catch(exception : IllegalArgumentException){
    println("예외발생 A")
}catch(exception : ArrayIndexOutOfBoundsException){
    println("예외발생 B")
}finally {
    println("마지막!")
}

class Person{

}
//주 생성자 -> 풀버전
class User1 constructor(name:String){
    val userName : String
    init{
        println(name)
        userName = name
    }
}
val user = User1("홍길동")

class User2 constructor(name : String){
    val userName : String = name
}

class User3 (name: String){
    val userName : String = name
}
class User4(name : String = "김아무개"){
    val userName : String = name
}
val user = User4()

class User5 constructor(age : Int, name : String){
    val age : Int
    val name : String
    init {
        this.age = age
        this.name = name
    }
}

class User6 constructor(name : String){
    var age : Int = 0
    var nickname : String = ""
    var name : String
    init{
        println("init")
        this.name=name
    }
    //부생성자는 클래스의 본문에 위치해야 한다.
    //부생성자에는 주생성자에서 필요한 조건을 포함해야 한다
    constructor(name : String, age : Int) : this(name){
        println("second")
        this.age = age
    }
    constructor(name : String, age : Int, nickname : String) : this(name){
        this.age = age
        this.nickname = nickname
    }
}
val user6 = User6(name = "가나다")
println(user6.name)
val user6_2 = User6("가나다다", 50)
println(user6_2.age)

class User7{
    val age : Int
    val name : String

    constructor(age : Int, name : String){
        this.age = age
        this.name = name
    }
}
val user7 = User7(10,"가가가")
println(user7.age)


