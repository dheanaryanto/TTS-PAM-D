package edu.uksw.fti.pam.pam_activityintent.ui.screens

import androidx.annotation.ContentView
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import edu.uksw.fti.pam.pam_activityintent.ui.theme.*
import edu.uksw.fti.pam.pam_activityintent.R
import edu.uksw.fti.pam.pam_activityintent.models.CartViewModel
import edu.uksw.fti.pam.pam_activityintent.models.PartsViewModel

private val vmp = PartsViewModel ()

@Composable
fun PartsScreen() {
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
        jdulparts()
        LazyVerticalGridExample()
    }
}

//@Composable
//fun hidir(){
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
//                value = "contoh",
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
//                    .background(coklatmuda, RoundedCornerShape(40.dp)),
//
//            )
//        }
//
//
//
//    }
//}

@Composable
fun jdulparts(){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, top = 5.dp, bottom = 5.dp)
    ) {
        Text(text = stringResource(id = R.string.parts), fontSize = 20.sp, fontFamily = anekBold, color = hitamkren)
        Image(painter = painterResource(id = R.drawable.nismo), contentDescription = "logonismo",
            modifier = Modifier
                .width(110.dp)
                .height(30.dp)
                .padding(top = 1.dp)

        )
    }
}



@Composable
fun LazyVerticalGridExample(){
//    val list = createDataList()
    LaunchedEffect(
        Unit,
        block = {
            vmp.getPartsList()
        }
    )
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(start = 5.dp, top = 5.dp, end = 5.dp, bottom = 60.dp),
        content = {
//            items(list.size) {index ->
//                GridItem(testData = list[index], )
//            }
            items(vmp.partsList.size) { index ->
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
                            painter = rememberAsyncImagePainter(vmp.partsList[index].gambar),
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
                                text = vmp.partsList[index].judul, fontSize = 12.sp, color = Color.White, fontFamily = anekMedium,
                                modifier = Modifier.padding(top = 0.dp, start = 6.dp, end = 6.dp, bottom = 6.dp)

                            )
                            Text(
                                text = vmp.partsList[index].harga, fontSize = 10.sp, color = Color.White, fontFamily = anekLight,
                                modifier = Modifier.padding(top = 0.dp, start = 6.dp, end = 6.dp, bottom = 6.dp)

                            )
                        }



                    }
                }
            }
        })
}

//@Composable
//fun GridItem(testData: TestData){
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
//                painter = painterResource(id = testData.gambar),
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
//                    text = testData.judul, fontSize = 12.sp, color = Color.White, fontFamily = anekMedium,
//                    modifier = Modifier.padding(top = 0.dp, start = 6.dp, end = 6.dp, bottom = 6.dp)
//
//                )
//                Text(
//                    text = testData.harga, fontSize = 10.sp, color = Color.White, fontFamily = anekLight,
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

fun createDataList():List<TestData> {
    val list = mutableListOf<TestData>()

    list.add(TestData("LM GT4 Aluminum Road Wheel Machining Logo", R.drawable.pelkz,"IDR 90.000.000" ))
    list.add(TestData("NISSAN GT-R (R35) Nissan Genuine Brake Kit", R.drawable.kaliperz, "IDR 30.000.000"))
    list.add(TestData("GTR LMX6 Aluminum Road Wheel", R.drawable.velghitam, "IDR 50.000.000"))
    list.add(TestData("NISSAN Sports Titanium Muffler", R.drawable.mufflerputih,"IDR 20.000.000"))
    list.add(TestData("Nissan Elgrand E52 Titanium Muffler", R.drawable.mufflerhitam,"IDR 30.000.000"))
    list.add(TestData("NISSAN Seat Cover Set (Black & Red)", R.drawable.jokkofer, "IDR 15.000.000"))
    return list
}

data class TestData(
    val judul : String,
    val gambar : Int,
    val harga : String
)


@Preview(showBackground = true)
@Composable
fun DefaultzzzPreview() {
    PAM_ActivityIntentTheme {
        LazyVerticalGridExample()
    }
}

@Composable
fun ExpandableSearchView(
    searchDisplay: String,
    onSearchDisplayChanged: (String) -> Unit,
    onSearchDisplayClosed: () -> Unit,
    modifier: Modifier = Modifier,
    expandedInitially: Boolean = false,
    tint: Color = hitamkren
) {
    val (expanded, onExpandedChanged) = remember {
        mutableStateOf(expandedInitially)
    }


    Crossfade(targetState = expanded) { isSearchFieldVisible ->
        when (isSearchFieldVisible) {
            true -> ExpandedSearchView(
                searchDisplay = searchDisplay,
                onSearchDisplayChanged = onSearchDisplayChanged,
                onSearchDisplayClosed = onSearchDisplayClosed,
                onExpandedChanged = onExpandedChanged,
                modifier = modifier,
                tint = tint
            )

            false -> CollapsedSearchView(
                onExpandedChanged = onExpandedChanged,
                modifier = modifier,
                tint = tint
            )
        }
    }
}

@Composable
fun SearchIcon(iconTint: Color) {
    Icon(
        imageVector = Icons.Default.Search,
        contentDescription = "Search Icon",
        tint = hitamkren,
    )
}

@Composable
fun CollapsedSearchView(
    onExpandedChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    tint: Color = hitamkren,
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(coklatTua)
            .padding(start = 15.dp, end = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = painterResource(id = R.drawable.nism_o), contentDescription = "Logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        IconButton(onClick = { onExpandedChanged(true) }) {
            SearchIcon(iconTint = tint)
        }
    }
}

@Composable
fun ExpandedSearchView(
    searchDisplay: String,
    onSearchDisplayChanged: (String) -> Unit,
    onSearchDisplayClosed: () -> Unit,
    onExpandedChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    tint: Color = hitamkren,
) {
    val focusManager = LocalFocusManager.current

    val textFieldFocusRequester = remember { FocusRequester() }

    SideEffect {
        textFieldFocusRequester.requestFocus()
    }

    var textFieldValue by remember {
        mutableStateOf(TextFieldValue(searchDisplay, TextRange(searchDisplay.length)))
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(coklatTua),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {
            onExpandedChanged(false)
            onSearchDisplayClosed()
        }) {
            Image(painter = painterResource(id = R.drawable.nism_o), contentDescription = "Logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
            )
        }
        TextField(
            value = textFieldValue,
            onValueChange = {
                textFieldValue = it
                onSearchDisplayChanged(it.text)
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    tint = white,
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(textFieldFocusRequester)
                .background(hitamkren),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            )

        )
    }
}

//@Preview
//@Composable
//fun CollapsedSearchViewPreview() {
//    AppTheme {
//        Surface(
//            color = MaterialTheme.colors.primary
//        ) {
//            ExpandableSearchView(
//                searchDisplay = "",
//                onSearchDisplayChanged = {},
//                onSearchDisplayClosed = {}
//            )
//        }
//    }
//}
//
//@Preview
//@Composable
//fun ExpandedSearchViewPreview() {
//    AppTheme {
//        Surface(
//            color = MaterialTheme.colors.primary
//        ) {
//            ExpandableSearchView(
//                searchDisplay = "",
//                onSearchDisplayChanged = {},
//                expandedInitially = true,
//                onSearchDisplayClosed = {}
//            )
//        }
//    }
//}
