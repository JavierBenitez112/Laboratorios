package Lab7

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppbarrita(modifier: Modifier = Modifier) {
    TopAppBar(
        title = { Row(modifier = Modifier.fillMaxWidth().background(Color.Green)) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Icono para regresar",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text("Notificaciones")
        } }
    )
}

@Composable
fun Todo6(){
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppbarrita()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRestaurante() {
    Todo6()
}