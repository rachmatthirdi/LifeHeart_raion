package com.example.myapplication4.login.register

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication4.AuthViewModel
import com.example.myapplication4.ui.theme.MyApplication4Theme

@Composable
fun OTPScreen(navController: NavController , authViewModel: AuthViewModel
) {
    var OTP1 by remember { mutableStateOf("") }
    var OTP2 by remember { mutableStateOf("") }
    var OTP3 by remember { mutableStateOf("") }
    var OTP4 by remember { mutableStateOf("") }
    var OTP5 by remember { mutableStateOf("") }
    var OTP6 by remember { mutableStateOf("") }
    var OTP = OTP1+OTP2+OTP3+OTP4+OTP5+OTP6
    val context = LocalContext.current

    val pinkColor = Color(0xFFE984C6)
    val grayColor = Color(0xFFBCBCBC)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Masukkan OTP", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Kode OTP sudah dikirimkan melalui email anda", fontSize = 14.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))


        Text(text = "05:00", fontSize = 30.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))



        Row( modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)){
            OutlinedTextField(
                modifier = Modifier
                    . weight(0.2f)
                    .padding(5.dp),
                value = OTP1,
                onValueChange = { OTP1 = it },
                label = { Text(text = "") }
            )

            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                modifier = Modifier
                    .weight(0.2f)
                    .padding(5.dp),
                value = OTP2,
                onValueChange = { OTP2 = it },
                label = { Text(text = "") }
            )

            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                modifier = Modifier
                    .weight(0.2f)
                    .padding(5.dp),
                value = OTP3,
                onValueChange = { OTP3 = it },
                label = { Text(text = "") }
            )

            Spacer(modifier = Modifier.height(5.dp))

            OutlinedTextField(
                modifier = Modifier
                    .weight(0.2f)
                    .padding(5.dp),
                value = OTP4,
                onValueChange = { OTP4 = it },
                label = { Text(text = "") }
            )

            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                modifier = Modifier
                    .weight(0.2f)
                    .padding(5.dp),
                value = OTP5,
                onValueChange = { OTP5 = it },
                label = { Text(text = "") }
            )

            Spacer(modifier = Modifier.height(5.dp))

            OutlinedTextField(
                modifier = Modifier
                    .weight(0.2f)
                    .padding(5.dp),
                value = OTP6,
                onValueChange = { OTP6 = it },
                label = { Text(text = "") }
            )

        }


        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (OTP.isNotEmpty()) {
                navController.navigate("main")
            } else {
                Toast.makeText(context, "Please enter your OTP", Toast.LENGTH_SHORT).show()
            }
        },
            enabled = OTP1.isNotEmpty() && OTP2.isNotEmpty() && OTP3.isNotEmpty()&&OTP4.isNotEmpty() && OTP5.isNotEmpty() && OTP6.isNotEmpty(),
            colors = ButtonDefaults.buttonColors(
                if (OTP1.isNotEmpty() && OTP2.isNotEmpty() && OTP3.isNotEmpty()&&OTP4.isNotEmpty() && OTP5.isNotEmpty() && OTP6.isNotEmpty()) pinkColor else grayColor
            ), modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .fillMaxWidth()
        ) {
            Text(text = "Verifikasi")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "KIRIM ULANG OTP", fontSize = 14.sp, fontWeight = FontWeight.Bold)

    }
}

//@Preview(showBackground = true)
//@Composable
//fun OTPScreenPreview() {
//    // You can create a mock NavController and AuthViewModel for the preview
//    val navController = rememberNavController()
//    val modifier = Modifier
//    OTPScreen(navController)
//}