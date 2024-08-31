package com.example.myapplication4.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication4.R

@Composable
fun CobaUI() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFE984C6))
        ) {
            Image(
                modifier = Modifier
                    .padding(16.dp, 8.dp),
                painter = painterResource(id = R.drawable.alur_prem_bpjs1),
                contentDescription = ""
            )
            Text("Vector content goes here")
        }

        Button(onClick = { /* Placeholder action */ }) {
            Text(text = "Capture Image")
        }

    }
}
@Preview(showBackground = true)
@Composable
fun CobaUIPreview() {
    CobaUI()
}