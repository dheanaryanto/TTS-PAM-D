package edu.uksw.fti.pam.pam_activityintent

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import edu.uksw.fti.pam.pam_activityintent.contracts.SignUpContracts
import edu.uksw.fti.pam.pam_activityintent.ui.screens.LoginForm
import edu.uksw.fti.pam.pam_activityintent.ui.theme.*
import kotlinx.coroutines.launch
import kotlin.contracts.contract

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PAM_ActivityIntentTheme {
                // A surface container using the 'background' color from the theme
                Card(
                    modifier = Modifier
                        .background(coklatTua)
                        .fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bgsatu),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(5.dp)),
                        contentScale = ContentScale.Crop
                    )
                    LoginForm()
                }
            }
        }
    }
}

internal fun doAuth(
    username: String,
    password: String
):Boolean{
    return(username.equals("admin") && password.equals("admin"))
}

//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.viewModels
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.*
//import androidx.compose.ui.graphics.Color
//import edu.uksw.fti.pam.pam_activityintent.ui.screens.SetData
//import edu.uksw.fti.pam.pam_activityintent.ui.theme.PAM_ActivityIntentTheme
//import edu.uksw.fti.pam.pam_activityintent.viewmodels.MainViewModel
//
//class MainActivity : ComponentActivity() {
//
//    private val viewModel: MainViewModel by viewModels()
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            PAM_ActivityIntentTheme {
//                Column {
//                    TopAppBar(
//                        title = {
//                            Text(text = "Food Categories")
//                        },
//                        backgroundColor = Color.Black,
//                        contentColor = Color.White
//
//                    )
//
//                    SetData(viewModel)
//
//                }
//            }
//        }
//    }
//}
//
//
