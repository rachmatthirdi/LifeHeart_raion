package com.example.myapplication4.login.register

//
//import android.util.Log
//import android.widget.Toast
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
//import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication4.AuthState
//import com.example.myapplication4.AuthState
//import androidx.lifecycle.ViewModel
import com.example.myapplication4.R
import com.example.myapplication4.AuthViewModel
//import com.example.myapplication4.ui.theme.MyApplication4Theme

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.TextField
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel
) {

    //warna
    val pinkColor = Color(0xFFE984C6)
    val grayColor = Color(0xFFBCBCBC)
//
//    val calendar = Calendar.getInstance()
//    val year = calendar.get(Calendar.YEAR)
//    val month = calendar.get(Calendar.MONTH)
//    val day = calendar.get(Calendar.DAY_OF_MONTH)

    val dateState = remember { mutableStateOf("") }
    val showDatePicker = remember { mutableStateOf(false) }

    val fontReguler = FontFamily(Font(R.font.satoshi_regular))

    var username by remember{
        mutableStateOf("")
    }
    var nomor1 by remember{
        mutableStateOf("")
    }
    var nomor2 by remember{
        mutableStateOf("")
    }
    var hasil by remember{
        mutableStateOf("")
    }
    hasil =nomor1+nomor2


    var email by remember{
        mutableStateOf("")
    }
    var lahir by remember{
        mutableStateOf("")
    }

    // gender
    var gender by remember{
        mutableStateOf("")
    }
    val genderOptions = listOf("Laki-laki", "Perempuan")
    var expanded by remember { mutableStateOf(false) }
    var selectedGender by remember { mutableStateOf(genderOptions[0]) }

    var lokasi by remember{
        mutableStateOf("")
    }
    var password by remember{
        mutableStateOf("")
    }

    var isShowDialog by remember {
        mutableStateOf(false)
    }
    var selectedDate by remember {
        mutableStateOf("")
    }

    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(authState.value) {
        when (authState.value) {
            is AuthState.Authenticated -> navController.navigate("home")
            is AuthState.Error -> Toast.makeText(context, (authState.value as AuthState.Error).message, Toast.LENGTH_SHORT).show()

            else -> Unit
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(painter = painterResource(id = R.drawable.img_2), contentDescription = "login image",
            modifier = Modifier.size(200.dp) )

//        Text("Register", fontSize = 28.sp, fontWeight = FontWeight.Bold )
//
//        Spacer(modifier = Modifier.height(4.dp))
//
//        Text(text = "Login to your account")
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = username,shape = RoundedCornerShape(20.dp) , onValueChange = {username = it}, modifier = Modifier.fillMaxWidth(), label = {
            Text(text = "username")
        } )
        Spacer(modifier = Modifier.height(10.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            OutlinedTextField(value = nomor1, onValueChange = {nomor1 = it},shape = RoundedCornerShape(20.dp) ,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
                label = {
                    Text(text = "+62")
                } )
            OutlinedTextField(value = nomor2, onValueChange = {nomor2 = it},shape = RoundedCornerShape(20.dp) ,
                modifier = Modifier
                    .weight(2f)
                    .padding(start = 8.dp),
                label = {
                    Text(text = "Masukkan nomor telepon")
                } )
        }


        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = email, onValueChange = {email = it},shape = RoundedCornerShape(20.dp) , modifier = Modifier.fillMaxWidth(), label = {
            Text(text = "Email address")
        } )

        Spacer(modifier = Modifier.width(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier

                    .weight(0.5f)
                    .clickable { showDatePicker.value = true }
            ) {
                OutlinedTextField(
                    value = selectedDate,shape = RoundedCornerShape(20.dp) ,
                    onValueChange = {},
                    label = { Text("Tanggal Lahir") },
                    readOnly = true,
                )
                Image(
                    painter = painterResource(id = R.drawable.calendar), // Gambar kalender
                    contentDescription = "Kalender",
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 5.dp)
                        .size(25.dp)
                        .clickable { isShowDialog = true } // Arahkan ke fungsi datepicked
                )
                if (isShowDialog) {
                    DatePickerDialog(
                        onDismiss = {
                            isShowDialog = false
                        },
                        onConfirm = {
                            selectedDate = it
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.width(5.dp))

            ExposedDropdownMenuBox(
                modifier = Modifier.weight(0.5f),
                expanded = expanded,
                onExpandedChange = { expanded = !expanded },
            ) {
                OutlinedTextField(shape = RoundedCornerShape(20.dp),
                        modifier = Modifier.menuAnchor(),
                    readOnly = true,
                    value = selectedGender,
                    onValueChange = {},
                    label = { Text("Pilih Gender") },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    colors = ExposedDropdownMenuDefaults.textFieldColors()
                )

                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                ) {
                    genderOptions.forEach { gender ->
                        DropdownMenuItem(
                            onClick = {
                                selectedGender = gender
                                expanded = false
                            }
                        ) {
                            Text(gender)
                        }
                    }
                }
            }
        }


        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = lokasi, onValueChange = {lokasi = it}, modifier = Modifier.fillMaxWidth(), label = {
            Text(text = "lokasi")
        },shape = RoundedCornerShape(20.dp) )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = password, onValueChange = {password = it}, modifier = Modifier.fillMaxWidth(), label = {
            Text(text = "Password")
        },shape = RoundedCornerShape(20.dp) , visualTransformation = PasswordVisualTransformation() )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                    authViewModel.register(username, email, password)
                    navController.navigate("otp")
                }
            },
            enabled = username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty(),
            colors = ButtonDefaults.buttonColors(
                if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) pinkColor else grayColor
            ), modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .fillMaxWidth()
        ) {
            Text(text = "Buat akun")
        }

        Spacer(modifier = Modifier.height(10.dp))
        Row {
            Text("Sudah memiliki akun? ", fontFamily = fontReguler, fontSize = 14.sp)

            Text("Masuk", fontFamily = fontReguler, fontSize = 14.sp, color = pinkColor, modifier= Modifier.clickable { navController.navigate("login") } )

        }

    }



}




//@Preview(showBackground = true)
//@Composable
//fun RegisterScreenPreview() {
//    // You can create a mock NavController and AuthViewModel for the preview
//    val navController = rememberNavController()
//    val modifier = Modifier
//    RegisterScreen(modifier,navController)
//}



