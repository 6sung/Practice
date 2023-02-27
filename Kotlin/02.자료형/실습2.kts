class Book(){
    var title: String = "모름"
        get() {
            return "책 제목"
        }
        set(value){
            println(value)
            field = value
        }
}
val book = Book()
println(book.title)
book.title = "제목 변경"
println(book.title)

class Book2(){
    lateinit var title : String

    fun nextPage(){
        if(::title.isInitialized == true){
            println("페이지가 넘어간다")
        }else {
            println("초기화 필요")
        }
    }
}
val book1 = Book2()
book1.title = "책이름"
println(book1.nextPage())

val book2 = Book2()
println(book2.nextPage())

class FootballPlayer constructor(uniform : String, ball : String){
    val uniform : String
    val ball : String
    init{
        this.uniform = uniform
        this.ball = ball
    }

    fun kick(){
        println("공을 찼다")
    }
    fun pass(){
        println("패스!")
    }
}
val footballPlayer = FootballPlayer("빨간색 유니폼", "축구공")
println(footballPlayer.uniform)
footballPlayer.kick()
footballPlayer.pass()

val footballPlayer2 = FootballPlayer("검정 유니폼", "배구공")
println(footballPlayer2.ball)

class Bank{

    fun save(account : Account , money : Int){
        if(money >= 0) account.balance += money
        else println("마이너스 금액은 예금할 수 없습니다.")
    }
    fun withdraw(account : Account, money : Int){
        if(account.checkBalance()>=money)account.balance -= money
        else println("잔액이 부족합니다.")
    }
}
class Account constructor (val initialBalance : Int = 0){
    var balance : Int = 0
    init{
        this.balance = balance
    }
    fun checkBalance() : Int{
        return balance
    }
}
val account = Account(1000)
val bank = Bank()
println(account.checkBalance())
bank.save(account, 2000)
println(account.checkBalance())
