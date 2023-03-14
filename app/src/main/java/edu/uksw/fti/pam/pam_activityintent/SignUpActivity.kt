package edu.uksw.fti.pam.pam_activityintent

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import edu.uksw.fti.pam.pam_activityintent.ui.screens.SignUpForm
import edu.uksw.fti.pam.pam_activityintent.ui.theme.*
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class  SignUpActivity : ComponentActivity() {
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
                    SignUpForm(::sendUsernameBackToLogin)
                }
            }
        }
    }
    private fun sendUsernameBackToLogin(username: String?){
        val result = Intent().putExtra("username", username)
        setResult(Activity.RESULT_OK, result)
        finish()
    }

//    private fun sendfirstname(firstname: String?){
//        val result = Intent().putExtra("firstname", firstname)
//        setResult(Activity.RESULT_OK, result)
//        finish()
//    }
//
//    private fun sendlastname(lastname: String?){
//        val result = Intent().putExtra("lastname", lastname)
//        setResult(Activity.RESULT_OK, result)
//        finish()
//    }

}

