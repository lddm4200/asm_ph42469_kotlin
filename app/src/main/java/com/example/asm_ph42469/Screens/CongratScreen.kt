package com.example.asm_ph42469.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun CongratScreen(navController: NavController){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "SUCCESS!",
            fontSize = 36.sp,
            fontWeight = FontWeight(700)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_congrat), contentDescription = "congrat",
            modifier = Modifier.size(270.dp,230.dp),
            colorFilter = ColorFilter.tint(Color(0xFF606060).copy(0.1f)))

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Your order will be delivered soon.\n" +
                    "Thank you for choosing our app!",
            color = Color(0xFF606060),
            fontSize = 18.sp,
            fontWeight = FontWeight(400)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Card(
            colors = CardDefaults.cardColors(Color.DarkGray),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
        ) {
            Button(
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF242424),
                    contentColor = Color(0xFFFFFFFF)
                ),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(315.dp, 60.dp)
                    .background(Color(0xFF242424), shape = RoundedCornerShape(7.dp))
            ) {
                Text(
                    text = "Track your orders",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600)
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))


        Button(
            onClick = {
                navController.navigate(Screen.HomeScreen.route)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.DarkGray
            ),
            modifier = Modifier
                .border(1.dp, Color.DarkGray, shape = RoundedCornerShape(8.dp))
                .size(315.dp, 60.dp)
        ) {
            Text(
                text = "BACK TO HOME",
                fontSize = 18.sp,
                fontWeight = FontWeight(600)
            )
        }
    }

    ImageCongrat()

}

@Composable
fun ImageCongrat(){
    Box(
        modifier = Modifier.fillMaxSize(1f)
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize(1f)
            
        ){
            Image(painter = painterResource(id = R.drawable.ic_congrat2), contentDescription = "",
                modifier = Modifier.size(200.dp, 180.dp),
                colorFilter = ColorFilter.tint(Color.DarkGray))

            Image(painter = painterResource(id = R.drawable.ic_check2), contentDescription = "",
                modifier = Modifier.size(41.dp, 41.dp))
            
            Spacer(modifier = Modifier.height(130.dp))
        }
    }
}