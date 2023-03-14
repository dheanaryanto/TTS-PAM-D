package edu.uksw.fti.pam.pam_activityintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import edu.uksw.fti.pam.pam_activityintent.ui.screens.*
import edu.uksw.fti.pam.pam_activityintent.ui.theme.PAM_ActivityIntentTheme
import edu.uksw.fti.pam.pam_activityintent.ui.theme.coklatmuda

class AccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        setContent {
            PAM_ActivityIntentTheme {
                // A surface container using the 'background' color from the theme
                val firstname = getIntent().getStringExtra("firstname") ?: ""
                AccountScreen()
//                Column(
//                    modifier = Modifier
//                        .background(coklatmuda)
//                        .fillMaxSize()
//                        .verticalScroll(rememberScrollState())
//
//                ){
//                    atasan()
//                    juduldanlogo()
//                    namadanakun()
//                    dompet()
//                    order()
//                    settings()
//                    bawahan()
//                }

            }
        }
    }
}