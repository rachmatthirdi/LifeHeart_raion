package com.example.myapplication4.navigation.bar

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.myapplication4.AuthState
import com.example.myapplication4.AuthViewModel
import com.example.myapplication4.MainActivity
import com.example.myapplication4.R

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    authViewModel: AuthViewModel
) {
    val fontMedium = FontFamily(Font(R.font.satoshi_medium))
    val fontRegular = FontFamily(Font(R.font.satoshi_regular))
    val fontBold = FontFamily(Font(R.font.satoshi_bold))

    val cardback = Color(0xFFE984C6)
    val cardbackdark = Color(0xFFAF6395)
    val cardbut = Color(0xFFFCEDF6)
    val cardbutdark = Color(0xFFFCEDF6)

    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        TopAppBar(
            backgroundColor = Color.Transparent,
            elevation = 0.dp,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .shadow(1.dp)
                .weight(1f)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp, bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Image(
                    painter = painterResource(id = R.drawable.lifeheart),
                    contentDescription = "Left Image",
                    modifier = Modifier
                        .size(90.dp)
                        .padding(start = 10.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.notif),
                    contentDescription = "Right Image",
                    modifier = Modifier
                        .size(25.dp)
                        .padding(end = 10.dp)
                        .clickable {navController.navigate("notif")}
                )
            }
        }

        androidx.compose.material3.Text(
            "Hai Username!",
            fontFamily = fontBold,
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier
                .weight(0.5f)
                .padding(horizontal = 10.dp)
                .padding(top = 10.dp)
                .align(Alignment.Start)
        )


        val scrollState = rememberScrollState()

        Row(
            modifier = Modifier
                .weight(3f)
                .horizontalScroll(scrollState)
                .fillMaxWidth()            ,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.img_3),
                contentDescription = "Red Square",
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .size(380.dp),
                alignment = Alignment.Center

            )
            Image(
                painter = painterResource(id = R.drawable.img_4),
                contentDescription = "Red Square",
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .size(380.dp),
                alignment = Alignment.Center

            )
            Image(
                painter = painterResource(id = R.drawable.img_5),
                contentDescription = "Red Square",
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .size(380.dp),
                alignment = Alignment.Center

            )

        }

        Card(
            modifier = Modifier
                .weight(3f)
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(containerColor = cardback)
        ) {
            Text(
                text = "LifeTrack",
                fontFamily = fontBold,
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 5.dp)
                    .weight(1f)
            )
            Text(
                text = "Lorem ipsum dolor sit amet consectetur. Dolor interdum odio quam sed aliquam.",
                fontFamily = fontBold,
                fontSize = 12.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, bottom = 5.dp)

                    .weight(1f)
            )

            Card(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .clickable { navController.navigate("ikutTes")
                               },
                colors = CardDefaults.cardColors(containerColor = cardbut)
            ) {
                Text(
                    text = "Ikuti Tes",
                    fontFamily = fontBold,
                    fontSize = 14.sp,
                    color = cardback,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }

        Card(
            modifier = Modifier
                .weight(3f)
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(containerColor = cardbackdark)
        ) {
            Text(
                text = "LifeMedication",
                fontFamily = fontBold,
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 5.dp)
                    .weight(1f)
            )
            Text(
                text = "Lorem ipsum dolor sit amet consectetur. Dolor interdum odio quam sed aliquam.",
                fontFamily = fontBold,
                fontSize = 12.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, bottom = 5.dp)

                    .weight(1f)
            )

            Card(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .clickable { navController.navigate("ikutTes") },
                colors = CardDefaults.cardColors(containerColor = cardbutdark)
            ) {
                Text(
                    text = "Ikuti Tes",
                    fontFamily = fontBold,
                    fontSize = 14.sp,
                    color = cardbackdark,
                    modifier = Modifier.align(Alignment.CenterHorizontally)

                )
            }
        }

        Spacer(modifier = Modifier.weight(2f))



    }
}