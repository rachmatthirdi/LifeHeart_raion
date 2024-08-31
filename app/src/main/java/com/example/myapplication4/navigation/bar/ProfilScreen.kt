package com.example.myapplication4.navigation.bar

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication4.AuthState
import com.example.myapplication4.AuthViewModel
import com.example.myapplication4.MainActivity
import com.example.myapplication4.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfilScreen(modifier: Modifier = Modifier,
                 navController: NavController,
                 authViewModel: AuthViewModel
) {

    val authState by authViewModel.authState.observeAsState()

    val back = Color(0xFFE984C6)
    var backnav = Color(0xFFF8D9ED)

    val fontMedium = FontFamily(Font(R.font.satoshi_medium))
    val fontRegular = FontFamily(Font(R.font.satoshi_regular))
    val fontBold = FontFamily(Font(R.font.satoshi_bold))


    LaunchedEffect(authState) {
        when (authState) {
            is AuthState.Unauthenticated -> {
                navController.navigate("login") {
                    popUpTo(navController.graph.startDestinationId) {
                        inclusive = true
                    }
                }
            }
            else -> Unit
        }
    }
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = back, // Replace 'back' with your desired color
                elevation = 0.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .shadow(1.dp)
            ) {
                Row {
                    Box(modifier = Modifier.padding(horizontal = 10.dp)) {
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
    )
    { innerPadding ->
        Column(
        modifier = modifier.padding(innerPadding)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { }
                .weight(4f)
                .padding(horizontal= 20.dp),
            shape = RoundedCornerShape(20.dp) ,
            colors = CardDefaults.cardColors(containerColor = backnav
            )
        ) {

            androidx.compose.material3.Button(
                onClick = {
                    navController.navigate("bpjs1")

                },
                colors =  ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .padding(15.dp , 5.dp)
                    .shadow(1.dp, RoundedCornerShape(20.dp))
            ) {
                androidx.compose.material3.Text(text = "Daftar Akun Premium BPJS" ,fontFamily = fontMedium, color = back, fontSize = 20.sp)
            }

            androidx.compose.material3.Button(
                onClick = {
                    authViewModel.logout()

                },
                colors =  ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .padding(15.dp , 5.dp)
                    .shadow(1.dp, RoundedCornerShape(20.dp))
            ) {
                androidx.compose.material3.Text(text = "Keluar Akun" ,fontFamily = fontMedium, color = back, fontSize = 20.sp)
            }


        }



    }}

}