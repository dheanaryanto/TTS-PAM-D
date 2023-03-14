package edu.uksw.fti.pam.pam_activityintent.ui.screens


import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.uksw.fti.pam.pam_activityintent.ui.theme.*
import edu.uksw.fti.pam.pam_activityintent.R
import edu.uksw.fti.pam.pam_activityintent.datastore.StoreFirstname
import edu.uksw.fti.pam.pam_activityintent.datastore.StoreLastname

@Composable
fun AccountScreen () {
    Column(
        modifier = Modifier
            .background(coklatmuda)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(bottom = 60.dp)

    ){
        ExpandableSearchView(
            searchDisplay = "",
            onSearchDisplayChanged = {},
            onSearchDisplayClosed = {}
        )
        juduldanlogo()
        namadanakun()
        dompet()
        order()
        settings()
        Spacer(modifier = Modifier.weight(1f))

    }
}

//@Composable
//fun atasan(){
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
fun juduldanlogo(){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, top = 5.dp, bottom = 5.dp)
    ) {
        Text(text = stringResource(id = R.string.account), fontSize = 20.sp, fontFamily = anekBold, color = hitamkren)
        Image(painter = painterResource(id = R.drawable.nismo), contentDescription = "logonismo",
            modifier = Modifier
                .width(110.dp)
                .height(30.dp)
                .padding(top = 1.dp)

        )
    }
}

@Composable
fun namadanakun(){
    val context = LocalContext.current

    val scope = rememberCoroutineScope()

    val dataStoreFname = StoreFirstname(context)

    val dataStoreLname = StoreLastname(context)

    val saveFName = dataStoreFname.getFName.collectAsState(initial = "")

    val saveLName = dataStoreLname.getLName.collectAsState(initial = "")
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp, bottom = 5.dp, top = 5.dp)
    ){
        Row(

        ) {
            var imageUri by remember { mutableStateOf<Uri?>(null) }
            val context = LocalContext.current
            val bitmap = remember { mutableStateOf<Bitmap?>(null) }

            val launcher =
                rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
                    imageUri = uri
                }

            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                ,
            ) {
                Box() {
                    Image(
                        painter = painterResource(id = R.drawable.akun), contentDescription = null,
                        modifier = Modifier
                            .clickable { launcher.launch("image/*") }
                            .width(100.dp)
                            .height(100.dp))
                }
                imageUri?.let {
                    if (Build.VERSION.SDK_INT < 28) {
                        bitmap.value = MediaStore.Images
                            .Media.getBitmap(context.contentResolver, it)
                    } else {
                        val source = ImageDecoder.createSource(context.contentResolver, it)
                        bitmap.value = ImageDecoder.decodeBitmap(source)
                    }

                    bitmap.value?.let { btm ->
                        Image(
                            bitmap = btm.asImageBitmap(),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,

                            modifier = Modifier
                                .width(100.dp)
                                .height(100.dp)
                                .clip(CircleShape)
                                .clickable(enabled = true, onClick = {  })
                        )
                    }
                }


            }
            Column(
                modifier = Modifier
                    .padding(top = 3.dp, start = 10.dp)
            ) {
                Text(
                    text = saveFName.value!! + " " + saveLName.value!!,
                    fontFamily = anekBold,
                    color = Color.Black,
                    fontSize = 23.sp,
                    modifier = Modifier
                )
                Image(
                    painter = painterResource(id = R.drawable.member),
                    contentDescription = "member" ,
                    modifier = Modifier
                        .height(17.dp)

                )
                Text(
                    text = "0821356273276",
                    fontFamily = anekLight,
                    color = Color.Black,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(top = 10.dp)
                )
            }
        }
        Divider(
            color = coklatTua,
            thickness = 3.dp,
            modifier = Modifier
                .padding(top = 10.dp, start = 10.dp, end = 10.dp)
        )
    }
}


@Composable
fun dompet(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(190.dp)
            .padding(start = 15.dp, end = 15.dp)
            .clip(RoundedCornerShape(10.dp)),
        elevation = 0.dp,
        backgroundColor = hitamkren
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, bottom = 10.dp, top = 10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ){
                Text(text = stringResource(id = R.string.dompet), fontFamily = anekMedium, color = Color.White)
                Image(
                    painter = painterResource(id = R.drawable.wallet),
                    contentDescription = "wallet" ,
                    modifier = Modifier
                        .height(20.dp)
                        .padding(start = 5.dp)
                )
            }
            Text(
                text = stringResource(id = R.string.saldo),
                fontFamily = anekLight,
                color = grey,
                fontSize = 13.sp
            )
            Text(
                text = "IDR 300.000.000",
                fontFamily = anekBold,
                color = Color.White,
                fontSize = 41.sp
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Text(
                    text = stringResource(id = R.string.pengluwaran),
                    fontFamily = anekLight,
                    color = grey,
                    fontSize = 15.sp,
                    modifier = Modifier
                )
                Text(
                    text = "Rp100.000.000",
                    fontFamily = anekBold,
                    color = Color.White,
                    fontSize = 16.sp,
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Image(
                    painter = painterResource(id = R.drawable.plus),
                    contentDescription = "plus" ,
                    modifier = Modifier
                        .height(15.dp)
                )
                Text(
                    text = "Top Up",
                    fontFamily = anekLight,
                    color = Color.White,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .padding(start = 10.dp)

                )
            }
        }

    }
}

