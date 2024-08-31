package com.example.myapplication4.login.register

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication4.AuthState
import com.example.myapplication4.AuthViewModel
import com.example.myapplication4.OnboardingPage
import com.example.myapplication4.R
import com.example.myapplication4.ui.theme.MyApplication4Theme

@Composable
fun LoginScreen(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel) {

    var email by remember{
        mutableStateOf("")
    }
    var password by remember{
        mutableStateOf("")
    }

    val back = Color(0xFFE984C6)
    var backnav = Color(0xFFF8D9ED)

    val fontMedium = FontFamily(Font(R.font.satoshi_medium))
    val fontRegular = FontFamily(Font(R.font.satoshi_regular))
    val fontBold = FontFamily(Font(R.font.satoshi_bold))


    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Authenticated -> navController.navigate("main")
            is AuthState.Error -> Toast.makeText(context,
                (authState.value as AuthState.Error).message, Toast.LENGTH_SHORT).show()
            is AuthState.PasswordResetSent -> Toast.makeText(
                context,
                (authState.value as AuthState.PasswordResetSent).message,
                Toast.LENGTH_SHORT
            ).show()
            else -> Unit
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(painter = painterResource(id = R.drawable.img_1), contentDescription = "login image",
            modifier = Modifier.size(250.dp), alignment = Alignment.TopStart )

        Text("Login", fontSize = 28.sp, fontWeight = FontWeight.Bold )

        Spacer(modifier = Modifier.height(4.dp))

        Text(text = "Login to your account")

        OutlinedTextField(shape = RoundedCornerShape(10.dp) ,value = email, onValueChange = {email = it}, label = {
            Text(text = "Email address")
        } )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = password,shape = RoundedCornerShape(10.dp) , onValueChange = {password = it}, label = {
            Text(text = "Password")
        }, visualTransformation = PasswordVisualTransformation() )

        Spacer(modifier = Modifier.height(10.dp))

        androidx.compose.material3.Button(
            onClick = {
                authViewModel.login(email,password)
            },
            colors =  ButtonDefaults.buttonColors(back),
            enabled = authState.value != AuthState.Loading,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .padding(15.dp , 5.dp)
                .shadow(1.dp, RoundedCornerShape(20.dp))
        ) {
            androidx.compose.material3.Text(text = "Login" ,fontFamily = fontMedium, color = Color.White, fontSize = 20.sp)
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text("lupa password", fontSize = 12.sp,  modifier = Modifier.clickable {
            if (email.isNotEmpty()) {
                authViewModel.resetPassword(email)

            } else {
                Toast.makeText(context, "Please enter your email address first", Toast.LENGTH_SHORT).show()
            }
        } )

        Spacer(modifier = Modifier.height(10.dp))

        Text("Register", fontSize = 12.sp, modifier= Modifier.clickable { navController.navigate("register") } )

    }

}
//
//@Preview(showBackground = true)
//@Composable
//fun LoginScreenPreview() {
//    MyApplication4Theme {
//        val navController = rememberNavController()
//        val authViewModel = AuthViewModel()
//        val modifier= Modifier
//        LoginScreen( modifier,navController,authViewModel)
//    }
//}