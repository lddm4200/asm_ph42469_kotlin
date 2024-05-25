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
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.asm_ph42469.Model.ProductModel
import com.example.asm_ph42469.R

@Composable
fun CartScreen(navController: NavController){
    Column (
        modifier = Modifier.fillMaxSize()
    ){
        Header(navController)
        ListItem()
    }

    BottomCart(navController)

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
                    navController.navigate(Screen.HomeScreen.route)
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
private fun ListItem(){
    val listProduct = mutableListOf<ProductModel>()
    listProduct.add(ProductModel("sp1","Black Simple Lamp",
        "Black Simple Lamp,Black Simple Lamp",12f, 4,R.drawable.item1))
    listProduct.add(ProductModel("sp2","Minimal Stand",
        "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home. "
        ,25f, 2,R.drawable.item2))
    listProduct.add(ProductModel("sp3","Coffee Chair",
        "Coffee Chair,Coffee Chair",20f, 1,R.drawable.item3))

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.8f)
    ) {
        listProduct.forEachIndexed { index, productModel ->
            ItemCart(pro = productModel, index)
        }
    }
}

@Composable
private fun ItemCart(pro : ProductModel, index : Int){

    if (index > 0) Image(painter = painterResource(id = R.drawable.underline)
        , contentDescription = "",
        modifier = Modifier.fillMaxWidth(),
        colorFilter = ColorFilter.tint(Color.DarkGray))

    var number by remember {
        mutableStateOf(1)
    }

    Row (
        modifier = Modifier
            .padding(top = 15.dp, bottom = 15.dp)
            .fillMaxWidth(0.9f)
            .height(100.dp)
    ){

        Image(painter = painterResource(id = pro.imageProduct), contentDescription = "",
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(4.dp)),
            contentScale = ContentScale.Crop)

        Spacer(modifier = Modifier.width(15.dp))

        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxHeight()
        ) {
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = buildAnnotatedString {
                    append("${pro.productName}\n")

                    withStyle(
                        SpanStyle(
                            color = Color(0xFF242424),
                            fontWeight = FontWeight(700),
                            fontSize = 16.sp
                        )
                    ){
                        append("$ ${pro.price}")
                    }
                },
                    fontSize = 14.sp, fontWeight = FontWeight(600),
                    color = Color(0xFF999999)
                )

                Image(painter = painterResource(id = R.drawable.ic_exit), contentDescription = "",
                    modifier = Modifier.size(20.dp))
            }

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
    }
}

private @Composable
fun BottomCart(navController: NavController){
    var code by remember {
        mutableStateOf("")
    }
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
                OutlinedTextField(
                    label = {
                            Text(text = "Enter your promo code",
                                fontSize = 16.sp,
                                color = Color(0xFF999999))
                    },
                    value = code,
                    onValueChange = {code = it},
                    trailingIcon = {
                        Image(painter = painterResource( id = R.drawable.ic_next)
                            , contentDescription = "visible",
                            Modifier
                                .clickable { }
                                .size(54.dp)
                                .background(
                                    Color.DarkGray,
                                    RoundedCornerShape(5.dp)
                                ),
                            colorFilter = ColorFilter.tint(Color.White))
                    },
                    modifier = Modifier.fillMaxWidth().border(0.dp,Color.White).clip(
                        RoundedCornerShape(5.dp)
                    ),
                )

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth().padding(start = 15.dp, end = 15.dp)
                ) {
                    Text(text = "Total:", fontSize = 20.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF808080)
                    )

                    Text(text = "$ 95.00", fontSize = 20.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF303030)
                    )
                }

                Card(
                    colors = CardDefaults.cardColors(Color.DarkGray),
                    elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
                ) {
                    Button(
                        onClick = {
                            navController.navigate(Screen.CheckOut.route)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF242424),
                            contentColor = Color(0xFFFFFFFF)
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                            .height( 60.dp)
                            .background(Color(0xFF242424), shape = RoundedCornerShape(7.dp))
                    ) {
                        Text(
                            text = "Check out",
                            fontSize = 18.sp,
                            fontWeight = FontWeight(600)
                        )
                    }
                }
            }
        }
    }
}
