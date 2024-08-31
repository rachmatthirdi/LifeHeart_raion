package com.example.myapplication4

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.myapplication4.ui.theme.MyApplication4Theme
import kotlinx.coroutines.delay

@Composable
fun OnboardingPage(navController: NavController, page: Int) {

    val fontReguler = FontFamily(Font(R.font.satoshi_regular))
    val fontBold = FontFamily(Font(R.font.satoshi_bold))
    val fontMedium = FontFamily(Font(R.font.satoshi_medium))
    val pinkColor = Color(0xFFE984C6)
    val whiteColor = Color(0xFFFAFAFA)
    val pageNumberText = page.toString()
    val pageNumberWord = when (page) {
        1 -> ""
        2 -> ""
        3 -> ""
        4 -> ""
        5 -> ""
        else -> ""


    }

        if(page == 1){
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                        contentAlignment = Alignment.Center
            ) {
                val imageResId = R.drawable.img_6 // Ganti dengan resource ID gambar

                var showSplashScreen by remember { mutableStateOf(true) }

                LaunchedEffect(key1 = true) {
                    delay(3000) // Waktu tampil (dalam milidetik)
                    showSplashScreen = false
                }

                if (showSplashScreen) {
                    Image(
                        painter = painterResource(id = imageResId),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        alignment = Alignment.Center
                    )
                } else {
                    navController.navigate("onboarding/2")
                }
            }
        }else if(page == 2){

            val imageResId = R.drawable.ob2

            Column(
                modifier = Modifier
                    .fillMaxSize()

            ) {
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(0.6f),
                    alignment = Alignment.TopCenter
                )

                Text("Selamat Datang di LifeHeart!",
                    fontFamily = fontBold,
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp)
                        .weight(0.05f),
                    textAlign = TextAlign.Center)

                Text("Selamat datang di solusi kesehatan jantung yang komprehensif. LifeHeart dirancang untuk membantu Anda memahami kondisi jantung dengan presisi.",
                    fontFamily = fontReguler,
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp)
                        .weight(0.15f),
                    textAlign = TextAlign.Center)


                Row(modifier = Modifier
                    .fillMaxSize()
                    .weight(0.08f),
                    verticalAlignment = Alignment.Top
                ) {
                    androidx.compose.material3.Text(
                        "",
                        fontFamily = fontBold,
                        fontSize = 14.sp,
                        modifier = Modifier
                            .weight(0.3f)
                            .size(20.dp),
                        textAlign= TextAlign.Center)

                    Image(
                        painter = painterResource(id = R.drawable.ob2p1),
                        contentDescription = "page1",
                        modifier = Modifier
                            .padding(7.dp)
                            .weight(0.4f),
                        alignment = Alignment.Center
                    )

                    androidx.compose.material3.Text(
                        "Next",
                        fontFamily = fontBold,
                        fontSize = 14.sp,
                        modifier = Modifier
                            .size(20.dp)
                            .weight(0.3f)
                            .clickable { navController.navigate("onboarding/3") },
                        textAlign= TextAlign.Center)
                }


            }


        }else if(page == 3){

            val imageResId = R.drawable.ob3

            Column(
                modifier = Modifier
                    .fillMaxSize()

            ) {
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(0.6f),
                    alignment = Alignment.TopCenter
                )

                Text("Analisis Jantung Mendalam",
                    fontFamily = fontBold,
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp)
                        .weight(0.05f),
                    textAlign = TextAlign.Center)

                Text("Manfaatkan analisis mendalam untuk memantau kesehatan jantung Anda dan membuat keputusan yang tepat.",
                    fontFamily = fontReguler,
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp)
                        .weight(0.15f),
                    textAlign = TextAlign.Center)


                Row(modifier = Modifier
                    .fillMaxSize()
                    .weight(0.08f),
                    verticalAlignment = Alignment.Top
                ) {
                    androidx.compose.material3.Text(
                        "Prev",
                        fontFamily = fontBold,
                        fontSize = 14.sp,
                        modifier = Modifier
                            .weight(0.3f)
                            .size(20.dp)
                            .clickable { navController.navigate("onboarding/2") },
                        textAlign= TextAlign.Center)

                    Image(
                        painter = painterResource(id = R.drawable.ob3p2),
                        contentDescription = "page1",
                        modifier = Modifier
                            .padding(7.dp)
                            .weight(0.4f),
                        alignment = Alignment.Center
                    )

                    androidx.compose.material3.Text(
                        "Next",
                        fontFamily = fontBold,
                        fontSize = 14.sp,
                        modifier = Modifier
                            .size(20.dp)
                            .weight(0.3f)
                            .clickable { navController.navigate("onboarding/4") },
                        textAlign= TextAlign.Center)
                }


            }


        }else if(page == 4){

            val imageResId = R.drawable.ob4

            Column(
                modifier = Modifier
                    .fillMaxSize()

            ) {
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(0.34f),
                    alignment = Alignment.TopCenter
                )

                Text("Rekomendasi Gaya Hidup Sehat",
                    fontFamily = fontBold,
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp)
                        .weight(0.03f),
                    textAlign = TextAlign.Center)

                Text("Peroleh rekomendasi gaya hidup seperti pola makan, rutinitas olahraga, dan kebiasaan sehat lainnya yang dirancang khusus untuk kebutuhan kesehatan jantung Anda.",
                    fontFamily = fontReguler,
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 10.dp , vertical = 5.dp)
                        .weight(0.08f),
                    textAlign = TextAlign.Center)

                androidx.compose.material3.Button(
                    onClick = {
                        navController.navigate("login")

                    },
                    colors =  ButtonDefaults.buttonColors(pinkColor),
                    modifier = Modifier
                        .weight(0.05f)
                        .clip(RoundedCornerShape(20.dp))
                        .fillMaxWidth()
                        .padding(15.dp , 5.dp)
                ) {
                    androidx.compose.material3.Text(text = "Masuk",fontFamily = fontMedium, color = whiteColor, fontSize = 20.sp)
                }

                androidx.compose.material3.Button(
                    onClick = {
                        navController.navigate("Register")

                    },
                    colors =  ButtonDefaults.buttonColors(whiteColor),
                    modifier = Modifier
                        .weight(0.04f)
                        .clip(RoundedCornerShape(20.dp))
                        .fillMaxWidth()
                        .padding(15.dp , 5.dp)
                        .shadow(2.dp, RoundedCornerShape(20.dp))
                ) {
                    androidx.compose.material3.Text(text = "Daftar" ,fontFamily = fontMedium, color = pinkColor, fontSize = 20.sp)
                }



                Row(modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp)
                    .weight(0.055f),
                    verticalAlignment = Alignment.Top
                ) {
                    androidx.compose.material3.Text(
                        "Prev",
                        fontFamily = fontBold,
                        fontSize = 14.sp,
                        modifier = Modifier
                            .weight(0.3f)
                            .size(20.dp)
                            .clickable { navController.navigate("onboarding/3") },
                        textAlign= TextAlign.Center)

                    Image(
                        painter = painterResource(id = R.drawable.ob4p3),
                        contentDescription = "page1",
                        modifier = Modifier
                            .padding(7.dp)
                            .weight(0.4f),
                        alignment = Alignment.Center
                    )



                    androidx.compose.material3.Text(
                        "",
                        fontFamily = fontBold,
                        fontSize = 14.sp,
                        modifier = Modifier
                            .size(20.dp)
                            .weight(0.3f),
                        textAlign= TextAlign.Center)
                }


            }


        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize() // Membuat Box memenuhi ukuran layar
            ) {
                Button(
                    onClick = {
                        navController.navigate("login")
                    },
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 10.dp) // Margin bawah 10.dp
                ) {
                    Text("Ke Login")
                }
            }
        }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplication4Theme {
        val navController = rememberNavController()
        OnboardingPage(navController, 4)
    }
}