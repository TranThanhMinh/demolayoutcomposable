package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
    val name = "tran thanh minh"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            layoutLogin(
                click = ::gotoMainActivity2,
                toast = {
                    Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
                }
            )
        }
    }

   private fun gotoMainActivity2(){
        startActivity(Intent(this,MainActivity2::class.java))
    }

}