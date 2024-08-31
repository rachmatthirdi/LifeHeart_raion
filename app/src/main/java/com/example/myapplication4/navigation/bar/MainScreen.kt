package com.example.myapplication4.navigation.bar

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.myapplication4.AuthState
import com.example.myapplication4.AuthViewModel
import com.example.myapplication4.NavItem
import com.example.myapplication4.R


@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    authViewModel: AuthViewModel
) {
    // Observe authentication state
    val authState by authViewModel.authState.observeAsState()

    var backnav = Color(0xFFF8D9ED)
    var iconcol = Color(0xFFE984C6)
    var icontou = Color(0xFF522E45)


    LaunchedEffect(authState) {
        when (authState) {
            is AuthState.Unauthenticated -> {
                navController.navigate("login") {
                    // Clear the back stack to prevent going back to authenticated screens
                    popUpTo(navController.graph.id) { inclusive = true }
                }
            }
            else -> Unit
        }
    }

    val navItemList = listOf(
        NavItem("Beranda", painterResource(R.drawable.b_vector), 0),
        NavItem("Riwayat", painterResource(R.drawable.r_vector), 0),
        NavItem("Profile", painterResource(R.drawable.p_vector), 0),
    )

    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(containerColor = backnav) {
                navItemList.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            BadgedBox(badge = {
                                if (navItem.badgeCount > 0) {
                                    Badge {
                                        Text(text = navItem.badgeCount.toString())
                                    }
                                }
                            }) {
                                Icon(painter = navItem.icon, contentDescription = "Icon", tint = if (selectedIndex == index) icontou else iconcol
                             )
                            }
                        },
                        label = {
                            Text(text = navItem.label)
                        }
                        ,
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = icontou, // Warna ikon saat dipilih
                            unselectedIconColor = icontou, // Warna ikon saat tidak dipilih
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        ContentScreen(
            modifier = modifier.padding(innerPadding),
            selectedIndex = selectedIndex,
            navController = navController,
            authViewModel = authViewModel
        )
    }
}

@Composable
fun ContentScreen(
    modifier: Modifier = Modifier,
    selectedIndex: Int,
    navController: NavController,
    authViewModel: AuthViewModel
) {
    val context = LocalContext.current

    when (selectedIndex) {
        0 -> HomeScreen(
            modifier = modifier,
            navController = navController,
            authViewModel = authViewModel
        )
        1 -> HistoryScreen(modifier)
        2 -> ProfilScreen(modifier, navController, authViewModel)
    }
}