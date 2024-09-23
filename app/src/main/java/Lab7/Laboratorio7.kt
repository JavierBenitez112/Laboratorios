package Lab7

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvg.ejercicioslabs.ejercicios.agosto19.Notification
import com.uvg.ejercicioslabs.ejercicios.agosto19.NotificationType
import com.uvg.ejercicioslabs.ejercicios.agosto19.generateFakeNotifications
import java.time.format.DateTimeFormatter
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppbarrita() {
    TopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        ),
        title = {
            Row(modifier = Modifier.fillMaxWidth()) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Icono para regresar",
                    modifier = Modifier.size(24.dp),
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text("Notificaciones", color = MaterialTheme.colorScheme.onPrimaryContainer)
            }
        }
    )
}

@Composable
fun Chips(
    selectedFilter: NotificationType?,
    onFilterSelected: (NotificationType?) -> Unit
) {
    Row {
        FilterChip(
            onClick = {
                onFilterSelected(if (selectedFilter == NotificationType.GENERAL) null else NotificationType.GENERAL)
            },
            label = {
                Text("General")
            },
            selected = selectedFilter == NotificationType.GENERAL,
            leadingIcon = if (selectedFilter == NotificationType.GENERAL) {
                {
                    Icon(
                        imageVector = Icons.Filled.Done,
                        contentDescription = "Done icon",
                        modifier = Modifier.size(FilterChipDefaults.IconSize)
                    )
                }
            } else {
                null
            },
            colors = FilterChipDefaults.filterChipColors(
                selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer,
                labelColor = MaterialTheme.colorScheme.onSurface,
                containerColor = MaterialTheme.colorScheme.surface
            )
        )

        Spacer(modifier = Modifier.width(8.dp))

        FilterChip(
            onClick = {
                onFilterSelected(if (selectedFilter == NotificationType.NEW_POST) null else NotificationType.NEW_POST)
            },
            label = {
                Text("New Post")
            },
            selected = selectedFilter == NotificationType.NEW_POST,
            leadingIcon = if (selectedFilter == NotificationType.NEW_POST) {
                {
                    Icon(
                        imageVector = Icons.Filled.Done,
                        contentDescription = "Done icon",
                        modifier = Modifier.size(FilterChipDefaults.IconSize)
                    )
                }
            } else {
                null
            },
            colors = FilterChipDefaults.filterChipColors(
                selectedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                selectedLabelColor = MaterialTheme.colorScheme.onSecondaryContainer,
                labelColor = MaterialTheme.colorScheme.onSurface,
                containerColor = MaterialTheme.colorScheme.surface
            )
        )

        Spacer(modifier = Modifier.width(8.dp))

        FilterChip(
            onClick = {
                onFilterSelected(if (selectedFilter == NotificationType.NEW_MESSAGE) null else NotificationType.NEW_MESSAGE)
            },
            label = {
                Text("New Message")
            },
            selected = selectedFilter == NotificationType.NEW_MESSAGE,
            leadingIcon = if (selectedFilter == NotificationType.NEW_MESSAGE) {
                {
                    Icon(
                        imageVector = Icons.Filled.Done,
                        contentDescription = "Done icon",
                        modifier = Modifier.size(FilterChipDefaults.IconSize)
                    )
                }
            } else {
                null
            },
            colors = FilterChipDefaults.filterChipColors(
                selectedContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                selectedLabelColor = MaterialTheme.colorScheme.onTertiaryContainer,
                labelColor = MaterialTheme.colorScheme.onSurface,
                containerColor = MaterialTheme.colorScheme.surface
            )
        )

        Spacer(modifier = Modifier.width(8.dp))

        FilterChip(
            onClick = {
                onFilterSelected(if (selectedFilter == NotificationType.NEW_LIKE) null else NotificationType.NEW_LIKE)
            },
            label = {
                Text("New Like")
            },
            selected = selectedFilter == NotificationType.NEW_LIKE,
            leadingIcon = if (selectedFilter == NotificationType.NEW_LIKE) {
                {
                    Icon(
                        imageVector = Icons.Filled.Done,
                        contentDescription = "Done icon",
                        modifier = Modifier.size(FilterChipDefaults.IconSize)
                    )
                }
            } else {
                null
            },
            colors = FilterChipDefaults.filterChipColors(
                selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer,
                labelColor = MaterialTheme.colorScheme.onSurface,
                containerColor = MaterialTheme.colorScheme.surface
            )
        )
    }
}

@Composable
fun Filtro(
    selectedFilter: NotificationType?,
    onFilterSelected: (NotificationType?) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column {
            Text(
                text = "Tipos de notificaciones",
                color = MaterialTheme.colorScheme.onSurface
            )
            Chips(selectedFilter = selectedFilter, onFilterSelected = onFilterSelected)
        }
    }
}

@Composable
fun NotificationItem(
    title: String,
    body: String,
    sendAt: Date,
    type: NotificationType
) {
    val icon = when (type) {
        NotificationType.GENERAL -> Icons.Default.Notifications
        NotificationType.NEW_POST -> Icons.Default.Add
        NotificationType.NEW_MESSAGE -> Icons.Default.Email
        NotificationType.NEW_LIKE -> Icons.Default.Check
    }

    val color = when (type) {
        NotificationType.GENERAL -> MaterialTheme.colorScheme.primary
        NotificationType.NEW_POST -> MaterialTheme.colorScheme.secondary
        NotificationType.NEW_MESSAGE -> MaterialTheme.colorScheme.tertiary
        NotificationType.NEW_LIKE -> MaterialTheme.colorScheme.tertiary
    }

    val formatter = DateTimeFormatter.ofPattern("dd MMMM")
    val formattedDate = sendAt.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate().format(formatter)

    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Icon(
            modifier = Modifier
                .padding(4.dp)
                .clip(CircleShape)
                .background(color)
                .size(40.dp),
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimary
        )
        Column {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f),
                    color = MaterialTheme.colorScheme.onSurface
                )

                Text(
                    text = formattedDate,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Row {
                Text(text = body, color = MaterialTheme.colorScheme.onSurface)
            }
        }
    }
}

@Composable
fun NotificationCenter(notifications: List<Notification>) {
    LazyColumn(
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(15.dp))
            .background(MaterialTheme.colorScheme.background) // Ajuste para cambiar el fondo en dark mode
            .padding(16.dp)
    ) {
        items(notifications) { notification ->
            NotificationItem(
                title = notification.title,
                body = notification.body,
                sendAt = notification.sendAt,
                type = notification.type
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun Todo6(modifier: Modifier = Modifier) {
    val allNotifications = generateFakeNotifications()
    var selectedFilter by rememberSaveable { mutableStateOf<NotificationType?>(null) }

    val filteredNotifications = if (selectedFilter != null) {
        allNotifications.filter { it.type == selectedFilter }
    } else {
        allNotifications
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppbarrita()
        Filtro(
            selectedFilter = selectedFilter,
            onFilterSelected = { newFilter ->
                selectedFilter = newFilter
            }
        )
        NotificationCenter(notifications = filteredNotifications)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRestaurante() {
    Todo6()
}
