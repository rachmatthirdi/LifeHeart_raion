package com.example.myapplication4.navigation.bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.myapplication4.R

@Composable
fun Notification(navController: NavController){

    val back = Color(0xFFE984C6)

    val fontMedium = FontFamily(Font(R.font.satoshi_medium))
    val fontRegular = FontFamily(Font(R.font.satoshi_regular))
    val fontBold = FontFamily(Font(R.font.satoshi_bold))

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
            Row(modifier = Modifier.padding(top = 20.dp, bottom = 5.dp)) {
                Image(
                    modifier = Modifier
                        .size(30.dp)
                        .clickable {

                            navController.navigate("main")
                        },
                    painter = rememberImagePainter(R.drawable.arrow_left),
                    contentDescription = ""
                )

                androidx.compose.material3.Text(
                    "Notifikasi ",
                    fontFamily = fontBold,
                    fontSize = 17.sp,
                    color = Color.Black,
                    textAlign= TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )


            }
        }

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .weight(9f)) {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    //    .align(Alignment.CenterHorizontally)
                    .clickable { },
                shape = RoundedCornerShape(5.dp) ,
                colors = CardDefaults.cardColors(containerColor = back
                )
            ) {
                Row {

                    Box(modifier = Modifier.padding(10.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.ellipse_38),
                            contentDescription = "Left Image",
                            modifier = Modifier
                                .size(40.dp)
                                .align(Alignment.CenterStart)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.icon_notifcations),
                            contentDescription = "Image",
                            modifier = Modifier
                                .size(30.dp)
                                .align(Alignment.Center)
                        )
                    }


                    Column(
                        verticalArrangement = Arrangement.spacedBy(0.dp)
                    ) {
                        Text(
                            text = "LifeMedication Completed",
                            fontFamily = fontBold,
                            fontSize = 17.sp,
                            color = Color.White,
                            modifier = Modifier.align(Alignment.Start)
                        )
                        Text(
                            text = "Lorem ipsum dolor sit amet",
                            fontFamily = fontMedium,
                            fontSize = 12.sp,
                            color = Color.White,
                            modifier = Modifier.align(Alignment.Start)
                        )
                        Text(
                            text = "20 mins ago",
                            fontFamily = fontMedium,
                            fontSize = 12.sp,
                            color = Color.White,
                            modifier = Modifier.align(Alignment.Start)
                        )
                    }




                }
            }



        }
    }
}

