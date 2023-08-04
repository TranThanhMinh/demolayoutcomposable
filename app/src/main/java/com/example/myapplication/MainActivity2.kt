package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity2 : ComponentActivity() {
    val name = "Layout Composable"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlayingWithComposeTheme(name, click = {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }, itemClick = { Toast.makeText(this, it, Toast.LENGTH_SHORT).show() })
//            layoutLogin(
//                click = {Toast.makeText(this,"Login",Toast.LENGTH_SHORT).show()}
//            )
        }
    }


}