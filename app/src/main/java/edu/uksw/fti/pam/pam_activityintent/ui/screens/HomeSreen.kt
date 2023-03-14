package edu.uksw.fti.pam.pam_activityintent.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import edu.uksw.fti.pam.pam_activityintent.ui.theme.*
import edu.uksw.fti.pam.pam_activityintent.R

@Composable
fun HomeScreen () {
    Box(modifier = Modifier
        .background(coklatmuda)
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .padding(bottom = 60.dp)

    ) {
        Column {
            ExpandableSearchView(
                searchDisplay = "",
                onSearchDisplayChanged = {},
                onSearchDisplayClosed = {}
            )
            jduduldanlogo()
            berita()
            jduduldanlogo2()
            Produk()
            aksesoris()
            Spacer(modifier = Modifier.weight(1f))

        }
    }
}

//@Composable
//fun HeaderProfileComponent(){
//    Row(
//        horizontalArrangement = Arrangement.SpaceBetween,
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(coklatTua)
//            .padding(start = 15.dp, end = 15.dp, top = 5.dp, bottom = 5.dp)
//
//    ){
//        Row(verticalAlignment = Alignment.CenterVertically){
//            Image(painter = painterResource(id = R.drawable.nism_o), contentDescription = "Logo",
//                contentScale = ContentScale.Crop,
//                modifier = Modifier
//                    .size(40.dp)
//                    .clip(CircleShape)
//            )
//        }
//
//        Row() {
//            OutlinedTextField(
//                value = "",
//                onValueChange = {},
//                leadingIcon = { Icon(
//                    imageVector = Icons.Default.Search,
//                    contentDescription = "Search Icon",
//                    tint = coklatTua,
//                ) },
//                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    focusedBorderColor = coklatTua,
//                    unfocusedBorderColor = coklatTua
//                ),
//                modifier = Modifier
//                    .padding(top = 1.dp)
//                    .height(35.dp)
//                    .width(220.dp)
//                    .background(coklatmuda, RoundedCornerShape(40.dp))
//            )
//        }
//
//
//
//    }
//}

@Composable
fun jduduldanlogo(){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, top = 5.dp, bottom = 5.dp)
    ) {
        Text(text = stringResource(id = R.string.news), fontSize = 20.sp, fontFamily = anekBold, color = hitamkren)
        Image(painter = painterResource(id = R.drawable.nismo), contentDescription = "logonismo",
            modifier = Modifier
                .width(110.dp)
                .height(30.dp)
                .padding(top = 1.dp)

        )
    }
}

@Composable
fun berita(){
    LazyRow(
        modifier = Modifier
            .height(180.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        item {
            beritaItem(imagePainter = painterResource(id = R.drawable.berita1),
                title = stringResource(id = R.string.jdulbrit1),
                subtitle = stringResource(id = R.string.brit1),
                backgroudColor = coklatmuda
            )
        }
        item {
            beritaItem(imagePainter = painterResource(id = R.drawable.berita2),
                title = stringResource(id = R.string.jdulbrit2),
                subtitle = stringResource(id = R.string.brit2),
                backgroudColor = coklatmuda
            )
        }
    }
}

@Composable
fun beritaItem(
    title: String = "",
    subtitle: String = "",
    header: String = "",
    backgroudColor: Color = coklatmuda,
    imagePainter: Painter
){
    Card(
        modifier = Modifier
            .width(300.dp),
        backgroundColor = backgroudColor,
        elevation = 0.dp

    ) {
        Column {
            Image(
                painter = imagePainter,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clip(RoundedCornerShape(5.dp)),

                alignment = Alignment.CenterEnd,
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(top = 2.dp)
            ) {
                Text(text = title, fontSize = 14.sp, color = Color.Black, fontFamily = anekMedium)
                Text(text = subtitle, fontSize = 14.sp, color = Color.Black, fontFamily = anekLight)
            }

        }
    }
}

@Composable
fun jduduldanlogo2(){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, top = 5.dp, bottom = 5.dp)
    ) {
        Text(text = stringResource(id = R.string.parts), fontSize = 20.sp, fontFamily = anekBold, color = hitamkren)
    }
}