@Composable
fun order(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(top = 10.dp, start = 15.dp, end = 15.dp, bottom = 10.dp)
            .clip(RoundedCornerShape(10.dp)),
        elevation = 0.dp,
        backgroundColor = hitamkren
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, bottom = 10.dp, top = 10.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth(),
            ){
                Text(text = stringResource(id = R.string.myorder), fontFamily = anekMedium, color = Color.White)
                Image(
                    painter = painterResource(id = R.drawable.myorder),
                    contentDescription = "myorder" ,
                    modifier = Modifier
                        .height(20.dp)
                        .padding(start = 10.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
            ){
                Image(
                    painter = painterResource(id = R.drawable.packing),
                    contentDescription = "packing" ,
                    modifier = Modifier
                        .height(40.dp)
                )
                Column(
                    modifier = Modifier
                        .padding(start = 12.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.packing),
                        fontFamily = anekMedium,
                        color = Color.White,
                        fontSize = 13.sp
                    )
                    Row() {
                        Text(
                            text = "0 ",
                            fontFamily = anekLight,
                            color = grey,
                            fontSize = 13.sp
                        )
                        Text(
                            text = stringResource(id = R.string.paket),
                            fontFamily = anekLight,
                            color = grey,
                            fontSize = 13.sp
                        )
                    }

                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
            ){
                Image(
                    painter = painterResource(id = R.drawable.sending),
                    contentDescription = "sending" ,
                    modifier = Modifier
                        .height(40.dp)
                )
                Column(
                    modifier = Modifier
                        .padding(start = 10.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.sending),
                        fontFamily = anekMedium,
                        color = Color.White,
                        fontSize = 13.sp
                    )
                    Row() {
                        Text(
                            text = "0 ",
                            fontFamily = anekLight,
                            color = grey,
                            fontSize = 13.sp
                        )
                        Text(
                            text = stringResource(id = R.string.paket),
                            fontFamily = anekLight,
                            color = grey,
                            fontSize = 13.sp
                        )
                        Text(
                            text = stringResource(id = R.string.perkiraan),
                            fontFamily = anekLight,
                            color = grey,
                            fontSize = 13.sp
                        )
                    }

                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
            ){
                Image(
                    painter = painterResource(id = R.drawable.bintang),
                    contentDescription = "bintang" ,
                    modifier = Modifier
                        .height(40.dp)
                )
                Column(
                    modifier = Modifier
                        .padding(start = 21.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.rating),
                        fontFamily = anekMedium,
                        color = Color.White,
                        fontSize = 13.sp
                    )
                    Row() {
                        Text(
                            text = "1 ",
                            fontFamily = anekLight,
                            color = grey,
                            fontSize = 13.sp
                        )
                        Text(
                            text = stringResource(id = R.string.paket),
                            fontFamily = anekLight,
                            color = grey,
                            fontSize = 13.sp
                        )
                    }

                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth(),
            ){
                Text(text = " ", fontFamily = anekMedium, color = Color.White)
                Text(
                    text = stringResource(id = R.string.purchase),
                    fontFamily = anekLight,
                    color = grey)
            }

        }

    }
}

@Composable
fun settings(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp, end = 5.dp, bottom = 5.dp)
    ){
        Divider(
            color = coklatTua,
            thickness = 1.dp,
            modifier = Modifier
                .padding(top = 10.dp, start = 10.dp, end = 10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
        ){
            Image(
                painter = painterResource(id = R.drawable.baseline_account_circle_24),
                contentDescription = "akunbawah" ,
                modifier = Modifier
                    .height(20.dp)
                    .padding(start = 5.dp, end = 5.dp)
            )
            Text(
                text = stringResource(id = R.string.setingakun),
                fontFamily = anekMedium,
                color = hitamkren,
                modifier = Modifier
                    .padding(start = 5.dp))
        }
        Divider(
            color = coklatTua,
            thickness = 1.dp,
            modifier = Modifier
                .padding(top = 0.dp, start = 10.dp, end = 10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
        ){
            Image(
                painter = painterResource(id = R.drawable.voucher),
                contentDescription = "voucher" ,
                modifier = Modifier
                    .height(15.dp)
                    .padding(start = 5.dp, end = 5.dp)
            )
            Text(
                text = stringResource(id = R.string.voucher),
                fontFamily = anekMedium,
                color = hitamkren,
                modifier = Modifier
                    .padding(start = 8.dp)
            )
        }
        Divider(
            color = coklatTua,
            thickness = 1.dp,
            modifier = Modifier
                .padding(top = 0.dp, start = 10.dp, end = 10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
        ){
            Image(
                painter = painterResource(id = R.drawable.call),
                contentDescription = "call" ,
                modifier = Modifier
                    .height(20.dp)
                    .padding(start = 5.dp, end = 5.dp)
            )
            Text(
                text = stringResource(id = R.string.call),
                fontFamily = anekMedium,
                color = hitamkren,
                modifier = Modifier
                    .padding(start = 5.dp)
            )
        }

    }
}

//@Composable
//fun bawahan( ){
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


@Preview(showBackground = true)
@Composable
fun DefaultssPreview() {
    PAM_ActivityIntentTheme {
        namadanakun()
        }
}
