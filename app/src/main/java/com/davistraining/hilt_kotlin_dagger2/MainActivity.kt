package com.davistraining.hilt_kotlin_dagger2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    //field injection
    @Inject
    lateinit var someClass: SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println(someClass.simpleFunc())
        println(someClass.hardFunc())

    }
}

class SomeClass
@Inject
constructor(private val secondClass: SecondClass)
{
    fun simpleFunc(): String{
        return "simpleFunc executed"
    }

    fun hardFunc(): String
    {
        return secondClass.mediumFunc()
    }
}

class SecondClass
@Inject
constructor()
{
    fun mediumFunc() : String
    {
        return "mediumFunc executed"
    }
}