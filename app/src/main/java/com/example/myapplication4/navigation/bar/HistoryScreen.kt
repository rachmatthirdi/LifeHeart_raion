package com.example.myapplication4.navigation.bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.myapplication4.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(modifier: Modifier = Modifier) {

    val back = Color(0xFFE984C6)

    val fontMedium = FontFamily(Font(R.font.satoshi_medium))
    val fontRegular = FontFamily(Font(R.font.satoshi_regular))
    val fontBold = FontFamily(Font(R.font.satoshi_bold))

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        CenterAlignedTopAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .shadow(1.dp),
            title = {
                Text(
                    text = "Riwayat",
                    fontFamily = fontBold,
                    fontSize = 20.sp,
                    color = Color.Black
                )
            }
        )


        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .weight(9f)) {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .height(100.dp)
                    .padding(20.dp)
                    .clickable { },

                shape = RoundedCornerShape(5.dp) ,
                colors = CardDefaults.cardColors(containerColor = back
                )
            ) {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.riwayat1),
                        contentDescription = "Left Image",
                        modifier = Modifier
                            .weight(2f)
                            .size(40.dp)
                            .padding(10.dp)
                    )



                    Column(
                        verticalArrangement = Arrangement.spacedBy(0.dp),
                        modifier = Modifier.weight(8f)
                    ) {
                        Text(
                            text = "Endokarditis",
                            fontFamily = fontMedium,
                            fontSize = 12.sp,
                            color = Color.Black,
                            modifier = Modifier.align(Alignment.Start)
                        )
                        Text(
                            text = "Aug 18 - Aug 18",
                            fontFamily = fontBold,
                            fontSize = 17.sp,
                            color = Color.Black,
                            modifier = Modifier.align(Alignment.Start)
                        )
                    }


                    Image(
                        painter = painterResource(id = R.drawable.back_history),
                        contentDescription = "Right Image",
                        modifier = Modifier
                            .size(35.dp)
                            .weight(2f)
                            .padding(end = 10.dp)
                    )

                }
            }



        }
    }


}