package com.example.asm_ph42469.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.asm_ph42469.R

@Composable
fun DetailProduct(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        ImageProduct()
        Chitiet()
    }
    Back(navController)
    StyleBackground()
    BottomAddToCart()
}

@Composable
fun ImageProduct() {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.End,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .fillMaxHeight(0.55f)
                .background(
                    Color.White,
                    shape = RoundedCornerShape(bottomStart = 56.dp, bottomEnd = 0.dp)
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.item2),
                contentDescription = "item",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(bottomStart = 56.dp))
            )
        }
    }
}

@Composable
fun Back(navController: NavController){
    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(top = 53.dp, start = 42.dp)

    ){
        Image(painter = painterResource(id = R.drawable.ic_back)
            , contentDescription = "bag",
            modifier = Modifier
                .size(40.dp)
                .background(Color(0xFFFFFFFF), shape = RoundedCornerShape(6.dp))
                .padding(8.dp)
                .clickable {
                    navController.navigate(Screen.HomeScreen.route)
                }
        )
    }
}

@Composable
fun StyleBackground(){
    var style by remember {
        mutableStateOf(0)
    }
    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(top = 149.dp, start = 31.dp)
            .size(64.dp, 192.dp)
            .background(Color(0xFFFFFFFF), shape = RoundedCornerShape(32.dp))

    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxSize()
        ){
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                onClick = {
                          style = 0
                },
                modifier = Modifier
                    .size(20.dp)
                    .border(6.dp, color = Color(0xFF909090), shape = RoundedCornerShape(30.dp))) {
            }

            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFB4916C)
                ),
                onClick = {
                          style = 1
                },
                modifier = Modifier
                    .size(20.dp)
                    .border(6.dp, color = Color(0xFFF0F0F0), shape = RoundedCornerShape(30.dp))) {
            }

            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE4CBAD)
                ),
                onClick = {
                          style = 2
                },
                modifier = Modifier
                    .size(20.dp)
                    .border(6.dp, color = Color(0xFFF0F0F0), shape = RoundedCornerShape(30.dp))) {
            }
        }
    }
}


@Composable
fun Chitiet(){

    var number by remember {
        mutableStateOf(1)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp)
    ) {
        Text(
            text = "Minimal Stand",
            fontSize = 24.sp,
            fontWeight = FontWeight(500),
            color = Color(0xFF303030)
        )

        Spacer(modifier = Modifier.height(10.dp))


        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "$ 50",
                fontSize = 30.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF303030)
            )

            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(0.38f)
            ){

                Image(
                    painter = painterResource(id = R.drawable.ic_plus), contentDescription = "",
                    modifier = Modifier
                        .clickable {
                            number++
                        }
                        .size(28.dp)
                        .background(Color(0xFFE0E0E0), shape = RoundedCornerShape(6.dp)))

                Text(
                    text = "$number",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600),
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_minus), contentDescription = "",
                    modifier = Modifier
                        .clickable {
                            if (number > 1) number--
                        }
                        .size(28.dp)
                        .background(Color(0xFFE0E0E0), shape = RoundedCornerShape(6.dp))
                        .padding(5.dp))
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth(0.54f)
        ){
            Image(
                painter = painterResource(id = R.drawable.star), contentDescription = "",
                modifier = Modifier
                    .size(22.dp),
                colorFilter = ColorFilter.tint(Color(0xFFF2C94C)))

            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "4.5",
                fontSize = 18.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF303030)
            )
            Spacer(modifier = Modifier.width(15.dp))

            Text(
                text = "(50 reviews)",
                fontSize = 14.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF808080)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home. ",
            fontSize = 14.sp,
            fontWeight = FontWeight(300),
            color = Color(0xFF606060)
        )

    }
}

@Composable
fun BottomAddToCart(){
    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(top = 834.dp, start = 25.dp)
            .size(325.dp, 60.dp)

    ){
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ){
            Image(
                painter = painterResource(id = R.drawable.ic_cart), contentDescription = "",
                modifier = Modifier
                    .clickable {

                    }
                    .size(60.dp)
                    .background(Color(0xFFE0E0E0), shape = RoundedCornerShape(6.dp))
                    .padding(15.dp),
                colorFilter = ColorFilter.tint(Color.DarkGray))


            Spacer(modifier = Modifier.width(20.dp))

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
                        .size(270.dp, 60.dp)
                        .background(Color(0xFF242424), shape = RoundedCornerShape(7.dp))
                ) {
                    Text(
                        text = "Add to cart",
                        fontSize = 20.sp,
                        fontWeight = FontWeight(600)
                    )
                }
            }
        }
    }
}