package com.example.asm_ph42469.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import com.example.asm_ph42469.R

@Composable
fun WelcomeScreen(navController: NavController){

    Image(
        painter = painterResource(R.drawable.bg),
        contentDescription = "background",
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.FillWidth)
    Box (
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(35.dp)
        ) {

            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = "MAKE YOUR",
                fontSize = 24.sp,
                fontWeight = FontWeight(600),
                fontFamily = FontFamily.Serif,
                color = Color(0xFF606060)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "HOME BEAUTIFUL",
                fontSize = 30.sp,
                fontWeight = FontWeight(700),
                fontFamily = FontFamily.Serif,
                color = Color(0xFF303030)
            )

            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = "The best simple place where you discover most wonderful furnitures and make your home beautiful",
                fontSize = 18.sp,
                fontWeight = FontWeight(400),
                fontFamily = FontFamily.Serif,
                color = Color(0xFF808080),
                modifier = Modifier.padding(
                    start = 20.dp
                ),
            )

            Spacer(modifier = Modifier.height(180.dp))

            Button(
                onClick = {
                          navController.navigate(Screen.LoginScreen.route)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF242424),
                    contentColor = Color(0xFFFFFFFF)
                ),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(159.dp, 54.dp)
                    .background(Color(0xFF242424), shape = RoundedCornerShape(7.dp))
                ) {
                Text(
                    text = "Get Started",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600)
                    )
            }

        }
    }
}