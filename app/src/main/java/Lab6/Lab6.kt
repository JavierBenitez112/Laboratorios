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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
    val cuadrosList = remember { mutableStateListOf<Pair<Int, Color>>() }

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
                cuadrosList.add(Pair(contador, Color.Red))
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
                cuadrosList.add(Pair(contador, Color.Green))
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

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Columna para los textos
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Total Incrementos:",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 4.dp)
            )
            Text(
                text = "Total Decrementos:",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 4.dp)
            )
            Text(
                text = "Valor máximo:",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 4.dp)
            )
            Text(
                text = "Valor mínimo:",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 4.dp)
            )
            Text(
                text = "Total Cambios:",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 4.dp)
            )
            Text(
                text = "Historial:",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
        // Columna para los valores
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "$incrementos",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 4.dp)
            )
            Text(
                text = "$decrementos",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 4.dp)
            )
            Text(
                text = "$maxValor",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 4.dp)
            )
            Text(
                text = "$minValor",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 4.dp)
            )
            Text(
                text = "$totalCambios",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }
    }


    LazyVerticalGrid(
        columns = GridCells.Fixed(5),
        modifier = Modifier.padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(cuadrosList.size) { index ->
            val (numero, color) = cuadrosList[index]
            Cuadros(numero = numero, backgroundColor = color)
        }
    }

    Button(
        onClick = {
            cuadrosList.clear() // Limpia todos los elementos del LazyVerticalGrid
            contador = 0
            incrementos = 0
            decrementos = 0
            maxValor = 0
            minValor = 0
            totalCambios = 0
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF3F51B5),
            contentColor = Color.White
        )
    ) {
        Text(text = "Reiniciar")
    }}

@Composable
fun Cuadros(numero: Int, backgroundColor: Color) {
    Box(
        modifier = Modifier
            .size(50.dp) // Tamaño del Box
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(8.dp)
            ) // Fondo con bordes redondeados
            .padding(8.dp), // Padding interno
        contentAlignment = Alignment.Center // Texto centrado en el Box
    ) {
        Text(
            text = numero.toString(),
            color = Color.White, // Texto de color blanco
            fontSize = 16.sp
        )
    }
}

@Composable
fun Todo7(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Javier Andre Benitez Garcia",
                style = MaterialTheme.typography.headlineMedium,
            )
        }
        Contador()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewContador() {
    Todo7()
}