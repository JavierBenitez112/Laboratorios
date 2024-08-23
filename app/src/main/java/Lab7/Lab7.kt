package Lab7

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab4.R


@Composable
fun Contador() {
    var contador by rememberSaveable { mutableStateOf(0) }
    var incrementos by rememberSaveable { mutableStateOf(0) }
    var decrementos by rememberSaveable { mutableStateOf(0) }
    var maxValor by rememberSaveable { mutableStateOf(0) }
    var minValor by rememberSaveable { mutableStateOf(0) }
    var totalCambios by rememberSaveable { mutableStateOf(0) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedButton(
            onClick = {
                contador--
                decrementos++
                totalCambios++
                if (contador < minValor) {
                    minValor = contador
                }
            },
            modifier = Modifier.size(50.dp),
            shape = CircleShape,
            border = BorderStroke(1.dp, Color.Blue),
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Blue)
        ) {
            Icon(painter = painterResource(id = R.drawable.baseline_remove_24), contentDescription = "Disminuir contador")
        }

        Spacer(modifier = Modifier.width(16.dp))

        Text(text = "$contador", fontSize = 24.sp)

        Spacer(modifier = Modifier.width(16.dp))

        OutlinedButton(
            onClick = {
                contador++
                incrementos++
                totalCambios++
                if (contador > maxValor) {
                    maxValor = contador
                }
            },
            modifier = Modifier.size(50.dp),
            shape = CircleShape,
            border = BorderStroke(1.dp, Color.Blue),
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Blue)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Aumentar contador")
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Total Incrementos: $incrementos", fontSize = 18.sp)
        Text(text = "Total Decrementos: $decrementos", fontSize = 18.sp)
        Text(text = "Valor máximo: $maxValor", fontSize = 18.sp)
        Text(text = "Valor mínimo: $minValor", fontSize = 18.sp)
        Text(text = "Total Cambios: $totalCambios", fontSize = 18.sp)
    }


}

@Composable
fun Historial(mensaje: String, backgroundColor: Color) {
    Box(
        modifier = Modifier
            .size(5.dp) // Tamaño de la Box
            .background(color = backgroundColor, shape = RoundedCornerShape(8.dp)) // Fondo con bordes redondeados
            .padding(16.dp), // Padding interno
        contentAlignment = Alignment.Center // Texto centrado en la Box
    ) {
        Text(
            text = mensaje,
            color = Color.White // Texto de color blanco
        )
    }
}


@Composable
fun Todo7(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize()){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Javier Andre Benitez Garcia",
                style = MaterialTheme.typography.headlineMedium,)
        }
        Contador()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewContador() {
    Todo7()
}