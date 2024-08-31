package com.example.myapplication4.navigation.bar
import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication4.AuthState
import com.example.myapplication4.AuthViewModel
import com.example.myapplication4.R

@Composable
fun IkutiTes(
    modifier: Modifier = Modifier,
    navController: NavController,
    authViewModel: AuthViewModel
) {

    val authState by authViewModel.authState.observeAsState()

    val back = Color(0xFFE984C6)
    val backnav = Color(0xFFF8D9ED)


    val fontMedium = FontFamily(Font(R.font.satoshi_medium))
    val fontRegular = FontFamily(Font(R.font.satoshi_regular))
    val fontBold = FontFamily(Font(R.font.satoshi_bold))

    var isLatihanDone: String? by remember { mutableStateOf(null) }
    var isMerokokDone: String? by remember { mutableStateOf(null) }
    var isDadaDone: String? by remember { mutableStateOf(null) }
    var isSesakDone: String? by remember { mutableStateOf(null) }
    var isBatukDone: String? by remember { mutableStateOf(null) }
    var tombolAktif:Boolean by remember{ mutableStateOf(false) }
    if(isLatihanDone != null && isMerokokDone != null && isDadaDone != null && isSesakDone != null && isBatukDone != null){
        tombolAktif = true
    }


    LaunchedEffect(authState) {
        when (authState) {
            is AuthState.Unauthenticated -> {
                // This block can be used if you want to handle unauthenticated state differently
            }
            else -> Unit
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = back,
                elevation = 0.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .shadow(1.dp)
            ) {
                Row {
                    Box(modifier = Modifier.padding(horizontal = 10.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.arrow_left),
                            contentDescription = "Left Image",
                            modifier = Modifier
                                .size(30.dp)
                                .align(Alignment.CenterStart)
                                .clickable { navController.navigate("main") }
                        )
                    }
                }
            }
        },
        bottomBar = {
            BottomAppBar(
                content = {
                    androidx.compose.material3.Button(
                        onClick = {
                            if (tombolAktif) {
                                navController.navigate("main")
                            }
                        },
                        enabled = tombolAktif,
                        colors = androidx.compose.material3.ButtonDefaults.buttonColors(back),
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .fillMaxWidth()
                    ) {
                        Text(text = "Masuk")
                    }
                },
                containerColor = backnav,
                contentColor = Color.Gray
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {



            OutlinedCard(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                border = BorderStroke(2.dp, back)
            ) {
                var backgroundColor by remember { mutableStateOf(Color.White) }

                Column {
                    Text(
                        text = "1. Latihan ?",
                        fontFamily = fontBold,
                        fontSize = 12.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .padding(top = 10.dp)
                            .fillMaxWidth()
                    )
                    OutlinedButton(
                        onClick = {
                            isLatihanDone = "ya"},
                        shape = RoundedCornerShape(10.dp),
                        border = BorderStroke(2.dp,back ),
                        modifier = Modifier
                            .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.outlinedButtonColors(
                            backgroundColor = if (isLatihanDone == "ya") back else Color.Transparent )
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Text(
                                text = "Ya",
                                fontFamily = fontRegular,
                                fontSize = 12.sp,
                                color = Color.Black
                            )
                        }
                    }
                    OutlinedButton(
                        onClick = {
                            isLatihanDone = "tidak" },
                        shape = RoundedCornerShape(10.dp),
                        border = BorderStroke(2.dp, back),
                        modifier = Modifier
                            .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.outlinedButtonColors(
                            backgroundColor = if (isLatihanDone == "tidak") back else Color.Transparent)

                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Text(
                                text = "Tidak",
                                fontFamily = fontRegular,
                                fontSize = 12.sp,
                                color = Color.Black
                            )
                        }
                    }
                }
            }

            OutlinedCard(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                border = BorderStroke(2.dp, back)
            ) {
                var backgroundColor by remember { mutableStateOf(Color.White) }

                Column {
                    Text(
                        text = "2. Merokok ?",
                        fontFamily = fontBold,
                        fontSize = 12.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .padding(top = 10.dp)
                            .fillMaxWidth()
                    )
                    OutlinedButton(
                        onClick = {
                            isMerokokDone = "ya"},
                        shape = RoundedCornerShape(10.dp),
                        border = BorderStroke(2.dp,back ),
                        modifier = Modifier
                            .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.outlinedButtonColors(
                            backgroundColor = if (isMerokokDone == "ya") back else Color.Transparent )
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Text(
                                text = "Ya",
                                fontFamily = fontRegular,
                                fontSize = 12.sp,
                                color = Color.Black
                            )
                        }
                    }
                    OutlinedButton(
                        onClick = {
                            isMerokokDone = "tidak" },
                        shape = RoundedCornerShape(10.dp),
                        border = BorderStroke(2.dp, back),
                        modifier = Modifier
                            .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.outlinedButtonColors(
                            backgroundColor = if (isMerokokDone == "tidak" ) back else Color.Transparent)

                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Text(
                                text = "Tidak",
                                fontFamily = fontRegular,
                                fontSize = 12.sp,
                                color = Color.Black
                            )
                        }
                    }
                }
            }

            OutlinedCard(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                border = BorderStroke(2.dp, back)
            ) {
                var backgroundColor by remember { mutableStateOf(Color.White) }

                Column {
                    Text(
                        text = "3. Dada kiri ditekan sakit ?",
                        fontFamily = fontBold,
                        fontSize = 12.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .padding(top = 10.dp)
                            .fillMaxWidth()
                    )
                    OutlinedButton(
                        onClick = {
                            isDadaDone = "ya" },
                        shape = RoundedCornerShape(10.dp),
                        border = BorderStroke(2.dp,back ),
                        modifier = Modifier
                            .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.outlinedButtonColors(
                            backgroundColor = if (isDadaDone == "ya" ) back else Color.Transparent )
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Text(
                                text = "Ya",
                                fontFamily = fontRegular,
                                fontSize = 12.sp,
                                color = Color.Black
                            )
                        }
                    }
                    OutlinedButton(
                        onClick = {
                            isDadaDone = "tidak"   },
                        shape = RoundedCornerShape(10.dp),
                        border = BorderStroke(2.dp, back),
                        modifier = Modifier
                            .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.outlinedButtonColors(
                            backgroundColor = if (isDadaDone == "tidak"  ) back else Color.Transparent)

                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Text(
                                text = "Tidak",
                                fontFamily = fontRegular,
                                fontSize = 12.sp,
                                color = Color.Black
                            )
                        }
                    }
                }
            }

            OutlinedCard(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                border = BorderStroke(2.dp, back)
            ) {
                var backgroundColor by remember { mutableStateOf(Color.White) }

                Column {
                    Text(
                        text = "4. Sesak nafas ?",
                        fontFamily = fontBold,
                        fontSize = 12.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .padding(top = 10.dp)
                            .fillMaxWidth()
                    )
                    OutlinedButton(
                        onClick = {
                            isSesakDone = "ya" },
                        shape = RoundedCornerShape(10.dp),
                        border = BorderStroke(2.dp,back ),
                        modifier = Modifier
                            .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.outlinedButtonColors(
                            backgroundColor = if (isSesakDone == "ya" ) back else Color.Transparent )
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Text(
                                text = "Ya",
                                fontFamily = fontRegular,
                                fontSize = 12.sp,
                                color = Color.Black
                            )
                        }
                    }
                    OutlinedButton(
                        onClick = {
                            isSesakDone = "tidak"  },
                        shape = RoundedCornerShape(10.dp),
                        border = BorderStroke(2.dp, back),
                        modifier = Modifier
                            .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.outlinedButtonColors(
                            backgroundColor = if (isSesakDone == "tidak" ) back else Color.Transparent)

                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Text(
                                text = "Tidak",
                                fontFamily = fontRegular,
                                fontSize = 12.sp,
                                color = Color.Black
                            )
                        }
                    }
                }
            }

            OutlinedCard(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                border = BorderStroke(2.dp, back)
            ) {
                var backgroundColor by remember { mutableStateOf(Color.White) }

                Column {
                    Text(
                        text = "5. Batuk Berdahak ?",
                        fontFamily = fontBold,
                        fontSize = 12.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .padding(top = 10.dp)
                            .fillMaxWidth()
                    )
                    OutlinedButton(
                        onClick = {
                            isBatukDone = "ya" },
                        shape = RoundedCornerShape(10.dp),
                        border = BorderStroke(2.dp,back ),
                        modifier = Modifier
                            .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.outlinedButtonColors(
                            backgroundColor = if (isBatukDone == "ya" ) back else Color.Transparent )
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Text(
                                text = "Ya",
                                fontFamily = fontRegular,
                                fontSize = 12.sp,
                                color = Color.Black
                            )
                        }
                    }
                    OutlinedButton(
                        onClick = {
                            isBatukDone = "tidak"  },
                        shape = RoundedCornerShape(10.dp),
                        border = BorderStroke(2.dp, back),
                        modifier = Modifier
                            .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.outlinedButtonColors(
                            backgroundColor = if (isBatukDone == "tidak" ) back else Color.Transparent)

                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Text(
                                text = "Tidak",
                                fontFamily = fontRegular,
                                fontSize = 12.sp,
                                color = Color.Black
                            )
                        }
                    }
                }
            }
        }
    }
}
