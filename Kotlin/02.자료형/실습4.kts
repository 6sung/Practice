interface Tiger{
    fun bite()
    fun goToBox()
}
class BackDoSanTiger : Tiger{
    override fun bite() {

    }

    override fun goToBox() {

    }
}
val backdosanTiger : BackDoSanTiger = BackDoSanTiger()
backdosanTiger.bite()

interface Person{
    var dress : String
    fun eat()
    fun sleep(){
        println("잠을 잔다")
    }
}
class Student : Person{
    override var dress: String
        get() = "옷"
        set(value) {}

    override fun eat() {
        println("밥을 먹는다")
    }
}
class Teacher : Person{
    override var dress: String
        get() = "정장"
        set(value) {}

    override fun eat() {
        println("밥을 먹는다")
    }
}

class GoodStudent : Student(){

}

val student : Student = Student()
student.eat()
student.sleep()