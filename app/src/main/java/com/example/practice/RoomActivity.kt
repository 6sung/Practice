package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.room.*
import androidx.room.Database
import androidx.room.OnConflictStrategy.REPLACE

class RoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)


        // 기본적으로 데이터베이스 작업은 메인 쓰레드에서 할 수 없다
        // 이유는, 데이터베이스 작업을 휴대폰이 하는 동안 사용자가 기다려야하기 때문
        // 해결책은, 쓰레드를 이용하거나 async 를 이용하면 된다
        val database = Room.databaseBuilder(
            applicationContext,
            UserDatabase::class.java,
            "user-database"
        ).allowMainThreadQueries().build()

        findViewById<TextView>(R.id.save).setOnClickListener {
            val userProfile = UserProfile(1,"소지연","왕궁딩")
            database.userProfileDao().insert(userProfile)
        }
        findViewById<TextView>(R.id.load).setOnClickListener {
            val userProfiles = database.userProfileDao().getAll()
            userProfiles.forEach{
                Log.d("testt",""+it.firstName)
            }
        }
    }
}

@Database(entities = [UserProfile::class], version = 1)
abstract class UserDatabase : RoomDatabase(){
    abstract fun userProfileDao(): UserProfileDao
}

@Entity
class UserProfile(

    @PrimaryKey(autoGenerate = true) val id : Int,

    @ColumnInfo(name = "last_name")
    val lastName : String,
    @ColumnInfo(name = "first_name")
    val firstName : String
){
    constructor(lastName: String,firstName: String) : this(0,lastName,firstName)
}

@Dao
interface UserProfileDao{
    @Insert(onConflict = REPLACE)
    fun insert(userProfile:UserProfile)

    @Delete
    fun delete(userProfile: UserProfile)

    @Query("SELECT * FROM userprofile")
    fun getAll():List<UserProfile>
}