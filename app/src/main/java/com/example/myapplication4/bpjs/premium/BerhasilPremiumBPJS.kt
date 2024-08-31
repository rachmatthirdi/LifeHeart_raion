package com.example.myapplication4.bpjs.premium

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication4.R
import kotlinx.coroutines.delay

@Composable
fun BerhasilPremiumBPJS (navController: NavController){
    val fontMedium = FontFamily(Font(R.font.satoshi_medium))
    val fontRegular = FontFamily(Font(R.font.satoshi_regular))
    val fontBold = FontFamily(Font(R.font.satoshi_bold))
    val black = Color(0xFF000000)

    var showSplashScreen by remember { mutableStateOf(true) }

    LaunchedEffect(key1 = true) {
        delay(3000) // Waktu tampil (dalam milidetik)
        showSplashScreen = false
    }

    if (showSplashScreen) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(20.dp).fillMaxSize()) {

            Image(painter = painterResource(id = R.drawable.berhasil_bpjs), contentDescription = "HasilBPJS",
                modifier = Modifier.size(170.dp) )


            androidx.compose.material3.Text(
                "Selamat akun anda berhasil terdaftar premium kapitasi BPJS! ",
                fontFamily = fontBold,
                fontSize = 24.sp,
                color = black,
                textAlign= TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

        }
    } else {
        navController.navigate("main")
    }
}
