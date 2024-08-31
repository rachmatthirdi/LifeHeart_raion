package com.example.myapplication4.bpjs.premium

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.myapplication4.R
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Objects

@Composable
fun BPJSTiga(navController: NavController) {
    val pinkBackground = Color(0xFFFCEDF6)
    val pinkColor = Color(0xFFE984C6)
    val black = Color(0xFF000000)
    val greyFoto = Color(0xFFBCBCBC)
    val greyText = Color(0xFF2A2A2A)
    val blueColor = Color(0xFFBDD9FF)
    val bluePanduan = Color(0xFF2984FF)

    val fontMedium = FontFamily(Font(R.font.satoshi_medium))
    val fontRegular = FontFamily(Font(R.font.satoshi_regular))
    val fontBold = FontFamily(Font(R.font.satoshi_bold))

    val context = LocalContext.current
    val file = context.createImageFile3()
    val uri = FileProvider.getUriForFile(
        Objects.requireNonNull(context),
        context.packageName + ".provider", file
    )

    var isVisible by remember { mutableStateOf(false) }

    var capturedImageUri by remember {
        mutableStateOf<Uri>(Uri.EMPTY)
    }

    val cameraLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) {
            capturedImageUri = uri
        }

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {
        if (it) {
            Toast.makeText(context, "Permission Granted", Toast.LENGTH_SHORT).show()
            cameraLauncher.launch(uri)
        } else {
            Toast.makeText(context, "Permission Denied", Toast.LENGTH_SHORT).show()
        }
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Row(modifier = Modifier.padding(top = 20.dp, bottom = 5.dp)) {
            Image(
                modifier = Modifier
                    .size(30.dp)
                    .clickable { navController.navigate("bpjs2")
                    },
                painter = rememberImagePainter(R.drawable.arrow_left),
                contentDescription = ""
            )

            androidx.compose.material3.Text(
                "Verifikasi ",
                fontFamily = fontBold,
                fontSize = 17.sp,
                color = black,
                textAlign= TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )


        }
        // Card dengan vektor atau konten lainnya
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp),
            colors = CardDefaults.cardColors(containerColor = pinkBackground)
        ) {
            Image(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .padding(top = 15.dp),
                painter = rememberImagePainter(R.drawable.alur_prem_bpjs3),
                contentDescription = ""
            )
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
                .align(Alignment.CenterHorizontally)) {

                androidx.compose.material3.Text(
                    "Foto Diri",
                    fontFamily = fontMedium,
                    fontSize = 12.sp,
                    color = black,
                    modifier = Modifier
                        .weight(0.15f),
                    textAlign= TextAlign.Center)

                androidx.compose.material3.Text(
                    "KTP",
                    fontFamily = fontMedium,
                    color = black,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .weight(0.3f),
                    textAlign= TextAlign.Center)

                androidx.compose.material3.Text(
                    "Kartu BPJS",
                    fontFamily = fontMedium,
                    fontSize = 12.sp,
                    color = black,
                    modifier = Modifier
                        .weight(0.15f),
                    textAlign= TextAlign.Center)
            }

        }

        androidx.compose.material3.Text(
            "Upload foto BPJS ",
            fontFamily = fontMedium,
            fontSize = 14.sp,
            color = black,
            textAlign= TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp, top = 10.dp)
        )

        androidx.compose.material3.Text(
            "Upload foto BPJS asli, bukan hasil fotocopy",
            fontFamily = fontRegular,
            fontSize = 12.sp,
            color = greyText,
            textAlign= TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp)
        )



        // Gambar hasil tangkapan atau gambar default ditampilkan di bawah Card



        if (capturedImageUri.path?.isNotEmpty() == true){

            Image(
                modifier = Modifier
                    .size(350.dp)
                    .padding(horizontal = 25.dp),
                painter = rememberImagePainter(capturedImageUri),
                contentDescription = null
            )

        }else {

            OutlinedCard(
                modifier = Modifier
                    .fillMaxWidth(),
                border = BorderStroke(1.dp, blueColor),  // Warna dan ketebalan border
                shape = RoundedCornerShape(8.dp)         // Bentuk sudut dari Card
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        modifier = Modifier
                            .size(40.dp)
                            .padding(vertical = 5.dp),
                        painter = rememberImagePainter(R.drawable.upload_foto),
                        contentDescription = null

                    )
                    androidx.compose.material3.Text(
                        "Upload foto",
                        fontFamily = fontMedium,
                        fontSize = 12.sp,
                        color = greyFoto,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                }
            }


        }





        //text panduan
        Row(modifier = Modifier.fillMaxWidth()) {
            androidx.compose.material3.Text(
                "", modifier = Modifier.weight(3f))
            androidx.compose.material3.Text(
                "", modifier = Modifier.weight(3f))
            androidx.compose.material3.Text(
                "Panduan",
                fontFamily = fontMedium,
                fontSize = 12.sp,
                color = bluePanduan,
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
                    .weight(3f)
                    .clickable {
                        isVisible = true
                    },
                textAlign= TextAlign.End)
            if (isVisible) {
                Popup(alignment = Alignment.BottomCenter) {
                    // Kontainer yang menangani sentuhan di luar tampilan
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .pointerInput(Unit) {
                                detectTapGestures {
                                    isVisible =
                                        false // Menyembunyikan tampilan saat layar disentuh di mana saja
                                }
                            }
                    ) {

                        //kode tampilan
                        val fontMedium = FontFamily(Font(R.font.satoshi_medium))
                        val fontRegular = FontFamily(Font(R.font.satoshi_regular))
                        val fontBold = FontFamily(Font(R.font.satoshi_bold))


                        val scrollState = rememberScrollState()
                        OutlinedCard(modifier = Modifier.shadow(2.dp, shape = RoundedCornerShape(10)) .align(Alignment.Center)) {
                            Column(
                                modifier = Modifier
                                    .padding(15.dp)
                                    .background(color = Color.White)



                            ) {

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
                                    "Panduan upload foto BPJS",
                                    fontFamily = fontMedium,
                                    fontSize = 14.sp,
                                    color = Color.Black,
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    textAlign= TextAlign.Start)


                                Row(
                                    modifier = Modifier
                                        .padding(top = 20.dp)
                                        .horizontalScroll(scrollState)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.bpjs1),
                                        contentDescription = "Red Square",
                                        modifier = Modifier.size(250.dp)
                                    )
                                    Image(
                                        painter = painterResource(id = R.drawable.bpjs2),
                                        contentDescription = "Green Square",
                                        modifier = Modifier.size(250.dp)
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
                                        "Pastikan upload foto BPJS asli, bukan hasil fotocopy",
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
                                        "Pastikan BPJS terlihat jelas dalam bingkai foto",
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
                                        "Pastikan foto KTP tidak blur",
                                        fontFamily = fontRegular,
                                        fontSize = 12.sp,
                                        color = Color.Black,
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        textAlign= TextAlign.Start)

                                }
                            }
                        }


                    }
                }
            }


        }



        Spacer(modifier = Modifier.height(10.dp))

        // Tombol di bagian bawah layar
        Button(
            onClick = {
                val permissionCheckResult =
                    ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)

                if (permissionCheckResult == PackageManager.PERMISSION_GRANTED) {
                    cameraLauncher.launch(uri)
                } else {
                    permissionLauncher.launch(Manifest.permission.CAMERA)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
                .padding(horizontal = 5.dp),
            shape = RoundedCornerShape(10.dp)
            ,
            colors =  ButtonDefaults.buttonColors(pinkBackground)

        ) {

            Row(modifier = Modifier
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center){
                Image( modifier = Modifier
                    .size(25.dp)
                    .align(Alignment.CenterVertically),
                    alignment = Alignment.Center,
                    painter = rememberImagePainter(R.drawable.camera_vec),
                    contentDescription = null
                )
                androidx.compose.material3.Text(
                    "Ambil Foto",
                    fontFamily = fontMedium,
                    fontSize = 17.sp,
                    color = black,
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .padding(bottom = 5.dp), // Memberikan bobot agar isi tombol berada di tengah
                    textAlign = TextAlign.Center
                )
            }

        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                navController.navigate("berhasilBPJS")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .padding(horizontal = 5.dp),
        //    enabled = capturedImageUri.path?.isNotEmpty() == true,
            colors =  ButtonDefaults.buttonColors(
        //        if (capturedImageUri.path?.isNotEmpty() == true){
                pinkColor
         //   }else{ greyText }
            ),
            shape = RoundedCornerShape(20.dp)

        ) {

            androidx.compose.material3.Text(
                "Selanjutnya",
                fontFamily = fontMedium,
                fontSize = 17.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(bottom = 5.dp),
                textAlign = TextAlign.Center
            )

        }
    }
}

fun Context.createImageFile3(): File {
    val timeStamp = SimpleDateFormat("yyyy_MM_dd_HH:mm:ss").format(Date())
    val imageFileName = "JPEG_" + timeStamp + "_"
    val image3 = File.createTempFile(
        imageFileName,
        ".jpg",
        externalCacheDir
    )

    return image3
}