@Composable
fun Produk(){
    val list = createDataListAksesoris()

    LazyRow(
        modifier = Modifier
            .height(250.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        content = {
            items(list.size) {index ->
                GridItemAksesoris(testDataAcc = list[index] )
            }
        })
}

fun createDataListAksesoris():List<TestDataAcc> {
    val list = mutableListOf<TestDataAcc>()
    list.add(TestDataAcc("LM GT4 Aluminum Road Wheel Machining Logo", R.drawable.pelkz,"IDR 90.000.000"))
    list.add(TestDataAcc("NISSAN GT-R (R35) Nissan Genuine Brake Kit", R.drawable.kaliperz, "IDR 30.000.000"))
    list.add(TestDataAcc("NISMO LightWeight Suspension Link Series", R.drawable.armz, "IDR 10.000.000"))
    return list
}

@Composable
fun GridItemAksesoris(testDataAcc: TestDataAcc){
    Card(
        modifier = Modifier
            .width(150.dp)
            .clip(RoundedCornerShape(5.dp)),
        backgroundColor = hitamkren,
        elevation = 0.dp

    ) {
        Column {
            Image(
                painter = painterResource(id = testDataAcc.gambar),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .padding(top = 10.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
                    .clip(RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(top = 10.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
            ) {
                Text(text = testDataAcc.judul, fontSize = 12.sp, color = Color.White, fontFamily = anekMedium)
                Text(text =  testDataAcc.harga, fontSize = 11.sp, color = Color.White, fontFamily = anekLight)
            }

        }

    }
}


data class TestDataAcc(
    val judul : String,
    val gambar : Int,
    val harga : String,
)

@Composable
fun aksesoris(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(start = 15.dp, end = 15.dp)
            .clip(RoundedCornerShape(10.dp)),
        elevation = 0.dp,
        backgroundColor = hitamkren
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp, end = 5.dp, bottom = 5.dp, top = 5.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.nism_o),
                    contentDescription = "logokcil" ,
                    modifier = Modifier
                        .size(20.dp)
                        .padding(start = 2.dp, end = 2.dp, bottom = 2.dp)
                )
                Text(text = stringResource(id = R.string.apparel), fontFamily = anekBold, color = Color.White)
                Image(
                    painter = painterResource(id = R.drawable.nism_o),
                    contentDescription = "logokcil" ,
                    modifier = Modifier
                        .size(20.dp)
                        .padding(start = 2.dp, end = 2.dp, bottom = 2.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.hoodie),
                    contentDescription = "hoodi" ,
                    modifier = Modifier
                        .height(32.dp)
                        .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.keychain),
                    contentDescription = "keych" ,
                    modifier = Modifier
                        .height(32.dp)
                        .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.shirt),
                    contentDescription = "shirt" ,
                    modifier = Modifier
                        .height(32.dp)
                        .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.umbrella),
                    contentDescription = "umbr" ,
                    modifier = Modifier
                        .height(32.dp)
                        .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.pants),
                    contentDescription = "pants" ,
                    modifier = Modifier
                        .height(32.dp)
                        .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.stickers),
                    contentDescription = "sticker" ,
                    modifier = Modifier
                        .height(32.dp)
                        .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.headwear),
                    contentDescription = "headwer" ,
                    modifier = Modifier
                        .height(32.dp)
                        .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.tumbker),
                    contentDescription = "tumbler" ,
                    modifier = Modifier
                        .height(32.dp)
                        .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                )
            }

        }

    }
}

//@Composable
//fun BottomComponent( ){
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(coklatTua)
//            .height(60.dp)
//    ){
//
//        Image(
//            painter = painterResource(id = R.drawable.cart),
//            contentDescription = "cart",
//            modifier = Modifier
//                .align(Alignment.TopCenter)
//                .size(48.dp)
//                .padding(top = 5.dp)
//        )
//        Row(
//            modifier = Modifier
//                .fillMaxWidth(),
//            horizontalArrangement = Arrangement.Center,
//            verticalAlignment = Alignment.CenterVertically
//        ){
//            Image(
//                painter = painterResource(id = R.drawable.home),
//                contentDescription = "home" ,
//                modifier = Modifier
//                    .height(55.dp)
//                    .padding(start = 0.dp, end = 12.dp, top = 5.dp)
//            )
//            Image(
//                painter = painterResource(id = R.drawable.parts),
//                contentDescription = "parts" ,
//                modifier = Modifier
//                    .height(55.dp)
//                    .padding(start = 12.dp, end = 39.dp, top = 5.dp)
//            )
//            Image(
//                painter = painterResource(id = R.drawable.apparelbna),
//                contentDescription = "apparel" ,
//                modifier = Modifier
//                    .height(55.dp)
//                    .padding(start = 39.dp, end = 12.dp, top = 5.dp)
//            )
//            Image(
//                painter = painterResource(id = R.drawable.news),
//                contentDescription = "news" ,
//                modifier = Modifier
//                    .height(55.dp)
//                    .padding(start = 12.dp, end = 0.dp, top = 5.dp)
//            )
//        }
//    }
//}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BottomNavigationMainScreenView(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation(
                navController = navController,
            )
        }
    ) {
        NavigationGraph(navController = navController)
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultsPreview() {
    PAM_ActivityIntentTheme {
//        HomeScreen()
        BottomNavigationMainScreenView()
    }
}

