package com.example.tallerandroidapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Pantalla de Ajustes", style = MaterialTheme.typography.titleLarge)

        // Botón de ejemplo para cambiar un ajuste
        Button(
            onClick = { /* Aquí puedes agregar lógica para manejar ajustes */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cambiar Configuración")
        }

        // Switch para habilitar/deshabilitar algo
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Modo Oscuro", style = MaterialTheme.typography.bodyLarge)
            Switch(
                checked = false,
                onCheckedChange = { /* Lógica para cambiar el modo oscuro */ }
            )
        }

        // Otro ejemplo de configuración
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Notificaciones", style = MaterialTheme.typography.bodyLarge)
            Switch(
                checked = true,
                onCheckedChange = { /* Lógica para habilitar/deshabilitar notificaciones */ }
            )
        }
    }
}
