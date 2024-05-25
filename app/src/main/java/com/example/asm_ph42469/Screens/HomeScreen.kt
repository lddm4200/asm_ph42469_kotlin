package com.example.asm_ph42469.Screens

import androidx.annotation.IdRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
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
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.asm_ph42469.Model.CategoryModel
import com.example.asm_ph42469.Model.ProductModel
import com.example.asm_ph42469.R
import java.util.Objects

@Composable
fun HomeScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Header(navController)
        ListType()
        ListProduct(navController)
    }
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
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "search",
            modifier = Modifier.size(28.dp))

        Text(
            text =
            buildAnnotatedString {
                append("Make home\n")

                withStyle(
                    SpanStyle(
                        color = Color(0xFF242424),
                        fontWeight = FontWeight(700),
                    )
                ){
                    append("BEAUTIFUL")
                }
            },
            fontWeight = FontWeight(400),
            fontSize = 18.sp,
            color = Color(0xFF909090)
        )

        Image(
            painter = painterResource(id = R.drawable.ic_cart2),
            contentDescription = "cart",
            modifier = Modifier.size(28.dp)
                .clickable {
                    navController.navigate(Screen.CartScreen.route)
                })
    }
}


@Composable
fun ListType(){
    val listCate = mutableListOf<CategoryModel>();
    listCate.add(CategoryModel(0,"Popular", R.drawable.star))
    listCate.add(CategoryModel(1,"Chair", R.drawable.chair))
    listCate.add(CategoryModel(2,"Table", R.drawable.table))
    listCate.add(CategoryModel(3,"Armchair", R.drawable.sofa))
    listCate.add(CategoryModel(4,"Bed", R.drawable.bed))
    listCate.add(CategoryModel(5,"Armchair", R.drawable.sofa))
    listCate.add(CategoryModel(6,"Bed", R.drawable.bed))

    val scrollState = rememberScrollState()

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(
                bottom = 15.dp,
                start = 20.dp
            )
            .horizontalScroll(scrollState)
    ){
        listCate.forEachIndexed { index, cate ->
            ItemRow(cate = cate, index = index)
        }
    }
}

@Composable
fun ItemRow(cate: CategoryModel, index: Int) {
    val selectedIndexes = remember { mutableStateListOf<Int>(0) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(end = 22.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(
                    color = if (index in selectedIndexes) Color(0xFF303030) else Color(0xFFF5F5F5),
                    shape = RoundedCornerShape(12.dp)
                )
                .size(44.dp)
                .clickable {
                    if (index in selectedIndexes) {
                        selectedIndexes.remove(index)
                    } else {
                        selectedIndexes.add(index)
                    }
                }
        ) {
            Image(
                painter = painterResource(id = cate.imageCate),
                contentDescription = cate.cateName,
                modifier = Modifier
                    .size(28.dp),
                colorFilter = if (index in selectedIndexes) {
                    ColorFilter.tint(Color(0xFFFFFFFF))
                } else {
                    ColorFilter.tint(Color.DarkGray)
                }
            )
        }
        Text(
            text = cate.cateName,
            color = if (index in selectedIndexes) {
                Color.DarkGray
            } else {
                Color(0xFF999999)
            },
            fontSize = 14.sp,
            fontWeight = if (index in selectedIndexes) {
                FontWeight(600)
            } else {
                FontWeight(400)
            }
        )
    }
}

@Composable
fun ListProduct(navController: NavController){
    val listProduct = mutableListOf<ProductModel>()
    listProduct.add(ProductModel("sp1","Black Simple Lamp",
        "Black Simple Lamp,Black Simple Lamp",12f, 4,R.drawable.item1))
    listProduct.add(ProductModel("sp2","Minimal Stand",
        "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home. "
        ,25f, 2,R.drawable.item2))
    listProduct.add(ProductModel("sp3","Coffee Chair",
        "Coffee Chair,Coffee Chair",20f, 1,R.drawable.item3))
    listProduct.add(ProductModel("sp4","Simple Desk",
        "Simple Desk,Simple Desk",50f, 3,R.drawable.item4))
    listProduct.add(ProductModel("sp1","Black Simple Lamp",
        "Black Simple Lamp,Black Simple Lamp",12f, 4,R.drawable.item1))
    listProduct.add(ProductModel("sp2","Minimal Stand",
        "Minimal Stand,Minimal Stand",25f, 2,R.drawable.item2))
    listProduct.add(ProductModel("sp3","Coffee Chair",
        "Coffee Chair,Coffee Chair",20f, 1,R.drawable.item3))
    listProduct.add(ProductModel("sp4","Simple Desk",
        "Simple Desk,Simple Desk",50f, 3,R.drawable.item4))

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(listProduct) { pro ->
            CardProduct(pro = pro, navController)
        }
    }
}

@Composable
fun CardProduct(pro : ProductModel, navController: NavController){
    Card(
        modifier = Modifier
            .padding(20.dp)
            .size(157.dp, 253.dp)
            .clickable {
                navController.navigate(Screen.DetailProduct.route)
            }
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)

        ) {
            Image(painter = painterResource(id = pro.imageProduct)
                , contentDescription = "productImage",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .size(175.dp, 200.dp)
                    .clip(RoundedCornerShape(12.dp))
            )

            Text(
                text = pro.productName,
                color = Color(0xFF606060),
                fontSize = 14.sp,
                fontWeight = FontWeight(400))

            Text(
                text = "$ ${pro.price}",
                color = Color(0xFF303030),
                fontSize = 14.sp,
                fontWeight = FontWeight(700))
        }
    }

    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(top = 180.dp, start = 140.dp, end = 36.dp)
            .size(30.dp)
            .background(Color(0xFF606060).copy(0.4f), shape = RoundedCornerShape(6.dp))

    ){
        Image(painter = painterResource(id = R.drawable.ic_bag)
            , contentDescription = "bag",
            modifier = Modifier.size(20.dp),
            colorFilter = ColorFilter.tint(Color.White))
    }

}