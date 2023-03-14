package edu.uksw.fti.pam.pam_activityintent.ui.screens

import android.content.Intent
import android.media.Image
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.uksw.fti.pam.pam_activityintent.HomeActivity
import edu.uksw.fti.pam.pam_activityintent.R
import edu.uksw.fti.pam.pam_activityintent.contracts.SignUpContracts
import edu.uksw.fti.pam.pam_activityintent.doAuth
import edu.uksw.fti.pam.pam_activityintent.ui.theme.*

@Composable
fun LoginForm() {
    val lContext = LocalContext.current
    var usernameInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }

    val  getUsernameFromSignUpForm = rememberLauncherForActivityResult(
        contract = SignUpContracts(),
        onResult = {usernameInput = it!!}
    )

    Row(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp, end = 15.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Image(painter = painterResource(id = R.drawable.nism_o), contentDescription = "logonismo",
            modifier = Modifier
                .height(40.dp)

        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, top = 230.dp)
            .width(600.dp)

    ) {
        Text(
            text = stringResource(id = R.string.login) ,
            fontFamily = anekBold,
            fontSize = 40.sp
        )
        Column(verticalArrangement = Arrangement.spacedBy(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            TextField(value = usernameInput,
                onValueChange = {usernameInput = it},
                label = {
                    Text(text =  stringResource(id = R.string.label_username))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(cokz)

            )
            TextField(
                value = passwordInput,
                onValueChange = { passwordInput = it },
                label = { Text(text = stringResource(id = R.string.label_password)) },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(cokz)
            )
            Button(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp)),
                onClick = {
                    val isAuthenticated = doAuth(usernameInput, passwordInput)
                    if (isAuthenticated)
                        lContext.startActivity(
                            Intent(lContext, HomeActivity::class.java)
                                .apply {
                                    putExtra("username", usernameInput)
                                }
                        )
                }
            ){
                Text(text = stringResource(id = R.string.login), color = merahNismo,)
            }
            Divider(
                color = Color.White.copy(alpha = 0.3f),
                thickness = 1.dp,
                modifier = Modifier
                    .padding(top = 48.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = stringResource(id = R.string.lumpnya), color = white, fontFamily = anekMedium)
                TextButton(
                    onClick = {
                        getUsernameFromSignUpForm.launch("")
                    }
                ) {
                    Text(text = stringResource(R.string.signup), color = merahNismo, fontFamily = anekMedium)
                }
            }
        }

    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    PAM_ActivityIntentTheme {
//        LoginForm()
//    }
//}

//@Composable
//fun SetData(viewModel: MainViewModel) {
//    when (val result = viewModel.response.value) {
//        is DataState.Loading -> {
//            Box(
//                modifier = Modifier.fillMaxSize(),
//                contentAlignment = Alignment.Center
//            ) {
//                CircularProgressIndicator()
//            }
//        }
//        is DataState.Success -> {
//            ShowLazyList(result.data)
//        }
//        is DataState.Failure -> {
//            Box(
//                modifier = Modifier.fillMaxSize(),
//                contentAlignment = Alignment.Center
//            ) {
//                Text(
//                    text = result.message,
//                    fontSize = MaterialTheme.typography.h5.fontSize,
//                )
//            }
//        }
//        else -> {
//            Box(
//                modifier = Modifier.fillMaxSize(),
//                contentAlignment = Alignment.Center
//            ) {
//                Text(
//                    text = "Error Fetching data",
//                    fontSize = MaterialTheme.typography.h5.fontSize,
//                )
//            }
//        }
//    }
//}
//
//@Composable
//fun ShowLazyList(carts: MutableList<Cart>) {
//    LazyColumn {
//        items(carts) { cart ->
//            CardItem(cart)
//        }
//    }
//}
//
//@Composable
//fun CardItem(cart: Cart) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(150.dp)
//            .padding(10.dp)
//    ) {
//
//        Box(modifier = Modifier.fillMaxSize()) {
//            Text(
//                text = cart.judul!!
//            )
//            Text(
//                text = cart.harga!!
//            )
//            Text(
//                text = cart.hargadis!!
//            )
//
//        }
//
//    }
//}


