package Lab5

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab4.FrontBasico
import com.example.lab4.R


@Composable
fun Actualizacion() {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0x567BD8FD))
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = "Icono de Actualización",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "Actualización disponible",
                modifier = Modifier.padding(16.dp),
            )
            Spacer(modifier = Modifier.width(4.dp))
            CustomButton(
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.crunchyroll.crunchyroid&pcampaignid=web_share"))
                    context.startActivity(intent)
                },
                text = "Descargar",
                borderColor = 0x0,
                textColor = 0xFF0EABFF,
                FondoColor = 0x0,
                modifier = Modifier
                    .padding(4.dp)
            )
        }
    }
}

@Composable
fun CustomButton(
    onClick: () -> Unit,
    text: String,
    borderColor: Int,
    textColor: Int,
    FondoColor: Int,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(FondoColor),
            contentColor = Color(textColor)
        ),
        border = BorderStroke(1.dp, Color(borderColor)),
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
    ) {
        Text(text = text)
    }
}

@Composable
fun CustomButton(
    onClick: () -> Unit,
    text: String,
    borderColor: Long,
    textColor: Long,
    FondoColor: Long,
    modifier: Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(FondoColor)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(FondoColor))

            .border(2.dp, Color(borderColor), shape = RoundedCornerShape(8.dp))


    ) {
        Text(
            text = text,
            color = Color(textColor)
        )
    }
}

@Composable
fun FechaCumple() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Domingo",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold

                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "7 de Enero",
                    style = MaterialTheme.typography.titleSmall
                )
            }

        }

        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            CustomButton(
                onClick = {


                },
                text = "Terminar jornada",
                borderColor = 0xFF888181,
                textColor = 0xFF6616E6,
                modifier = Modifier.padding(bottom = 8.dp),
                FondoColor = 0x0
            )
        }
    }
}

@Composable
fun Restaurante() {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                width = 2.dp,
                color = Color(0x16DBD8D8),
                shape = RoundedCornerShape(3.dp)
            )
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = "Donde Joselito Steakhouse",
                modifier = Modifier.padding(5.dp),
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "4A Avenida 10-06 Zona 9",
                modifier = Modifier.padding(5.dp),
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "11:30AM  10:00PM",
                modifier = Modifier.padding(5.dp),
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xAB464646)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(6.dp)
                ) {
                    CustomButton(
                        onClick = {
                            Toast.makeText(context, "Javier Andre Benitez Garcia", Toast.LENGTH_LONG).show()
                        },
                        text = "Iniciar",
                        borderColor = 0xFFFF8400,
                        textColor = 0xFFFFFFFF,
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 4.dp),
                        FondoColor = 0xFFFF8400 // Color de fondo del botón
                    )
                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(6.dp)
                ) {
                    CustomButton(
                        onClick = {
                            Toast.makeText(context, "Carne a la parrilla\nQQ", Toast.LENGTH_LONG).show()
                        },
                        text = "Detalles",
                        borderColor = 0x0,
                        textColor = 0xFFFF8400,
                        FondoColor = 0x0, // Color de fondo transparente
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 4.dp)
                    )
                }
            }
        }
        Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = "Arrow Forward",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(5.dp)
                .size(24.dp)
                .clickable {

                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.app.goo.gl/MF5vftqStbT2YGvk9"))
                    context.startActivity(intent)
                },
            tint = Color(0xFF6C0CB1)
        )
    }
}


@Composable
fun Todo5(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .fillMaxSize()
        .background(Color(0xFFE0E0E0))) {
        Actualizacion()
        Box(modifier = Modifier.padding(15.dp)) {
            FechaCumple()
        }

        Restaurante()
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewRestaurante() {
    Todo5()
}