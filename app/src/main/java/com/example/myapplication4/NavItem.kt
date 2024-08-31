package com.example.myapplication4

import androidx.compose.ui.graphics.painter.Painter

data class NavItem(
    val label: String,
    val icon: Painter,
    val badgeCount: Int,
)