class Warrior(){
    fun attack(){
        println("복잡한 코드 + 공격")
    }
}

class DefenseWarrior(){
    fun attack(){
        println("복잡한 코드 + 공격")
    }
    fun defense(){
        println("방어")
    }
}

class HardAttackWarrior(){
    fun attack(){
        println("복잡한 코드 + 공격")
    }
    fun hardAttack(){
        println("방어")
    }
}

open class Warrior1(var name : String, var power : Int, var type : String){
    fun attack(){
        println("복잡한 코드 + 공격")
    }
}
class DefenseWarrior1 constructor(name : String, power : Int) : Warrior1(name,power,"고블린"){
    fun defense(){
        println("방어")
    }
}

val defenseWarrior : DefenseWarrior1 = DefenseWarrior1("똑똑한고블린", 100)
defenseWarrior.defense()
defenseWarrior.attack()


class HardAttackWarrior : Warrior1{
    constructor(name : String, power : Int, bonusPower : Int): super(name,power,"골렘")
}
