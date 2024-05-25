package com.example.asm_ph42469.Screens.Authen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.asm_ph42469.Screens.Screen
import com.example.asm_ph42469.R

@Composable
fun LoginScreen(navController: NavController){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.gach)
                    , contentDescription = "",
                    modifier = Modifier.size(105.dp,1.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_chair)
                    , contentDescription = "",
                    modifier = Modifier
                        .padding(20.dp)
                        .size(60.dp)
                        .border(0.5.dp, Color.DarkGray, CircleShape)
                        .padding(9.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.gach)
                    , contentDescription = "",
                    modifier = Modifier.size(105.dp,1.dp)

                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Hello !",
                fontSize = 30.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF909090))

            Text(
                text = "WELCOME BACK",
                fontSize = 30.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF303030))
        }

    FromLogin(navController)
}


@Composable
fun FromLogin(navController: NavController){
    var email by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var visible by remember { mutableStateOf(true) }
    Box(
        modifier = Modifier
            .padding(top = 278.dp)
            .fillMaxWidth(0.90f)
            .fillMaxHeight(0.80f)
        )
    {
        Card(
            modifier = Modifier
                .fillMaxSize(),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding( top = 35.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding( start = 30.dp)
                )  {
                    Text(
                        text = "Email",
                        color = Color(0xFF909090),
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400)
                    )

                    TextField(
                        value = email,
                        onValueChange = {email = it},
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    Text(
                        text = "Password",
                        color = Color(0xFF909090),
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400)
                    )

                    TextField(
                        value = pass,
                        onValueChange = {pass = it},
                        trailingIcon = {
                            Icon(painter = painterResource( id =
                            if(visible) R.drawable.ic_eye else R.drawable.hidden)
                                , contentDescription = "visible",
                                Modifier
                                    .clickable { visible = !visible }
                                    .size(25.dp))
                        },
                        modifier = Modifier.fillMaxWidth(),
                        visualTransformation =
                        if (visible) PasswordVisualTransformation()
                        else VisualTransformation.None,
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = "Forgot Password",
                        fontSize = 18.sp,
                        fontWeight = FontWeight(600))

                    Card(
                        colors = CardDefaults.cardColors(Color.DarkGray),
                        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
                    ) {
                        Button(
                            onClick = {
                                      navController.navigate(Screen.HomeScreen.route)
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF242424),
                                contentColor = Color(0xFFFFFFFF)
                            ),
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .size(285.dp, 50.dp)
                                .background(Color(0xFF242424), shape = RoundedCornerShape(7.dp))
                        ) {
                            Text(
                                text = "Log in",
                                fontSize = 18.sp,
                                fontWeight = FontWeight(600)
                            )
                        }
                    }

                    Text(
                        text = "SIGN UP",
                        fontSize = 18.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF303030),
                        modifier = Modifier.clickable {
                            navController.navigate(Screen.SignUpScreen.route)
                        })
                }

            }
        }
    }
}
