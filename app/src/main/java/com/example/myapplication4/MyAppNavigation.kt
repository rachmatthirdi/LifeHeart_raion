package com.example.myapplication4

import android.content.Context
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication4.bpjs.premium.BPJSDua
import com.example.myapplication4.bpjs.premium.BPJSTiga
import com.example.myapplication4.bpjs.premium.BPJSSatu
import com.example.myapplication4.bpjs.premium.BerhasilPremiumBPJS
import com.example.myapplication4.login.register.LoginScreen
import com.example.myapplication4.login.register.OTPScreen
import com.example.myapplication4.login.register.RegisterScreen
import com.example.myapplication4.navigation.bar.HomeScreen
import com.example.myapplication4.navigation.bar.IkutiTes
import com.example.myapplication4.navigation.bar.MainScreen
import com.example.myapplication4.navigation.bar.Notification
import com.example.myapplication4.navigation.bar.ProfilScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppNavigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {
    val navController = rememberNavController()
    val authState by authViewModel.authState.observeAsState()

    NavHost(navController = navController, startDestination = "onboarding/1") {
        composable("onboarding/{page}") { backStackEntry ->
            val page = backStackEntry.arguments?.getString("page")?.toInt() ?: 1
            OnboardingPage(navController, page)
        }
        composable("login") { LoginScreen(modifier, navController, authViewModel) }
        composable("register") { RegisterScreen(modifier, navController, authViewModel) }
        composable("main") { MainScreen(modifier, navController, authViewModel) }
       // composable("lupa") { ForgotPasswordScreen(navController, authViewModel) }
        composable("otp") { OTPScreen(navController, authViewModel) }
        composable("bpjs1") { BPJSSatu(navController) }
        composable("bpjs2") { BPJSDua(navController) }
        composable("bpjs3") { BPJSTiga(navController) }
        composable("berhasilBPJS") { BerhasilPremiumBPJS(navController) }
        composable("home") { HomeScreen(modifier, navController, authViewModel) }
        composable("ikutTes") { IkutiTes(modifier, navController, authViewModel) }
        composable("notif") { Notification(navController) }
        composable("profil") { ProfilScreen(modifier, navController, authViewModel) }




    }
}

