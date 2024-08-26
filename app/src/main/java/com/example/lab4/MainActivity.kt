package com.example.lab4

import Todo7
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold { innerPadding ->
                Todo7(modifier = Modifier.padding(innerPadding))
            }
        }
    }
}

@Preview
@Composable
fun FrontBasico() {
    Box(
        modifier = Modifier
            .border(2.dp, Color(0xFF055700))
            .width(200.dp)
            .height(400.dp)
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.estrellasss),
            contentDescription = "Background Image",
            modifier = Modifier
                .align(Alignment.Center)
                .size(100.dp)
                .graphicsLayer(alpha = 0.5f)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 16.dp)
            ) {
                Text(
                    text = "Universidad del Valle de Guatemala",
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Programación de plataformas móviles, Sección 30",
                    color = Color.Black,
                    fontSize = 10.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 16.dp)
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(2.dp)

            ) {
                Row {
                    Text(
                        text = "INTEGRANTES",
                        color = Color.Black,
                        fontSize = 8.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(30.dp))

                    Column {
                        Text(
                            text = "Javier Benitez",
                            color = Color.Black,
                            fontSize = 8.sp,
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = "Manuel Ulin",
                            color = Color.Black,
                            fontSize = 8.sp,
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            textAlign = TextAlign.Center
                        )

                    }
                }
                Row {
                    Text(text = "")
                }
                Row  {
                    Text(
                        text = "CATEDRÁTICO",
                        color = Color.Black,
                        fontSize = 8.sp,
                        textAlign = TextAlign.Left,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(33.dp))

                    Column {
                        Text(
                            text = "Juan Durini",
                            color = Color.Black,
                            fontSize = 9.sp,
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = "Manuel Ulin",
                            color = Color.White,
                            fontSize = 8.sp,
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
            Text(text = "Javier Benitez",
                color = Color.Black,
                fontSize = 12.sp,

            )
            Text(text = "23405",
                color = Color.Black,
                fontSize = 12.sp,

                )
        }
    }
}
