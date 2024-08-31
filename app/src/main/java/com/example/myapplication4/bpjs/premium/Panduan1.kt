package com.example.myapplication4.bpjs.premium

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.myapplication4.R

@Composable
fun Panduan1(navController: NavController) {
    val fontMedium = FontFamily(Font(R.font.satoshi_medium))
    val fontRegular = FontFamily(Font(R.font.satoshi_regular))
    val fontBold = FontFamily(Font(R.font.satoshi_bold))



    Column(
        modifier = Modifier
            .padding(15.dp)
    ) {

//        Row(modifier = Modifier.padding(top = 20.dp, bottom = 5.dp)) {
//            Image(
//                modifier = Modifier
//                    .size(25.dp)
//                    .clickable { // terserah kemana
//                    },
//                painter = rememberImagePainter(R.drawable.arrow_left),
//                contentDescription = "",
//                alignment = Alignment.BottomStart
//            )
//
//
//        }
        androidx.compose.material3.Text(
            "Panduan upload foto diri dengan KTP",
            fontFamily = fontBold,
            fontSize = 17.sp,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            textAlign= TextAlign.Start)


        androidx.compose.material3.Text(
            "Panduan upload foto diri dengan KTP",
            fontFamily = fontMedium,
            fontSize = 14.sp,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth(),
            textAlign= TextAlign.Start)

        val scrollState = rememberScrollState()
        Row(
            modifier = Modifier
                .padding(top = 20.dp)
                .horizontalScroll(scrollState)
        ) {
            Image(
                painter = painterResource(id = R.drawable.p_ktp1),
                contentDescription = "Red Square",
                modifier = Modifier.size(width = 200.dp, height =300.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.p_ktp2),
                contentDescription = "Green Square",
                modifier = Modifier.size(width = 200.dp, height =300.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.p_ktp3),
                contentDescription = "Blue Square",
                modifier = Modifier.size(width = 200.dp, height =300.dp)
            )
        }

        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top) {
            Image(
                painter = painterResource(id = R.drawable.titik_panduan),
                contentDescription = "Blue Square",
                modifier = Modifier.padding(8.dp)

            )

            androidx.compose.material3.Text(
                "Foto diri dan KTP harus milik pemilik usaha atau investor",
                fontFamily = fontRegular,
                fontSize = 12.sp,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign= TextAlign.Start)

        }
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top) {
            Image(
                painter = painterResource(id = R.drawable.titik_panduan),
                contentDescription = "Blue Square",
                modifier = Modifier.padding(8.dp)

            )

            androidx.compose.material3.Text(
                "Pastikan wajah dan KTP sesuai dengan tata letak yang tersedia",
                fontFamily = fontRegular,
                fontSize = 12.sp,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign= TextAlign.Start)

        }
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top) {
            Image(
                painter = painterResource(id = R.drawable.titik_panduan),
                contentDescription = "Blue Square",
                modifier = Modifier.padding(8.dp)

            )

            androidx.compose.material3.Text(
                "Pastikan KTP tidak menutupi area wajah dan dapat terbaca dengan jelas dalam foto",
                fontFamily = fontRegular,
                fontSize = 12.sp,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign= TextAlign.Start)

        }
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top) {
            Image(
                painter = painterResource(id = R.drawable.titik_panduan),
                contentDescription = "Blue Square",
                modifier = Modifier.padding(8.dp)

            )

            androidx.compose.material3.Text(
                "Posisi kepala dan pandangan lurus ke kamera",
                fontFamily = fontRegular,
                fontSize = 12.sp,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign= TextAlign.Start)

        }
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top) {
            Image(
                painter = painterResource(id = R.drawable.titik_panduan),
                contentDescription = "Blue Square",
                modifier = Modifier.padding(8.dp)

            )

            androidx.compose.material3.Text(
                "Ambil foto di lokasi dengan pencahayaan yang bagus dan latar belakang polos",
                fontFamily = fontRegular,
                fontSize = 12.sp,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign= TextAlign.Start)

        }
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top) {
            Image(
                painter = painterResource(id = R.drawable.titik_panduan),
                contentDescription = "Blue Square",
                modifier = Modifier.padding(8.dp)

            )

            androidx.compose.material3.Text(
                "Dilarang menggunakan aksesoris seperti kacamata, masker, atau topi",
                fontFamily = fontRegular,
                fontSize = 12.sp,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign= TextAlign.Start)

        }

    }
}
