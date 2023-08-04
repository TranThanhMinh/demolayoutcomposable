package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Card
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.flow.MutableStateFlow

@OptIn(ExperimentalMaterial3Api::class)
@Preview("PlayingWithComposeTheme")
@Composable
fun PlayingWithComposeTheme(
    name: String = "Minh",
    click: ((String) -> Unit)? = null,
    itemClick: ((String) -> Unit)? = null
) {
    var textState by remember { mutableStateOf("") }

    val _list = remember { MutableStateFlow(listOf<String>()) }
    val list by remember { _list }.collectAsState()


    Column(modifier = Modifier.background(Color.White)) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(height = 40.dp)
                .background(Color.White)
        ) {
            val modifier =
                Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 10.dp)
            val color = Red
            Text(text = name!!, modifier = modifier, color)
        }

        Box(
            Modifier
                .fillMaxWidth()
                .height(height = 40.dp)
                .background(Color.White)
        ) {
            val modifier =
                Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 10.dp)
            val color = Color.Red
            Text(text = name!!, modifier = modifier, color)
        }

        val shape = RoundedCornerShape(5.dp)
        TextField(
            value = textState,
            onValueChange = {
                textState = it
            },
            label = { Text("User name") },
            textStyle = TextStyle(Blue),
            modifier = Modifier
                .background(Color.White)
                .border(1.dp, Red, shape)
                .fillMaxWidth()
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = 40.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .fillMaxHeight()
                    .background(Red)
            ) {
                Text(
                    text = "so 1", modifier = Modifier.align(Alignment.Center)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .fillMaxHeight()
                    .background(Blue)
            ) {
                Text(
                    text = "so 2", modifier = Modifier.align(Alignment.Center)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(Yellow)
            ) {
                Text(
                    text = "so 3", modifier = Modifier.align(Alignment.Center),
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

        }
        Button(
            onClick = {
                if (textState.isNotEmpty())
                    click!!.invoke(textState)
            },
            modifier = Modifier.padding(start = 10.dp)
        ) {
            Text(text = "them thanh vien", modifier = Modifier.clickable {
                val newList = ArrayList(list)
                newList.add(textState)
                _list.value = newList
                textState = ""
            })
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            val modifier = Modifier
                .align(Alignment.BottomStart)

            LazyColumn(modifier = modifier) {
                items(items = list, itemContent = {
                    PuppyListItem(it, itemClick = itemClick!!)
                })
            }
        }

    }

}

@Composable
fun PuppyListItem(puppy: String, itemClick: ((String) -> Unit)?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Green)
            .padding(horizontal = 10.dp)
            .clickable {
                itemClick!!.invoke(puppy)
            }) {
            Text(
                text = puppy, modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterStart), color = White
            )
        }
    }

}

@Preview
@Composable
fun layoutLogin(
    click: (() -> Unit)? = null,
    toast: ((String) -> Unit)? = null
) {
    var username by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }

    val top = Modifier.padding(top = 10.dp)

    val border =
        Modifier
            .border(0.5.dp, Blue, shape = RoundedCornerShape(5.dp))
            .fillMaxWidth()
            .height(40.dp)
            .padding(horizontal = 10.dp)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)
    ) {
        Card(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 30.dp)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(horizontal = 10.dp, vertical = 10.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Dang nhap")

                BasicTextField(
                    value = username,
                    modifier = top,
                    onValueChange = { username = it },
                    decorationBox = { innerTextField ->
                        Row(
                            modifier = border,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            if (username.isEmpty())
                                Text(text = "nhap tai khoan", style = TextStyle(Color.Gray))
                            innerTextField.invoke()

                        }
                    },
                )

                BasicTextField(
                    value = pass,
                    modifier = top,
                    onValueChange = { pass = it },
                    decorationBox = { innerTextField ->
                        Row(
                            modifier = border,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            if (pass.isEmpty())
                                Text(text = "nhap mat khau", style = TextStyle(Color.Gray))
                            innerTextField.invoke()
                        }
                    },
                )

                Button(
                    modifier = top,
                    onClick = {
                        if (pass.isNotEmpty() && username.isNotEmpty())
                            click!!.invoke()
                        else if (username.isEmpty()) {
                            toast!!.invoke("Vui long nhap tai khoan")
                        } else toast!!.invoke("Vui long nhap mat khau")

                    }) {
                    Text(text = "Đăng nhập")
                }
            }
        }

    }
}
