package edu.uksw.fti.pam.pam_activityintent.ui.screens

import androidx.annotation.ContentView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import edu.uksw.fti.pam.pam_activityintent.ui.theme.*
import edu.uksw.fti.pam.pam_activityintent.R
import edu.uksw.fti.pam.pam_activityintent.models.ApparelViewModel
import edu.uksw.fti.pam.pam_activityintent.models.CartViewModel

private val vma = ApparelViewModel()

@Composable
fun ApparelScreen() {
    Column(
        modifier = Modifier
            .background(coklatmuda)
            .fillMaxSize()

    ){
        ExpandableSearchView(
            searchDisplay = "",
            onSearchDisplayChanged = {},
            onSearchDisplayClosed = {}
        )
        jdulapparel()
        LazyVerticalGridApparel()
    }
}

@Composable
fun jdulapparel(){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, top = 5.dp, bottom = 5.dp)
    ) {
        Text(text = stringResource(id = R.string.aparl), fontSize = 20.sp, fontFamily = anekBold, color = hitamkren)
        Image(painter = painterResource(id = R.drawable.nismo), contentDescription = "logonismo",
            modifier = Modifier
                .width(110.dp)
                .height(30.dp)
                .padding(top = 1.dp)

        )
    }
}



@Composable
fun LazyVerticalGridApparel(){
    //val list = createDataListApaprel()
    LaunchedEffect(
        Unit,
        block = {
            vma.getApparelList()
        }
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(start = 5.dp, top = 5.dp, end = 5.dp, bottom = 60.dp),
        content = {
//            items(list.size) {index ->
//                GridItemApparel(testData2 = list[index] )
//            }
            items(vma.apparelList.size) { index ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    backgroundColor = hitamkren,
                    elevation = 12.dp,
                    shape = RoundedCornerShape(6.dp)

                ) {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(vma.apparelList[index].gambar),
                            contentDescription = "",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .aspectRatio(1f)
                                .padding(top = 6.dp, start = 6.dp, end = 6.dp, bottom = 6.dp)
                                .clip(RoundedCornerShape(6.dp)),
                            contentScale = ContentScale.Crop
                        )
                        Column(
                            modifier = Modifier.background(hitamkren)
                        ){
                            Text(
                                text = vma.apparelList[index].judul, fontSize = 12.sp, color = Color.White, fontFamily = anekMedium,
                                modifier = Modifier.padding(top = 0.dp, start = 6.dp, end = 6.dp, bottom = 6.dp)

                            )
                            Text(
                                text = vma.apparelList[index].harga, fontSize = 10.sp, color = Color.White, fontFamily = anekLight,
                                modifier = Modifier.padding(top = 0.dp, start = 6.dp, end = 6.dp, bottom = 6.dp)

                            )
                        }



                    }
                }
            }

        })
}

fun createDataListApaprel():List<TestData2> {
    val list = mutableListOf<TestData2>()

    list.add(TestData2("Nismo Racing Classic Logo Hoodie Yellow on Black", R.drawable.hudi2,"IDR 3.000.000" ))
    list.add(TestData2("Nismo Racing Basic Logo Hoodie Black on Black", R.drawable.hudi, "IDR 3.000.000"))
    list.add(TestData2("Nismo x Motul GranPrix Racing Team Polo", R.drawable.polo, "IDR 1.000.000"))
    list.add(TestData2("Basic Logo Nismo Racing Oversized Tee", R.drawable.koas,"IDR 800.000"))
    list.add(TestData2("Nismo Racing Basic Steel Logo Keychain", R.drawable.keychin,"IDR 100.000"))
    list.add(TestData2("Nismo Racing Cloth Black Logo Keychain", R.drawable.keychen, "IDR 100.000"))
    return list
}

//@Composable
//fun GridItemApparel(testData2: TestData2){
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(4.dp),
//        backgroundColor = hitamkren,
//        elevation = 12.dp,
//        shape = RoundedCornerShape(6.dp)
//
//    ) {
//        Column(
//            modifier = Modifier.fillMaxSize()
//        ) {
//            Image(
//                painter = painterResource(id = testData2.gambar),
//                contentDescription = "",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(200.dp)
//                    .aspectRatio(1f)
//                    .padding(top = 6.dp, start = 6.dp, end = 6.dp, bottom = 6.dp)
//                    .clip(RoundedCornerShape(6.dp)),
//                contentScale = ContentScale.Crop
//            )
//            Column(
//                modifier = Modifier.background(hitamkren)
//            ){
//                Text(
//                    text = testData2.judul, fontSize = 12.sp, color = Color.White, fontFamily = anekMedium,
//                    modifier = Modifier.padding(top = 0.dp, start = 6.dp, end = 6.dp, bottom = 6.dp)
//
//                )
//                Text(
//                    text = testData2.harga, fontSize = 10.sp, color = Color.White, fontFamily = anekLight,
//                    modifier = Modifier.padding(top = 0.dp, start = 6.dp, end = 6.dp, bottom = 6.dp)
//
//                )
//            }
//
//
//
//        }
//    }
//}


data class TestData2(
    val judul : String,
    val gambar : Int,
    val harga : String
)


@Preview(showBackground = true)
@Composable
fun DefaultzzPreview() {
    PAM_ActivityIntentTheme {
        LazyVerticalGridApparel()
    }
}
