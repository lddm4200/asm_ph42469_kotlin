package com.example.asm_ph42469.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.asm_ph42469.R

@Composable
fun CheckOut(navController: NavController){
    Column (
        modifier = Modifier.fillMaxSize()
    ){
        Header(navController)
    }

    BottomCheck(navController)
}

@Composable
private fun Header(navController: NavController){
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(20.dp)
            .height(60.dp)
            .fillMaxWidth()
    ){
        Image(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = "search",
            modifier = Modifier
                .size(28.dp)
                .clickable {
                    navController.navigate(Screen.CartScreen.route)
                })

        Text(
            text = "My cart",
            fontWeight = FontWeight(700),
            fontSize = 16.sp,
            color = Color(0xFF303030)
        )

        Spacer(modifier = Modifier.width(28.dp))
    }
}

@Composable
private fun BottomCheck(navController: NavController){

    Box(modifier = Modifier.fillMaxSize()){
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.weight(0.2f))

            Column(
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .height(280.dp)
                    .padding(20.dp)
            ) {

                Card(
                    colors = CardDefaults.cardColors(Color.DarkGray),
                    elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
                ) {
                    Button(
                        onClick = {
                            navController.navigate(Screen.CongratScreen.route)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF242424),
                            contentColor = Color(0xFFFFFFFF)
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                            .height(60.dp)
                            .background(Color(0xFF242424), shape = RoundedCornerShape(7.dp))
                    ) {
                        Text(
                            text = "SUBMIT ORDER",
                            fontSize = 18.sp,
                            fontWeight = FontWeight(600)
                        )
                    }
                }
            }
        }
    }
}
